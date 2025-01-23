
import java.util.Scanner;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;


public class Save {
    /**
     * Ask if we want to Save
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
     * Function to write into a file to save
     */
    public static void WriteToFile(String[][] grid){

        try {
            FileWriter fileWriter = new FileWriter("Save.txt", true);
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
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    /**
     *  Function to recup the grid saved
     * @return the grid save in the file
     */
    public static String[][] RecupGridFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            // 2. Récupérer la premiere ligne
            String content = lines.get(0);  // La premiere ligne du fichier

            // 3. Supprimer les espaces et sauts de ligne inutiles
            content = content.replaceAll("\\s+", "").trim();

            // 4. Extraire les emojis complets (sans découpe incorrecte)
            List<String> emojis = extractEmojis(content);

            // 5. Vérifier qu'on a exactement 110 emojis (11x10)
            int rows = 11;
            int cols = 10;
            if (emojis.size() != rows * cols) {
                System.out.println("❌ Erreur : Nombre d'emojis incorrect !");
                System.out.println("🔍 Emojis détectés : " + emojis.size());
                return null;
            }

            // 6. Remplir une grille 2D avec les emojis
            String[][] grid = new String[rows][cols];
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = emojis.get(index++);
                }
            }

            // 7. Afficher la grille dans la console
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            // pseudo
            System.out.println(lines.get(1));
            return grid;
        } catch (IOException e) {
            System.out.println("❌ Erreur de lecture du fichier : " + e.getMessage());
        }
        return null;
    }

    // Méthode pour extraire correctement les emojis (sans les couper)
    public static List<String> extractEmojis(String text) {
        List<String> emojis = new ArrayList<>();
        BreakIterator it = BreakIterator.getCharacterInstance(Locale.ROOT);
        it.setText(text);
        int start = it.first();
        for (int end = it.next(); end != BreakIterator.DONE; start = end, end = it.next()) {
            emojis.add(text.substring(start, end));
        }
        return emojis;
    }




    public static void main(String[] args) {
        //AskToSave();
        Game.load = true;
        Game.Setup();
        RecupGridFile();


    }
}
