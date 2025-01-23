import java.util.Random;

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

        if (load){
            System.out.println("You have loaded the game!");
            //grid = Save.RecupGridFile();

        } else{
            grid = Grid.grid;
        }

        Nickname.main(null);
        boolean end = true;
        byte[] eliminate_player = new byte [Grid.number_player-1];
        char fill = '0';
        String[] liste_emoji = {"\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDB3", "\uD83D\uDC68\uD83C\uDFFF", "\uD83D\uDC69\uD83C\uDFFE", "\uD83D\uDC69\uD83C\uDFFB"};

        if(Menuu.esteregg)
        {
            Grid.grid_change();
            fill = '⬛';
        }
        if (!load){
            Grid.grid_fill(grid, fill);
            for (byte i = 0; i < Grid.number_player; i++) {
                String s = ""+(i+1);
                Grid.place_players(grid, Grid.playerPositions[i], s.charAt(0));
            }

        }
        if(Menuu.esteregg){
            EsterEgg.allwalker(1000);
//            EsterEgg.place_random_player();
        }


        while (end) {
            for (byte i = 0; i < Grid.number_player; i++) {
                byte count =0;
                for (int j = 0; j < eliminate_player.length; j++) {
                    if (eliminate_player[j]!=0) {
                        count++;
                    }
                }
                if(count==Grid.number_player-1  && eliminate_player[0] != (byte)0)
                // 3==4
                {
                    win= true;
                    player = Nickname.nicknames.get(i);
                    Score.main(null);
                    System.out.println("Game finish the player " + player + " win");

                    end = false;
                    break;
                }
                for (byte j = 0; j < eliminate_player.length; j++) {
                    if (eliminate_player[j] == (i+1)) {i++;}
                }
                Grid.see_grid(grid);
                System.out.println("It's your turn "+ Nickname.nicknames.get(i) + " " + liste_emoji[i]);
                String s = ""+(i+1);
                Move.move_player(grid, Grid.playerPositions[i], s.charAt(0));
                Grid.see_grid(grid);
                Destroy.PlaceTheBomb(grid, Destroy.AskToDestroy());
                if (No_Move.detection(grid, Grid.playerPositions[i]))
                {
                    win= false;
                    player = Nickname.nicknames.get(i);
                    Score.main(null);


                    eliminate_player[i] = (byte) (i+1);
                    for (int j = 0; j < eliminate_player.length; j++) {
                        System.out.println(eliminate_player[j]);
                    }
                }

            }
            if (Save.AskToSave()){

                    Save.WriteToFile(grid);
                    return;
                }
                if (Menuu.esteregg){
                    EsterEgg.storm();
                }



            }


        }

    public static void main(String[] args) {
        Setup();

    }

}
