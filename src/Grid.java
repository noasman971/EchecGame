public class Grid {

    public static byte height = 11;
    public static byte width = 10;
    public static char[][] grid = new char[height][width];
    public static byte[] graduate_height = new byte[height];
    public static byte[] graduate_width = new byte[width];
    public static byte number_player = 4;


    /**
     * Changes the grid size and initializes player positions.
     * If the Easter egg mode is enabled, it sets the grid to 25x25.
     * Otherwise, it uses the default grid size and calculates player placements.
     */
    public static void grid_change() {
        if (Menuu.esteregg) {
            height = 25;
            width = 25;
        }

        grid = new char[height][width];
        graduate_height = new byte[height];
        graduate_width = new byte[width];
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
    public static void grid_fill (char[][] grid, char nb)
    {
        for (byte i = 0; i < grid.length; i++) {
            graduate_height[i] = i;
            for (byte j = 0; j < grid[i].length; j++) {
                grid[i][j] = nb;
                graduate_width[j] = j;
            }
        }

    }

    /**
     * To see what are the element on the grid
     * @param grid the grid of the game
     */
    public static void see_grid(char[][] grid){
        if (graduate_width.length == 10) {
            System.out.println("      0   1   2   3   4    5   6   7   8   9");
        } else if (graduate_width.length == 25) {
            System.out.println("      0   1   2   3   4    5   6   7   8   9   10  11  12   13  14  15   16  17  18  19  20  21  22  23   24");
        }
        for (byte i = 0; i < grid.length; i++) {
            if (i<10){
                System.out.print(graduate_height[i] + "   ");
            }
            else {
                System.out.print(graduate_height[i] + "  ");
            }


            for (byte j = 0; j < grid[i].length; j++) {
                System.out.print(Color.emoji(grid[i][j]));
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
    public static void place_players(char[][] grid, byte[] pos, char num_player ){
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                if (i == pos[0] && j == pos[1]){
                    grid[i][j] =  num_player;
                }
            }
        }

    }


}