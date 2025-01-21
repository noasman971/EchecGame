public class No_Move {

    public static boolean detection (byte[][] gird, byte[] player)
    {
        byte count = 0;
        byte[] current_pos = player.clone();
        for (byte i = 0; i < Move.alldir.length; i++) {
            current_pos[0] += Move.alldir[i].move_coordonne[0];
            current_pos[1] += Move.alldir[i].move_coordonne[1];
            if (Game.grid[current_pos[0]][current_pos[1]]!=0) {count++;}
        }
        if(count==4) {return true;} else {return false;}
    }
    public static void main(String[] args) {

    }
}
