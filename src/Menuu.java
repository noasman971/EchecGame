import java.util.Scanner;

class Menuu {

    public static void Menu() {
        System.out.println("\n=== GOAT'S MENU ===");
        System.out.println("1. PLAY");
        System.out.println("2. RULES");
        System.out.println("3. OPTIONS");
        System.out.println("4. LEAVE");
        System.out.print("CHOOSE WHAT YOU WANT (1-4): ");
    }


    public static void Rules() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("RULES:");
        System.out.println("1. A player cannot occupy a destroyed square or a square already occupied.");
        System.out.println("2. A player cannot destroy an occupied square.");
        System.out.println("3. A player blocked during a turn is declared the loser.");
        System.out.println("Back to menu with 4.");

        short level;
        level = scanner.nextShort();

        switch (level) {
            case 4:
                Menu();
                break;
        }
        while (!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, return to lobby with enter");
            // Detects if the button is invalid
            scanner.next();
            // Display the menu again
            Rules();

        }
    }


    public static void Options() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Options");
        System.out.println("2. BLACK MODE / WHITE MODE");
        System.out.println("Back to menu with 4.");

        while (!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, return to lobby with enter");
            // Detects if the button is invalid
            scanner.next();
            // Display the menu again
            Rules();
             }
                switch (scanner.nextShort()) {
                    case 4:
                    Menu();
                    break;
                }
    }

    public static void EsterEgg() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("Clément le meilleur PO")){
            boolean esteregg = true;
        };
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short choix;

        do {
            // Menu display
            Menu();

            //validate the user input to make sure its a valid number
            while (!scanner.hasNextInt()) {
                System.out.println("Your stupid but chill, choose between 1 and 4.");
                // Detects if the button is invalid
                scanner.nextLine();
            }

            // Read user's choice
            choix = scanner.nextShort();

            if (choix==58) {
                EsterEgg();
            }
            // Check if the choice is between 1 and 4
            else if (choix < 1 || choix > 4) {
                System.out.println("Your stupid but chill, choose between 1 and 4.");
                continue;
            }

            // Choice processing
            switch (choix) {
                case 1:
                    SecondeMenu.SECONDMENU();
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
