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
            allwalker[i]=walker(middle,(byte)24);
        }
        for (int i = 0; i < allwalker.length; i++) {
            for (int j = 0; j < allwalker[i].length; j++) {
                if (allwalker[i][j][0] >= 0 && allwalker[i][j][0] < Grid.height &&
                        allwalker[i][j][1] >= 0 && allwalker[i][j][1] < Grid.width) {
                    Grid.grid[allwalker[i][j][0]][allwalker[i][j][1]] = '0';
                    count_allwalker++;
                }
            }
        }

    }

//    public static void storm() {
//        ArrayList<byte[]> alldestruction = new ArrayList<>();
//
//        // Parcourir tous les walkers
//        for (int i = 0; i < allwalker.length; i++) {
//            for (int j = 0; j < allwalker[i].length; j++) {
//                byte[] currentpos = {allwalker[i][j][0], allwalker[i][j][1]};
//                boolean destruction = false;
//
//                // Vérifier tous les voisins
//                for (int k = 0; k < Move.alldir.length; k++) {
//                    byte[] neighbor = {
//                            (byte) (currentpos[0] + Move.alldir[k].move_coordonne[0]),
//                            (byte) (currentpos[1] + Move.alldir[k].move_coordonne[1])
//                    };
//
//                    // Vérifier si le voisin est dans les limites de la grille
//                    if (neighbor[0] >= 0 && neighbor[0] < Grid.height &&
//                            neighbor[1] >= 0 && neighbor[1] < Grid.width) {
//
//                        // Vérifier si le voisin contient le caractère '7'
//                        if (Grid.grid[neighbor[0]][neighbor[1]] == '7') {
//                            destruction = true;
//                            break;
//                        }
//                    }
//                }
//
//                // Ajouter la position actuelle à la liste des destructions si nécessaire
//                if (destruction) {
//                    alldestruction.add(currentpos.clone());
//                }
//            }
//        }
//
//        // Appliquer les destructions sur la grille
//        for (byte[] pos : alldestruction) {
//            Grid.grid[pos[0]][pos[1]] = '7'; // Remplacez '0' par le caractère souhaité si nécessaire
//        }
//    }


    public static void storm (){
        ArrayList<byte[]> alldestruction = new ArrayList<>();
        for (int i = 0; i < allwalker.length; i++) {
            for (int j = 0; j < allwalker[i].length; j++) {
                boolean destruction = false;
                for (int k = 0; k < Move.alldir.length; k++) {
                    byte[] currentpos = {allwalker[i][j][0],allwalker[i][j][1]};
                    currentpos[0] += Move.alldir[k].move_coordonne[0];
                    currentpos[1] += Move.alldir[k].move_coordonne[1];
                    if (currentpos[0] >= 0 && currentpos[0] < Grid.height &&
                            currentpos[1] >= 0 && currentpos[1] < Grid.width) {
                        if (Grid.grid[currentpos[0]][currentpos[1]] == '7') {
                            destruction = true;
                        }
                    }
                    if (destruction){
                        currentpos[0] -= Move.alldir[k].move_coordonne[0];
                        currentpos[1] -= Move.alldir[k].move_coordonne[1];
                        alldestruction.add(currentpos);
                        destruction = false;
                    }
                }
            }
        }
        for (int i = 0; i < alldestruction.size(); i++) {
            Grid.grid[alldestruction.get(i)[0]][alldestruction.get(i)[1]] = '7';
        }
    }

    public static void main(String[] args) {
        Game.Setup();
    }
}
