import java.util.Scanner;

public class Destroy {

    /**
     * Ask to the player what coords to Destroy
     *
     * @return coord the coords chose by the player
     */
    public static byte[] AskToDestroy() {
        byte[] coord = new byte[2];
        boolean Ican = false;
        while (!Ican) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Choose an emplacement to Destroy \uD83D\uDCA3\uD83D\uDCA5");
                System.out.println("x: ");

                byte x = sc.nextByte();
                System.out.println("y: ");

                byte y = sc.nextByte();
                coord[1] = x;
                coord[0] = y;
                Ican = true;

            } catch (Exception e) {
                System.out.println("This coordonate does not exist");
            }

        }

        return coord;

    }

    /**
     * Place the Bomb to the coords when it's possible
     *
     * @param grid  the grid of the game
     * @param coord the coordonate chose by the Player
     */
    public static void PlaceTheBomb(char[][] grid, byte[] coord) {
        boolean canIPlace = false;
        while (!canIPlace) {
            if (coord[1] < Grid.width && coord[0] < Grid.height && coord[0] >= 0 && coord[1] >= 0 && grid[coord[0]][coord[1]] == '0') {
                grid[coord[0]][coord[1]] = '6';
                canIPlace = true;
            } else {
                System.out.println("You can't destroy this position");
                coord = AskToDestroy();
            }
        }
    }


}
