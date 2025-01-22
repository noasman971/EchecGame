import java.io.*;

public class Score {
    public static void main(String[] args) {

        // Nom du fichier de sortie
        String myFil = "ScoreList.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFil))) {
            for (String element : myFil.split("\n")) {
                writer.write(element);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}
