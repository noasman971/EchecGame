import java.util.Scanner;

public class Move {
    // Creation of a class to use a dictionary of my 4 directions.
    public static class Direction {
        String dir;
        byte[] move_coordonne;
        public Direction(String dir, byte[] move_coordonne) {
            this.dir = dir;
            this.move_coordonne = move_coordonne;
        }
    }
    // Creation of a class to use a dictionary of my 4 directions with keyboard input and the direction to apply
    public static Direction[] alldir= {
        new Direction("z", new byte[]{-1,0}),
        new Direction("s", new byte[]{1,0}),
        new Direction("d", new byte[]{0,1}),
        new Direction("q", new byte[]{0,-1})
    };
    /*
        Creation of a function to process user input and move the player.
        @param grid: the grid on which modifications will be applied.
        @param playerCoordinates: the coordinates of the player to be moved.
        @param currentPlayer: the number of the current player to distinguish between players.
     */
    public static void move_player(byte[][] grid, byte[] player, byte num_player)
    {
        System.out.println("Choose the direction in which you want to move:");
        //User input
        Scanner input = new Scanner(System.in);
        String enter_user = input.nextLine();
        byte count = 0;
        //Iterate through my 4 possible directions in my dictionary.
        for (int i = 0; i < alldir.length; i++) {
            //If the user input is one of z, q, s, d.
            if (alldir[i].dir.equals(enter_user)) {
                //Add the chosen direction to the player.
                player[0] += alldir[i].move_coordonne[0];
                player[1] += alldir[i].move_coordonne[1];
                //Check if the player's new position is empty.
                if (grid[player[0]][player[1]] == 0) {
                    //If yes, then place the player on the grid at their new position.
                    Grid.place_players(Grid.grid, player, num_player );
                    //We remove the player from their previous position.
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    Grid.place_players(Grid.grid, player, (byte)0 );
                    player[0] += alldir[i].move_coordonne[0];
                    player[1] += alldir[i].move_coordonne[1];

                }
                //If the player's new position is not empty, return the player to their previous position and restart the function.
                else {
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    System.out.println("Your chosen position is already occupied.");
                    move_player(grid, player, num_player);
                }
            }
            // If the user input is not z, q, s, or d, restart the function.
            if (!alldir[i].dir.equals(enter_user)) {
                count++;
            }
            if (count == 4) {
                move_player(grid, player, num_player);
            }

        }

    }
    public static void main(String[] args) {
        Grid.main(args);
        move_player(Grid.grid, Grid.j1, (byte)1);
        Grid.see_grid(Grid.grid);
    }
}
