import javax.swing.*;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.net.*;
import java.io.*;
import org.json.*;

public class gui {
    public static JLabel l1, l2, l3, l4;
    public static JButton button, btn;
    public static JTextField t1;
    static ActionEvent e;
    static String cityn = "chennai";

    public void guii(String un) throws IOException {
        // String op;

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
        JLabel textLabel = new JLabel("Smart weather application for weather forecast and much more");
        textLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        textLabel.setBounds(20, 20, 50, 10);

        JPanel jp1 = new JPanel();
        l1 = new JLabel("Enter the city name to find weather reports");
        l1.setFont(new Font("Verdana", Font.BOLD, 25));
        t1 = new JTextField(10);
        t1.setBounds(10, 10, 100, 100);
        jp1.setBackground(new Color(0, 0, 0, 0));
        jp1.setBounds(10, 10, 100, 100);

        button = new JButton("Search");
        button.setBounds(20, 20, 90, 75);
        // button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);

        JPanel jp = new JPanel();
        JLabel taa = new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/one.png"));
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
        JTextArea taa3 = new JTextArea();
        taa3.setFont(new Font("Verdana", Font.BOLD, 20));
        taa3.setOpaque(false);
        taa3.setBackground(new Color(0, 0, 0, 0));

        JPanel jp2 = new JPanel();
        JLabel ta = new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/two.png"));
        ta.setBounds(20, 40, 25, 10);
        JTextArea ta1 = new JTextArea();
        ta1.setFont(new Font("Verdana", Font.BOLD, 20));
        ta1.setOpaque(false);
        ta1.setBackground(new Color(0, 0, 0, 0));
        JTextArea ta2 = new JTextArea();
        ta2.setFont(new Font("Verdana", Font.BOLD, 20));
        ta2.setOpaque(false);
        ta2.setBackground(new Color(0, 0, 0, 0));
        JTextArea ta3 = new JTextArea();
        ta3.setFont(new Font("Verdana", Font.BOLD, 20));
        ta3.setOpaque(false);
        ta3.setBackground(new Color(0, 0, 0, 0));

        JPanel jp3 = new JPanel();
        JLabel tb = new JLabel(new ImageIcon("C:/Users/vigne/Desktop/WeatherGui/images/three.png"));
        tb.setBounds(20, 40, 25, 10);
        JTextArea tb1 = new JTextArea();
        tb1.setFont(new Font("Verdana", Font.BOLD, 20));
        tb1.setOpaque(false);
        tb1.setBackground(new Color(0, 0, 0, 0));
        JTextArea tb2 = new JTextArea();
        tb2.setFont(new Font("Verdana", Font.BOLD, 20));
        tb2.setOpaque(false);
        tb2.setBackground(new Color(0, 0, 0, 0));
        JTextArea tb3 = new JTextArea();
        tb3.setFont(new Font("Verdana", Font.BOLD, 20));
        tb3.setOpaque(false);
        tb3.setBackground(new Color(0, 0, 0, 0));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cityn = t1.getText();
                try {
                    extra e1 = new extra();
                    String s1[] = e1.exec(cityn);
                    ta1.setText("Maximum temp" + s1[4] + "C");
                    ta2.setText("Minimum temp" + s1[3] + "C");
                    ta3.setText("Feels-Like" + s1[2] + "C");
                    tb1.setText("Wind-speed:" + s1[5] + "metres/sec");
                    tb2.setText("Pressure:" + s1[6] + "hPa");
                    tb3.setText("Humidity:" + s1[7] + "%");
                    taa1.setText("Sunrise" + s1[8]);
                    taa2.setText("Sunset" + s1[9]);
                    taa3.setText("Country" + s1[10]);
                    taz.setText("Weather at:" + s1[0]);

                } catch (IOException io) {

                }

            }
        });
        JPanel jp4 = new JPanel();
        btn = new JButton("GET global warming and travel Guidance");
        btn.setBounds(100, 20, 320, 80);
        btn.setBackground(Color.pink);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                second s1 = new second();
                s1.ss(un);
                frame.setVisible(false);

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
        jp.add(taa3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(jp, gbc);

        jp2.add(ta);
        jp2.add(ta1);
        jp2.add(ta2);
        jp2.add(ta3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(jp2, gbc);

        jp3.add(tb);
        jp3.add(tb1);
        jp3.add(tb2);
        jp3.add(tb3);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jp3, gbc);

        jp4.add(btn);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(jp4, gbc);

        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBounds(440, 150, 1014, 850);
        frame.setSize(1650, 1080);
        frame.setVisible(true);
        cityn = t1.getText();

    }

    class extra {
        public String[] exec(String cc) throws IOException {
            urltojson u1 = new urltojson();
            String op = u1.ExtractJson(cc);
            jsontotext jt = new jsontotext();
            String opp[] = jt.jsonop(op);
            // System.out.println(op);
            return opp;

        }
    }

}
