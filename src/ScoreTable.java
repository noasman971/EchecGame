/*import java.util.Scanner;

public class ScoreTable {

    public static void SCORE() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n --* SCOREBOARD *-- ");
        System.out.println("Retour au Lobby = 4");

        while(!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, return to lobby with 4");
            scanner.next();
            SCORE();
        }

        short level = scanner.nextShort();
        switch (level) {
            case 4:
                System.out.println("Retour au Lobby ");
                SecondeMenu.SECONDMENU();
        }

        while(level < 4 || level > 4) {
            System.out.println("return to lobby with 4 ");
        }

        while(!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill ");
            scanner.next();
            SCORE();
        }

    }
}*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreTable {
    public static void main(String[] args) {
        // Nom du fichier à lire (ici, "ScoreList.txt")
        String fichier = "ScoreList.txt";

        // Création d'une liste pour stocker les scores et les pseudos
        List<String[]> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            // Lecture ligne par ligne du fichier
            String ligne;
            while ((ligne = br.readLine()) != null) {
                // On divise chaque ligne en deux parties, séparées par un "="
                String[] elements = ligne.split("=");
                scores.add(elements);  // Ajout des éléments (pseudo, score) à la liste
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }


        System.out.println("+-----------+-------+");
        System.out.println("| Nickname  | Score |");
        System.out.println("+-----------+-------+");

        // Parcours de la liste des scores pour les afficher
        for (String[] score : scores) {
            // Ajustement de la largeur des colonnes pour un meilleur alignement
            String Nickname = String.format("%-10s", score[0]);  // Le pseudo à une largeur de 10 caractères
            String scoreValue = String.format("%-6s", score[1]);  // Le score à une largeur de 7 caractères
            // Affichage formaté du pseudo et du score dans le tableau
            System.out.println("| " + Nickname + "| " + scoreValue + "|");
        }

        // Affichage de la ligne de fin du tableau
        System.out.println("+-----------+-------+");
    }
}

