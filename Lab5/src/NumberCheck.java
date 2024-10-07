import java.util.Scanner;

/**
 * Compute if Fibonacci or Prime number
 *
 * @author Summer Voeller
 */

public class NumberCheck {

    /*

    // Final Constants that don't change for whole code
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAX_NUMBERS_INTEGERS = 10;  // the max # of integers the array can hold


    // ----------------------------------------------------------------------------------------------------------------
    // Start of Main method
    public static void main(String[] args) {
        // declaring variables for main method
        int[] numbers = new int[MAX_NUMBERS_INTEGERS];  // makes an array to store up to 10 integers
        int ourcount;  // ourcount stores the # of correct entries the user provides

        // This calls the method to read #'s
        ourcount = readArrayNumbers(numbers);  // this reads #'s from user and stores how many were entered


        // for loop to go through #'s in the array
        for (int i = 0; i < ourcount; i++) {  // This loops through each number entered
            int number = numbers[i];  // Gets the number from the array

            // calls the method to check if the # is fibonacci or prime
            boolean isFibonacci = isFibonacci(number);
            boolean isPrime = isPrime(number);

            // prints results for each #
            System.out.print(number + " is ");
            if (isFibonacci) {  // If Fibonacci
                System.out.print("Fibonacci");  // Print "Fibonacci"
            } else {  // If not Fibonacci
                System.out.print("not Fibonacci");  // Print "not Fibonacci"
            }
            System.out.print(" and is ");  // Continue printing to check if the number is prime
            if (isPrime) {  // If # is prime
                System.out.println("prime");  // Print "prime"
            } else {  // If # is not prime
                System.out.println("not prime");  // Print "not prime"
            }
        }
    } // End of Main method -------------------------------------------------------------------------------------

    // Start of arrayNumbers method------------------------------------------------------------------------------
    // Reads up to 10 #'s and stores them in an array
    double[] readArrayNumbers = new double[10];

    public static int readArrayNumbers(int[] numbers) {

        // Declared variables for this method
        int index = 0;  // Counter for how many numbers have been read
        int number;  // Variable to store each number entered by the user
        System.out.print("Enter a number (0 to stop): ");
        // Do while loop
        do {

            numbers[index] = keyboard.nextInt();  // Store the number in the array


            number = keyboard.nextInt();
        } while (numbers[index - 1] != 0 && index < MAX_NUMBERS_INTEGERS);


        System.out.println("Array is full. No more numbers can be entered.");  // array is full
    }
}

        return index;
    } // End of readNumbers method -------------------------------------------------------------------------------

// Start of isFibonacci method------------------------------------------------------------------------------
// checkS if # is fibonacci #
public static boolean isFibonacci(int num) {

    int
    int

    if (num < 0) return false;  // Return false for neg #'s bc they are not Fibonacci


    while (current < num) {

    }
    return
} // End of isFibonacci method----------------------------------------------

// Start of isPrime method
// checks if a number is a prime #
public static boolean isPrime(int num) {

    if (num <= 1) return false;

    // check for factors 2 and up to the sqrt of num
    for (int i = 2; i <= Math.sqrt(num); i++) {  // Loop from 2 to the square root of the number
        if (num % i == 0) return false;  // If 'num' is divisible by 'i', it is not prime
    }
    return true;
} // End of isPrime method


     */

} // end of the class
