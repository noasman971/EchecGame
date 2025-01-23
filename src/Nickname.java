import java.util.ArrayList; // import the ArrayList class
import java.util.List; // import the List interface
import java.util.Scanner; // import the Scanner class

public class Nickname { // create a class named Nickname

    static Scanner scanner = new Scanner(System.in); // create a static Scanner object
    static List<String> nicknames = new ArrayList<>(); // create a static List to store nicknames

    public static void main(String[] args) {
        int numberOfPlayers = 4;//debug
        askNickname(1, numberOfPlayers); // start the recursive
        // display all the nicknames
        System.out.println("The players's nicknames are:");
        for (String nickname : nicknames) {
            System.out.println(" " + nickname);
        }
    }

    public static void askNickname(int player, int totalPlayers) { // recursive method
        if (player > totalPlayers) { // condition for exit the recursive
            return;
        }

        String nickname;
        do { // asking for nickname until a valid one is entered
            System.out.print("Player " + player + ", choose a nickname (between 2 and 10 characters): ");
            nickname = scanner.nextLine();

            if (nickname.length() < 2 || nickname.length() > 10) { // check if the nickname length is valid
                System.out.println("Error: The nickname must contain between 2 and 10 characters. Please try again.");
            } else if (nicknames.contains(nickname)) {
                System.out.println("Error: The nickname is already taken. Please choose a different one.");// check if it's already taken
            } else {
                nicknames.add(nickname); // add the nickname to the nicknames list
                break; // exit the loop
            }
        } while (true);

        askNickname(player + 1, totalPlayers); // recursive call for the next player
    }
}


/*
Start
  Define the number of players as 4
  Create a list named "nicknames"

  For each "player" from 1 to the number of players
    Display "Player [player], choose a nickname (between 2 and 10 characters):"
    Get "input" from user
    While "input length" is less than 2 or more than 10 or "input" is in "nicknames"
      If "input length" is less than 2 or more than 10
        Display "Error: The nickname must contain between 2 and 10 characters."
      If "input" is in "nicknames"
        Display "Error: The nickname is already taken. Please choose a different one."
      Get "input" from user
    Add "input" to "nicknames"

  Display "The players' nicknames are:"
  For each "nickname" in "nicknames"
    Display "nickname"
End
*/