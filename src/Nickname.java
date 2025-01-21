import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pseudo {
    static Scanner scanner = new Scanner(System.in);
    static List<String> pseudos = new ArrayList<>();

    public static void main(String[] args) {
        int numberOfPlayers = 4;
        for (int i = 1; i <= numberOfPlayers; i++) {
            askNickname(i);
        }

        // Afficher tous les pseudos
        System.out.println("The players' nicknames are:");
        for (String pseudo : pseudos) {
            System.out.println(", " + pseudo);
        }
    }

    public static void askNickname(int player) {
        String pseudo;

        do {
            System.out.print("Player " + player + ", choisissez un pseudo (entre 2 et 10 caractères) : ");
            pseudo = scanner.nextLine();

            if (pseudo.length() < 2 || pseudo.length() > 10) {
                System.out.println("Erreur : le pseudo doit contenir entre 2 et 10 caractères. Veuillez réessayer.");
            } else {
                pseudos.add(pseudo);
                break;
            }
        } while (true);
    }
}