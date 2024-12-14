package org.example;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the "Find the Thimble" game where the player guesses the location of a hidden thimble among three cups.
 */

public class FindTheThimble {
    boolean testMode = false;
    int playerScore = 0;
    int hostScore = 0;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor for the FindTheThimble class.
     */
    public FindTheThimble() {}

    /**
     * Randomly selects a cup where the thimble is hidden.
     *
     * @return an integer between 1 and 3 representing the host's chosen cup.
     */
    public int gameHostChooseCup() {
        return random.nextInt(3) + 1;
    }

    /**
     * Checks the player's guess against the host's chosen cup and updates the scores.
     *
     * @param playersGuess the player's guessed cup (e.g., "Cup 1").
     * @param hostsCup the host's chosen cup number (1, 2, or 3).
     * @return a character ('Y' or 'N') indicating whether the player wants to play again.
     */
    public char checkPlayerGuess(String playersGuess, int hostsCup) {
        if(!validCupChoice(playersGuess)) {
            System.out.println("\nInvalid input");
        }
        else {
            switch (hostsCup) {
                case 1:
                    if (playersGuess.equals("Cup 1")) {
                        System.out.println("\nPlayer Wins");
                        playerScore++;
                    } else {
                        System.out.println("\nPlayer Loses");
                        hostScore++;
                    }
                    break;

                case 2:
                    if (playersGuess.equals("Cup 2")) {
                        System.out.println("\nPlayer Wins");
                        playerScore++;
                    } else {
                        System.out.println("\nPlayer Loses");
                        hostScore++;
                    }
                    break;

                case 3:
                    if (playersGuess.equals("Cup 3")) {
                        System.out.println("\nPlayer Wins");
                        playerScore++;
                    } else {
                        System.out.println("\nPlayer Loses");
                        hostScore++;
                    }
                    break;
            }
        }

        return playAgain();
    }

    /**
     * Prompts the player to decide whether to play another round.
     *
     * @return a character ('Y' or 'N') representing the player's decision to continue.
     */
    public char playAgain() {
        char play_or_dont;

        while (true) {
            System.out.println("\nAnother round?");
            play_or_dont = scanner.next().charAt(0);

            scanner.nextLine(); //extra \n character

            if (play_or_dont == 'Y' || play_or_dont == 'N') {
                return play_or_dont;
            }
        }
    }

    /**
     * Validates the player's guessed cup choice.
     *
     * @param userGuess the player's guessed cup (e.g., "Cup 1").
     * @return true if the guessed cup is valid, false otherwise.
     */
    public boolean validCupChoice(String userGuess) {
        return switch (userGuess) {
            case "Cup 1" -> true;
            case "Cup 2" -> true;
            case "Cup 3" -> true;
            default -> false;
        };
    }

    /**
     * Executes the main game loop for "Find the Thimble" and calculates scores.
     *
     * @return an array containing the player's score and the host's score.
     */
    public int[] playFindTheThimble() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            int hostsCup = gameHostChooseCup();

            if(testMode) {
                System.out.println("\nThe host choose the following cup: " + hostsCup);
            }

            System.out.println("\nEnter input to choose a cup where the host hid the thimble (Ex->'Cup 1', 'Cup 2', 'Cup 3'): ");
            String usersCupChoice = scanner.nextLine();

            char playAgain = checkPlayerGuess(usersCupChoice, hostsCup);

            if (playAgain == 'N') {
                keepPlaying = false;
            }
        }

        System.out.println("\nGame Score Board for Find the Thimble:\nPlayer Score: " + playerScore + "\nHost Score: " + hostScore);

        return new int[]{playerScore, hostScore};
    }

}
