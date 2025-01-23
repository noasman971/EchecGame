import java.util.Scanner;
class SecondeMenu{
    public static void  SECONDMENU(){
        Scanner scanner = new Scanner(System.in);
        short level;

        System.out.println("\n                                                               --- Lobby ---");
        System.out.println("                                                                 1. LOAD GAME");
        System.out.println("                                                                 2. CHOOSE LVL");
        System.out.println("                                                                 3. SCORE");
        System.out.print("                                                              CHOOSE WHAT YOU WANT (1-3):");
        System.out.println("                                                                BACK TO MENU = 4");

        //check if its an integer
        while (!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, choose between 1 and 3.");
            // Detects if the button is invalid
            scanner.next();
            // Display the menu again
            SECONDMENU();
        }

        level = scanner.nextShort();


        switch (level) {
            case 1:
                System.out.println("THE GAME Loading ...");
                Game.load = true;
                Game.Setup();
                break;
            case 2:
                GameMenu.Game();
                break;
            case 3:
                //ScoreTable.SCORE();
                break;
            case 4:
                Menuu.Menu();
                break;
        }


        while (level < 1 || level > 3) {
            System.out.println();
            level = scanner.nextShort();
        }

    }

}

