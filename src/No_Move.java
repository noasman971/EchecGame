public class No_Move {

    public static boolean detection (char[][] grid, byte[] player)
    {
        byte count = 0;
        byte[] current_pos = player.clone();
        for (byte i = 0; i < Move.alldir.length; i++) {
            current_pos[0] += Move.alldir[i].move_coordonne[0];
            current_pos[1] += Move.alldir[i].move_coordonne[1];
            if(current_pos[0]>=Grid.height || current_pos[1]>=Grid.width || current_pos[0] <= 0 || current_pos[1] <= 0){count++;}
            else if (grid[current_pos[0]][current_pos[1]] == '6' || grid[current_pos[0]][current_pos[1]] == '7') {count++;}
        }
        if(count==4) {return true;} else {return false;}
    }
    public static void main(String[] args) {

    }
}
