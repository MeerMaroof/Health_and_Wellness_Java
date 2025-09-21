import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    public static void main(String[] args) {
        JFrame frr = new JFrame();
        frr.setSize(800, 600);
        frr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frr.setLayout(null);

        JPanel pp = new JPanel();
        pp.setBounds(0, 0, 800, 600);
        pp.setBackground(Color.BLACK);
        pp.setLayout(null);

        JButton backToDashboard = new JButton("Back");
        backToDashboard.setBounds(10, 10, 80, 30);
        backToDashboard.setBackground(Color.BLACK);
        backToDashboard.setForeground(Color.WHITE);
        backToDashboard.addActionListener(ev -> {
            Dashboard.main(new String[]{});
            frr.dispose();
        });
        pp.add(backToDashboard);


        // JLabel llb = new JLabel("Email:");   // commented out
        // llb.setBounds(50, 40, 120, 30);
        // llb.setForeground(Color.WHITE);
        // pp.add(llb);

        // JTextField eef = new JTextField();  // commented out
        // eef.setBounds(120, 40, 200, 30);
        // pp.add(eef);

        JButton bb = new JButton("Generate a Graph");
        bb.setBounds(110, 120, 150, 30);
        pp.add(bb);

        bb.addActionListener(e -> {
            DefaultCategoryDataset d = new DefaultCategoryDataset();


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project",
                        "abc", "000000000"
                );

                // fetch last 7 days activity for current user
                String sql = """
                    SELECT day, water_intake, calories_burn,
                           sleep_hours, diet_completed, exercise_completed
                      FROM activity
                     WHERE user_id = ?
                  ORDER BY id DESC
                     LIMIT 7
                """;

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Session.currentUserId);
                ResultSet rs = ps.executeQuery();

                List<String> days = new ArrayList<>();
                List<Integer> scores = new ArrayList<>();

                while (rs.next()) {
                    days.add(rs.getString("day"));

                    int score = 0;
                    // water intake: assume >=8 glasses is good
                    try {
                        int w = Integer.parseInt(rs.getString("water_intake"));
                        if (w >= 8) score++;
                    } catch (Exception ignore) {}

                    // calories_burn: assume >=300
                    try {
                        int cals = Integer.parseInt(rs.getString("calories_burn"));
                        if (cals >= 300) score++;
                    } catch (Exception ignore) {}

                    // sleep_hours: assume >=7
                    try {
                        int sl = Integer.parseInt(rs.getString("sleep_hours"));
                        if (sl >= 7) score++;
                    } catch (Exception ignore) {}

                    // diet_completed: "Yes" => +1
                    if ("Yes".equalsIgnoreCase(rs.getString("diet_completed"))) {
                        score++;
                    }

                    // exercise_completed: "Yes" => +1
                    if ("Yes".equalsIgnoreCase(rs.getString("exercise_completed"))) {
                        score++;
                    }

                    scores.add(score);
                }

                con.close();

                if (days.size() < 7) {
                    JOptionPane.showMessageDialog(
                            frr,
                            "Please complete at least 7 days to see your progress",
                            "Not Enough Data",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                frr.dispose();          // and add here...


                // reverse so oldest day is first
                Collections.reverse(days);
                Collections.reverse(scores);

                // populate dataset
                for (int i = 0; i < days.size(); i++) {
                    d.addValue(scores.get(i), "Daily Score", days.get(i));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }

            JFreeChart c = ChartFactory.createBarChart(
                    "Last 7 Days Activity Score",
                    "Day",
                    "Score (0–5)",
                    d
            );





            // chart ko panel main dalne ka liye panel bnaye ga

            ChartPanel p = new ChartPanel(c);

            // ab dialog bnaye ga us main sab kuch daalen ga
            JDialog dialog = new JDialog(frr, "Your Activity Progress", true);
            dialog.setLayout(new BorderLayout());
            dialog.add(p, BorderLayout.CENTER);

            // —— Here’s the Back button inside the chart dialog ——
            JButton backChart = new JButton("Back");
            backChart.setBackground(Color.BLACK);
            backChart.setForeground(Color.WHITE);
            backChart.addActionListener(ev -> {
                Graph.main(new String[]{});
                dialog.dispose();
            });
            JPanel south = new JPanel();
            south.add(backChart);
            dialog.add(south, BorderLayout.SOUTH);

            dialog.setResizable(false);
            dialog.setLocationRelativeTo(frr);
            dialog.setSize(800, 600);
            dialog.setVisible(true);
        });

        frr.setResizable(false);
        frr.setLocationRelativeTo(null);
        frr.setContentPane(pp);
        frr.setVisible(true);
    }
}

