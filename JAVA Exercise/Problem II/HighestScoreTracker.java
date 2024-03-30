import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighestScoreTracker {
    public static void main(String[] args) {
        String fileName = "scores.csv"; // Replace with the actual file name
        Map<String, Integer> playerScores = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile("(\\w+)_(\\d+)_(\\d{2})_(\\w{3})");

            while ((line = reader.readLine()) != null) {
                String[] entries = line.split(" ");
                for (String entry : entries) {
                    if (entry.matches("\\w+")) {
                        // If the entry is just a player's name, add it to the map with a default score
                        // of 0
                        playerScores.putIfAbsent(entry, 0);
                    } else {
                        Matcher matcher = pattern.matcher(entry);
                        if (matcher.find()) {
                            String playerName = matcher.group(1);
                            int score = Integer.parseInt(matcher.group(2));

                            // Update the maximum score for the player
                            playerScores.put(playerName, Math.max(playerScores.getOrDefault(playerName, 0), score));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the maximum score for each player
        for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}