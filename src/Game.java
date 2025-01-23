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
     * To play with the Game
     */
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
            for (byte i = 0; i < Grid.number_player; i++) {
                String s = "" + (i + 1);
                Grid.place_players(grid, player_position[i], s.charAt(0));
            }

        }


        while (end) {
            for (int i = 0; i < Grid.number_player; i++) {
                // Passez au joueur suivant si le joueur est éliminé
                if (!eliminate_player.contains(i)) {
                    // Affichez la grille
                    Grid.see_grid(grid);

                    // Vérifiez si le joueur est bloqué
                    if (No_Move.detection(grid, Grid.playerPositions[i])) {
                        System.out.println("Le joueur " + Nickname.nicknames.get(i) + " est bloqué !");
                        win = false;
                        player = Nickname.nicknames.get(i);
                        Score.main(null);

                        // Ajoutez le joueur à la liste des éliminés
                        eliminate_player.add(i);

                        // Vérifiez si un seul joueur reste en jeu
                        if (eliminate_player.size() == Grid.number_player - 1) {
                            win = true;
                            player = Nickname.nicknames.get((i + 1) % Grid.number_player); // Trouvez le joueur gagnant
                            Score.main(null);
                            System.out.println("La partie est terminée ! Le joueur " + player + " gagne !");
                            end = false;
                            break;
                        }
                    } else {
                        // Tour du joueur
                        System.out.println("C'est votre tour " + Nickname.nicknames.get(i) + " " + liste_emoji[i]);
                        String s = "" + (i + 1);
                        Move.move_player(grid, Grid.playerPositions[i], s.charAt(0));

                        // Affichez la grille après le déplacement
                        Grid.see_grid(grid);

                        // Placez une bombe
                        Destroy.PlaceTheBomb(grid, Destroy.AskToDestroy());

                        // Vérifiez à nouveau si le joueur est bloqué après son mouvement
                        if (No_Move.detection(grid, Grid.playerPositions[i])) {
                            System.out.println("Le joueur " + Nickname.nicknames.get(i) + " est maintenant bloqué !");
                            win = false;
                            player = Nickname.nicknames.get(i);
                            Score.main(null);

                            // Ajoutez le joueur à la liste des éliminés
                            eliminate_player.add(i);
                        }

                    }
                }
            }
            if (Menuu.esteregg) {
                EsterEgg.storm();
                for (byte p = 0; p < Grid.number_player; p++) {
                    String l = "" + (p + 1);
                    Grid.place_players(grid, Grid.playerPositions[p], l.charAt(0));
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


    public static void main(String[] args) {
        Setup();

    }

}
