import java.util.Scanner;
/**
 * Record of dental information for a family.
 * @author Summer Voeller
 */
public class RedoTeethProjectPractice {
    /**
     * Global Scanner object to use keyboard
     */
    private static final Scanner keyboard = new Scanner(System.in);

    private static final int MAX_FAMILY_MEMBERS = 6;
    private static final int MAX_NUMBER_OF_TEETH = 8;
    private static final int UPPER_ROW = 1;
    private static final int LOWER_ROW = 0;
    private static final int ROWS_FOR_UPPER_AND_LOWER = 2;

    private static char[][][] familyTeethTypesArray;
    private static String[] familyNamesArray;

    //------------------------------------------------------------------------------------------------------------
    /**
     * The main method
     * @param args Passed in from the command line
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        int numberOfMembers = getFamilySize();
        getFamilyInfo(numberOfMembers);
        showMenu(numberOfMembers);
        keyboard.close();

    }// END OF MAIN CLASS

    //------------------------------------------------------------------------------------------------------------
    /**
     * gets and validates the number of people in the family
     * @return validated number of people in the family
     */

    private static int getFamilySize() {

        int familySize;

        do {
            System.out.print("Please enter number of people in the family: ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Invalid input, please enter a number: ");
                keyboard.nextLine();
            }
            familySize = keyboard.nextInt();
            if (familySize <= 0 || familySize > MAX_FAMILY_MEMBERS) {
                System.out.print("Invalid number of people, try again: ");
            }
        } while (familySize <= 0 || familySize > MAX_FAMILY_MEMBERS);

        return familySize;

    }// end of getFamilySize method

    //------------------------------------------------------------------------------------------------------------
    /**
     * prompts the user to enter the names and teeth information for each family member
     * @param numberOfMembers number of family members
     */

    private static void getFamilyInfo(int numberOfMembers) {

        familyNamesArray = new String[numberOfMembers];
        familyTeethTypesArray = new char[numberOfMembers][ROWS_FOR_UPPER_AND_LOWER][];

        for (int individual = 0; individual < numberOfMembers; individual++) {

            System.out.print("Please enter the name for family member " + (individual + 1) + ": ");
            familyNamesArray[individual] = keyboard.next();

            System.out.print("Please enter the uppers for " + familyNamesArray[individual] + ": ");
            getTeethInfo(individual, UPPER_ROW);

            System.out.print("Please enter the lowers for " + familyNamesArray[individual] + ": ");
            getTeethInfo(individual, LOWER_ROW);

        }// end of for statement

    } // end of getFamilyInfo method

    //-----------------------------------------------------------------------------------------------------------
    /**
     * get and validate the teeth information for a specific family member and tooth row
     * @param individual individual family member
     * @param row the tooth row (upper or lower)
     */

    private static void getTeethInfo(int individual, int row) {

        String teethInput;

        while (true) {
            teethInput = keyboard.next().toUpperCase();

            if (teethInput.length() > MAX_NUMBER_OF_TEETH) {
                System.out.print("Too many teeth, try again: ");
                continue;
            }

            int correctLetters = 0;

            for (int i = 0; i < teethInput.length(); i++) {
                char tooth = teethInput.charAt(i);

                if (tooth == 'I' || tooth == 'B' || tooth == 'M') {
                    correctLetters++;
                }
            }

            if (correctLetters == teethInput.length()) {
                familyTeethTypesArray[individual][row] = new char[teethInput.length()];
                for (int i = 0; i < teethInput.length(); i++) {
                    familyTeethTypesArray[individual][row][i] = teethInput.charAt(i);
                }
                break;
            } else {
                System.out.print("Invalid teeth types, try again: ");
            }

        }//end of while loop

    }//end of getTeethInfo method
    //-----------------------------------------------------------------------------------------------------------
    /**
     * display a menu of options to the user and handle their input
     * @param numberOfMembers number of family members
     */

    private static void showMenu(int numberOfMembers) {
        char menuChoice;

        System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it: ");
        menuChoice = keyboard.next().toUpperCase().charAt(0);

        while (true) {
            switch (menuChoice) {
                case 'P':
                    printTeethRecords(numberOfMembers);
                    break;
                case 'E':
                    extractTooth(numberOfMembers);
                    break;
                case 'R':
                    calculateRootCanal(numberOfMembers);
                    break;
                case 'X':
                    System.out.println("\nExiting the Floridian Tooth Records :-)");
                    return;
                default:
                    System.out.println("Invalid menu option, try again");
            }

            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it: ");
            menuChoice = keyboard.next().toUpperCase().charAt(0);
        }

    }// end of displayMenu method
    //------------------------------------------------------------------------------------------------------------
    /**
     * prints the teeth records for each family member
     * @param numberOfMembers number of family members
     */
    private static void printTeethRecords(int numberOfMembers) {

        for (int individual = 0; individual < numberOfMembers; individual++) {
            System.out.println(familyNamesArray[individual]);
            System.out.print("  Uppers:  ");
            for (int tooth = 0; tooth < familyTeethTypesArray[individual][UPPER_ROW].length; tooth++) {
                System.out.print((tooth + 1) + ":" + familyTeethTypesArray[individual][UPPER_ROW][tooth] + "  ");
            }
            System.out.println();
            System.out.print("  Lowers:  ");
            for (int tooth = 0; tooth < familyTeethTypesArray[individual][LOWER_ROW].length; tooth++) {
                System.out.print((tooth + 1) + ":" + familyTeethTypesArray[individual][LOWER_ROW][tooth] + "  ");
            }
            System.out.println();
        }//end of for statement

    }//end of printTeethRecords method
    //------------------------------------------------------------------------------------------------------------
    /**
     * extract a tooth from a specific family member
     * @param numberOfMembers number of family members
     */
    private static void extractTooth(int numberOfMembers) {
        System.out.print("Which family member: ");
        String memberName = keyboard.next();
        int memberIndex = -1;
        for (int i = 0; i < numberOfMembers; i++) {
            if (familyNamesArray[i].equalsIgnoreCase(memberName)) {
                memberIndex = i;
                break;
            }
        }
        if (memberIndex == -1) {
            System.out.println("Invalid family member, try again");
            return;
        }
        System.out.print("Which tooth layer (U)pper or (L)ower: ");
        char layer = keyboard.next().toUpperCase().charAt(0);
        int row = -1;
        if (layer == 'U') {
            row = UPPER_ROW;
        } else if (layer == 'L') {
            row = LOWER_ROW;
        } else {
            System.out.println("Invalid layer, try again");
            return;
        }
        System.out.print("Which tooth number: ");
        int toothNumber = keyboard.nextInt() - 1;
        if (toothNumber < 0 || toothNumber >= familyTeethTypesArray[memberIndex][row].length) {
            System.out.println("Invalid tooth number, try again");
            return;
        }
        if (familyTeethTypesArray[memberIndex][row][toothNumber] == 'M') {
            System.out.println("Missing tooth, try again");
            return;
        }
        familyTeethTypesArray[memberIndex][row][toothNumber] = 'M';

    }// end of extractTooth method
    //------------------------------------------------------------------------------------------------------------
    /**
     * calculates the root canal indices for the family
     * @param numberOfMembers number of family members
     */
    private static void calculateRootCanal(int numberOfMembers) {
        int incisors = 0;
        int bicuspids = 0;
        int missingTeeth = 0;
        for (int individual = 0; individual < numberOfMembers; individual++) {
            for (int row = 0; row < ROWS_FOR_UPPER_AND_LOWER; row++) {
                for (int tooth = 0; tooth < familyTeethTypesArray[individual][row].length; tooth++) {
                    char toothType = familyTeethTypesArray[individual][row][tooth];
                    if (toothType == 'I') {
                        incisors++;
                    } else if (toothType == 'B') {
                        bicuspids++;
                    } else if (toothType == 'M') {
                        missingTeeth++;
                    }
                }
            }
        }
        double discriminant = bicuspids * bicuspids - 4 * incisors * missingTeeth;
        if (discriminant < 0) {
            System.out.println("No real roots");
        } else {
            double root1 = (-bicuspids + Math.sqrt(discriminant)) / (2 * incisors);
            double root2 = (-bicuspids - Math.sqrt(discriminant)) / (2 * incisors);
            System.out.printf("One root canal at     %.2f%n", root1);
            System.out.printf("Another root canal at %.2f%n", root2);
        }//end of if else statement

    }// end of calculateRootCanal method

} // end of RedoTeethProjectPractice class
