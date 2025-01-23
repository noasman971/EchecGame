public class No_Move {
    public static byte count = 0;

    /**
     * This function detects if a player's position is at the edge of the grid or on an occupied cell.
     * It iterates through all possible directions defined in Move.alldir, calculates the player's
     * potential new position for each direction, and checks whether the position is out of bounds
     * or occupied. If all four possible directions are invalid, it returns true, otherwise false.
     *
     * @param grid A 2D array representing the game grid where each cell contains a character value.
     * @param player A byte array where the first element represents the player's row, and the second element represents the player's column.
     * @return Returns true if all four possible directions from the player's position are invalid; otherwise, returns false.
     */
    public static boolean detection (char[][] grid, byte[] player)
    {
        count = 0;
        for (byte i = 0; i < Move.alldir.length; i++) {
            byte[] current_pos = player.clone();
            current_pos[0] += Move.alldir[i].move_coordonne[0];
            current_pos[1] += Move.alldir[i].move_coordonne[1];
            System.out.println(current_pos[0] + " " + current_pos[1]);
            if(current_pos[0] >= Grid.height || current_pos[1] >= Grid.width || current_pos[0] < 0 || current_pos[1] < 0){count++;}
            else if (grid[current_pos[0]][current_pos[1]] != '0') {count++;}
        }
        if(count==4) {return true;} else {return false;}
    }
    public static void main(String[] args) {

    }
}
