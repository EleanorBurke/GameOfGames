import java.util.Scanner; // Import the Scanner class
import java.util.Random; // Import the Random class

/**
 * The CoinFlip class implements a coin-flipping game where a player
 * guesses the outcome of a coin flip (Heads or Tails).
 *
 * The game supports two modes:
 * Player Mode: Standard gameplay where the coin flip result is hidden.
 * Test Mode: Displays the coin flip result for debugging and testing purposes.
 *
 * @author: Eleanor Burke
 * @version: 1.0
 *           Date: 2024-12-14
 */
public class CoinFlip {

    // VARIABLES
    // If test is true the testing mode is activated -- default is false
    private boolean test = false;
    private Random rand = new Random();

    // These var will be updated according to player's guess and the computer's
    // random coin flip
    private String guess = "H";
    private String flip = "H";

    // Integer records the score player
    private int playerScore = 0;

    // CONSTRUCTOR
    /**
     * Constructs a new CoinFlip game.
     *
     * @param test a boolean value that determines if the game runs in test mode.
     *             If true, the coin flip result is displayed to the user.
     */
    public CoinFlip(boolean test) {
        this.test = test;
    }

    // METHODS
    /**
     * Game play for CoinFlip game.
     * 
     * @return returns updated score.
     */
    public int play() {
        boolean playAgain = true;
        Scanner input = new Scanner(System.in);

        while (playAgain) {
            // Computer flipping coin: If 0 -- H and if 1 -- T
            int randomFlip = rand.nextInt(2);
            if (randomFlip == 0) {
                flip = "H";
            } else {
                flip = "T";
            }

            // If test is true flip is shown to user
            if (test) {
                System.out.println("TEST: Coin Flip result: " + flip);
            }

            // Prompts users for guess until valid value is entered
            while (true) {
                System.out.println("Player Choose Heads or Tails (H/T)");
                String playerInput = input.nextLine();
                if (playerInput.equals("N")) {
                    System.out.println("Game Over.");
                    System.out.println("Player Score: " + playerScore);
                    return playerScore;
                } else if (GetInput.validateString("H", "T", playerInput)) {
                    guess = playerInput;
                    break;
                }
            }

            // Shows player coin flip outcome and wether or not they won and
            // updates playerScore accordingly
            System.out.println("Coin flip: " + flip);
            if (flip.equals(guess)) {
                System.out.println("You Wons!");
                playerScore += 1;
                if (test) {
                    System.out.println("TEST: score increased by 1");
                }
            } else {
                System.out.println("You Lost!");
                if (test) {
                    System.out.println("TEST: score NOT increased");
                }
            }

            // Prompts users for guess until valid value is entered
            while (true) {
                System.out.println("Play Again? (Y/N)");
                String playerInput = input.nextLine();
                if (GetInput.validateString("Y", "N", playerInput)) {
                    if (playerInput.equals("Y")) {
                        playAgain = true;
                    } else {
                        playAgain = false;
                        System.out.println("Player Score: " + playerScore);
                    }
                    break;
                }
            }

        }

        return playerScore;
    }

    public static void main(String[] args) {
        CoinFlip game = new CoinFlip(true);

        game.play();
    }

}