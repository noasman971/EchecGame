import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Save {
    /**
     * Prompts the user to decide whether to save or not.
     * Returns true if the user selects 'y', false if 'n'.
     *
     * @return boolean: true for save, false for no save.
     */
    public static boolean AskToSave() {
        boolean Ican = false;
        boolean save = false;
        while(!Ican) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to Save \uD83D\uDCBE: y/n ");

            char x = sc.next().charAt(0);
            if (x == 'y') {
                Ican = true;
                save = true;

            } else if (x == 'n') {
                Ican = true;
            }
        }
        return save;
    }

    /**
     * Writes the current grid, player nicknames, and positions to a save file.
     */
    public static void WriteToFile(char[][] grid){

        try {
            FileWriter fileWriter = new FileWriter("Save.txt");
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    fileWriter.write(grid[i][j]);
                }
            }
            fileWriter.write("\n");
            for (int i = 0; i < Grid.number_player; i++) {
                fileWriter.write(Nickname.nicknames.get(i));
                if (i<Grid.number_player-1) {
                    fileWriter.write(",");
                }

            }
            fileWriter.write("\n");
            for (int i = 0; i < Grid.playerPositions.length; i++) {
                fileWriter.write(Grid.playerPositions[i][0] + " " + Grid.playerPositions[i][1] + " "); //  Y X
            }
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    /**
     * Reads and returns the saved grid from the file.
     * @return the saved grid as a 2D char array.
     */
    public static char[][] RecupGridFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            String content = lines.get(0);

            int height = 11;
            int width = 10;

            char[][] grid = new char[height][width];
            int index = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    grid[i][j] = content.charAt(index);
                    index++;
                }
            }

            return grid;

        } catch (IOException e) {
            System.out.println("❌ Read Error : " + e.getMessage());
        }
        return null;
    }

    /**
     * Gets the player names from the save file.
     * @return a list of player names.
     */
    public static List<String> PlayerPseudo() {
        List<String> pseudo = new ArrayList<>();
        try {

            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            String secondLine = lines.get(1);

            pseudo = Arrays.asList(secondLine.split(","));

        } catch (IOException e) {
            System.out.println("❌ Read Error : " + e.getMessage());
        }
        return pseudo;
    }

    /**
     * Gets the positions of the players from the save file.
     * @return a list of player positions (X, Y).
     */
    public static byte[][] PlayerPosition() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            String positionsLine = lines.get(2);
            String[] positions = positionsLine.split(" ");

            byte[][] playerPositions = new byte[Grid.number_player][2];

            for (int i = 0; i < Grid.number_player; i++) {
                playerPositions[i][0] = Byte.parseByte(positions[i * 2]);   // X
                playerPositions[i][1] = Byte.parseByte(positions[i * 2 + 1]); // Y
            }

            return playerPositions;

        } catch (IOException e) {
            System.out.println("❌ Read Error : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Position error format : " + e.getMessage());
        }
        return null;
    }

}