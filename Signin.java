import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Signin {
    public static void main(String[] args) {
        JFrame f = new JFrame("Sign Up");
        f.setSize(500, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bg = new JLabel(new ImageIcon("d2.png"));
        bg.setBounds(0, 0, 500, 850);
        f.setContentPane(bg);
        bg.setLayout(null);

        JLabel title = new JLabel("SIGN IN PAGE");
        title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        title.setBounds(100, 300, 300, 25);
        title.setForeground(Color.WHITE);
        bg.add(title);

        JLabel userLbl = new JLabel("Username:");
        userLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        userLbl.setBounds(20, 360, 80, 25);
        userLbl.setForeground(Color.WHITE);
        bg.add(userLbl);

        JTextField userF = new JTextField();
        userF.setBounds(120, 360, 160, 25);
        userF.setOpaque(false);
        userF.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        userF.setBackground(new Color(255, 255, 255, 50));
        userF.setForeground(Color.WHITE);
        bg.add(userF);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        passLbl.setBounds(20, 410, 80, 25);
        passLbl.setForeground(Color.WHITE);
        bg.add(passLbl);

        JPasswordField passF = new JPasswordField();
        passF.setBounds(120, 410, 160, 25);
        passF.setOpaque(false);
        passF.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        passF.setBackground(new Color(255, 255, 255, 50));
        passF.setForeground(Color.WHITE);
        bg.add(passF);

        JLabel emailLbl = new JLabel("Email:");
        emailLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        emailLbl.setBounds(20, 460, 80, 25);
        emailLbl.setForeground(Color.WHITE);
        bg.add(emailLbl);

        JTextField emailF = new JTextField();
        emailF.setBounds(120, 460, 160, 25);
        emailF.setOpaque(false);
        emailF.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        emailF.setBackground(new Color(255, 255, 255, 50));
        emailF.setForeground(Color.WHITE);
        bg.add(emailF);

        JLabel qLbl = new JLabel("Who was your fav teacher in Primary?");
        qLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        qLbl.setBounds(20, 510, 300, 25);
        qLbl.setForeground(Color.WHITE);
        bg.add(qLbl);

        JLabel secLbl = new JLabel("Sec Answer:");
        secLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        secLbl.setBounds(20, 550, 100, 25);
        secLbl.setForeground(Color.WHITE);
        bg.add(secLbl);

        JTextField secF = new JTextField();
        secF.setBounds(120, 550, 160, 25);
        secF.setOpaque(false);
        secF.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        secF.setBackground(new Color(255, 255, 255, 50));
        secF.setForeground(Color.WHITE);
        bg.add(secF);

        JLabel inst1 = new JLabel("Always keep remember this answer");
        inst1.setFont(new Font("Arial", Font.PLAIN, 12));
        inst1.setBounds(20, 580, 400, 20);
        inst1.setForeground(Color.LIGHT_GRAY);
        bg.add(inst1);

        JLabel inst2 = new JLabel("otherwise you won't able to unlock your account if you forget your password");
        inst2.setFont(new Font("Arial", Font.PLAIN, 12));
        inst2.setBounds(20, 600, 460, 20);
        inst2.setForeground(Color.LIGHT_GRAY);
        bg.add(inst2);

        JButton signupBtn = new JButton("Signin");
        signupBtn.setBackground(Color.BLACK);
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setBounds(40, 650, 100, 30);
        bg.add(signupBtn);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBounds(160, 650, 100, 30);
        bg.add(loginBtn);

        JLabel loginHint = new JLabel("Login if already signed in");
        loginHint.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        loginHint.setBounds(90, 700, 150, 25);
        loginHint.setForeground(Color.WHITE);
        bg.add(loginHint);

        signupBtn.addActionListener(s -> {
            String username  = userF.getText().trim();
            String password1 = new String(passF.getPassword());
            String email1    = emailF.getText().trim();
            String secAns    = secF.getText().trim();

            if (username.isEmpty() || password1.isEmpty() ||
                    email1.isEmpty() || secAns.isEmpty()) {
                JOptionPane.showMessageDialog(f,
                        "Please fill in all fields",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            if(username.length() < 3 || username.length() > 20){
                JOptionPane.showMessageDialog(f,
                        "Username must be 3–20 characters","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }


            if(password1.length() < 6){
                JOptionPane.showMessageDialog(f,
                        "Password must be at least 6 characters","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(!email1.contains("@") || !email1.contains(".")){
                JOptionPane.showMessageDialog(f,
                        "Please enter a valid email address","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            String url    = "jdbc:mysql://localhost:3307/project";
            String dbUser = "root";
            String dbPass = "@12042004";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, dbUser, dbPass);

                String checkSql = "SELECT id FROM users WHERE username = ?";
                PreparedStatement cp = con.prepareStatement(checkSql);
                cp.setString(1, username);
                if (cp.executeQuery().next()) {
                    JOptionPane.showMessageDialog(f,
                            "Username already exists!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    con.close();
                    return;
                }

                String insertSql =
                        "INSERT INTO users(username, password, email, sec_answer) "
                                + "VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(
                        insertSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, username);
                ps.setString(2, password1);
                ps.setString(3, email1);
                ps.setString(4, secAns);
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    Session.currentUserId = keys.getInt(1);
                }

                con.close();
                Profile.main(new String[]{});
                f.dispose();

            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(f,
                        "JDBC Driver Not Found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(f,
                        "Database Error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });

        loginBtn.addActionListener(ee -> {
            Login.showLoginpage();
            f.dispose();
        });

        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
