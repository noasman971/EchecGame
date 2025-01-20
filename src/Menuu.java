import java.util.Scanner;

class Menuu {
    //Method to display the menu
    public static void DisplayMenu() {
        System.out.println("\n=== GOAT'S MENU ===");
        System.out.println("1. PLAY");
        System.out.println("2. RULES");
        System.out.println("3. OPTIONS");
        System.out.println("4. LEAVE");
        System.out.print("CHOOSE WHAT YOU WANT (1-4): ");
    }

    //Method to display the game
    public static void GAME() {
        System.out.println("THE GAME BEGINS...");
        BackToMenu();
    }

    //Method to display the rules
    public static void DisplayRules() {
        System.out.println("RULES:");
        System.out.println("1. A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println("2. A player cannot destroy an occupied square.");
        System.out.println("3. A player blocked during a turn is declared the loser.");
        BackToMenu();
    }

    //Method to display the options
    public static void DisplayOptions() {
        System.out.println("Options");
        System.out.println("1. MODIFY LEVEL");
        System.out.println("2. BLACK MODE / WHITE MODE");
        BackToMenu();
    }

    // When the user presses enter they return to the menu
    public static void BackToMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BACK TO MENU = ENTER");
        // Wait for user input
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short choix;


        do {
            //Menu display
            DisplayMenu();

            //Validate the user's input to make sure it's a valid number
            while (!scanner.hasNextInt()) {
                System.out.println("your stupid but chill, choose between 1 and 4");
                //detects if the button is invalid
                scanner.next();
                //Display the menu again
                DisplayMenu();
            }

            //Read user's choice
            choix = scanner.nextShort();

            //Check if the choice is between 1 and 4
            if (choix < 1 || choix > 4) {
                System.out.println("your stupid but chill, choose between 1 and 4");
                continue;
            }

            // Choice processing
            switch (choix) {
                case 1:
                    GAME();
                    break;
                case 2:
                    DisplayRules();
                    break;
                case 3:
                    DisplayOptions();
                    break;
                case 4:
                    System.out.println("SEE YOU SOON");
                    break;
            }
            //as long as the user hasn't quit the menu won't close
        } while (choix != 4);
    }
}
