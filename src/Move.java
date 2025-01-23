import java.util.Scanner;

public class Move {
    public static class Direction {
        String dir;
        byte[] move_coordonne;
        public Direction(String dir, byte[] move_coordonne) {
            this.dir = dir;
            this.move_coordonne = move_coordonne;
        }
    }
    public static Direction[] alldir= {
        new Direction("z", new byte[]{-1,0}),
        new Direction("s", new byte[]{1,0}),
        new Direction("d", new byte[]{0,1}),
        new Direction("q", new byte[]{0,-1})
    };
    public static void move_player(char[][] grid, byte[] player, char num_player)
    {
        System.out.println("Choose the direction in which you want to move:");
        Scanner input = new Scanner(System.in);
        String enter_user = input.nextLine();
        byte count = 0;
        for (int i = 0; i < alldir.length; i++) {
            if (alldir[i].dir.equals(enter_user)) {
                player[0] += alldir[i].move_coordonne[0];
                player[1] += alldir[i].move_coordonne[1];
                if (grid[player[0]][player[1]] == '0') {
                    Grid.place_players(grid, player, num_player);
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    Grid.place_players(grid, player, '0' );
                    player[0] += alldir[i].move_coordonne[0];
                    player[1] += alldir[i].move_coordonne[1];

                }
                else {
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    System.out.println("Your chosen position is already occupied.");
                    move_player(grid, player, num_player);
                }
            }
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
        //move_player(Grid.grid, Grid.j1, "");
        Grid.see_grid(Grid.grid);
    }
}
