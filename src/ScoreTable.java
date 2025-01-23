import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScoreTable {
    public static void main() {

        String fil = "ScoreList.txt";// Name of file to read
        List<String[]> scores = new ArrayList<>();// List scores and nicknames

        try (BufferedReader read = new BufferedReader(new FileReader(fil))) {//
            String line;
            // Separation of score and nickname in a list
            while ((line = read.readLine()) != null) {
                String[] elements = line.split("=");
                scores.add(elements);
            }
        } catch (IOException e) {
            System.err.println("Error reading file : " + e.getMessage());
        }

        showScores(scores); // Print the score

        //Ask the user if they want to sort the scores
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                                      Do you want to sort the scores?");
        System.out.println("                                                                Croissant = 1");
        System.out.println("                                                               Decreasing = 2");

        int choixTri = scanner.nextInt();

        // Apply quick sort based on user choice
        if (choixTri == 1) {
            quickSort(scores, 0, scores.size() - 1, true);  // Tri croissant
        } else if (choixTri == 2) {
            quickSort(scores, 0, scores.size() - 1, false);  // Tri décroissant
        } else {
            System.out.println("Invalid choice. No sorting done.");
        }

        // Redisplay the sorted array
        showScores(scores);

        char Exit;
        do {
            System.out.println("e for Exit");
            Exit = scanner.next().charAt(0);

            switch (Exit) {
                case 'e':
                    Menuu.Menu(); //
                    break;
            }
        } while (Exit != 'e');
    }

    // Method to display scores
    public static void showScores(List<String[]> scores) {
        System.out.println("                                                           +-----------+-------+");
        System.out.println("                                                           | Nickname  | Score |");
        System.out.println("                                                           +-----------+-------+");

        // Browse the list of scores to display them
        for (String[] score : scores) {
            String Nickname = String.format("%-10s", score[0]);
            String scoreValue = String.format("%-6s", score[1]);
            System.out.println("                                                           | " + Nickname + "| " + scoreValue + "|");
        }

        System.out.println("                                                           +-----------+-------+");
    }

    // Main method to perform quicksort
    public static void quickSort(List<String[]> scores, int low, int high, boolean croissant) {
        // If the lower index is smaller than the upper index, we continue to divide the list
        if (low < high) {
            // We partition the list and obtain the pivot index
            int i = partition(scores, low, high, croissant);

            // Recursive sorting of the sublist to the left of the pivot
            quickSort(scores, low, i - 1, croissant);

            // Recursive sorting of the sublist to the right of the pivot
            quickSort(scores, i + 1, high, croissant);
        }
    }

    // Method that partitions the list around a pivot
    private static int partition(List<String[]> scores, int low, int high, boolean croissant) {
        // The pivot is the element at the end of the sublist
        String[] pivot = scores.get(high);

        // i represents the boundary between elements smaller than the pivot and those larger
        int i = low - 1;

        // We go through all the elements of the sublist
        for (int j = low; j < high; j++) {
            // Retrieving the scores of the elements to compare
            int score1 = Integer.parseInt(scores.get(j)[1]);
            int score2 = Integer.parseInt(pivot[1]);


            // If we want an ascending order, we exchange if score1 < score2
            // If we want a descending order, we exchange if score1 > score2
            if ((croissant && score1 < score2) || (!croissant && score1 > score2)) {
                // Increment of index i and exchange of elements
                Collections.swap(scores, ++i, j);
            }
        }

        // We finally place the pivot in its correct position
        Collections.swap(scores, i + 1, high);

        // Return the pivot position after partitioning
        return i + 1;
    }
}