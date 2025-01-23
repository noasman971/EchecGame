import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class Game {

    public static String player;
    public static Boolean win = false;
    public static Boolean load = false;
    public static char[][] grid;
    public static byte number_player;
    public static byte[][] player_position;
    /**
     * To play with the Game
     */
    public static  void Setup ()
    {
        char fill = '0';
        if(Menuu.esteregg)
        {
            Grid.grid_change();
            fill = '7';
        }
        if(Menuu.esteregg){
            EsterEgg.allwalker(1000);
//            EsterEgg.place_random_player();
        }

        if (load){
            System.out.println("You have loaded the game!");
            grid = Save.RecupGridFile();
            number_player = (byte) Save.PlayerPseudo().size();
            Nickname.nicknames = Save.PlayerPseudo();
            player_position = Save.PlayerPosition() ;



        } else{
            grid = Grid.grid;
            number_player = Grid.number_player;
            Nickname.main(null);
            player_position = Grid.playerPositions;

        }

        boolean end = true;
        ArrayList<Integer> eliminate_player = new ArrayList<>();


        String[] liste_emoji = {"\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDB3", "\uD83D\uDC68\uD83C\uDFFF", "\uD83D\uDC69\uD83C\uDFFE", "\uD83D\uDC69\uD83C\uDFFB"};


        if (!load){
            Grid.grid_fill(grid, fill);
            for (byte i = 0; i < number_player; i++) {
                String s = ""+(i+1);
                Grid.place_players(grid, player_position[i], s.charAt(0));
            }

        }



        while (end) {
            while (end) {
                for (int i = 0; i < number_player; i++) {
                    // if player eliminate the next player play
                    if (!eliminate_player.contains(i)) {
                        // Affichez la grille
                        Grid.see_grid(grid);

                        // Verify if the player is blocked
                        if (No_Move.detection(grid, player_position[i])) {
                            System.out.println("Le joueur " + Nickname.nicknames.get(i) + " est bloqué !");
                            win = false;
                            player = Nickname.nicknames.get(i);
                            Score.main(null);

                            // Add the player to the eliminate list
                            eliminate_player.add(i);

                            // Verify if there is just one player
                            if (eliminate_player.size() == number_player - 1) {
                                win = true;
                                player = Nickname.nicknames.get((i + 1) % number_player); // Trouvez le joueur gagnant
                                Score.main(null);
                                System.out.println("La partie est terminée ! Le joueur " + player + " gagne !");
                                end = false;
                                break;
                            }
                        } else {
                            // Turn of the player
                            System.out.println("C'est votre tour " + Nickname.nicknames.get(i) + " " + liste_emoji[i]);
                            String s = "" + (i + 1);
                            Move.move_player(grid, player_position[i], s.charAt(0));

                            // Display the grid after a movement
                            Grid.see_grid(grid);

                            // Destruct a case
                            Destroy.PlaceTheBomb(grid, Destroy.AskToDestroy());

                            // Verify again if the player is blocked after a movement
                            if (No_Move.detection(grid, player_position[i])) {
                                System.out.println("Le joueur " + Nickname.nicknames.get(i) + " est maintenant bloqué !");
                                win = false;
                                player = Nickname.nicknames.get(i);
                                Score.main(null);

                                // Add the player to the eliminate list
                                eliminate_player.add(i);
                            }
                        }
                    }
                }

                // Verify if the game should be save
                if (Save.AskToSave()) {
                    Save.clearFile();
                    Save.WriteToFile(grid);
                    return;
                }

                // Manage the easteregg
                if (Menuu.esteregg) {
                    EsterEgg.storm();
                }
            }

        }
    }

    public static void main(String[] args) {
        Setup();

    }

}
