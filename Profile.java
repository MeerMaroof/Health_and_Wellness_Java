


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Profile {
 public static void main(String[] args) {

  JFrame f = new JFrame();
  f.setSize(500, 550);
  f.getContentPane().setBackground(new Color(0, 30, 30));
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setLayout(null);

  JLabel lm = new JLabel(new ImageIcon("profile11.png"));
  lm.setBounds(330, 60, 100, 100);
  f.add(lm);

  JLabel ll = new JLabel("Profile");
  ll.setBounds(120, 40, 150, 30);
  ll.setForeground(Color.WHITE);
  ll.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 25));
  f.add(ll);

  JLabel l = new JLabel("Full Name :");
  l.setBounds(60, 100, 150, 30);
  l.setForeground(Color.WHITE);
  l.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l);

  JTextField t = new JTextField(20);
  t.setBounds(180, 100, 100, 30);
  f.add(t);

  JLabel l1 = new JLabel("Father Name :");
  l1.setBounds(60, 150, 150, 30);
  l1.setForeground(Color.WHITE);
  l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l1);

  JTextField t1 = new JTextField(20);
  t1.setBounds(180, 150, 100, 30);
  f.add(t1);

  JLabel l2 = new JLabel("Age :");
  l2.setBounds(60, 200, 150, 30);
  l2.setForeground(Color.WHITE);
  l2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l2);

  JTextField t2 = new JTextField(20);
  t2.setBounds(180, 200, 100, 30);
  f.add(t2);

  JLabel l3 = new JLabel("Height :");
  l3.setBounds(60, 250, 150, 30);
  l3.setForeground(Color.WHITE);
  l3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l3);

  JTextField t3 = new JTextField(20);
  t3.setBounds(180, 250, 100, 30);
  f.add(t3);

  JLabel l4 = new JLabel("Weight :");
  l4.setBounds(60, 300, 150, 30);
  l4.setForeground(Color.WHITE);
  l4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l4);

  JTextField t4 = new JTextField(20);
  t4.setBounds(180, 300, 100, 30);
  f.add(t4);

  JLabel l5 = new JLabel("Gender :");
  l5.setBounds(60, 350, 150, 30);
  l5.setForeground(Color.WHITE);
  l5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  f.add(l5);

  JComboBox<String> cb = new JComboBox<>();
  cb.addItem("Male");
  cb.addItem("Female");
  cb.setBounds(180, 350, 100, 30);
  f.add(cb);

  JButton b = new JButton("Save and Continue");
  b.setBounds(30, 420, 190, 40);
  b.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  b.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    try {

     String gender = (String) cb.getSelectedItem();

     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/project", "ro000ot", "000000000");

     String sql = """
                        UPDATE users
                           SET name       = ?,
                               age        = ?,
                               height_ft  = ?,
                               weight_kg  = ?,
                               goal       = ?,
                               diet_pref  = ?,
                               gender     = ?
                         WHERE id = ?
                    """;
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, t.getText());
     ps.setInt(2, Integer.parseInt(t2.getText()));
     ps.setDouble(3, Double.parseDouble(t3.getText()));
     ps.setDouble(4, Double.parseDouble(t4.getText()));
     ps.setString(5, "Maintain");
     ps.setString(6, "Both");
     ps.setString(7, gender);             // bind gender here
     ps.setInt(8, Session.currentUserId);
     ps.executeUpdate();
     con.close();
     f.dispose();
     Dashboard.main(new String[]{});
    } catch (Exception ex) {
     ex.printStackTrace();
     JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
    }
   }
  });
  f.add(b);

  JButton b1 = new JButton("Cancel");
  b1.setBounds(240, 420, 100, 40);
  b1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
  b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/project", "rooo0ot", "000000000");

     String sql = "DELETE FROM users WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, Session.currentUserId);
     ps.executeUpdate();

     Session.currentUserId = -1;
     con.close();
     Signin.main(new String[]{});
     f.dispose();
    } catch (Exception ex) {
     ex.printStackTrace();
     JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
    }
   }
  });
  f.add(b1);

  f.setResizable(false);
  f.setLocationRelativeTo(null);
  f.setVisible(true);
 }
}

