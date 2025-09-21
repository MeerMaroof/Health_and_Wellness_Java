import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BMI {
    private int age;
    private double heightFt;
    private String gender;

    public BMI(JFrame previousFrame) {
        previousFrame.dispose();
        loadUserProfile();

        JFrame resultFrame = new JFrame("Your Health Report");
        resultFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setLayout(null);

        ImageIcon bgIcon = new ImageIcon("BMIbg.png");
        Image bgImage = bgIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        JLabel resultBackground = new JLabel(new ImageIcon(bgImage));
        resultBackground.setBounds(0, 0, 1366, 768);
        resultFrame.setContentPane(resultBackground);
        resultBackground.setLayout(null);

        JLabel reportTitle = new JLabel("Health Report");
        reportTitle.setFont(new Font("Arial", Font.BOLD, 28));
        reportTitle.setForeground(Color.WHITE);
        reportTitle.setBounds(180, 100, 400, 40);
        resultBackground.add(reportTitle);

        JLabel activityLabel = new JLabel("Select activity level:");
        activityLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        activityLabel.setForeground(Color.WHITE);
        activityLabel.setBounds(180, 160, 300, 30);
        resultBackground.add(activityLabel);

        JComboBox<String> activityBox = new JComboBox<>(new String[]{
                "Select",
                "Sedentary (no exercise)",
                "Lightly Active (light exercise 1-3 days/week)",
                "Moderately Active (moderate exercise 3-5 days/week)",
                "Very Active (hard exercise 6-7 days/week)",
                "Super Active (physical job or intense training)"
        });
        activityBox.setBounds(180, 190, 250, 30);
        resultBackground.add(activityBox);

        JLabel weightLabel = new JLabel("Enter your current weight (kg):");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        weightLabel.setForeground(Color.WHITE);
        weightLabel.setBounds(180, 230, 300, 30);
        resultBackground.add(weightLabel);

        JTextField weightInput = new JTextField();
        weightInput.setBounds(180, 260, 200, 30);
        resultBackground.add(weightInput);

        JButton calculateButton = new JButton("Show Report");
        calculateButton.setBounds(180, 310, 150, 30);
        calculateButton.setBackground(Color.BLACK);
        calculateButton.setForeground(Color.WHITE);
        resultBackground.add(calculateButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.BOLD, 16));
        resultArea.setBounds(430, 160, 500, 300);
        resultArea.setOpaque(false);
        resultArea.setForeground(Color.WHITE);
        resultBackground.add(resultArea);

        calculateButton.addActionListener(ev -> {
            try {
                if (weightInput.getText().trim().isEmpty() || activityBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(resultFrame, "Please fill in all fields!");
                    return;
                }
                double weightKg = Double.parseDouble(weightInput.getText().trim());
                if (weightKg < 10 || weightKg > 500) {
                    JOptionPane.showMessageDialog(resultFrame, "Please enter a realistic weight (10–500 kg).");
                    return;
                }
                if (heightFt <= 0) {
                    JOptionPane.showMessageDialog(resultFrame, "Invalid user height. Please check your profile.");
                    return;
                }
                double heightM = heightFt * 0.3048;
                double bmi = weightKg / (heightM * heightM);
                double bmr = gender.equalsIgnoreCase("Male")
                        ? 10 * weightKg + 6.25 * (heightFt * 30.48) - 5 * age + 5
                        : 10 * weightKg + 6.25 * (heightFt * 30.48) - 5 * age - 161;
                double[] factors = {1.2, 1.375, 1.55, 1.725, 1.9};
                double tdee = bmr * factors[activityBox.getSelectedIndex() - 1];

                String status;
                int calGoal;
                if (bmi < 18.5) {
                    status = "Underweight";
                    calGoal = (int)(tdee + 400);
                } else if (bmi < 25) {
                    status = "Normal";
                    calGoal = (int)tdee;
                } else {
                    status = "Overweight";
                    calGoal = (int)(tdee - 400);
                }
                String suggestion = status.equals("Normal")
                        ? "Maintain weight (" + calGoal + " kcal/day)"
                        : (status.equals("Underweight") ? "Gain weight (" + calGoal + " kcal/day)" : "Lose weight (" + calGoal + " kcal/day)");

                resultArea.setText(
                        "Your BMI: " + String.format("%.1f", bmi) + "\n" +
                                "Status: " + status + "\n" +
                                "BMR: " + String.format("%.0f", bmr) + " kcal\n" +
                                "TDEE: " + String.format("%.0f", tdee) + " kcal\n" +
                                suggestion
                );

                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project","root","000000000");
                     PreparedStatement ps = conn.prepareStatement(
                             "INSERT INTO health_info(user_id, height, age, gender, activity_level, weight, bmi, tdee, health_status) VALUES (?,?,?,?,?,?,?,?,?)")) {
                    ps.setInt(1, Session.currentUserId);
                    ps.setDouble(2, heightFt);
                    ps.setInt(3, age);
                    ps.setString(4, gender);
                    ps.setString(5, activityBox.getSelectedItem().toString());
                    ps.setDouble(6, weightKg);
                    ps.setDouble(7, bmi);
                    ps.setDouble(8, tdee);
                    ps.setString(9, status);
                    ps.executeUpdate();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(resultFrame, "Please enter valid inputs!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(resultFrame, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(50,650,100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        resultBackground.add(backButton);
        backButton.addActionListener(e -> { resultFrame.dispose(); previousFrame.setVisible(true); });

        resultFrame.setVisible(true);
    }

    private void loadUserProfile() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/project","root","@12042004");
                 PreparedStatement psAge = conn.prepareStatement(
                         "SELECT age, height_ft FROM users WHERE id = ?")) {
                psAge.setInt(1, Session.currentUserId);
                try (ResultSet rs = psAge.executeQuery()) {
                    if (rs.next()) {
                        age = rs.getInt("age");
                        heightFt = rs.getDouble("height_ft");
                    } else {
                        JOptionPane.showMessageDialog(null, "User profile not found!","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project","root","000000000");
                 PreparedStatement psG = conn.prepareStatement(
                         "SELECT gender FROM health_info WHERE user_id = ? ORDER BY id DESC LIMIT 1")) {
                psG.setInt(1, Session.currentUserId);
                try (ResultSet rs = psG.executeQuery()) {
                    if (rs.next()) {
                        gender = rs.getString("gender");
                    } else {
                        //JOptionPane.showMessageDialog(null, "No previous record for gender. Please input gender while registering.","Info",JOptionPane.INFORMATION_MESSAGE);
                        gender = "Male"; // default
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Profile load error: " + e.getMessage());
        }
    }
}






































































// updated / amna

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class BMI {
//
//    public BMI(JFrame previousFrame) {
//        previousFrame.dispose();
//
//        JFrame resultFrame = new JFrame("Your Health Report");
//        resultFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        resultFrame.setLayout(null);
//
//        ImageIcon bgIcon = new ImageIcon("BMIbg.png");
//        Image bgImage = bgIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
//        JLabel resultBackground = new JLabel(new ImageIcon(bgImage));
//        resultBackground.setBounds(0, 0, 1366, 768);
//        resultFrame.setContentPane(resultBackground);
//        resultBackground.setLayout(null);
//
//        JLabel reportTitle = new JLabel("Health Report");
//        reportTitle.setFont(new Font("Arial", Font.BOLD, 28));
//        reportTitle.setForeground(Color.WHITE);
//        reportTitle.setBounds(180, 100, 400, 40);
//        resultBackground.add(reportTitle);
//
//        JLabel heightLabel = new JLabel("Enter height (in ft):");
//        heightLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        heightLabel.setForeground(Color.WHITE);
//        heightLabel.setBounds(180, 160, 300, 30);
//        resultBackground.add(heightLabel);
//
//        JTextField heightField = new JTextField();
//        heightField.setBounds(180, 190, 200, 30);
//        resultBackground.add(heightField);
//
//        JLabel ageLabel = new JLabel("Enter age:");
//        ageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        ageLabel.setForeground(Color.WHITE);
//        ageLabel.setBounds(180, 230, 300, 30);
//        resultBackground.add(ageLabel);
//
//        JTextField ageField = new JTextField();
//        ageField.setBounds(180, 260, 200, 30);
//        resultBackground.add(ageField);
//
//        JLabel genderLabel = new JLabel("Select gender:");
//        genderLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        genderLabel.setForeground(Color.WHITE);
//        genderLabel.setBounds(180, 300, 300, 30);
//        resultBackground.add(genderLabel);
//
//        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Select", "Male", "Female"});
//        genderBox.setBounds(180, 330, 200, 30);
//        resultBackground.add(genderBox);
//
//        JLabel activityLabel = new JLabel("Select activity level:");
//        activityLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        activityLabel.setForeground(Color.WHITE);
//        activityLabel.setBounds(180, 370, 300, 30);
//        resultBackground.add(activityLabel);
//
//        JComboBox<String> activityBox = new JComboBox<>(new String[]{
//                "Select",
//                "Sedentary (no exercise)",
//                "Lightly Active (light exercise 1-3 days/week)",
//                "Moderately Active (moderate exercise 3-5 days/week)",
//                "Very Active (hard exercise 6-7 days/week)",
//                "Super Active (physical job or intense training)"
//        });
//        activityBox.setBounds(180, 400, 250, 30);
//        resultBackground.add(activityBox);
//
//        JTextArea tipArea = new JTextArea(
//                "\u2705 Tips:\n"
//                        + "- Office/Student: Sedentary or Lightly Active\n"
//                        + "- Regular Gym: Moderately/Very Active\n"
//                        + "- Athlete/Manual Work: Super Active"
//        );
//        tipArea.setBounds(180, 440, 400, 60);
//        tipArea.setFont(new Font("Arial", Font.BOLD, 12));
//        tipArea.setForeground(Color.WHITE);
//        tipArea.setOpaque(false);
//        tipArea.setEditable(false);
//        resultBackground.add(tipArea);
//
//        JLabel weightLabel = new JLabel("Enter your current weight (kg):");
//        weightLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        weightLabel.setForeground(Color.WHITE);
//        weightLabel.setBounds(180, 510, 300, 30);
//        resultBackground.add(weightLabel);
//
//        JTextField weightInput = new JTextField();
//        weightInput.setBounds(180, 540, 200, 30);
//        resultBackground.add(weightInput);
//
//        JButton calculateButton = new JButton("Show Report");
//        calculateButton.setBounds(180, 570, 150, 30);
//        calculateButton.setBackground(Color.BLACK);
//        calculateButton.setForeground(Color.WHITE);
//        resultBackground.add(calculateButton);
//
//        JTextArea resultArea = new JTextArea();
//        resultArea.setEditable(false);
//        resultArea.setFont(new Font("Arial", Font.BOLD, 16));
//        resultArea.setBounds(400, 160, 500, 300);
//        resultArea.setOpaque(false);
//        resultArea.setForeground(Color.WHITE);
//        resultBackground.add(resultArea);
//
//        calculateButton.addActionListener(ev -> {
//            try {
//                if (heightField.getText().isEmpty()
//                        || ageField.getText().isEmpty()
//                        || weightInput.getText().isEmpty()
//                        || genderBox.getSelectedIndex() == 0
//                        || activityBox.getSelectedIndex() == 0
//                ) {
//                    JOptionPane.showMessageDialog(
//                            resultFrame,
//                            "Please fill in all fields!"
//                    );
//                    return;
//                }
//
//                double heightFt = Double.parseDouble(heightField.getText());
//                if (heightFt < 0.5 || heightFt > 8) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic height (0.5–8 ft).");
//                    return;
//                }
//
//                double heightM  = heightFt * 0.3048;
//                double weightKg = Double.parseDouble(weightInput.getText());
//                if (weightKg < 10 || weightKg > 500) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic weight (10–500 kg).");
//                    return;
//                }
//
//                int    age      = Integer.parseInt(ageField.getText());
//
//                if (age < 5 || age > 120) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic age (5–120).");
//                    return;
//                }
//
//
//                String gender   = (String) genderBox.getSelectedItem();
//
//                double bmi = weightKg / (heightM * heightM);
//                double bmr = gender.equals("Male")
//                        ? 10 * weightKg
//                        + 6.25 * (heightFt * 30.48)
//                        - 5 * age
//                        + 5
//                        : 10 * weightKg
//                        + 6.25 * (heightFt * 30.48)
//                        - 5 * age
//                        - 161;
//
//                double[] activityFactors = {1.2, 1.375, 1.55, 1.725, 1.9};
//                double tdee = bmr * activityFactors[activityBox.getSelectedIndex() - 1];
//
//                String healthStatus;
//                double adjustedCalories;
//                String goalSuggestion;
//
//                if (bmi < 18.5) {
//                    healthStatus     = "Underweight";
//                    adjustedCalories = tdee + 400;
//                    goalSuggestion   = "Suggested: Gain weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else if (bmi < 25) {
//                    healthStatus     = "Normal";
//                    adjustedCalories = tdee;
//                    goalSuggestion   = "Suggested: Maintain weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else if (bmi < 30) {
//                    healthStatus     = "Overweight";
//                    adjustedCalories = tdee - 400;
//                    goalSuggestion   = "Suggested: Lose weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else {
//                    healthStatus     = "Obese";
//                    adjustedCalories = tdee - 400;
//                    goalSuggestion   = "Suggested: Lose weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//
//                resultArea.setText(
//                        "Your BMI is: "      + String.format("%.1f", bmi)          + "\n"
//                                + "Health Status: "     + healthStatus                      + "\n"
//                                + "BMR: "               + String.format("%.0f", bmr)         + " kcal\n"
//                                + "TDEE: "              + String.format("%.0f", tdee)        + " kcal\n"
//                                + goalSuggestion
//                );
//
//                String url        = "jdbc:mysql://localhost:3307/project";
//                String uname      = "root";
//                String pa         = "@12042004";
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection conn   = DriverManager.getConnection(url, uname, pa);
//
//                String query =
//                        "INSERT INTO health_info "
//                                + "(user_id, height, age, gender, activity_level, weight, bmi, tdee, health_status) "
//                                + "VALUES (?,?,?,?,?,?,?,?,?)";
//                PreparedStatement stmt = conn.prepareStatement(
//                        query, Statement.RETURN_GENERATED_KEYS
//                );
//                stmt.setInt(    1, Session.currentUserId );
//                stmt.setDouble( 2, heightFt );
//                stmt.setInt(    3, age );
//                stmt.setString( 4, gender );
//                stmt.setString( 5, activityBox.getSelectedItem().toString() );
//                stmt.setDouble( 6, weightKg );
//                stmt.setDouble( 7, bmi );
//                stmt.setDouble( 8, tdee );
//                stmt.setString( 9, healthStatus );
//
//                int rows = stmt.executeUpdate();
//                if (rows > 0) {
//                    ResultSet generatedKeys = stmt.getGeneratedKeys();
//                    if (generatedKeys.next()) {
//                        int recordId = generatedKeys.getInt(1);
//                        JOptionPane.showMessageDialog(
//                                resultFrame,
//                                "Your User ID is: " + recordId
//                        );
//                    }
//                }
//                conn.close();
//
//                resultFrame.dispose();
//                previousFrame.setVisible(true);
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(
//                        resultFrame,
//                        "Please enter valid inputs!"
//                );
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        JButton backButton = new JButton("Back");
//        backButton.setBounds(50, 650, 100, 30);
//        backButton.setBackground(Color.BLACK);
//        backButton.setForeground(Color.WHITE);
//        resultBackground.add(backButton);
//
//        backButton.addActionListener(e -> {
//            previousFrame.setVisible(true);
//            resultFrame.dispose();
//        });
//
//        resultFrame.setVisible(true);
//    }
//}
//
//


//  older / mine
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class BMI {
//
//    public BMI(JFrame previousFrame) {
//        previousFrame.dispose();
//
//        JFrame resultFrame = new JFrame("Your Health Report");
//        resultFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        resultFrame.setLayout(null);
//
//        JLabel resultBackground = new JLabel();
//        resultBackground.setBounds(0, 0, 1366, 768);
//        resultFrame.setContentPane(resultBackground);
//        resultBackground.setLayout(null);
//
//        JLabel reportTitle = new JLabel("Health Report");
//        reportTitle.setFont(new Font("Arial", Font.BOLD, 28));
//        reportTitle.setForeground(Color.BLACK);
//        reportTitle.setBounds(180, 100, 400, 40);
//        resultBackground.add(reportTitle);
//
//        JLabel heightLabel = new JLabel("Enter height (in ft):");
//        heightLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        heightLabel.setForeground(Color.BLACK);
//        heightLabel.setBounds(180, 160, 300, 30);
//        resultBackground.add(heightLabel);
//
//        JTextField heightField = new JTextField();
//        heightField.setBounds(180, 190, 200, 30);
//        resultBackground.add(heightField);
//
//        JLabel ageLabel = new JLabel("Enter age:");
//        ageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        ageLabel.setForeground(Color.BLACK);
//        ageLabel.setBounds(180, 230, 300, 30);
//        resultBackground.add(ageLabel);
//
//        JTextField ageField = new JTextField();
//        ageField.setBounds(180, 260, 200, 30);
//        resultBackground.add(ageField);
//
//        JLabel genderLabel = new JLabel("Select gender:");
//        genderLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        genderLabel.setForeground(Color.BLACK);
//        genderLabel.setBounds(180, 300, 300, 30);
//        resultBackground.add(genderLabel);
//
//        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Select", "Male", "Female"});
//        genderBox.setBounds(180, 330, 200, 30);
//        resultBackground.add(genderBox);
//
//        JLabel activityLabel = new JLabel("Select activity level:");
//        activityLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        activityLabel.setForeground(Color.BLACK);
//        activityLabel.setBounds(180, 370, 300, 30);
//        resultBackground.add(activityLabel);
//
//        JComboBox<String> activityBox = new JComboBox<>(new String[]{
//                "Select",
//                "Sedentary (no exercise)",
//                "Lightly Active (light exercise 1-3 days/week)",
//                "Moderately Active (moderate exercise 3-5 days/week)",
//                "Very Active (hard exercise 6-7 days/week)",
//                "Super Active (physical job or intense training)"
//        });
//        activityBox.setBounds(180, 400, 250, 30);
//        resultBackground.add(activityBox);
//
//        JTextArea tipArea = new JTextArea(
//                "\u2705 Tips:\n"
//                        + "- Office/Student: Sedentary or Lightly Active\n"
//                        + "- Regular Gym: Moderately/Very Active\n"
//                        + "- Athlete/Manual Work: Super Active"
//        );
//        tipArea.setBounds(180, 440, 400, 60);
//        tipArea.setFont(new Font("Arial", Font.BOLD, 12));
//        tipArea.setForeground(Color.BLACK);
//        tipArea.setOpaque(false);
//        tipArea.setEditable(false);
//        resultBackground.add(tipArea);
//
//        JLabel weightLabel = new JLabel("Enter your current weight (kg):");
//        weightLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        weightLabel.setForeground(Color.BLACK);
//        weightLabel.setBounds(180, 510, 300, 30);
//        resultBackground.add(weightLabel);
//
//        JTextField weightInput = new JTextField();
//        weightInput.setBounds(180, 540, 200, 30);
//        resultBackground.add(weightInput);
//
//        JButton calculateButton = new JButton("Show Report");
//        calculateButton.setBounds(180, 570, 150, 30);
//        calculateButton.setBackground(Color.BLACK);
//        calculateButton.setForeground(Color.WHITE);
//        resultBackground.add(calculateButton);
//
//        JTextArea resultArea = new JTextArea();
//        resultArea.setEditable(false);
//        resultArea.setFont(new Font("Arial", Font.BOLD, 16));
//        resultArea.setBounds(400, 160, 500, 300);
//        resultArea.setOpaque(false);
//        resultArea.setForeground(Color.BLACK);
//        resultBackground.add(resultArea);
//
//        calculateButton.addActionListener(ev -> {
//            try {
//                if (heightField.getText().isEmpty()
//                        || ageField.getText().isEmpty()
//                        || weightInput.getText().isEmpty()
//                        || genderBox.getSelectedIndex() == 0
//                        || activityBox.getSelectedIndex() == 0
//                ) {
//                    JOptionPane.showMessageDialog(
//                            resultFrame,
//                            "Please fill in all fields!"
//                    );
//                    return;
//                }
//
//                double heightFt = Double.parseDouble(heightField.getText());
//                if (heightFt < 0.5 || heightFt > 8) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic height (0.5–8 ft).");
//                    return;
//                }
//
//                double heightM  = heightFt * 0.3048;
//                double weightKg = Double.parseDouble(weightInput.getText());
//                if (weightKg < 10 || weightKg > 500) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic weight (10–500 kg).");
//                    return;
//                }
//
//                int    age      = Integer.parseInt(ageField.getText());
//
//                if (age < 5 || age > 120) {
//                    JOptionPane.showMessageDialog(resultFrame,
//                            "Please enter a realistic age (5–120).");
//                    return;
//                }
//
//
//                String gender   = (String) genderBox.getSelectedItem();
//
//                double bmi = weightKg / (heightM * heightM);
//                double bmr = gender.equals("Male")
//                        ? 10 * weightKg
//                        + 6.25 * (heightFt * 30.48)
//                        - 5 * age
//                        + 5
//                        : 10 * weightKg
//                        + 6.25 * (heightFt * 30.48)
//                        - 5 * age
//                        - 161;
//
//                double[] activityFactors = {1.2, 1.375, 1.55, 1.725, 1.9};
//                double tdee = bmr * activityFactors[activityBox.getSelectedIndex() - 1];
//
//                String healthStatus;
//                double adjustedCalories;
//                String goalSuggestion;
//
//                if (bmi < 18.5) {
//                    healthStatus     = "Underweight";
//                    adjustedCalories = tdee + 400;
//                    goalSuggestion   = "Suggested: Gain weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else if (bmi < 25) {
//                    healthStatus     = "Normal";
//                    adjustedCalories = tdee;
//                    goalSuggestion   = "Suggested: Maintain weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else if (bmi < 30) {
//                    healthStatus     = "Overweight";
//                    adjustedCalories = tdee - 400;
//                    goalSuggestion   = "Suggested: Lose weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//                else {
//                    healthStatus     = "Obese";
//                    adjustedCalories = tdee - 400;
//                    goalSuggestion   = "Suggested: Lose weight ("
//                            + (int) adjustedCalories + " kcal/day)";
//                }
//
//                resultArea.setText(
//                        "Your BMI is: "      + String.format("%.1f", bmi)          + "\n"
//                                + "Health Status: "     + healthStatus                      + "\n"
//                                + "BMR: "               + String.format("%.0f", bmr)         + " kcal\n"
//                                + "TDEE: "              + String.format("%.0f", tdee)        + " kcal\n"
//                                + goalSuggestion
//                );
//
//                String url        = "jdbc:mysql://localhost:3307/project";
//                String uname      = "root";
//                String pa         = "@12042004";
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection conn   = DriverManager.getConnection(url, uname, pa);
//
//                String query =
//                        "INSERT INTO health_info "
//                                + "(user_id, height, age, gender, activity_level, weight, bmi, tdee, health_status) "
//                                + "VALUES (?,?,?,?,?,?,?,?,?)";
//                PreparedStatement stmt = conn.prepareStatement(
//                        query, Statement.RETURN_GENERATED_KEYS
//                );
//                stmt.setInt(    1, Session.currentUserId );
//                stmt.setDouble( 2, heightFt );
//                stmt.setInt(    3, age );
//                stmt.setString( 4, gender );
//                stmt.setString( 5, activityBox.getSelectedItem().toString() );
//                stmt.setDouble( 6, weightKg );
//                stmt.setDouble( 7, bmi );
//                stmt.setDouble( 8, tdee );
//                stmt.setString( 9, healthStatus );
//
//                int rows = stmt.executeUpdate();
//                if (rows > 0) {
//                    ResultSet generatedKeys = stmt.getGeneratedKeys();
//                    if (generatedKeys.next()) {
//                        int recordId = generatedKeys.getInt(1);
//                        JOptionPane.showMessageDialog(
//                                resultFrame,
//                                "Your User ID is: " + recordId
//                        );
//                    }
//                }
//                conn.close();
//
//                resultFrame.dispose();
//                previousFrame.setVisible(true);
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(
//                        resultFrame,
//                        "Please enter valid inputs!"
//                );
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        JButton backButton = new JButton("Back");
//        backButton.setBounds(50, 650, 100, 30);
//        backButton.setBackground(Color.BLACK);
//        backButton.setForeground(Color.WHITE);
//        resultBackground.add(backButton);
//
//        backButton.addActionListener(e -> {
//            previousFrame.setVisible(true);
//            resultFrame.dispose();
//        });
//
//        resultFrame.setVisible(true);
//    }
//}

