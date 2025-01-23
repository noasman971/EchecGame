import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Score {

    public static void main(String[] args) {
        String nickname = Game.player; // récupération du joueur
        int plus = 5; // score victoire
        int moin = -2; // score défaite
        String Fil = "ScoreList.txt"; // fichier

        Map<String, Integer> AddScore = new HashMap<>(); // stocker les associations en mémoire

        // Lecture du fichier existant (si existe) pour remplir le Map
        try (BufferedReader read = new BufferedReader(new FileReader(Fil))) { // système de lecture du fichier
            String line;
            while ((line = read.readLine()) != null) { // Boucle tant qu'il y a des lignes à lire dans le fichier
                String[] parts = line.split("="); // Séparation de la ligne en deux parties : le nom et le score
                AddScore.put(parts[0], Integer.parseInt(parts[1])); // Vérification de la séparation
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage()); // message d'erreur pour la lecture du fichier
        }

        // Vérification si le nom existe déjà et mise à jour si nécessaire
        if (AddScore.containsKey(nickname)) {
            if (Game.win) {
                AddScore.put(nickname, AddScore.get(nickname) + plus); // Mise à jour du score du joueur
            } else {
                AddScore.put(nickname, AddScore.get(nickname) + moin); // Mise à jour du score du joueur
            }
        } else {
            if (Game.win) {
                AddScore.put(nickname, plus); // Ajout du score du joueur
            } else {
                AddScore.put(nickname, moin); // Ajout du score du joueur
            }
        }

        // Écriture des associations dans le fichier
        try (BufferedWriter right = new BufferedWriter(new FileWriter(Fil))) { // système d'écriture du fichier
            for (Map.Entry<String, Integer> entry : AddScore.entrySet()) {
                right.write(entry.getKey() + "=" + entry.getValue()); // = entre le nickname et le score
                right.newLine(); // écriture
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage()); // message d'erreur pour l'écriture du fichier
        }
    }
}
