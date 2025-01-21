import java.util.ArrayList; // Import the ArrayList class
import java.util.List; // Import the List interface
import java.util.Scanner; // Import the Scanner class

public class Nickname { // Create a class named Nickname

    static Scanner scanner = new Scanner(System.in); // Create a static Scanner object
    static List<String> nicknames = new ArrayList<>(); // Create a static List of strings to store nicknames

    public static void main(String[] args) {
        int numberOfPlayers = Grid.number_player;

        for (int i = 1; i <= numberOfPlayers; i++) { // Loop to ask for nicknames from each player
            askNickname(i); // Call the askNickname method to get the nickname for the current player
        }

        // Display all the nicknames
        System.out.println("The players' nicknames are:");
        for (String nickname : nicknames) {
            System.out.println(", " + nickname);
        }
    }

    public static void askNickname(int player) { // Method to ask for a nickname from a player
        String nickname;

        do { // Loop to keep asking for nickname until a valid one is entered
            System.out.print("Player " + player + ", choose a nickname (between 2 and 10 characters): ");
            nickname = scanner.nextLine();

            if (nickname.length() < 2 || nickname.length() > 10) { // Check if the nickname length is valid
                System.out.println("Error: The nickname must contain between 2 and 10 characters. Please try again.");
            } else {
                nicknames.add(nickname); // Add the valid nickname to the nicknames list
                break; // Exit the loop
            }
        } while (true);
    }
}

/*
Start
  Add nickname numbers
  Create a list named "nicknames"

  For each "nickname" from 1 to "nicknames"
    Display "nickname [nickname], choose a pseudonym (2-10 characters):"
    Get "input" from user
    If "length of input" is between 2 and 10
      Add "input" to "nicknames"
    Else
      Display "Error: nickname must be 2-10 characters."

  Display "nicknames:"
  For each "nickname" in "nicknames"
    Display "nickname"
End
 */