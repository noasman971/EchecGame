public class Grid {

    public static byte height = 11;
    public static byte width = 10;
    public static String[][] grid = new String[height][width];
    public static byte[] graduate = new byte[height];
    public static byte number_player = 4;
    byte numplayer;

    public static void grid_change() {
        if (Menuu.esteregg) {
            height = 25;
            width = 25;
        }

        grid = new String[height][width];
        graduate = new byte[height];
        byte placment_player = (byte) (height/2/2/2);
        j1 = new byte[]{(byte) (height / 2 - placment_player), (byte) (width / 2 -placment_player)};
        j2 = new byte[]{(byte) (height / 2 - placment_player), (byte) (width / 2 + placment_player)};
        j3 = new byte[]{(byte) (height / 2 + placment_player), (byte) (width / 2 + placment_player)};
        j4 = new byte[]{(byte) (height / 2 + placment_player), (byte) (width / 2 - placment_player)};
        playerPositions = new byte[][]{j1, j2, j3, j4};
    }
    public static byte[] j1 = {(byte) (height/2-2), (byte)(width/2)}, j2 = {(byte) (height/2-1), (byte)(width/2)},
            j3 = {(byte) (height/2+1), (byte)(width/2)}, j4 = {(byte) (height/2+2), (byte)(width/2)};
    public static byte[][] playerPositions = {j1, j2, j3, j4};
    /**
     * Fill the grid with nb
     * @param grid the grid of the game
     * @param nb with what we fill
     */
    public static void grid_fill (String[][] grid, String nb)
    {
        for (byte i = 0; i < grid.length; i++) {
            graduate[i] = i;
            for (byte j = 0; j < grid[i].length; j++) {
                grid[i][j] = nb;
            }
        }

    }

    /**
     * To see what are the element on the grid
     * @param grid the grid of the game
     */
    public static void see_grid(String[][] grid){
        for (byte i = 0; i < grid.length; i++) {
            if (i<10){
                System.out.print(graduate[i] + "   ");
            }
            else {
                System.out.print(graduate[i] + "  ");
            }


            for (byte j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Place the player on the grid
     * @param grid the grid of the game
     * @param pos position x,y  in an array of the play
     * @param num_player number of the player
     */
    public static void place_players(String[][] grid, byte[] pos, String num_player ){
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                if (i == pos[0] && j == pos[1]){
                    grid[i][j] =  ""+num_player;
                }
            }
        }

    }
    public static void main (String[] args) {



    }

}