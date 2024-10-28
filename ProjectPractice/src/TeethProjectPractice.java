// CHAT GPT VERSION


import java.util.Scanner; //YES

public class TeethProjectPractice { //YES

    private static final Scanner scanner = new Scanner(System.in); //YES


    private static final int MAX_FAMILY_MEMBERS = 6;//YES
    private static final int MAX_TEETH = 8;//YES



    public static void main(String[] args) {

        String[] namesOfFamilyMembers = new String[MAX_FAMILY_MEMBERS]; // OUR 1D STRING ARRAY FOR FAMILY MEMBERS
        char[][][] teethInfo = new char[MAX_FAMILY_MEMBERS][2][MAX_TEETH];
        int numFamilyMembers;

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        numFamilyMembers = getFamilySize();
        inputTeethInfo(namesOfFamilyMembers, teethInfo, numFamilyMembers);
        processMenuOptions(namesOfFamilyMembers, teethInfo, numFamilyMembers);

        scanner.close();
    } // End of main method



    // Start of getFamilySize method
    private static int getFamilySize() {
        int size;


        do {
            System.out.print("Please enter number of people in the family : ");
            size = scanner.nextInt();
            if (size <= 0 || size > MAX_FAMILY_MEMBERS) {
                System.out.print("Invalid number of people, try again         : ");
            }
        } while (size <= 0 || size > MAX_FAMILY_MEMBERS);
        // End of do-while loop

        scanner.nextLine();
        return size;
    } // End of getFamilySize method


    // Start of inputFamilyData method
    private static void inputTeethInfo(String[] names, char[][][] teethRecords, int numFamilyMembers) {
        // Start of for loop
        for (int i = 0; i < numFamilyMembers; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + "   : ");
            names[i] = scanner.nextLine();
            inputTeeth(teethRecords[i][0], "uppers", names[i]);
            inputTeeth(teethRecords[i][1], "lowers", names[i]);
        } // End of for loop
    } // End of inputFamilyData method



    // Start of inputTeeth method
    private static void inputTeeth(char[] teeth, String jawType, String name) {
        String teethInput;

        do {
            System.out.print("Please enter the " + jawType + " for " + name + "       : ");
            teethInput = scanner.nextLine().toUpperCase();
            if (!isValidTeeth(teethInput)) {
                System.out.print("Invalid teeth types, try again              : ");
            } else if (teethInput.length() > MAX_TEETH) {
                System.out.print("Too many teeth, try again                   : ");
            }
        } while (!isValidTeeth(teethInput) || teethInput.length() > MAX_TEETH);
        // End of do-while loop

        System.arraycopy(teethInput.toCharArray(), 0, teeth, 0, teethInput.length());
    } // End of inputTeeth method



    // Start of isValidTeeth method
    private static boolean isValidTeeth(String teeth) {
        return teeth.matches("[IBM]+");
    } // End of isValidTeeth method



    // Start of processMenuOptions method
    private static void processMenuOptions(String[] names, char[][][] teethRecords, int numFamilyMembers) {
        char choice;

        do {
            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            choice = scanner.nextLine().toUpperCase().charAt(0);
            switch (choice) {
                case 'P':
                    printTeethRecords(names, teethRecords, numFamilyMembers);
                    break;
                case 'E':
                    extractTooth(names, teethRecords, numFamilyMembers);
                    break;
                case 'R':
                    calculateRootCanalIndices(names, teethRecords, numFamilyMembers);
                    break;
                case 'X':
                    System.out.println("\nExiting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.print("Invalid menu option, try again              : ");
            }
        } while (choice != 'X');
        // End of do-while loop
    } // End of processMenuOptions method




    // Start of printTeethRecords method
    private static void printTeethRecords(String[] names, char[][][] teethRecords, int numFamilyMembers) {
        // Start of for loop
        for (int i = 0; i < numFamilyMembers; i++) {
            System.out.println("\n" + names[i]);
            System.out.println("  Uppers: " + formatTeeth(teethRecords[i][0]));
            System.out.println("  Lowers: " + formatTeeth(teethRecords[i][1]));
        } // End of for loop
    } // End of printTeethRecords method




    // Start of extractTooth method
    private static void extractTooth(String[] names, char[][][] teethRecords, int numFamilyMembers) {
        System.out.print("Which family member                         : ");
        String familyMember = scanner.nextLine();
        int index = findFamilyMemberIndex(names, familyMember, numFamilyMembers);

        if (index == -1) {
            System.out.println("Invalid family member, try again            : ");
            return;
        }

        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        char layer = scanner.nextLine().toUpperCase().charAt(0);

        if (layer != 'U' && layer != 'L') {
            System.out.println("Invalid layer, try again                    : ");
            return;
        }

        System.out.print("Which tooth number                          : ");
        int toothNumber = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (toothNumber < 0 || toothNumber >= MAX_TEETH) {
            System.out.println("Invalid tooth number, try again             : ");
            return;
        }

        int rowIndex = (layer == 'U') ? 0 : 1;
        if (teethRecords[index][rowIndex][toothNumber] == 'M') {
            System.out.println("Missing tooth, try again                    : ");
        } else if (teethRecords[index][rowIndex][toothNumber] == '\0') {
            System.out.println("No tooth present, try again                 : ");
        } else {
            teethRecords[index][rowIndex][toothNumber] = 'M';
            System.out.println("Tooth extracted successfully.");
        }
    } // End of extractTooth method




    // Start of calculateRootCanalIndices method
    private static void calculateRootCanalIndices(String[] names, char[][][] teethRecords, int numFamilyMembers) {
        int I = 0, B = 0, M = 0;
        // Start of for loop
        for (int i = 0; i < numFamilyMembers; i++) {
            I += countTeeth(teethRecords[i], 'I');
            B += countTeeth(teethRecords[i], 'B');
            M += countTeeth(teethRecords[i], 'M');
        } // End of for loop

        double discriminant = B * B + 4 * I * M;
        if (discriminant < 0) {
            System.out.println("No real roots found.");
        } else {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * I);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * I);
            System.out.printf("One root canal at     %.2f\n", root1);
            System.out.printf("Another root canal at %.2f\n", root2);
        }
    } // End of calculateRootCanalIndices method




    // Start of countTeeth method
    private static int countTeeth(char[][] teeth, char type) {
        int count = 0;
        // Start of outer for loop
        for (int i = 0; i < 2; i++) {
            // Start of inner for loop
            for (int j = 0; j < MAX_TEETH; j++) {
                if (teeth[i][j] == type) {
                    count++;
                }
            } // End of inner for loop
        } // End of outer for loop
        return count;
    } // End of countTeeth method




    // Start of findFamilyMemberIndex method
    private static int findFamilyMemberIndex(String[] names, String familyMember, int numFamilyMembers) {
        // Start of for loop
        for (int i = 0; i < numFamilyMembers; i++) {
            if (names[i].equalsIgnoreCase(familyMember)) {
                return i;
            }
        } // End of for loop
        return -1;
    } // End of findFamilyMemberIndex method




    // Start of formatTeeth method
    private static String formatTeeth(char[] teeth) {
        StringBuilder formatted = new StringBuilder();
        // Start of for loop
        for (int i = 0; i < MAX_TEETH; i++) {
            if (teeth[i] != '\0') {
                formatted.append(i + 1).append(":").append(teeth[i]).append("  ");
            }
        } // End of for loop
        return formatted.toString().trim();
    } // End of formatTeeth method

} // End of FloridianToothRecords class