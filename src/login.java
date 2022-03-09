import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class login {
    String na;

    public void logi() throws IOException {

        JFrame frame1 = new JFrame("login");
        JTextField textField;
        JPasswordField passwordField;
        JButton btnNewButton, btnNewButton1;
        JLabel label;
        JPanel contentPane;

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame1.setBounds(1650, 1080, 1014, 850);
        frame1.setSize(1650, 1080);
        frame1.setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame1.setContentPane(contentPane);
        frame1.getContentPane().setBackground(new Color(64, 142, 207));

        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Smart weather Gui-Login");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblNewLabel.setBounds(680, 80, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(701, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(701, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(480, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(480, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(775, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String user_name = textField.getText();
                String password = new String(passwordField.getPassword());
                /*
                 * Scanner sc = new Scanner(System.in); System.out.println("enter name:");
                 * String userName = sc.next(); System.out.println("Enter pwd:"); String
                 * password = sc.next();
                 */
                try {
                    Connection connection = (Connection) DriverManager
                            .getConnection("jdbc:mysql://localhost:3307/project", "root", "root");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(
                            "Select user_name, password from account where user_name=? and password=?");

                    st.setString(1, user_name);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        System.out.println("succesfull");

                        try {
                            gui g1 = new gui();
                            g1.guii(user_name);
                            frame1.setVisible(false);
                        } catch (IOException io) {

                        }
                    } else {
                        System.out.println("not correct");
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btnNewButton1 = new JButton("Register");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(580, 392, 160, 73);
        btnNewButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    UserRegistration ur = new UserRegistration();
                    frame1.setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        });
        frame1.setVisible(true);
        contentPane.add(btnNewButton1);
        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }

}
