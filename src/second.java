import javax.swing.*;
import java.sql.SQLException;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class second {
    String cityn;
    int[] t = new int[14];

    public void ss(String un) {

        JFrame frame = new JFrame("Smart Weather Apllication");
        frame.setContentPane(new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/bgi.jpg")));
        frame.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.setOpaque(true);
        panel.setSize(500, 100);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel jp0 = new JPanel();
        JLabel textLabel = new JLabel("Smart weather application for Global warming data and travel Guidance");
        textLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        textLabel.setBounds(20, 20, 50, 10);

        JPanel jp1 = new JPanel();
        JLabel l1 = new JLabel("Enter the city name to find weather reports");
        l1.setFont(new Font("Verdana", Font.BOLD, 25));
        JTextField t1 = new JTextField();
        t1.setColumns(10);
        jp1.setBackground(new Color(0, 0, 0, 0));

        JPanel jp = new JPanel();
        JLabel taa = new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/four.png"));
        taa.setBounds(20, 40, 25, 10);
        JTextArea taz = new JTextArea();
        taz.setFont(new Font("Verdana", Font.BOLD, 20));
        taz.setOpaque(false);
        taz.setBackground(new Color(0, 0, 0, 0));
        JTextArea taa1 = new JTextArea();
        taa1.setFont(new Font("Verdana", Font.BOLD, 20));
        taa1.setOpaque(false);
        taa1.setBackground(new Color(0, 0, 0, 0));
        JTextArea taa2 = new JTextArea();
        taa2.setFont(new Font("Verdana", Font.BOLD, 20));
        taa2.setOpaque(false);
        taa2.setBackground(new Color(0, 0, 0, 0));

        JPanel jp2 = new JPanel();
        JLabel tz1 = new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/rain.png"));
        taa.setBounds(20, 40, 25, 10);
        JTextArea taz1 = new JTextArea();
        taz1.setFont(new Font("Verdana", Font.BOLD, 20));
        taz1.setOpaque(false);
        taz1.setBackground(new Color(0, 0, 0, 0));
        JTextArea taa11 = new JTextArea();
        taa11.setFont(new Font("Verdana", Font.BOLD, 20));
        taa11.setOpaque(false);
        taa11.setBackground(new Color(0, 0, 0, 0));
        JTextArea taa21 = new JTextArea();
        taa21.setFont(new Font("Verdana", Font.BOLD, 20));
        taa21.setOpaque(false);
        taa21.setBackground(new Color(0, 0, 0, 0));

        JPanel jpeg = new JPanel();
        JLabel aa = new JLabel();

        JButton button = new JButton("Search");
        button.setBounds(20, 20, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cityn = t1.getText();
                try {
                    ext e1 = new ext();
                    String s1[] = e1.exec(cityn);
                    taz.setText("visibility:=" + s1[0]);
                    taa1.setText("Ultra violet Index:=" + s1[1]);
                    taa2.setText("dew-point:=" + s1[2]);
                    taz1.setText("Mainly:=" + s1[4]);
                    taa11.setText("Overall description for " + cityn + " is:" + s1[3]);
                    taa21.setText(" Clouds:" + s1[8] + "%");
                    PrintWriter out = new PrintWriter("C:/Users/vigne/Desktop/WeatherGui/mailfile/Weatherreport.txt");
                    out.println("Weather Report at " + cityn);
                    out.println("\n");
                    out.println("Temperature is:=" + s1[5] + "*c");
                    out.println("Feels_like:=" + s1[6] + "*c");
                    out.println("Humidity:=" + s1[7] + "*c");
                    out.println("Dew-point:=" + s1[2]);
                    out.println("Cloudy is:=" + s1[8] + "%");
                    out.println("Overall description for " + cityn + " is:" + s1[3]);
                    out.close();

                    t[0] = Integer.parseInt(s1[9]);
                    t[1] = Integer.parseInt(s1[10]);
                    t[2] = Integer.parseInt(s1[11]);
                    t[3] = Integer.parseInt(s1[12]);
                    t[4] = Integer.parseInt(s1[13]);
                    t[5] = Integer.parseInt(s1[14]);
                    t[6] = Integer.parseInt(s1[15]);

                    t[7] = Integer.parseInt(s1[16]);
                    t[8] = Integer.parseInt(s1[17]);
                    t[9] = Integer.parseInt(s1[18]);
                    t[10] = Integer.parseInt(s1[19]);
                    t[11] = Integer.parseInt(s1[20]);
                    t[12] = Integer.parseInt(s1[21]);
                    t[13] = Integer.parseInt(s1[22]);

                    System.out.println(t[13]);
                    LineChart ll = new LineChart(t, cityn);
                    ll.cc();

                } catch (IOException io) {

                } catch (Exception me) {

                }

            }
        });
        JPanel mail = new JPanel();
        JButton btnNewButton = new JButton("Press to send mail");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(775, 392, 162, 73);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(Color.ORANGE);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = (Connection) DriverManager
                            .getConnection("jdbc:mysql://localhost:3307/project", "root", "root");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(
                            "Select email_id from account where user_name=?");

                    st.setString(1, un);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        String em = rs.getString("email_id");
                        System.out.println(em);
                        final String username = "vizzardgv@gmail.com";
                        final String password = "Vicky@24";
                        String fromEmail = "vizzardgv@gmail.com";
                        String toEmail = em;

                        Properties properties = new Properties();
                        properties.put("mail.smtp.auth", "true");
                        properties.put("mail.smtp.starttls.enable", "true");
                        properties.put("mail.smtp.host", "smtp.gmail.com");
                        properties.put("mail.smtp.port", "587");

                        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });
                        // Start our mail message
                        MimeMessage msg = new MimeMessage(session);
                        try {
                            msg.setFrom(new InternetAddress(fromEmail));
                            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                            msg.setSubject("Weather report to phone");

                            Multipart emailContent = new MimeMultipart();

                            MimeBodyPart textBodyPart = new MimeBodyPart();
                            textBodyPart.setText("Weather report at " + t1.getText());

                            MimeBodyPart pdfAttachment = new MimeBodyPart();
                            pdfAttachment.attachFile("C:/Users/vigne/Desktop/WeatherGui/mailfile/Weatherreport.txt");

                            // Attach body parts
                            emailContent.addBodyPart(textBodyPart);
                            emailContent.addBodyPart(pdfAttachment);

                            // Attach multipart to message
                            msg.setContent(emailContent);

                            Transport.send(msg);
                            System.out.println("Sent message");
                        } catch (MessagingException ae) {
                            ae.printStackTrace();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
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

        JButton back = new JButton("<--Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 26));
        back.setBounds(775, 392, 162, 73);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.MAGENTA);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {

                    gui g1 = new gui();
                    g1.guii(un);

                    frame.setVisible(false);
                } catch (IOException oe) {
                    System.out.println(oe.toString());
                }
            }
        });
        JButton chart = new JButton("<--Chart-->");
        chart.setFont(new Font("Tahoma", Font.PLAIN, 26));
        chart.setBounds(775, 392, 162, 73);
        chart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                try {
                    String c = t1.getText() + ".jpeg";
                    ImageIcon m = new ImageIcon(getClass().getResource(c));
                    aa.setIcon(m);
                } catch (Exception e) {

                }

            }
        });

        l1.setBounds(20, 20, 50, 10);

        jp0.add(textLabel);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(jp0);

        jp1.add(l1);
        jp1.add(t1);
        jp1.add(button);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(jp1, gbc);

        jp.add(taa);
        jp.add(taz);
        jp.add(taa1);
        jp.add(taa2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(jp, gbc);

        jp2.add(tz1);
        jp2.add(taz1);
        jp2.add(taa11);
        jp2.add(taa21);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(jp2, gbc);

        jpeg.add(aa);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jpeg, gbc);

        mail.add(btnNewButton);
        mail.add(back);
        mail.add(chart);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(mail, gbc);

        frame.add(panel);
        frame.setSize(1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class ext {
        public String[] exec(String cc) throws IOException {
            url2tojson u1 = new url2tojson();
            String op = u1.ExtractJson(cc);
            json2totext jt = new json2totext();
            String opp[] = jt.jsonop(op);
            // System.out.println(op);
            return opp;

        }
    }
}
