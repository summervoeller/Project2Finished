import java.util.Scanner;

public class CheckingFibonacciPrime {

    private static final Scanner keyboard = new Scanner(System.in);

    private static final int ARRAY_SIZE = 10;
    private static final int STOP_VALUE_ZERO = 0;

    public static void main(String[] args) {

        System.out.println("WEEK 6 - LAB5");

        int [] myNumberArray = new int[ARRAY_SIZE];

        int validNumberCount = fillingArray(myNumberArray);

        int index;

        for (index = 0; index < validNumberCount; index++) {

            int currentValue = myNumberArray[index];

            if(isFibonacci(currentValue) &&  isPrime(currentValue)) {
                System.out.println(currentValue + "is Fibonacci and is Prime");
            } else if(isFibonacci(currentValue) &&  !isPrime(currentValue)) {
                System.out.println(currentValue + "is Fibonacci and is NOT Prime");
            } else if(!isFibonacci(currentValue) &&  isPrime(currentValue)) {
                System.out.println(currentValue + "is NOT Fibonacci and is Prime");
            } else {
                System.out.println(currentValue + "is NOT Fibonacci and is NOT Prime");
            }


        }








    } //end of the main method


    private static boolean isPrime(int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {

                return(false);
            }
            divisor++;
        }
        return(true);
    } // End of the isPrime Method


    private static boolean isFibonacci(int candidate){


        long previous = 1;
        long current = 0;
        long next;


        while (current < candidate){
            next = current + previous;
            previous = current;
            current = next;
        } //end of the while loop

        if(current == candidate) {
            return true;
        }else{
            return false;
        }


    } // End of isFibonacci Method



    private static int fillingArray (int [] receivingArray) {

        System.out.println("Please enter numbers (0 to stop) :");

        int inputvalue = keyboard.nextInt();
        int index = 0;


        do {

          receivingArray[index]  = inputvalue;
          index++;

            inputvalue = keyboard.nextInt();



        }while ( inputvalue != STOP_VALUE_ZERO && index < ARRAY_SIZE );



        return index;
    } // end of do while loop


} // end of class
