import java.util.Scanner;

public class GameMenu {
    public static void Game() {
        Scanner scanner = new Scanner(System.in);
        short level;
        //ask for lvl at user
        System.out.println("\n--- SELECT LVL --- ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("CHOOSE LEVEL (1-3):");
        System.out.println("BACK TO MENU = 4");

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
                System.out.println("You selected EASY lvl. Launch ... ");
                break;
            case 2:
                System.out.println("You selected MEDIUM lvl. Launch ... ");
                break;
            case 3:
                System.out.println("You selected HARD lvl. Launch ... ");
                break;
        }

        //read the lvl choose by the user
        while (level < 1 || level > 4) {
            System.out.println("between 1 and 3 happy idiots.");
            level = scanner.nextShort();


        }
    }
}
