import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.io.*;
import java.net.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Dashboard {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(768, 768);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        ImageIcon ic = new ImageIcon("db2.jpg");
        Image scaledImage = ic.getImage().getScaledInstance(768, 768, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel l = new JLabel(scaledIcon);
        l.setBounds(0, 0, 768, 768);
        l.setLayout(null);
        f.add(l);

        JPanel p = new JPanel();
        p.setLayout(null);
//        p.setBounds(240, 280, 170, 100);
//        p.setOpaque(true);
//        p.setBackground(Color.BLACK);

//        JLabel l1 = new JLabel("Healthy");
//        l1.setBounds(25, 10, 200, 40);
//        l1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 29));
//        l1.setForeground(Color.WHITE);
//        p.add(l1);
//
//        JLabel l2 = new JLabel("lifestyle");
//        l2.setBounds(40, 40, 200, 40);
//        l2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
//        l2.setForeground(Color.WHITE);
//        p.add(l2);

        JButton b1 = new JButton("Diet");
        b1.setBounds(100, 230, 100, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b1);

        JButton b2 = new JButton("Exercise");
        b2.setBounds(335, 65, 100, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b2);

        JButton b3 = new JButton("Activity");
        b3.setBounds(580, 390, 100, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b3);

        JButton b4 = new JButton("Graph");
        b4.setBounds(550, 260, 100, 40);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b4);

        JButton b5 = new JButton("Profile");
        b5.setBounds(334, 560, 100, 40); // Centered better
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b5);

        JButton b6 = new JButton("Games");
        b6.setBounds(530, 560, 100, 40);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b6);

        JButton b7 = new JButton("Bmi");
        b7.setBounds(80, 400, 100, 40);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        l.add(b7);

        l.add(p);



        b7.addActionListener(e -> {
            new BMI(f);
        });



        b1.addActionListener(e -> {
            new Diet ();
            f.dispose();
        });



        b2.addActionListener(e -> {
            Exercise.main(new String[]{});
            f.dispose();
        });

        b3.addActionListener(e -> {
            Activity.main(new String[]{}); // open Activity window
            f.dispose(); // dispose dashboard
        });

        b4.addActionListener(e -> {
            Graph.main(new String[]{});
            f.dispose();
        });


        b5.addActionListener(e -> {

            ProfileUpdate.main(new String[]{});
            f.dispose();

        });


        b6.addActionListener(e -> {

            Game.main(new String[]{});
            f.dispose();

        });




        f.setResizable(false);
        // 2) Center the window on the screen
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
