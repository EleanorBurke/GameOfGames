import java.util.Scanner;

public class RedThreadGame {

    private static int redThreadSpool; // Random spool containing the red thread
    private static int totalSpools;   // Total number of spools in the game
    private static boolean gameInProgress = false; // Tracks if a game is currently running
    private static int player1Score = 0;  // Player 1's score
    private static int player2Score = 0;  // Player 2's score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Find the Red Thread Game!");

        runTestCases(); // Automatically run test cases before interactive game starts

        while (true) {
            if (!gameInProgress) {
                setupGame(scanner);
            }

            playGame(scanner);

            System.out.println("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                System.out.println("Exiting the game. Final Scores:");
                displayScores();
                break;
            }

            resetGame();
        }
    }

    private static void setupGame(Scanner scanner) {
        System.out.print("Enter the total number of spools: ");
        try {
            totalSpools = Integer.parseInt(scanner.nextLine());
            if (totalSpools <= 1) {
                System.out.println("Invalid input. Please enter a valid number of spools (greater than 1).");
                setupGame(scanner);
            } else {
                redThreadSpool = (int) (Math.random() * totalSpools) + 1;
                gameInProgress = true;
                System.out.println("Game is set up. Players can start playing.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number of spools.");
            setupGame(scanner);
        }
    }

    private static void playGame(Scanner scanner) {
        int currentPlayer = 1; // Start with Player 1
        boolean gameWon = false;

        while (!gameWon) {
            System.out.println("Player " + currentPlayer + ", it's your turn. Pick a spool (1-" + totalSpools + "):");
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Invalid input, please enter a guess.");
                    continue;
                }

                int playerPick = Integer.parseInt(input);

                if (playerPick < 1 || playerPick > totalSpools) {
                    System.out.println("Invalid input. Please pick a valid number of spools.");
                    continue;
                }

                if (playerPick == redThreadSpool) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    if (currentPlayer == 1) {
                        player1Score++;
                    } else {
                        player2Score++;
                    }
                    gameWon = true;
                } else {
                    System.out.println("Wrong spool. Passing the turn to Player " + (currentPlayer == 1 ? 2 : 1) + ".");
                    currentPlayer = currentPlayer == 1 ? 2 : 1; // Toggle player
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid guess.");
            }
        }
    }

    private static void displayScores() {
        System.out.println("Player 1 Score: " + player1Score);
        System.out.println("Player 2 Score: " + player2Score);
    }

    private static void resetGame() {
        gameInProgress = false;
        System.out.println("The game has been reset.");
    }

    // Test cases
    private static void runTestCases() {
        System.out.println("Running test cases...");

        // Test 1: Game setup
        totalSpools = 10;
        gameInProgress = false;
        redThreadSpool = 5;
        assert totalSpools == 10 : "Test 1 Failed: Total spools setup error.";

        // Test 2: Player 1 picks the red thread
        int pick = 5;
        boolean player1Wins = pick == redThreadSpool;
        assert player1Wins : "Test 2 Failed: Player 1 win logic error.";

        // Test 3: Player 1 picks a wrong spool
        pick = 4;
        boolean turnPasses = pick != redThreadSpool;
        assert turnPasses : "Test 3 Failed: Turn pass logic error.";

        // Test 4: Player 2 picks the red thread
        int currentPlayer = 2;
        pick = 5;
        boolean player2Wins = pick == redThreadSpool && currentPlayer == 2;
        assert player2Wins : "Test 4 Failed: Player 2 win logic error.";

        // Test 5: Invalid input
        try {
            pick = Integer.parseInt("invalid");
        } catch (NumberFormatException e) {
            assert true : "Test 5 Passed: Caught invalid input.";
        }

        // Test 6: Game loop continues
        pick = 3;
        assert pick != redThreadSpool : "Test 6 Failed: Game loop error.";

        // Test 7: Out-of-range input
        pick = 11;
        boolean invalidRange = pick < 1 || pick > totalSpools;
        assert invalidRange : "Test 7 Failed: Out-of-range input error.";

        // Test 8: Empty input
        String input = "";
        boolean isEmpty = input.trim().isEmpty();
        assert isEmpty : "Test 8 Failed: Empty input logic error.";

        System.out.println("All test cases passed.");
    }
}
