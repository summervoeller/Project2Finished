import java.util.ArrayList;

public class ExceptionalIntegers {

    public static void main(String[] integerList) {

        ArrayList<Integer> validIntegerList = new ArrayList<>(); //creating the array list (like example)

        // looping through each argument
        for (int index = 0; index < integerList.length; index++) {
            String argument = integerList[index]; // gets current argument at (whichever) index

            try {

                Integer acceptableInteger = converter(argument); //tries to convert argument to int using conv. method


                validIntegerList.add(acceptableInteger); //if number is acceptable add it to the list
            } catch (NumberFormatException exception) {

                System.out.println("catch block says the argument " + argument + " is ignored because " + argument);
            }//end of catch
        }//end of for loop



        System.out.println("The ArrayList contents are:"); //displays what is inside ArrayList
        for (int index = 0; index < validIntegerList.size(); index++) {
            System.out.println("Item " + index + " is " + validIntegerList.get(index));
        }//end of for loop

    }//end of main method



    //seperate method converting string to integer
    public static Integer converter(String inputString) throws NumberFormatException {

        int newConvertedNumber = Integer.parseInt(inputString); // converts to integer (like example in ArrayLists)


        System.out.println("Converter method says integer OK - " + newConvertedNumber);

        return newConvertedNumber;
    }//end of converter method
}//end of ExceptionalIntegers class

