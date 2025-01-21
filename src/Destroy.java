import java.util.Scanner;

public class Destroy {

    /**
     * Ask to the player what coords to Destroy
     * @return coord the coords chose by the player
     */
    public static int[] AskToDestroy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an emplacement to Destroy \uD83D\uDCA3\uD83D\uDCA5");
        System.out.println("x: ");

        byte x = sc.nextByte();
        System.out.println("y: ");

        byte y = sc.nextByte();
        int[] coord = {x,y};

        return coord;

    }
    /**
     * Place the Bomb to the coords
     * @param grid the grid of the game
     * @param coord the coord chose by the Player
     */
    public static void PlaceTheBomb(byte[][] grid, int[] coord) {
        boolean canIPlace = false;
        while (!canIPlace) {
            if(coord[0]<11 && coord[1]<11) {
                if (grid[coord[0]][coord[1]] == 0) {
                    grid[coord[0]][coord[1]] = 6;
                    canIPlace = true;
                }
                else {
                    System.out.println("You can't destroy this position");
                    coord = AskToDestroy();
                }
            }
            else {
                System.out.println("You can't destroy this position");
                coord = AskToDestroy();
            }
        }
    }


    public static void main(String[] args) {
        Game.main(args);
        PlaceTheBomb(Game.grid, AskToDestroy());
        Game.see_grid(Game.grid);



    }
}
