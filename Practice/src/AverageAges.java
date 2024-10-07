/*
import java.util.Scanner;

public class AverageAges {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("WEEK 7 - LAB 6");
        System.out.println("How many houses in the street");

        int houseAmount = keyboard.nextInt();

        int [] houseNumbers = new int[houseAmount];

        int index;
        for(index = 0; index < houseNumbers.length; index++){

            System.out.println("What is the next house number:  ");
            houseNumbers [index] = keyboard.nextInt();


        }//end of for loop

        int[][] houseAges = new int[houseAmount][];

        int rowIndex;
        int columnIndex;

        for (rowIndex = 0; rowIndex < houseAmount; rowIndex++ ){
            System.out.println("How many people living in number "+ houseNumbers[rowIndex]);
            int numberOfColumn = keyboard.nextInt();

            houseAges[rowIndex] = new int[numberOfColumn];

            for (columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++ ) {
                System.out.println("What is the age of person" + (columnIndex + 1));
                houseAges[rowIndex][columnIndex] = keyboard.nextInt();



            }// end of inner loop
            System.out.println();


        }//end of outer loop


        //lets count - display

        int totalAge = 0;


        for (rowIndex = 0; rowIndex < houseAmount; rowIndex++ ){

            for (columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++ ) {

               totalAge = totalAge + houseAges[rowIndex][columnIndex];



            }
            System.out.println("House " + (rowIndex + 1) + "has a total age of:  ");
            System.out.println();


        }



    }//end of main method

 */

//}// end of AverageAges
