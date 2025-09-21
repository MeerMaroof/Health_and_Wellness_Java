import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Diet {

    public Diet() {
        JFrame frame = new JFrame("7-Day Diet Plan");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JTextArea outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JButton fetchButton = new JButton("Load My Diet Plan");
        fetchButton.addActionListener(e -> {
            outputArea.setText("");
            try {
                int userId = Session.currentUserId;
                // Fetch latest tdee and healthStatus for current user
                String urlDb = "jdbc:mysql://localhost:3307/project";
                String uname = "root";
                String pa = "@12042004";
                String sql = "SELECT tdee, health_status FROM health_info WHERE user_id = ? ORDER BY id DESC LIMIT 1";
                String tdee = "", healthStatus = "";
                try (Connection con = DriverManager.getConnection(urlDb, uname, pa);
                     PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, userId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            tdee = rs.getString("tdee");
                            healthStatus = rs.getString("health_status");
                        } else {
                            outputArea.setText("❌ No BMI record found for current user.");
                            return;
                        }
                    }
                }

                // Prepare API prompt
                String prompt = "Give a detailed 7-day Pakistani diet plan list and instructions only for someone with TDEE "
                        + tdee + " and health status: " + healthStatus
                        + ". Don't include any introduction or other useless things, just the concise diet plan.";

                // Call generative API
                URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyDB3h0Tf3DGO_o5CU-omlMueI1c34J1z64");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject json = new JSONObject();
                JSONObject textPart = new JSONObject();
                textPart.put("text", prompt);

                JSONArray partsArray = new JSONArray();
                partsArray.add(textPart);

                JSONObject contentObj = new JSONObject();
                contentObj.put("parts", partsArray);

                JSONArray contentsArray = new JSONArray();
                contentsArray.add(contentObj);

                json.put("contents", contentsArray);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(json.toJSONString().getBytes());
                    os.flush();
                }

                int responseCode = conn.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    BufferedReader errorReader = new BufferedReader(
                            new InputStreamReader(conn.getErrorStream()));
                    StringBuilder errorResponse = new StringBuilder();
                    String line;
                    while ((line = errorReader.readLine()) != null) {
                        errorResponse.append(line);
                    }
                    errorReader.close();
                    outputArea.setText("❌ Error: HTTP " + responseCode + " - " + errorResponse);
                    return;
                }

                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                }

                JSONParser parser = new JSONParser();
                JSONObject respObj = (JSONObject) parser.parse(response.toString());
                JSONObject first = (JSONObject) ((JSONArray) respObj.get("candidates")).get(0);
                JSONObject content = (JSONObject) first.get("content");
                JSONArray parts = (JSONArray) content.get("parts");
                String dietPlan = (String) ((JSONObject) parts.get(0)).get("text");
                outputArea.setText(dietPlan);

            } catch (Exception ex) {
                outputArea.setText("❌ Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(fetchButton);
        frame.add(topPanel, BorderLayout.NORTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            Dashboard.main(new String[]{});
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
