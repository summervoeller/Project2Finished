
import java.util.Scanner;

public class StreetMaintenance {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("WEEK 7 - LAB 6");
        System.out.print("How many houses in the street? ");

        int houseAmount = keyboard.nextInt();
        int[] houseNumbers = new int[houseAmount];

        //updating the array
        int index;
        for (index = 0; index < houseNumbers.length; index++){
            System.out.print("What is the next house number:  ");
            houseNumbers[index] = keyboard.nextInt();

        } // end of for loop

        int [][] houseAges = new int[houseAmount][];

        int rowIndex;
        int columnIndex;

        for(rowIndex = 0; rowIndex < houseAges.length; rowIndex++){

            System.out.print("How many people live in:  "  +  houseNumbers[rowIndex] + ": ");
            int numberOfPeople = keyboard.nextInt();

            houseAges[rowIndex] = new int[numberOfPeople];

            for(columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++){
                System.out.print("What is the age of person"  +  (columnIndex + 1));
                houseAges[rowIndex][columnIndex] = keyboard.nextInt();

            } //end of inner for loop

        }// end of for loop


        //DISPLAY
        int totalAge = 0;
        int streetAge = 0;


        for(rowIndex = 0; rowIndex < houseAges.length; rowIndex++){


            for(columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++){

                totalAge = totalAge + houseAges[rowIndex][columnIndex];

            } //end of inner for loop
            System.out.println("House  " + (rowIndex + 1) + "has total age of: " + totalAge);

            streetAge = streetAge + totalAge;
            totalAge = 0;






        }// end of for loop

        System.out.println("The street has a total age of" + streetAge);


    }//end of main method


}//end of class
