/*
import java.util.Scanner;

public class HelloWorld {
private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Practice Arrays");


        // Declaring an array first
        int [] myArray = new int[3];
        int [][] yourArray = new int[3][4];


    } // end of the main method


    private static void updateYourArray (int [][] yourArray){

        int indexRow;
        int indexColumn;

        //updating the array to assign a value into the array 2nd step
        for(indexRow = 0; indexRow < 3; indexRow++){
            for(indexColumn = 0; indexColumn < 4; indexColumn++){

                System.out.println("At index ["  + indexRow +  "]["  + indexColumn  +  "]: Enter the integer number: ");
                yourArray[indexRow][indexColumn] = keyboard.nextInt();


            }// end of inner for loop
        }//end of outer for loop

        // lets display the content of the 2D array 3rd step
        for(indexRow = 0; indexRow < 3; indexRow++){
            for(indexColumn = 0; indexColumn < 4; indexColumn++){

                System.out.println("At index ["  + indexRow +  "]["  + indexColumn  +  "]: "  +yourArray[indexRow][indexColumn]);



            }// end of inner for loop
        }//end of outer for loop


    }//end of updateYourArray










    private static void updateMyArray (int [] myArray){
        // update an array and put numbers inside
        int index;
        for (index = 0; index < myArray.length; index++){

            System.out.println("Enter a number to be stored into the array");
            myArray[index] = keyboard.nextInt();

        }//end of for loop

        //Now display the content of the array
        System.out.println("Here is the content stored in the array");
        for (index = 0; index < myArray.length; index++){

            System.out.println(myArray[index]);


        }//end of for loop

    }//end of method



 */


//} //End of the HelloWorld CLass
