import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Score {

    public static void main(String[] args) {
        String nom = Game.player;//récupération du joueur
        int plus = 5;//score victoir
        int moin = -2; //score défète
        String Fil = "ScoreList.txt";//fil


        Map<String, Integer> AddScore = new HashMap<>();//stocker les associations en mémoire

        // Lecture du fichier existant (si existe) pour remplir le Map
        try (BufferedReader read = new BufferedReader(new FileReader(Fil))) { //système de lecture du fichier
            String line;
            while ((line = read.readLine()) != null) {// Boucle tant qu'il y a des lignes à lire dans le fichier
                String[] parts = line.split("=");// Séparation de la ligne en deux parties : le nom et le score
                AddScore.put(parts[0], Integer.parseInt(parts[1]));// Vérification de la séparation
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage()); //message d'érreur pour la lecture du fichier
        }

        // Vérification si le nom existe déjà et mise à jour si nécessaire
        if (AddScore.containsKey(nom)) {
            if (Game.win=true) {plus += AddScore.get(nom);}
            else {moin += AddScore.get(nom);}
        }
        // Ajout de l'association dans le Map
        else {
            if (Game.win=true) {AddScore.put(nom, plus);}
            else {AddScore.put(nom, moin);}
        }



        // Écriture des associations dans le fichier
        try (BufferedWriter right = new BufferedWriter(new FileWriter(Fil))) {//système de d'écriture du fichier
            for (Map.Entry<String, Integer> entry : AddScore.entrySet()) {
                right.write(entry.getKey() + "=" + entry.getValue());//= entre le nickname et le score
                right.newLine();//écriture
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());//message d'érreur pour la lecture du fichier
        }
    }
}