import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ProfileUpdate {
    public static void main(String[] args) {


        if (Session.currentUserId == -1) {
            JOptionPane.showMessageDialog(null, "No user logged in.");
            return;
        }

        JFrame f = new JFrame("Update Profile");
        f.setSize(500, 500);
        f.getContentPane().setBackground(new Color(0, 30, 30));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JLabel title = new JLabel("Update Profile");
        title.setBounds(150, 20, 250, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        f.add(title);

        JLabel idLbl = new JLabel("Account ID:");
        idLbl.setBounds(40, 70, 120, 25);
        idLbl.setForeground(Color.WHITE);
        f.add(idLbl);

        JLabel nameLbl = new JLabel("Name:");
        nameLbl.setBounds(40, 100, 120, 25);
        nameLbl.setForeground(Color.WHITE);
        f.add(nameLbl);

        JLabel ageLbl = new JLabel("Age:");
        ageLbl.setBounds(40, 140, 120, 25);
        ageLbl.setForeground(Color.WHITE);
        f.add(ageLbl);

        JLabel heightLbl = new JLabel("Height (ft):");
        heightLbl.setBounds(40, 180, 120, 25);
        heightLbl.setForeground(Color.WHITE);
        f.add(heightLbl);

        JLabel weightLbl = new JLabel("Weight (kg):");
        weightLbl.setBounds(40, 220, 120, 25);
        weightLbl.setForeground(Color.WHITE);
        f.add(weightLbl);

        JLabel dietLbl = new JLabel("Diet Preference:");
        dietLbl.setBounds(40, 260, 120, 25);
        dietLbl.setForeground(Color.WHITE);
        f.add(dietLbl);

        JLabel goalLbl = new JLabel("Fitness Goal:");
        goalLbl.setBounds(40, 300, 120, 25);
        goalLbl.setForeground(Color.WHITE);
        f.add(goalLbl);

        JLabel idVal = new JLabel("");
        idVal.setBounds(160, 70, 200, 25);
        idVal.setForeground(Color.WHITE);
        f.add(idVal);

        JLabel nameVal = new JLabel("");
        nameVal.setBounds(160, 100, 200, 25);
        nameVal.setForeground(Color.WHITE);
        f.add(nameVal);

        JTextField ageF = new JTextField();
        ageF.setBounds(160, 140, 150, 25);
        f.add(ageF);

        JTextField heightF = new JTextField();
        heightF.setBounds(160, 180, 150, 25);
        f.add(heightF);

        JTextField weightF = new JTextField();
        weightF.setBounds(160, 220, 150, 25);
        f.add(weightF);

        JComboBox<String> dietCb = new JComboBox<>();
        dietCb.addItem("Veg");
        dietCb.addItem("Non-Veg");
        dietCb.addItem("Both");
        dietCb.setBounds(160, 260, 150, 25);
        f.add(dietCb);

        JComboBox<String> goalCb = new JComboBox<>();
        goalCb.addItem("Lose");
        goalCb.addItem("Gain");
        goalCb.addItem("Maintain");
        goalCb.setBounds(160, 300, 150, 25);
        f.add(goalCb);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(100, 360, 100, 30);
        f.add(saveBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(220, 360, 100, 30);
        f.add(cancelBtn);

        // Load user data
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "rt", "000000000"
            );
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Session.currentUserId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idVal.setText(String.valueOf(rs.getInt("id")));
                nameVal.setText(rs.getString("name"));
                ageF.setText(String.valueOf(rs.getInt("age")));
                heightF.setText(String.valueOf(rs.getDouble("height_ft")));
                weightF.setText(String.valueOf(rs.getDouble("weight_kg")));
                dietCb.setSelectedItem(rs.getString("diet_pref"));
                goalCb.setSelectedItem(rs.getString("goal"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveBtn.addActionListener(e -> {
            try {
                int age = Integer.parseInt(ageF.getText().trim());
                double height = Double.parseDouble(heightF.getText().trim());
                double weight = Double.parseDouble(weightF.getText().trim());
                String diet = (String) dietCb.getSelectedItem();
                String goal = (String) goalCb.getSelectedItem();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project", "oo", "000000000"
                );
                String update = "UPDATE users SET age = ?, height_ft = ?, weight_kg = ?, diet_pref = ?, goal = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(update);
                ps.setInt(1, age);
                ps.setDouble(2, height);
                ps.setDouble(3, weight);
                ps.setString(4, diet);
                ps.setString(5, goal);
                ps.setInt(6, Session.currentUserId);
                ps.executeUpdate();

                con.close();
                JOptionPane.showMessageDialog(f, "Profile updated!");
                Dashboard.main(new String[]{});
                f.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> {
            Dashboard.main(new String[]{});
            f.dispose();
        });

        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
