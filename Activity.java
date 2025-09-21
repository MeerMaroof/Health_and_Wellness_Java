import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class Activity {
    public static void main(String[] args) {

        JFrame ff = new JFrame();
        ff.setSize(550, 600);
        ff.getContentPane().setBackground(new Color(40, 46, 55));
        ff.setLayout(null);

        JLabel lm = new JLabel(new ImageIcon("activity1.png"));
        lm.setBounds(370, 60, 100, 130);
        ff.add(lm);

        JLabel lm1 = new JLabel(new ImageIcon("activity22.jpg"));
        lm1.setBounds(370, 215, 100, 130);
        ff.add(lm1);

        JLabel ll = new JLabel("Activity Details");
        ll.setBounds(100, 40, 230, 30);
        ll.setForeground(Color.WHITE);
        ll.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 22));
        ff.add(ll);

        JLabel l7 = new JLabel("Day :");
        l7.setBounds(60, 100, 150, 30);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l7);

        JComboBox<String> cb2 = new JComboBox<>();
        cb2.addItem("Monday");
        cb2.addItem("Tuesday");
        cb2.addItem("Wednesday");
        cb2.addItem("Thursday");
        cb2.addItem("Friday");
        cb2.addItem("Saturday");
        cb2.addItem("Sunday");
        cb2.setBounds(230, 100, 100, 30);
        ff.add(cb2);

        JLabel l = new JLabel("Water Intake :");
        l.setBounds(60, 150, 150, 30);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l);

        JTextField t = new JTextField(20);
        t.setBounds(230, 150, 100, 30);
        ff.add(t);

        JLabel l1 = new JLabel("Calories Burn :");
        l1.setBounds(60, 200, 150, 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l1);

        JTextField t1 = new JTextField(20);
        t1.setBounds(230, 200, 100, 30);
        ff.add(t1);

        JLabel l2 = new JLabel("Weight :");
        l2.setBounds(60, 250, 150, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l2);

        JTextField t2 = new JTextField(20);
        t2.setBounds(230, 250, 100, 30);
        ff.add(t2);

        JLabel l3 = new JLabel("Sleep Hours :");
        l3.setBounds(60, 300, 150, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l3);

        JTextField t3 = new JTextField(20);
        t3.setBounds(230, 300, 100, 30);
        ff.add(t3);

        JLabel l4 = new JLabel("Diet Completed :");
        l4.setBounds(60, 350, 150, 30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l4);

        JComboBox<String> cb = new JComboBox<>();
        cb.addItem("Yes");
        cb.addItem("No");
        cb.setBounds(230, 350, 100, 30);
        ff.add(cb);

        JLabel l6 = new JLabel("Excersice Completed :");
        l6.setBounds(60, 400, 180, 30);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(l6);

        JComboBox<String> cb1 = new JComboBox<>();
        cb1.addItem("Yes");
        cb1.addItem("No");
        cb1.setBounds(230, 400, 100, 30);
        ff.add(cb1);

        JButton b = new JButton("Save and Continue");
        b.setBounds(30, 470, 190, 40);
        b.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(b);

//        JButton b1 = new JButton("Cancel");
//        b1.setBounds(240, 470, 100, 40);
//        b1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
//        ff.add(b1);

        JButton back = new JButton("Back");
        back.setBounds(20, 20, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.addActionListener(ev -> {
            Dashboard.main(new String[]{});
            ff.dispose();
        });

        b.addActionListener(e -> {
            String day = cb2.getSelectedItem().toString();
            String water = t.getText();
            String calories = t1.getText();
            String weight = t2.getText();
            String sleep = t3.getText();
            String diet = cb.getSelectedItem().toString();
            String exercise = cb1.getSelectedItem().toString();

            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3307/project",
                        "root", "@12042004"
                );

                String sql = """
                    INSERT INTO activity
                      (user_id, day, water_intake, calories_burn, weight,
                       sleep_hours, diet_completed, exercise_completed)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Session.currentUserId);
                ps.setString(2, day);
                ps.setString(3, water);
                ps.setString(4, calories);
                ps.setString(5, weight);
                ps.setString(6, sleep);
                ps.setString(7, diet);
                ps.setString(8, exercise);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(ff, "Data saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(ff, "Failed to save data.");
                }

                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(ff, "Error: " + ex.getMessage());
            }
        });

        JButton graphBtn = new JButton("Graph");
        graphBtn.setBounds(360, 470, 100, 40);
        graphBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        ff.add(graphBtn);

        graphBtn.addActionListener(ev -> {
            Graph.main(new String[]{});
            ff.dispose();
        });

        ff.add(back);
        ff.setResizable(false);
        ff.setLocationRelativeTo(null);
        ff.setVisible(true);
    }
}


