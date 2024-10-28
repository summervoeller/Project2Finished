import java.util.Scanner;//YES


public class Practice2D { //YES

    private static final Scanner keyboard = new Scanner(System.in); //YES

    public static void main(String[] args) { //YES

        int [][] myArray = new int[2][];


        for (int rowIndex = 0; rowIndex < myArray.length; rowIndex++){ // Loops through each row of the array

            System.out.println("At row index"  +  rowIndex  + "Enter the number of column for this row...");

            int numberOfColumn = keyboard.nextInt();

            myArray[rowIndex] = new int[numberOfColumn];

            for(int columnIndex = 0; columnIndex <numberOfColumn; columnIndex++ ){ // Now, loop through each column in this row

                System.out.println("At row ["  + rowIndex + "]  [" + columnIndex + "]: Enter a number: " );
                myArray[rowIndex][columnIndex] = keyboard.nextInt();

            }

        }


        for (int rowIndex = 0; rowIndex < myArray.length; rowIndex++){



            for(int columnIndex = 0; columnIndex < myArray[rowIndex].length; columnIndex++ ){

                System.out.println("At row ["  + rowIndex + "]  [" + columnIndex + "]: " + myArray[rowIndex][columnIndex] );


            }

        }










    }// end of main method


}// end of Practice2D class
