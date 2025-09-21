import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

public class Login {
    public static void main(String[] args) {
        showLoginpage();
    }

    public static void showLoginpage() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(533, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        // Set the background image
        JLabel background = new JLabel(new ImageIcon("d2.png"));
        background.setBounds(0, 0, 350, 400);
        frame.setContentPane(background);
        background.setLayout(null);

        // Logo
        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        logo.setBounds(100, 100, 120, 120);
        background.add(logo);

        // “User Login” title
        JLabel welcome = new JLabel("User Login");
        welcome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        welcome.setBounds(100, 350, 300, 25);
        welcome.setForeground(Color.WHITE);
        background.add(welcome);

        // Username
        JLabel user = new JLabel("Username:");
        user.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        user.setBounds(20, 410, 80, 25);
        user.setForeground(Color.WHITE);
        background.add(user);

        JTextField userf = new JTextField();
        userf.setBounds(100, 410, 160, 25);
        userf.setOpaque(false);
        userf.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        userf.setBackground(new Color(255, 255, 255, 50));
        userf.setForeground(Color.WHITE);
        background.add(userf);

        // Password
        JLabel passl = new JLabel("Password:");
        passl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        passl.setBounds(20, 460, 80, 25);
        passl.setForeground(Color.WHITE);
        background.add(passl);

        JPasswordField passf = new JPasswordField();
        passf.setBounds(100, 460, 160, 25);
        passf.setOpaque(false);
        passf.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        passf.setBackground(new Color(255, 255, 255, 50));
        passf.setForeground(Color.WHITE);
        background.add(passf);

        // Buttons
        JButton button1 = new JButton("Login");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(100, 520, 80, 30);
        background.add(button1);

        JButton button2 = new JButton("Sign Up");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(200, 520, 80, 30);
        background.add(button2);

        // Message label
        JLabel m = new JLabel();
        m.setBounds(100, 390, 200, 25);
        background.add(m);

        // Actions
        button1.addActionListener(e -> {
            String username = userf.getText().trim();
            String pwdStr   = new String(passf.getPassword()).trim();
            if (username.isEmpty() || pwdStr.isEmpty()) {
                m.setText("Please enter both username and password");
                return;
            }

            String dbUrl      = "jdbc:mysql://localhost:3306/project";
            String dbUser     = "roooot";
            String dbPassword = "000000000";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                String query =
                        "SELECT id FROM users WHERE username = ? AND password = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, pwdStr);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Session.currentUserId = rs.getInt("id");
                    Dashboard.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Username or Password!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                con.close();
            } catch (ClassNotFoundException ea) {
                JOptionPane.showMessageDialog(
                        frame,
                        "JDBC Driver Not Found",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                ea.printStackTrace();
            } catch (SQLException eq) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Database Connection Failed",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                eq.printStackTrace();
            }
        });

        button2.addActionListener(e -> {
            frame.dispose();
            Signin.main(new String[]{});
        });

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

