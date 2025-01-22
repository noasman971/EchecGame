import java.util.Random;

public class EsterEgg {
    public static byte[] middle = new byte[] {(byte) (Grid.height/2), (byte) (Grid.width/2)};
    public static byte[][][] allwalker;
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

        // Pour vérifier, affichons les directions générées
        for (int i = 0; i < walker.length; i++) {
            System.out.println("Déplacement " + (i + 1) + ": [" + walker[i][0] + ", " + walker[i][1] + "]");
        }
        return walker;
    }
    public static void allwalker (int iterations){
        allwalker = new byte[iterations][][];
        for (int i = 0; i < iterations; i++) {
            allwalker[i]=walker(middle,(byte)10);
        }
        for (int i = 0; i < allwalker.length; i++) {
            for (int j = 0; j < allwalker[i].length; j++) {
                Grid.grid[allwalker[i][j][0]][allwalker[i][j][1]] = Byte.parseByte("⬜");
                System.out.println(allwalker[i][j][0] + " " + allwalker[i][j][1]);
            }
        }

    }
    public static void main(String[] args) {

        Game.Setup();
    }
}
