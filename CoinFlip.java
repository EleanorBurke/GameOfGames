import java.util.Scanner; // Import the Scanner class
import java.util.Random; // Import the Random class

public class CoinFlip {

    // VARIABLES
    // If test is true the testing mode is activated
    // meaning the user will see the computers 'moves'
    private boolean test = true;
    private Random rand = new Random();

    // These var will be updated according to player's guess and the computer's
    // random coin flip
    private String guess = "H";
    private String flip = "H";

    // Array records the score player and computer
    public int playerScore = 0;

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
                System.out.println("Coin Flip result: " + flip);
            }

            // Prompts users for guess until valid value is entered
            while (true) {
                System.out.println("Player Choose Heads or Tails (H/T)");
                String playerInput = input.nextLine();
                if(GetInput.validateString("H", "T", playerInput)){
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
            } else {
                System.out.println("You Lost!");
            }

            // Prompts users for guess until valid value is entered
            while (true) {
                System.out.println("Play Again? (Y/N)");
                String playerInput = input.nextLine();
                if(GetInput.validateString("Y", "N", playerInput)){
                    if (playerInput.equals("Y")){
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
        CoinFlip game = new CoinFlip();

        game.play();

    }

}