import java.util.Scanner;

public class IAm {


    private static final Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Please enter sentences, . to end.");

        String sentence;
        String qualities = "The qualities are ";

        do {

            sentence = keyboard.nextLine();

            if (sentence.startsWith("I am ")) {
                sentence = sentence.substring(5); // 5th character

                qualities = qualities + sentence + ", ";


            }


        } while (!sentence.equals(".")); // end of do while loop

        System.out.println( qualities);






    }//end of main method











} // end of IAm class
