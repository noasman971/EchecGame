import java.io.*;
import java.util.Scanner;

public class Save {
    /**
     * Ask if we want to Save
     */
    public static boolean AskToSave() {
        boolean Ican = false;
        boolean save = false;
        while(!Ican) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to Save \uD83D\uDCBE: y/n ");

            char x = sc.next().charAt(0);
            if (x == 'y') {
                Ican = true;
                save = true;

            } else if (x == 'n') {
                Ican = true;
            }
        }
        return save;
    }

    /**
     * Function to write into a file to save
     */
    public static void WriteToFile(String[][] grid){

        try {
            FileWriter fileWriter = new FileWriter("Save.txt", true);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    fileWriter.write(grid[i][j]);
                }
            }
            fileWriter.write("\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    public static void RecupGridFile(){
        try (FileReader fileReader = new FileReader("Save.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[][] savegrid = new String[10][11];
            line = bufferedReader.readLine();
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < line.length(); j++) {
                    savegrid[i][j] = line.charAt(i) + "";
                }
            }
            System.out.println(savegrid);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


    }





    public static void main(String[] args) {
        //AskToSave();
        RecupGridFile();

    }
}
