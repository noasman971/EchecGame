import java.util.Random;

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
                Grid.grid[allwalker[i][j][0]][allwalker[i][j][1]] = "⬜";
                count_allwalker++;
            }
        }

    }

    public static void place_random_player (){
        Random random = new Random();
        int index = random.nextInt(EsterEgg.count_allwalker);
        byte[] place_player = new byte [2];
        place_player[0] = EsterEgg.allwalker[index][index][0];
        place_player[1] = EsterEgg.allwalker[index][index][1];
    }
    public static void main(String[] args) {

        Game.Setup();
    }
}
