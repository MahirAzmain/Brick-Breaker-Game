package Main;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParserApp extends JFrame {
    private JTextArea resultTextArea;

    public JsonParserApp() {
        super("JSON Parser App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(51, 0, 51));
        
        
       
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setBackground(new Color(102, 0, 102));
        resultTextArea.setForeground(Color.BLACK);
       // Add ScrollBars
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        JButton parseButton = new JButton("Parse JSON");
        parseButton.setBackground(new Color(153, 255, 255));
        parseButton.setForeground(Color.BLACK);


        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseJsonFromApi();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTextArea.setText("");
                showMainMenu();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(parseButton);
        buttonPanel.add(backButton);

        getContentPane().setLayout(new BorderLayout());

        // Use JScrollPane instead of directly adding JTextArea
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
      //  getContentPane().add(resultTextArea, BorderLayout.CENTER);
        
       // getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        
       // getContentPane().add(scrollPane, BorderLayout.CENTER);
       // getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void parseJsonFromApi() {
        try {
            URL url = new URL("https://api.myjson.online/v1/records/452eb693-0ade-4b02-9961-d94ceb952bac");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                connection.disconnect();

                // Parse JSON
                parseJson(response.toString());
            } else {
                resultTextArea.setText("Failed to fetch data from API. HTTP error code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
            resultTextArea.setText("Error: " + e.getMessage());
        }
    }

    private void parseJson(String jsonString) {
        try {
            Gson gson = new Gson();
            JsonObject mainObject = gson.fromJson(jsonString, JsonObject.class);

            if (mainObject != null) {
                JsonObject dataObject = mainObject.getAsJsonObject("data");
                JsonObject gameObject = dataObject.getAsJsonObject("game");

                if (gameObject != null) {
                    String gameName = gameObject.getAsJsonPrimitive("name").getAsString();

                    JsonArray tipsArray = gameObject.getAsJsonArray("tips");
                    JsonObject controlsObject = gameObject.getAsJsonObject("controls");
                    JsonObject elementsObject = gameObject.getAsJsonObject("elements");
                    JsonObject gameplayObject = gameObject.getAsJsonObject("gameplay");
                    String objective = gameObject.getAsJsonPrimitive("objective").getAsString();
                    JsonObject progressionObject = gameObject.getAsJsonObject("progression");

                    StringBuilder parsedData = new StringBuilder("Game Information:\n");
                    parsedData.append("Game Name: ").append(gameName).append("\n\n");

                    parsedData.append("Tips:\n");
                    for (JsonElement jsonElement : tipsArray) {
                        parsedData.append("- ").append(jsonElement.getAsString()).append("\n");
                    }

                    parsedData.append("\nControls:\n").append(controlsObject.toString()).append("\n");
                    parsedData.append("\nElements:\n").append(elementsObject.toString()).append("\n");
                    parsedData.append("\nGameplay:\n").append(gameplayObject.toString()).append("\n");
                    parsedData.append("\nObjective: ").append(objective).append("\n");
                    parsedData.append("\nProgression:\n").append(progressionObject.toString());

                    resultTextArea.setText(parsedData.toString());
                } else {
                    resultTextArea.setText("Error: 'game' object not found in JSON");
                }
            } else {
                resultTextArea.setText("Error: JSON object is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultTextArea.setText("Error parsing JSON: " + e.getMessage());
        }
    }

    private void showMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.dispose(); // Close the current frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new JsonParserApp().setVisible(true);
            }
        });
    }
}
