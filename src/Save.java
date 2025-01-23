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
    public static void WriteToFile(char[][] grid){

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
            fileWriter.write("\n");
            for (int i = 0; i < Grid.number_player; i++) {
                for (int j = 0; j < Grid.number_player; j++) {
                    fileWriter.write(Game.number_player);
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
    public static char[][] RecupGridFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            // 2. Récupérer la premiere ligne
            String content = lines.get(0);  // La premiere ligne du fichier

            // 3. Supprimer les espaces et sauts de ligne inutiles
            content = content.replaceAll("\\s+", "").trim();



            int height = 11;
            int width = 10;

            // 6. Remplir une grille 2D avec les chiffres en char
            char[][] grid = new char[height][width];
            int index = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    grid[i][j] = content.charAt(index);
                    index++;
                }
            }

            // 7. Afficher la grille dans la console
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }

            return grid;

        } catch (IOException e) {
            System.out.println("❌ Erreur de lecture du fichier : " + e.getMessage());
        }
        return null;
    }

    /**
     * Function to recup pseudo of the player
     * @return the pseudo of the players saved
     */
    public static List<String> PlayerPseudo() {
        List<String> pseudo = new ArrayList<>(); // Tableau vide par défaut
        try {
            // Lire toutes les lignes du fichier
            var lines = Files.readAllLines(Paths.get("Save.txt"));

            // Récupérer la deuxième ligne
            String secondLine = lines.get(1);

            // Diviser la ligne en pseudonymes en utilisant la virgule comme séparateur
            pseudo = Arrays.asList(secondLine.split(","));

        } catch (IOException e) {
            System.out.println("❌ Erreur de lecture du fichier : " + e.getMessage());
        }
        return pseudo;
    }

    /**
     * Function to recup position of the player
     * @return the position of the player
     */
    public static byte[][] PlayerPosition() {
        byte[][] position = new byte[2][4]; // Tableau vide par défaut
        try {
            // Lire toutes les lignes du fichier
            List<String> lines = Files.readAllLines(Paths.get("Save.txt"));

            // Récupérer la troisième ligne
            String thirdLine = lines.get(2);

            int index = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    // Convertir chaque caractère en byte et l'ajouter au tableau
                    position[i][j] = Byte.parseByte(String.valueOf(thirdLine.charAt(index)));
                    System.out.println(position[i][j]);
                    index++;
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Erreur de lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Erreur de conversion des données : " + e.getMessage());
        }
        return position;
    }


    /**
     * Function to clear the save file to have just one save
     */
    public static void clearFile() {
        try {
            // Écrire une chaîne vide pour effacer le fichier
            Files.write(Paths.get("Save.txt"), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("❌ Erreur lors de l'effacement des données : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        RecupGridFile();
        PlayerPseudo();

    }
}