import java.util.Scanner;

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
}