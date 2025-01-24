import java.util.Scanner;

public class Move {
    public static class Direction {
        String dir;
        byte[] move_coordonne;
        public Direction(String dir, byte[] move_coordonne) {
            this.dir = dir;
            this.move_coordonne = move_coordonne;
        }
    }
    public static Direction[] alldir= {
        new Direction("z", new byte[]{-1,0}),
        new Direction("s", new byte[]{1,0}),
        new Direction("d", new byte[]{0,1}),
        new Direction("q", new byte[]{0,-1})
    };

    /**
     * Moves the player in the chosen direction if the move is valid.
     *
     * @param grid The game grid.
     * @param player The player's current position.
     * @param num_player The character representing the player.
     */
    public static void move_player(char[][] grid, byte[] player, char num_player)
    {
        System.out.println("Choose the direction in which you want to move:");
        Scanner input = new Scanner(System.in);
        String enter_user = input.nextLine();
        boolean validMove = false; // Pour vérifier si le déplacement est valide

        for (Direction direction : alldir) {
            if (direction.dir.equals(enter_user)) {
                // Calcule la nouvelle position
                byte newRow = (byte) (player[0] + direction.move_coordonne[0]);
                byte newCol = (byte) (player[1] + direction.move_coordonne[1]);

                // Vérifie si la nouvelle position est dans les limites de la grille
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    // Vérifie si la nouvelle position est libre
                    if (grid[newRow][newCol] == '0') {
                        // Met à jour la position
                        Grid.place_players(grid, player, '0'); // Supprime l'ancien joueur
                        player[0] = newRow;
                        player[1] = newCol;
                        Grid.place_players(grid, player, num_player); // Place le joueur à la nouvelle position
                        validMove = true;
                    } else {
                        System.out.println("Your chosen position is already occupied.");
                    }
                } else {
                    System.out.println("You cannot move outside the grid.");
                }
                break;
            }
        }

        if (!validMove) {
            System.out.println("Invalid direction. Try again.");
            move_player(grid, player, num_player); // Relance pour une nouvelle tentative
        }
    }

    public static void main(String[] args) {
//        Grid.main(args);
        //move_player(Grid.grid, Grid.j1, "");
        Grid.see_grid(Grid.grid);
    }
}
