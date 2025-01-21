public class Game {

    /**
     * To play with the Game
     */
    public static  void Setup ()
    {
        boolean end = true;
        byte[] eliminate_player = new byte [Grid.number_player-1];
        Grid.grid_fill(Grid.grid, (byte) 0);
        for (byte i = 0; i < Grid.number_player; i++) {
            Grid.place_players(Grid.grid, Grid.playerPositions[i], (byte) (i + 1));
        }
        while (end) {
            for (byte i = 0; i < Grid.number_player; i++) {
                if(eliminate_player.length == (Grid.number_player-1)  && eliminate_player[0] != (byte)0)
                {
                    System.out.println("Game finish the player " + i + " win");
                    end = false;
                    break;
                }
                for (byte j = 0; j < eliminate_player.length; j++) {
                    if (eliminate_player[j] == (i+1)) {i++;}
                }
                Grid.see_grid(Grid.grid);
                System.out.println("Au tour du joueur " + (i+1));
                Move.move_player(Grid.grid, Grid.playerPositions[i], (byte) (i + 1));
                Grid.see_grid(Grid.grid);
                Destroy.PlaceTheBomb(Grid.grid, Destroy.AskToDestroy());
                if (No_Move.detection(Grid.grid, Grid.playerPositions[i]))
                {
                    eliminate_player[i] = (byte) (i+1);
                    for (int j = 0; j < eliminate_player.length; j++) {
                        System.out.println(eliminate_player[j]);

                    }

                }
            }

        }
    }
    public static void main(String[] args) {
        Setup();

    }

}
