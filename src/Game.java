public class Game {
    public static  void Setup ()
    {
        byte[] eliminate_player = new byte [Grid.number_player-1];
        Grid.grid_fill(Grid.grid, (byte) 0);
        for (byte i = 0; i < Grid.number_player; i++) {
            Grid.place_players(Grid.grid, Grid.playerPositions[i], (byte) (i + 1));
        }
        while (Grid.number_player>1) {

            for (byte i = 0; i < Grid.number_player; i++) {
                Grid.see_grid(Grid.grid);
                System.out.println("Au tour du joueur " + (i+1));
                Move.move_player(Grid.grid, Grid.playerPositions[i], (byte) (i + 1));
                Grid.see_grid(Grid.grid);
                Destroy.PlaceTheBomb(Grid.grid, Destroy.AskToDestroy());
                if (No_Move.detection(Grid.grid, Grid.playerPositions[i]))
                {
                    eliminate_player[i] = i;
                    System.out.println(eliminate_player);

                }
            }

        }
    }
    public static void main(String[] args) {
        Setup();

    }

}
