import java.util.Scanner;

/**
 * This program records and manages the dental records for a family in Florida
 * @author Summer Voeller
 */
public class FloridianToothRecords {
    /**
     * Global Scanner object to use keyboard
     */
    private static final Scanner keyboard = new Scanner(System.in);

    //Global variables
    /**
     * There is a max of 6 family members
     * There is a max of 8 teeth per row
     */
    private static final int MAX_TEETH = 8;
    private static final int MAX_FAMILY_MEMBERS = 6;

    public static void main(String[] args) {
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        int familyNum = getFamilyInfo();
        String[] memberName = new String[familyNum];
        char[][][] toothType = new char[familyNum][2][MAX_TEETH];
        getFamilyMemberData(familyNum, memberName, toothType);
        char menuChoice;
        do {
            displayMenuOptions();
            menuChoice = keyboard.next().toUpperCase().charAt(0);
            doUserChoice(familyNum, memberName, toothType, menuChoice);
        } while (menuChoice != 'X');
        System.out.println("Exiting the Floridian Tooth Records :-)");
    }

    /**
     * Asks the user to enter the number of family members
     * @return The number of family members.
     */
    private static int getFamilyInfo() {
        int numberOfFamilyMembers;
        System.out.print("Please enter number of people in the family : ");
        do {
            numberOfFamilyMembers = keyboard.nextInt();
            if (numberOfFamilyMembers < 1 || numberOfFamilyMembers > MAX_FAMILY_MEMBERS) {
                System.out.print("Invalid number of people, try again         : ");
            }
        } while (numberOfFamilyMembers < 1 || numberOfFamilyMembers > MAX_FAMILY_MEMBERS);
        return numberOfFamilyMembers;
    }

    /**
     * Gets the name, upper teeth, and lower teeth data for each member.
     * @param familyNumber  The number of family members.
     * @param familyMemberName The array to store family member names.
     * @param toothType  The 3D array to store tooth data.
     */
    private static void getFamilyMemberData(int familyNumber, String[] familyMemberName, char[][][] toothType) {
        int famIndex;
        for (famIndex = 0; famIndex < familyNumber; famIndex++) {
            System.out.print("Please enter the name for family member " + (famIndex + 1) + "   : ");
            familyMemberName[famIndex] = keyboard.next();
            toothType[famIndex][0] = getTeethInformation(familyMemberName[famIndex], "uppers");
            toothType[famIndex][1] = getTeethInformation(familyMemberName[famIndex], "lowers");
        }
    }

    /**
     * Gets the teeth data uppers or lowers
     * @param memberName The name of the family member.
     * @param upperOrLower "uppers" or "lowers".
     * @return The array of characters representing the teeth data.
     */
    private static char[] getTeethInformation(String memberName, String upperOrLower) {
        String teethString;
        System.out.print("Please enter the " + upperOrLower + " for " + memberName + " : ");
        do {
            teethString = keyboard.next().toUpperCase();
            if (teethString.length() > MAX_TEETH) {
                System.out.print("Too many teeth, try again : ");
            } else if (!isValidTeethString(teethString)) {
                System.out.print("Invalid teeth types, try again : ");
            }
        } while (teethString.length() > MAX_TEETH || !isValidTeethString(teethString));
        return teethString.toCharArray();
    }

    /**
     * Checks if teeth input is valid
     * @param teethString The teeth string to validate.
     * @return True if the string is valid, false otherwise.
     */
    private static boolean isValidTeethString(String teethString) {
        for (char ch : teethString.toCharArray()) {
            if (ch != 'B' && ch != 'I' && ch != 'M') {
                return false;
            }
        }
        return true;
    }

    /**
     * Displays the menu options.
     */
    private static void displayMenuOptions() {
        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it :");
    }

    /**
     * @param familyNum  The number of family members.
     * @param memberName The array of family member names.
     * @param toothType  The 3D array of tooth data.
     * @param menuChoice The user's menu choice.
     */
    private static void doUserChoice(int familyNum, String[] memberName, char[][][] toothType, char menuChoice) {
        switch (menuChoice) {
            case 'P':
                printFamilyInfo(familyNum, memberName, toothType);
                break;
            case 'E':
                extractTooth(familyNum, memberName, toothType);
                break;
            case 'R':
                calculateRootCanals(familyNum, toothType);
                break;
            case 'X':
                break; // Exit
            default:
                System.out.print("Invalid menu option, try again : ");
        }
        displayMenuOptions();
    }

    /**
     * Prints the family's tooth records..
     *
     * @param familyNum  The number of family members.
     * @param memberName The array of family member names.
     * @param toothType  The 3D array of tooth data.
     */
    private static void printFamilyInfo(int familyNum, String[] memberName, char[][][] toothType) {
        int famIndex;
        int toothIndex;
        for (famIndex = 0; famIndex < familyNum; famIndex++) {
            System.out.println(memberName[famIndex]);
            System.out.print(" Uppers: ");
            for (toothIndex = 0; toothIndex < toothType[famIndex][0].length; toothIndex++) {
                System.out.printf("%3d:%c  ", toothIndex + 1, toothType[famIndex][0][toothIndex]);
            }
            System.out.println();
            System.out.print(" Lowers: ");
            for (toothIndex = 0; toothIndex < toothType[famIndex][1].length; toothIndex++) {
                System.out.printf("%3d:%c  ", toothIndex + 1, toothType[famIndex][1][toothIndex]);
            }
            System.out.println();
        }
    }

    /**
     * Checks if the tooth wanting to be extracted is present.
     *
     * @param familyNum  The number of family members.
     * @param memberName The array of family member names.
     * @param toothType  The 3D array of tooth data.
     */
    private static void extractTooth(int familyNum, String[] memberName, char[][][] toothType) {
        String memberNameInput;
        int memberInfo = 0;
        boolean found = false;
        int famIndex;
        int toothRow;
        int toothInfo;
        System.out.print("Which family member: ");
        memberNameInput = keyboard.next();
        do {
            for (famIndex = 0; famIndex < familyNum; famIndex++) {
                if (memberNameInput.equalsIgnoreCase(memberName[famIndex])) {
                    found = true;
                    memberInfo = famIndex;
                }
            }
            if (!found) {
                System.out.print("Invalid family member, try again :");
                memberNameInput = keyboard.next();
            }
        } while (!found);
        toothRow = getToothLayer();
        toothInfo = getToothNumber(toothType, memberInfo, toothRow);
        toothType[memberInfo][toothRow][toothInfo - 1] = 'M';
    }

    /**
     * Gets the tooth layer (upper or lower) from the user.
     *
     * @return 0 for uppers, 1 for lowers.
     */
    private static int getToothLayer() {
        char toothJaw;
        int toothRow = 0;
        boolean correctUL = false;
        do {
            System.out.print(" Which tooth layer (U)pper or (L)ower: ");
            toothJaw = keyboard.next().toUpperCase().charAt(0);
            switch (toothJaw) {
                case 'U':
                    correctUL = true;
                    toothRow = 0;
                    break;
                case 'L':
                    correctUL = true;
                    toothRow = 1;
                    break;
                default:
                    System.out.print("Invalid layer, try again : ");
            }
        } while (!correctUL);
        return toothRow;
    }

    /**
     * Gets the tooth number and checks if it exists.
     *
     * @param toothType The 3D array of tooth data.
     * @param memberInfo The index of the family member.
     * @param toothRow The row (upper or lower).
     * @return The valid tooth number.
     */
    private static int getToothNumber(char[][][] toothType, int memberInfo, int toothRow) {
        int toothInfo;
        do {
            System.out.print("Which tooth number : ");
            toothInfo = keyboard.nextInt();
            if (toothInfo > toothType[memberInfo][toothRow].length || toothInfo <= 0 || toothType[memberInfo][toothRow][toothInfo - 1] == 'M') {
                if (toothInfo > toothType[memberInfo][toothRow].length || toothInfo <= 0) {
                    System.out.print("Invalid tooth number, try again : ");
                } else if (toothType[memberInfo][toothRow][toothInfo - 1] == 'M') {
                    System.out.print("Missing tooth, try again : ");
                }
            }
        } while (toothInfo > toothType[memberInfo][toothRow].length || toothInfo <= 0 || toothType[memberInfo][toothRow][toothInfo - 1] == 'M');
        return toothInfo;
    }

    /**
     * Calculates the root canals based on the family's data.
     *
     * @param familyNumber The number of family members.
     * @param toothType The 3D array of tooth data.
     */
    private static void calculateRootCanals(int familyNumber, char[][][] toothType) {
        double a;
        double b;
        double c;
        double root1, root2;
        double discriminant;
        double sumI = 0.0;
        double sumB = 0.0;
        double sumM = 0.0;
        int toothIndex;
        int fam_index;
        int row;
        // Count the total number of each tooth type the family has
        for (fam_index = 0; fam_index < familyNumber; fam_index++) {
            for (row = 0; row < 2; row++) {
                for (toothIndex = 0; toothIndex < toothType[fam_index][row].length; toothIndex++) {
                    switch (toothType[fam_index][row][toothIndex]) {
                        case 'I':
                            sumI += 1;
                            break;
                        case 'B':
                            sumB += 1;
                            break;
                        case 'M':
                            sumM += 1;
                            break;
                    }
                }
            }
        }
        // Use the sum of each tooth and the quadratic formula to calculate the roots.
        a = sumI;
        b = sumB;
        // Corrected variable name: sumI for incisors
        c = -1 * sumM;
        discriminant = b * b - 4.0 * a * c;
        if (discriminant >= 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
            // Print the roots
            System.out.printf("Root canals: %.2f, %.2f\n", root1, root2);
        } else {
            System.out.println(" No real roots");
        }
    }// end of calculateRootCanals method
} // end of FloridianToothRecords class