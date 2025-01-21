public class Grid {

    public static byte[][] grid = new byte[10][11];
    public static byte number_player = 2;
    byte numplayer;
    public static byte[] j1 = {3, 5}, j2 = {4, 5}, j3 = {5,5}, j4 = {6, 5};
    public static byte[][] playerPositions = {j1, j2, j3, j4};


    public static void grid_fill (byte[][] grid, byte nb)
    {
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                grid[i][j] = nb;
            }
        }

    }


    public static void see_grid(byte[][] grid){
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void place_players(byte[][] grid, byte[] pos, byte num_player ){
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                if (i == pos[0] && j == pos[1]){
                    grid[i][j] = num_player;
                }
            }
        }

    }
    public static void main (String[] args) {



    }

}