/*
 * Author: Hannah Klecan
 * Lab4: Arrays
 * This program gives the user the option of processing a 1 or 2D array.
 * Once chosen, the program finds the min/max value, index, sum and average. 
 * Finally, the program will sort the array using the insertion sort method. 
 */
public class Lab4_Arrays {

    final static int OPTION_1 = 1;
    final static int OPTION_2 = 2;
    final static int OPTION_3 = 3;

    public static void main(String[] args){

        displayMenu();
        int userChoice = getUserChoice();

        while(userChoice!= OPTION_3) {

            //1D Array
            if(userChoice == OPTION_1) {
                OneDimensionalArray.oneDimensionalProcessing();
            }
            //2D array
            else if(userChoice == OPTION_2){
                TwoDimensionalArray.twoDimensionalProcessing();
            }

            displayMenu();
            userChoice = getUserChoice();
        }

        System.out.println("--- Program Ended Normally ---");
    }//end of main

    /**
     * Displays the program menu to the user.
     */
    public static void displayMenu(){
        System.out.println("************************************");
        System.out.println("           Array Program\n");
        System.out.printf("%3d. One-dimensional Array\n", OPTION_1);
        System.out.printf("%3d. Two-dimensional Array\n", OPTION_2);
        System.out.printf("%3d. Exit\n", OPTION_3);
    }

    /**
     * Gets a valid menu option from the user
     * @return userChoice, the menu option chosen by the user.
     */
    public static int getUserChoice(){
        int userChoice = IR4.getInteger("Enter your selection: ");

        while(isInvalidOption(userChoice)){
            userChoice = IR4.getInteger("Enter your selection: ");
        }

        return userChoice;
    }

    /**
     * determines if the entered user option is valid or not.
     * @param userChoice the menu option entered by the user.
     * @return true if the number entered is INVALID, false if it is VALID
     */
    public static boolean isInvalidOption(int userChoice){

        switch(userChoice){
            case OPTION_1:
            case OPTION_2:
            case OPTION_3:
                return false;
            default:
                break;
        }

        System.out.println("Error: invalid menu option, try again.");
        return true;
    }

}//end of class

