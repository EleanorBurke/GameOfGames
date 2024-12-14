package org.example;

import java.util.Scanner;

/**
 * Manages the "Game of Games" collection, allowing players to choose and play multiple games.
 */
public class PlayGames {
    int overallPlayerScore = 0;
    int overallHostScore = 0;

    Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor for the PlayGames class.
     */
    public PlayGames() {
    }

    /**
     * Displays the main menu, allowing the player to choose and play games.
     */
    public void mainMenu() {
        boolean stillPlaying = true;
        boolean wasGamePlayed;
        int gameNumber;
        char keepPlaying;

        while(stillPlaying) {
            displayGameOptions();
            gameNumber = scanner.nextInt();

            wasGamePlayed = playAGame(gameNumber);
            if(!wasGamePlayed) {
                do {
                    System.out.println("\nInvalid number. Please enter a number between 1-5");
                    gameNumber = scanner.nextInt();

                } while (gameNumber < 1 || gameNumber > 5);

                playAGame(gameNumber);
            }

            keepPlaying = playAgain();
            if(keepPlaying == 'N') {
                stillPlaying = false;
                System.out.println("\nThank you for playing!");
            }

        }

        System.out.println("\nGame Score Board for Overall Game of Games:\nPlayer Score: " + overallPlayerScore + "\nHost Score: " + overallHostScore);
    }

    /**
     * Displays the list of available games to the player.
     */
    public void displayGameOptions() {
        System.out.println(
                """
                
                1 - Find the Thimble
                2 - Coin Flip
                3 - Guess the Number
                4 - Even Odd
                5 - Find the Red Thread
                
                """
        );
    }

    /**
     * Starts the selected game based on the player's choice.
     *
     * @param gameNumber the number representing the selected game.
     * @return true if a valid game was played, false if the input was invalid.
     */
    public boolean playAGame(int gameNumber) {
        switch (gameNumber) {
            case 1:
                //FindTheThimble findTheThimble = new FindTheThimble();
                //int[] playerThenHostScore = findTheThimble.playFindTheThimble();
                //overallPlayerScore += playerThenHostScore[0];
                //overallHostScore += playerThenHostScore[1];
                break;
            case 2:
                //CoinFlip coinFlip = new CoinFlip();
                //overallPlayerScore += coinFlip.play();
                break;
            case 3:
                //GuessTheNumber guessTheNumber = new GuessTheNumber();
                //overallPlayerScore += guessTheNumber.play();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                return false;
        }

        return true;
    }

    /**
     * Prompts the player to decide whether to continue playing the "Game of Games".
     *
     * @return a character ('Y' or 'N') representing the player's decision to continue.
     */
    public char playAgain() {
        char play_or_dont;

        while (true) {
            System.out.println("\nDo you want to continue the game?");
            play_or_dont = scanner.next().charAt(0);

            if (play_or_dont == 'Y' || play_or_dont == 'N') {
                return play_or_dont;
            }
            else {
                System.out.println("\nInvalid option. Please enter Y or N");
            }
        }
    }

}
