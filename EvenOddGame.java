import java.util.Scanner;

public class EvenOddGame {

    // Static variables to track the scores
    private static int evenScore = 0;
    private static int oddScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the Even-Odd Game!");

        while (playAgain) {
            // System randomly selects a number before prompting the user
            int systemNumber = generateRandomNumber();
            System.out.println("The system has chosen a number.");

            // Continuously prompt for a valid guess until the user enters a valid input
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter your guess (integer): ");
                String input = scanner.nextLine();

                try {
                    // Check for invalid input (i.e., if the input is empty or contains a decimal point)
                    if (input.isBlank() || input.contains(".")) {
                        throw new NumberFormatException();
                    }

                    int playerNumber = Integer.parseInt(input);
                    String playerResult = checkEvenOdd(playerNumber);
                    String systemResult = checkEvenOdd(systemNumber);

                    System.out.println("The number you entered is: " + playerResult);

                    // Call the updateScore method to update the score based on the player's guess
                    updateScore(playerResult, systemResult);

                    validInput = true;  // Exit the loop if the input is valid
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            // Display current scores after each round
            System.out.println("Current Score: Even: " + evenScore + ", Odd: " + oddScore);

            // Prompt to continue or restart
            System.out.print("Do you want to play again or restart the game? (play/restart/exit): ");
            String userChoice = scanner.nextLine().trim().toLowerCase();

            if (userChoice.equals("restart")) {
                resetScores();
                System.out.println("Scores have been reset! Starting a new game...");
            } else if (userChoice.equals("exit")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over!");
        System.out.println(getFinalScores());  // Display final score using the new static method

        scanner.close();
    }

    public static String checkEvenOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static boolean playAgain(String input) {
        return input.trim().equalsIgnoreCase("yes");
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    // Static method to get the Even score
    public static int getEvenScore() {
        return evenScore;
    }

    // Static method to get the Odd score
    public static int getOddScore() {
        return oddScore;
    }

    // Static method to reset the scores
    public static void resetScores() {
        evenScore = 0;
        oddScore = 0;
    }

    // Static method to set final scores (e.g., if ending the game early)
    public static void setFinalScores(int even, int odd) {
        evenScore = even;
        oddScore = odd;
    }

    // Static method to get the final scores as a string
    public static String getFinalScores() {
        return "Final Score: Even: " + evenScore + ", Odd: " + oddScore;
    }

    // Static method to update the score based on the player's guess
    public static void updateScore(String playerResult, String systemResult) {
        if (playerResult.equals(systemResult)) {
            if (playerResult.equals("Even")) {
                evenScore++;
            } else {
                oddScore++;
            }
        }
    }
}
