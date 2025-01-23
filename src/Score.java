import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Score {

    public static void main(String[] args) {
        String nickname = Game.player; // Get the player's nickname
        int plus = 5; // win score
        int moin = -2; // loss score
        String Fil = "ScoreList.txt"; // file name

        Map<String, Integer> AddScore = new HashMap<>(); // Store associations in memory

        // Read the existing file (if it exists) to fill the map
        try (BufferedReader read = new BufferedReader(new FileReader(Fil))) { // File reading system
            String line;
            while ((line = read.readLine()) != null) { // Loop as long as there are lines to read in the file
                String[] parts = line.split("="); // Split the line into two parts: name and score
                AddScore.put(parts[0], Integer.parseInt(parts[1])); // Check the split and add to the map
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage()); // Error message for file reading
        }

        // Check if the name already exists and update if necessary
        if (AddScore.containsKey(nickname)) {
            if (Game.win) {
                AddScore.put(nickname, AddScore.get(nickname) + plus); // Update the player's score
            } else {
                AddScore.put(nickname, AddScore.get(nickname) + moin); // Update the player's score
            }
        } else {
            if (Game.win) {
                AddScore.put(nickname, plus); // Add the player's score
            } else {
                AddScore.put(nickname, moin); // Add the player's score
            }
        }

        // Write the associations to the file
        try (BufferedWriter right = new BufferedWriter(new FileWriter(Fil))) { // File writing system
            for (Map.Entry<String, Integer> entry : AddScore.entrySet()) {
                right.write(entry.getKey() + "=" + entry.getValue()); // Write the nickname and score with '=' in between
                right.newLine(); // New line after writing
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage()); // Error message for file writing
        }
    }

}
