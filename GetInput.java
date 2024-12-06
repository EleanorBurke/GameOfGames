public class GetInput {

    /**
     *  This method validates string inputs by comparing input to the expected value
     * 
     * @param Exp1  The valid entry
     * @param input The user input that need to be validated 
     * @return      Returns true if input is valid and false if not
     */
    public static boolean validateString(String Exp1, String input){

        if(input.equals(Exp1)){
            return true;
        } else {
            System.out.println("Invalid Choice. Please Enter " + Exp1);
        }

        return false;
    }


    /**
     *  This method validates string inputs by comparing input to the 2 expected values
     * 
     * @param Exp1  The 1st valid entry
     * @param Exp2  The 2nd valid entry
     * @param input The user input that need to be validated 
     * @return      Returns true if input is valid and false if not
     */
    public static boolean validateString(String Exp1, String Exp2, String input){

        if(input.equals(Exp1) || input.equals(Exp2)){
            return true;
        } else {
            System.out.println("Invalid Choice. Please Enter " + Exp1 + " or " + Exp2);
        }

        return false;
    }


}
