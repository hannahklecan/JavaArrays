/*
 *This file contains all the code related to the Two-Dimensional Array processing. 
 */

public class TwoDimensionalArray {
    //global variables
    final static int ROW = 10;
    final static int COL = 10;
    final static int MIN = 100;
    final static int MAX= 999;

    /** Calls the entry point for this program. (In case user wishes to run program from current file.) 
    * @param args - Null: Not used in this program.  
    */ 
    public static void main(String[] args) {
    
        Lab4_Arrays.main(null);
    }   

    /*********************************************************************************************************
     * TWO DIMENSIONAL ARRAY CREATION, PROCESSING & OUTPUT
     *********************************************************************************************************/

    /**
     * This module acts as the control center for two-dimensional array processing. Separating this code from main makes
     * the code easier to read and debug.
     */
    public static void twoDimensionalProcessing() {
        System.out.println("\n************************************");
        System.out.println("      Two-Dimensional Processing");
        System.out.println("************************************");

        int[][] array2D = new int[ROW][COL];

        createArray(array2D);
        printArray(array2D, "unsorted");

        int lowestRowIndex = getLowestRowIndex(array2D);
        int lowestColIndex = getLowestColIndex(array2D);
        int highestRowIndex = getHighestRowIndex(array2D);
        int highestColIndex = getHighestColIndex(array2D);
        int sum = getSum(array2D);
        double average = getAverage(array2D);

        printResults(array2D, lowestRowIndex,lowestColIndex, highestRowIndex,highestColIndex, sum, average);

        sortArray(array2D);
        printArray(array2D, "sorted");
    }

    /**
     * This module builds the 2D array for the user
     * @param theArray represents the 2D array that will be referenced throughout the program.
     */
    public static void createArray(int [][] theArray){
        int newValue;

        for (int i = 0; i < theArray.length; i++) {
            for(int j = 0; j < theArray[i].length; j++) {
                newValue =(int)(Math.random() * ((MAX + 1) - MIN)) + MIN;
                //if the value is not unique, a new value should be generated.
                while (!isValueUnique(theArray, newValue)) {
                    newValue = (int)(Math.random() * ((MAX + 1) - MIN)) + MIN;
                }
                theArray[i][j] = newValue;
            }
        }
    }
    /**
     * This function ensures that the 2D array that was generated has unique values.The function checks each array value
     * with the current value that is generated by the created1DArray module.
     * @param theArray represents the 2D array that was generated.
     * @param value represents the current value being checked
     */
    public static boolean isValueUnique(int[][] theArray, int value){

        for (int i = 0; i < theArray.length; i++) {
            for(int j = 0; j< theArray[i].length;j++) {
                if (value == theArray[i][j]) {
                    //for testing purposes, indicates when a value is found to be NOT unique
                    //System.out.println("found duplicate");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This module prints the data obtained through the program for the 2D array.
     * @param theArray represents the 2D array being used throughout the program.
     * @param lowestRowIndex the row index of the array that contains the lowest value of the array.
     * @param lowestColIndex the col index of the array that contains the lowest value of the array.
     * @param highestRowIndex the row index of the array that contains the highest value of the array.
     * @param highestColIndex the col index of the array that contains the highest value of the array.
     * @param sum the sum of all the elements in the array.
     * @param average the average of all the elements in the array.
     */
    public static void printResults(int [][] theArray, int lowestRowIndex, int lowestColIndex,
                                    int highestRowIndex, int highestColIndex, int sum, double average){

        System.out.println("\nThe index of the highest value is " + highestRowIndex +", " + highestColIndex + ".  Its value is " + theArray[highestRowIndex][highestColIndex] + ".");
        System.out.println("The index of the lowest value is "  + lowestRowIndex +", " + lowestColIndex + ".  Its value is " + theArray[lowestRowIndex][lowestColIndex] + ".");
        System.out.println("The sum of the " + ROW*COL + " array elements is " + sum + ".");
        System.out.println("The average of the " + ROW*COL + " array elements is " + average + ".\n");
    }

    /**
     * This module prints the contents of the 2D array
     * @param theArray represents the 2D array that has been generated.
     */
    public static void printArray(int[][] theArray, String msgEdit){

        System.out.printf("Auto-generated %dx%d Array Elements:  (%s)\n", ROW, COL,msgEdit);

        for(int i = 0; i < theArray.length;i++){
            for(int j = 0; j < theArray[i].length; j++) {
                System.out.print(theArray[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This function finds the index with the lowest value.
     * @param theArray represents the 2D array being used throughout the program
     * @return lowestIndex the index where the lowest value of the array was found.
     */
    public static int getLowestRowIndex(int [][] theArray){
        int lowestRow = 0;
        int lowestValue = theArray[0][0];

        for(int i = 0; i < theArray.length; i++){
            for(int j = 0; j<theArray[i].length; j++) {
                if (theArray[i][j] < lowestValue) {
                    lowestValue = theArray[i][j];
                    lowestRow = i;
                }
            }
        }
        return lowestRow;
    }
    public static int getLowestColIndex(int [][] theArray){
        int lowestCol = 0;
        int lowestValue = theArray[0][0];

        for(int i = 0; i < theArray.length; i++){
            for(int j = 0; j<theArray[i].length; j++) {
                if (theArray[i][j] < lowestValue) {
                    lowestValue = theArray[i][j];
                    lowestCol = j;
                }
            }
        }
        return lowestCol;
    }

    /**
     * This function finds the index with the highest value.
     * @param theArray represents the 2D array being used throughout the program
     * @return highestIndex the index where the highest value of the array was found.
     */
    public static int getHighestRowIndex(int [][] theArray){
        int highestRow = 0;
        int highestValue = theArray[0][0];

        for(int i = 0; i < theArray.length; i++){
            for(int j = 0; j<theArray[i].length; j++) {
                if (theArray[i][j] > highestValue) {
                    highestValue = theArray[i][j];
                    highestRow = i;
                }
            }
        }
        return highestRow;
    }
    public static int getHighestColIndex(int [][] theArray){
        int highestCol = 0;
        int highestValue = theArray[0][0];

        for(int i = 0; i < theArray.length; i++){
            for(int j = 0; j<theArray[i].length; j++) {
                if (theArray[i][j] > highestValue) {
                    highestValue = theArray[i][j];
                    highestCol = j;
                }
            }
        }
        return highestCol;
    }

    /**
     * This function finds the sum of the 1d array
     * @param theArray represents the 2D array being used throughout the program
     * @return sum of the array values
     */
    public static int getSum(int [][] theArray){
        int sum = 0;

        for(int i = 0; i < theArray.length; i++){
            for(int j = 0; j<theArray.length;j++) {
                sum = sum + theArray[i][j];
            }
        }
        return sum;
    }

    /**
     * This function finds the average of all the values in the array.
     * @param theArray represents the 2D array being used throughout the program
     * @return average the average of the values in the array.
     */
    public static double getAverage(int[][] theArray){

        int sum = getSum(theArray);

        double average = (double)sum/ (ROW*COL);

        return average;
    }

    /**
     * This module sorts the elements of the array in ascending order using the insertion method.
     * First the module transfers the 2D array into a 1D array that can be sorted using the established insertion sort method.
     * Next the temp array is sorted using the 1D sortArray module. Finally the sorted 1D array is transferred into the 2D array
     * that is being referenced in main as (sorted).
     * @param theArray represents the 2D array being used throughout the program.
     */
    public static void sortArray(int[][] theArray){

        //create a 1D temp array to hold all the values in the 2D array linearly
        int temp[] = new int[ROW * COL];
        int k = 0;

        //copy elements in theArray (2D) into the 1D temp array
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                temp[k++] = theArray[i][j];
            }
        }

        //call insertion sort method for 1D array
        OneDimensionalArray.sortArray(temp);

        //copy the now sorted elements from the 1D temp array into theArray(2D)
        k = 0;
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                theArray[i][j] = temp[k++];
            }
        }
    }
}
