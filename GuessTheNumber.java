import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    // VARIABLES
    private boolean test = true; // For testing, displays the number to guess
    private Random rand = new Random(); // Random number generator
    private int numberToGuess; // The number the player needs to guess
    private int playerGuess; // The player's current guess

    // METHODS

    /**
     * Starts the Guess the Number game.
     */
    public void play() {
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);

        while (playAgain) {
            // Generate a random number between 1 and 100
            numberToGuess = rand.nextInt(100) + 1;

            if (test) {
                System.out.println("Number to guess (for testing): " + numberToGuess);
            }

            boolean numberGuessed = false;

            // Main game loop
            while (!numberGuessed) {
                System.out.println("Enter your guess (1-100):");
                String playerInput = input.nextLine();
                
                try {
                    playerGuess = Integer.parseInt(playerInput);

                    if (playerGuess < 1 || playerGuess > 100) {
                        System.out.println("Invalid input. Please enter a number between 1 and 100.");
                        continue;
                    }

                    if (playerGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number.");
                        numberGuessed = true;
                    } else if (playerGuess < numberToGuess) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // Prompt for replay
            while (true) {
                System.out.println("Play Again? (Y/N)");
                String playerInput = input.nextLine();
                if (GetInput.validateString("Y", "N", playerInput)) {
                    if (playerInput.equals("Y")) {
                        playAgain = true;
                    } else {
                        playAgain = false;
                        System.out.println("Thanks for playing!");
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        GuessTheNumber game = new GuessTheNumber();
        game.play();
    }
}
