import javax.print.DocFlavor;
import java.io.*;
import java.nio.file.Path;
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
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    public static void ReadFromFile(){

    }





    public static void main(String[] args) {
        //AskToSave();

    }
}
