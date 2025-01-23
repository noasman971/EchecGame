import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class EsterEgg {
    public static byte[] middle = new byte[] {(byte) (Grid.height/2), (byte) (Grid.width/2)};
    public static byte[][][] allwalker;
    public static int count_allwalker =0;
    public static  byte[][] walker (byte[] pos, byte lenghtwalker) {
        byte[][] walker = new byte[lenghtwalker][2];
        byte[] currentpos = middle.clone();
        for (int i = 0; i < lenghtwalker; i++) {
            Random random = new Random();
            int index = random.nextInt(Move.alldir.length);
            byte[] dirrandom = new byte[2];
            currentpos[0] += Move.alldir[index].move_coordonne[0];
            currentpos[1] += Move.alldir[index].move_coordonne[1];
            if (currentpos[0] < 0 || currentpos[0] >= Grid.height ||
                    currentpos[1] < 0 || currentpos[1] >= Grid.width) {
                currentpos[0] -= Move.alldir[index].move_coordonne[0];
                currentpos[1] -= Move.alldir[index].move_coordonne[1];
                continue;
            }
            dirrandom[0] = currentpos[0];
            dirrandom[1] = currentpos[1];
            walker[i][0] = dirrandom[0];
            walker[i][1] = dirrandom[1];
        }

        return walker;
    }
    public static void allwalker (int iterations){
        allwalker = new byte[iterations][][];
        for (int i = 0; i < iterations; i++) {
            allwalker[i]=walker(middle,(byte)20);
        }
        for (int i = 0; i < allwalker.length; i++) {
            for (int j = 0; j < allwalker[i].length; j++) {
                if (allwalker[i][j][0] >= 0 && allwalker[i][j][0] < Grid.height &&
                        allwalker[i][j][1] >= 0 && allwalker[i][j][1] < Grid.width) {
                    Grid.grid[allwalker[i][j][0]][allwalker[i][j][1]] = '⬜';
                    count_allwalker++;
                }
            }
        }

    }

    public static void storm (){
        ArrayList<byte[]> alldestruction = new ArrayList<>();
        for (int i = 0; i < allwalker.length; i++) {
            for (int j = 0; j < allwalker[i].length; j++) {
                boolean destruction = false;
                for (int k = 0; k < Move.alldir.length; k++) {
                    byte[] currentpos = {allwalker[i][j][0],allwalker[i][j][1]};
                    currentpos[0] += Move.alldir[k].move_coordonne[0];
                    currentpos[1] += Move.alldir[k].move_coordonne[1];
                    if(Grid.grid[currentpos[0]][currentpos[1]] == '⬛')
                    {
                        destruction = true;
                    }
                    if (destruction){
                        currentpos[0] -= Move.alldir[k].move_coordonne[0];
                        currentpos[1] -= Move.alldir[k].move_coordonne[1];
                        // add la current a alldestruction
                        break;
                    }
                }
            }
        }
    }

//    public static void place_random_player (){
//        Random random = new Random();
//        int index = random.nextInt(allwalker.length);
//        int test = allwalker[index].length;
//        byte[] place_player = new byte [2];
//        place_player[0] = EsterEgg.allwalker[index][test][0];
//        place_player[1] = EsterEgg.allwalker[index][test][1];
//    }
    public static void main(String[] args) {

        Game.Setup();
    }
}
