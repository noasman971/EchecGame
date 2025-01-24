import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static String player;
    public static Boolean win = false;
    public static Boolean load = false;
    public static char[][] grid;
    public static byte number_player;
    public static byte[][] player_position;

    /**
     * Sets up the game, either by loading a saved game or starting a new one.
     * It handles player turns, checks for blocked players, manages eliminations,
     * and checks for a winner. It also allows saving the game and using Easter eggs.
     *
     */

    private static void initializePlayerPositions() {
        player_position = new byte[number_player][2];

        // Attribuer les positions prédéfinies
        byte[] j1 = {(byte) (Grid.height / 2 - 2), (byte) (Grid.width / 2)};
        byte[] j2 = {(byte) (Grid.height / 2 - 1), (byte) (Grid.width / 2)};
        byte[] j3 = {(byte) (Grid.height / 2 + 1), (byte) (Grid.width / 2)};
        byte[] j4 = {(byte) (Grid.height / 2 + 2), (byte) (Grid.width / 2)};

        player_position[0] = j1;
        player_position[1] = j2;
        if (number_player > 2) player_position[2] = j3;
        if (number_player > 3) player_position[3] = j4;
    }

    public static void Setup() {
        char fill = '0';
        if (Menuu.esteregg) {
            Grid.grid_change();
            fill = '7';
//            EsterEgg.allwalker(1000);
//            EsterEgg.storm();

        }

        if (load) {
            System.out.println("You have loaded the game!");
            grid = Save.RecupGridFile();
            number_player = (byte) Save.PlayerPseudo().size();
            Nickname.nicknames = Save.PlayerPseudo();
            player_position = Save.PlayerPosition();


        } else {
            grid = Grid.grid;
            number_player = Grid.number_player;
            Nickname.main(null);
            player_position = Grid.playerPositions;


        }

        boolean end = true;
        ArrayList<Integer> eliminate_player = new ArrayList<>();


        String[] liste_emoji = {"\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDB3", "\uD83D\uDC68\uD83C\uDFFF", "\uD83D\uDC69\uD83C\uDFFE", "\uD83D\uDC69\uD83C\uDFFB"};


        if (!load) {
            Grid.grid_fill(grid, fill);
            if (Menuu.esteregg) {
                EsterEgg.allwalker(500);
            }
            for (byte i = 0; i < number_player; i++) {
                String s = "" + (i + 1);
                Grid.place_players(grid, player_position[i], s.charAt(0));
            }

        }


        while (end) {
            for (int i = 0; i < number_player; i++) {
                if (eliminate_player.size() == number_player - 1) {
                    win = true;
                    for (int j = 0; j < number_player; j++) {
                        if (!eliminate_player.contains(j)) {
                            player = Nickname.nicknames.get(j); // Récupérer le pseudo du gagnant
                            break;
                        }
                    }
                    Score.main(null);
                    System.out.println("La partie est terminée ! Le joueur " + player + " gagne !");
                    if (!Menuu.esteregg) {
                        initializePlayerPositions();
                    }
                    end = false;
                    break;
                }
                // Passez au joueur suivant si le joueur est éliminé
                if (!eliminate_player.contains(i)) {
                    // Affichez la grille
                    Grid.see_grid(grid);

                    // Verify if the player is blocked
                    if (No_Move.detection(grid, player_position[i])) {
                        System.out.println("The player " + Nickname.nicknames.get(i) + " is blocked !");
                        win = false;
                        player = Nickname.nicknames.get(i);
                        Score.main(null);

                        // Add the player to the eliminate list
                        eliminate_player.add(i);
                    }
                    else {
                        // Player turn
                        System.out.println("It's your turn " + Nickname.nicknames.get(i) + " " + liste_emoji[i]);
                        String s = "" + (i + 1);
                        Move.move_player(grid, player_position[i], s.charAt(0));


                        Grid.see_grid(grid);

                        Destroy.PlaceTheBomb(grid, Destroy.AskToDestroy());

                        // Verify again if the player is blocked
                        if (No_Move.detection(grid, player_position[i])) {
                            System.out.println("The player " + Nickname.nicknames.get(i) + " is now blocked !");
                            win = false;
                            player = Nickname.nicknames.get(i);
                            Score.main(null);


                            eliminate_player.add(i);
                        }

                    }
                    // Verify if there is just one player alive
                    if (eliminate_player.size() == number_player - 1) {
                        win = true;
                        player = Nickname.nicknames.get((i + 1) % number_player); // Trouvez le joueur gagnant
                        Score.main(null);
                        System.out.println("Game finish ! the player " + player + " has win !");

                        end = false;
                        break;
                    }

                }
                if (Menuu.esteregg) {
                    EsterEgg.storm();
                    for (byte p = 0; p < number_player; p++) {
                        String l = "" + (p + 1);
                        Grid.place_players(grid, player_position[p], l.charAt(0));
                    }
                }
            }


            // Verify if the game should be save
            if (Save.AskToSave()) {
                Save.WriteToFile(grid);
                return;
            }

            // Manage the easteregg
            if (Menuu.esteregg) {
                EsterEgg.storm();
            }
        }

    }


    public static void main(String[] args) {
        Setup();

    }

}
