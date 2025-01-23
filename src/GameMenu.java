import java.util.Scanner;

public class GameMenu {
    public static void Game() {
        Scanner scanner = new Scanner(System.in);
        short level;
        //ask for lvl at user
        System.out.println("\u001B[5m\n--- SELECT LVL --- ");
        System.out.println("\u001B[36m 1. 2 PLAYERS");
        System.out.println("\u001B[36m 2. 3 PLAYERS");
        System.out.println("\u001B[36m 3. 4 PLAYERS");
        System.out.print("\u001B[33m CHOOSE number player (1-3):");
        System.out.println("     BACK TO MENU = 4");

        //check if its an integer(entier)
        while (!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, return to lobby with 4");
            // Detects if the button is invalid
            scanner.next();
            // Display the menu again
            Game();
        }
        level = scanner.nextShort();

        //display the selected lvl
        switch (level) {
            case 1:
                System.out.println("You selected 2 PLAYERS . Launch ... ");
                Grid.number_player=2;
                Game.Setup();
                break;
            case 2:
                System.out.println("You selected 3 PLAYERS . Launch ... ");
                Grid.number_player=3;
                Game.Setup();
                break;
            case 3:
                System.out.println("You selected 4  PLAYERS . Launch ... ");
                Grid.number_player=4;
                Game.Setup();
                break;
        }

        //read the lvl choose by the user
        while (level < 1 || level > 4) {
            System.out.println("between 1 and 3 happy idiots.");
            level = scanner.nextShort();


        }
    }
}
