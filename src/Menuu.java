import java.util.Scanner;

class Menuu {
    //Method to display the menu
    public static void Menu() {
        System.out.println("\n=== GOAT'S MENU ===");
        System.out.println("1. PLAY");
        System.out.println("2. RULES");
        System.out.println("3. OPTIONS");
        System.out.println("4. LEAVE");
        System.out.print("CHOOSE WHAT YOU WANT (1-4): ");
    }

    public static void  SECONDMENU(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("\n--- Lobby ---");
        System.out.println("1. LOAD GAME");
        System.out.println("2. CHOOSE LVL");
        System.out.print("CHOOSE WHAT YOU WANT (1-3):");
        System.out.println("BACK TO MENU = 3");

        //check if its an integer(entier)
        short level;

        level = scanner.nextShort();

            switch (level) {
            case 1:
                System.out.println("THE GAME Loading ...");
                break;
            case 2:
                Game();
                break;
            case 3:
                Menu();
                break;
            }

                while (level < 1 || level > 3) {
            System.out.println("between 1 and 2 happy idiots.");
            level = scanner.nextShort();
                }



                while (!scanner.hasNextInt()) {
                    System.out.println("Your stupid but chill, choose between 1 and 3.");
                    // Detects if the button is invalid
                    scanner.next();
                    // Display the menu again
                    SECONDMENU();
                    }
    }

    //Method to display the game and ask for the lvl
    public static void Game() {
        Scanner scanner = new Scanner(System.in);


        //ask for lvl at user
        System.out.println("\n--- SELECT LVL --- ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("CHOOSE LEVEL (1-3):");
        System.out.println("BACK TO MENU = 4");

        //check if its an integer(entier)
        short level;

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
            case 4:
                Menu();
                System.out.println();
                break;
        }

            //read the lvl choose by the user
                while (level < 1 || level > 4) {
                    System.out.println("between 1 and 3 happy idiots.");
                    level = scanner.nextShort();
        }

                //as long as its not a valid integer then the question still ask
                while (!scanner.hasNextShort()) {
                    //recover the invalid character
                    scanner.next();
                    //ask question for lvl
                    System.out.print("CHOOSE LEVEL (1-3): ");
                    }
    }

    // Method to display the rules
    public static void Rules() {
        System.out.println("RULES:");
        System.out.println("1. A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println("2. A player cannot destroy an occupied square.");
        System.out.println("3. A player blocked during a turn is declared the loser.");
        BackToMenu();
    }

    // Method to display the options
    public static void Options() {
        System.out.println("Options");
        System.out.println("2. BLACK MODE / WHITE MODE");
        BackToMenu();
    }

    // When the user presses enter they return to the menu
    public static void BackToMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BACK TO MENU = ENTER");
        // Wait for user input
        scanner.nextShort();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short choix;

        do {
            // Menu display
            Menu();

            // Validate the user's input to make sure it's a valid number
            while (!scanner.hasNextInt()) {
                System.out.println("Your stupid but chill, choose between 1 and 4.");
                // Detects if the button is invalid
                scanner.next();
                // Display the menu again
                Menu();
            }

            // Read user's choice
            choix = scanner.nextShort();

            // Check if the choice is between 1 and 4
            if (choix < 1 || choix > 4) {
                System.out.println("Your stupid but chill, choose between 1 and 4.");
                continue;
            }

            // Choice processing
            switch (choix) {
                case 1:
                    SECONDMENU();
                    break;
                case 2:
                    Rules();
                    break;
                case 3:
                    Options();
                    break;
                case 4:
                    System.out.println("SEE YOU SOON");
                    break;
            }
            //As long as the user hasn't quit, the menu won't close
        } while (choix != 4);
    }
}
