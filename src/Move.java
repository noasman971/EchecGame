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
    public static void move_player(byte[][] grid, byte[] player, byte num_player)
    {
        System.out.println("Choose the direction in which you want to move:");
        Scanner input = new Scanner(System.in);
        String enter_user = input.nextLine();
        for (int i = 0; i < alldir.length; i++) {
            if (alldir[i].dir.equals(enter_user)) {
                player[0] += alldir[i].move_coordonne[0];
                player[1] += alldir[i].move_coordonne[1];
                if (grid[player[0]][player[1]] == 0) {
                    Game.place_players(Game.grid, player, num_player );
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    Game.place_players(Game.grid, player, (byte)0 );
                }
                else {
                    player[0] -= alldir[i].move_coordonne[0];
                    player[1] -= alldir[i].move_coordonne[1];
                    System.out.println("Your chosen position is already occupied.");
                    move_player(grid, player, num_player);
                }
            }
        }

    }
    public static void main(String[] args) {
        Game.main(args);
        move_player(Game.grid, Game.j1, (byte)1);
        Game.see_grid(Game.grid);
    }
}
