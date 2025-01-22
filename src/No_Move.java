public class No_Move {

    /*
        Function to detect if the player is blocked.
        @param grid: the grid to check what is around the player.
        @param playerPosition: the position of the player to be tested.
     */
    public static boolean detection (byte[][] grid, byte[] player)
    {
        //Counter to track in how many directions the player is blocked.
        byte count = 0;
        byte[] current_pos = player.clone();
        //Iterate through the 4 directions: z, q, s, d.
        for (byte i = 0; i < Move.alldir.length; i++) {
            //Add the desired direction.
            current_pos[0] += Move.alldir[i].move_coordonne[0];
            current_pos[1] += Move.alldir[i].move_coordonne[1];
            //If the new position is outside the grid or different, increment the counter by 1.
            if(current_pos[0]>=Grid.width || current_pos[1]>=Grid.height || current_pos[0] <= 0 || current_pos[1] <= 0){count++;}
            else if (grid[current_pos[0]][current_pos[1]]!=0) {count++;}
        }
        //If the player is blocked in all 4 directions, return true.
        if(count==4) {return true;} else {return false;}
    }
    public static void main(String[] args) {

    }
}
