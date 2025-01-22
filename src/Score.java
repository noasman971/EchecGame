import java.util.Scanner;

public class Score {
    public static void SCORE(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n --* SCOREBOARD *-- ");
        System.out.println("MAEL ET PAS MAELLE - 3255pts");
        System.out.println("LOUIS LE GOAT - 3000pts ");
        System.out.println("LE ROI DES NOEILLE - 2850pts ");
        System.out.println("Noahrr - 2500pts ");
        System.out.println("Retour au Lobby = 4");


        short level;

        while (!scanner.hasNextShort()) {
            System.out.println("Your stupid but chill, return to lobby with 4");
            //detect if the button is invalid
            scanner.next();
            //show menu again
            SCORE();
        }
        //read the input choice by the user
        level = scanner.nextShort();

        //will execute one or more selected option
        switch (level) {
            case 4:
                System.out.println("Retour au Lobby ");
                SecondeMenu.SECONDMENU();
                break;
        }

        while (level < 4 || level >4) {
            System.out.println("return to lobby with 4 ");
        }
        //verify if the input is valid and she continue if is not integer1
        while (!scanner.hasNextInt()) {
            System.out.println("Your stupid but chill ");
            // Detects if the button is invalid
            scanner.next();
            // Display the menu again
            SCORE();
        }




    }


}
