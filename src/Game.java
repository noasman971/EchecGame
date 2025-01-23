import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static String player;
    public static Boolean win = false;
    public static Boolean load = false;
    public static char[][] grid;
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
            //grid = Save.RecupGridFile();

        } else{
            grid = Grid.grid;
        }

        Nickname.main(null);
        boolean end = true;
        ArrayList<Integer> eliminate_player = new ArrayList<>();


        String[] liste_emoji = {"\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDB3", "\uD83D\uDC68\uD83C\uDFFF", "\uD83D\uDC69\uD83C\uDFFE", "\uD83D\uDC69\uD83C\uDFFB"};


        if (!load){
            Grid.grid_fill(grid, fill);
            for (byte i = 0; i < Grid.number_player; i++) {
                String s = ""+(i+1);
                Grid.place_players(grid, Grid.playerPositions[i], s.charAt(0));
            }

        }



        while (end) {
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

                // Vérifiez si la partie doit être sauvegardée
                if (Save.AskToSave()) {
                    Save.WriteToFile(grid);
                    return; // Quittez la partie après la sauvegarde
                }

                // Gérer l'Easter Egg si activé
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
