/**
 * 
 * The GetInput class provides methods for validating user inputs.
 *
 * @author Eleanor Burke
 * @version 1.0
 *          Date: 2024-12-14
 * 
 */
public class GetInput {

    /**
     * Validates a string input by comparing it to a single expected value.
     *
     * @param Exp1  The valid entry.
     * @param input The user input that needs to be validated.
     * @return {@code true} if the input matches the expected value; {@code false}
     *         otherwise.
     */
    public static boolean validateString(String Exp1, String input) {

        if (input.equals(Exp1)) {
            return true;
        } else {
            System.out.println("Invalid Choice. Please Enter " + Exp1);
        }

        return false;
    }

    /**
     * Validates a string input by comparing it to two expected values.
     *
     * @param Exp1  The first valid entry.
     * @param Exp2  The second valid entry.
     * @param input The user input that needs to be validated.
     * @return {@code true} if the input matches either expected value;
     *         {@code false} otherwise.
     */
    public static boolean validateString(String Exp1, String Exp2, String input) {

        if (input.equals(Exp1) || input.equals(Exp2)) {
            return true;
        } else {
            System.out.println("Invalid Choice. Please Enter " + Exp1 + " or " + Exp2);
        }

        return false;
    }

    /**
     * 
     * Validates an integer input by checking whether it falls within a specified
     * range.
     * 
     * @param lowBound The lower bound of the valid range (inclusive).
     * @param topBound The upper bound of the valid range (inclusive).
     * @param input    The user input that needs to be validated.
     * @return {@code true} if the input is within the range; {@code false}
     *         otherwise.
     */
    public static boolean validateNumRange(int lowBound, int topBound, int input) {

        if (input >= lowBound && input <= topBound) {
            return true;
        } else {
            System.out
                    .println("Invalid input. Please enter a valid number between range: " + lowBound + "-" + topBound);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.print(validateNumRange(1, 10, 1000000));
    }
}
