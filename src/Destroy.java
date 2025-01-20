import java.util.Scanner;

public class Destroy {
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
    public static void PlaceBomb(byte[][] grid, int[] coord) {
        if (grid[coord[0]][coord[1]] ==0 ) {
            grid[coord[0]][coord[1]] = 6;
        }
        else{
            System.out.println("Mauvais choix");
        }


    }

    public static void main(String[] args) {
        Game.main(args);
        PlaceBomb(Game.grid, AskToDestroy());
        Game.see_grid(Game.grid);



    }
}
