import java.util.Scanner;
import java.io.*;

/**
 * Main class for managing the boat fleet system
 * Handles file operations and user interface
 * @author Summer Voeller
 */
public class BoatManagement {
    private ListOfBoats boats;
    private static final Scanner keyboard = new Scanner(System.in);
    private static final String DB_FILE = "FleetData.db";

    /**
     * Creates a boat management system
     * @param args Command line arguments (CSV filename)
     */
    public BoatManagement(String[] args) {
        if (args.length > 0) {
            boats = new ListOfBoats();
            loadFromCSV(args[0]);
        } else {
            boats = loadFromDB();
            if (boats == null) {
                boats = new ListOfBoats();
            }
        }
    } //end of constructor method

    /**
     * Loads fleet data from CSV file
     * @param filename Name of CSV file to load
     */
    private void loadFromCSV(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                parseAndAddBoat(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + filename);
        }
    } //end of loadFromCSV method

    /**
     * Parses boat data and adds boat to fleet
     * @param line String containing boat data
     */
    private void parseAndAddBoat(String line) {
        // Handle comma-separated input
        if (line.contains(",")) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                try {
                    BoatType type = BoatType.valueOf(parts[0].trim());
                    String name = parts[1].trim();
                    short year = Short.parseShort(parts[2].trim());
                    String makeModel = parts[3].trim();
                    byte length = Byte.parseByte(parts[4].trim());
                    double price = Double.parseDouble(parts[5].trim());

                    Boat newBoat = new Boat(type, name, year, makeModel, length, price);
                    boats.addBoat(newBoat);
                } catch (Exception e) {
                    System.out.println("Error parsing boat data: " + line);
                }
            }
        } else {
            // Handle space-separated input
            String[] parts = line.split(" ");
            if (parts.length >= 6) {
                try {
                    BoatType type = BoatType.valueOf(parts[0].trim());
                    String name;
                    int startIndex;
                    if (parts[2].matches("\\d+")) {
                        name = parts[1];
                        startIndex = 2;
                    } else {
                        name = parts[1] + " " + parts[2];
                        startIndex = 3;
                    }
                    short year = Short.parseShort(parts[startIndex].trim());
                    String makeModel = parts[startIndex + 1].trim();
                    byte length = Byte.parseByte(parts[startIndex + 2].trim());
                    double price = Double.parseDouble(parts[startIndex + 3].trim());

                    Boat newBoat = new Boat(type, name, year, makeModel, length, price);
                    boats.addBoat(newBoat);
                } catch (Exception e) {
                    System.out.println("Error parsing boat data: " + line);
                }
            }
        }
    } //end of parseAndAddBoat method

    /**
     * Loads fleet data from database file
     * @return ListOfBoats object or null if error
     */
    private ListOfBoats loadFromDB() {
        try {
            FileInputStream fileIn = new FileInputStream(DB_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ListOfBoats loadedBoats = (ListOfBoats) in.readObject();
            in.close();
            fileIn.close();
            return loadedBoats;
        } catch (Exception e) {
            return null;
        }
    } //end of loadFromDB method

    /**
     * Saves fleet data to database file
     */
    private void saveToDB() {
        try {
            FileOutputStream fileOut = new FileOutputStream(DB_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(boats);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error saving data to database");
        }
    } //end of saveToDB method

    /**
     * Displays menu options to user
     */
    public void displayMenu() {
        System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
    } //end of displayMenu method

    /**
     * Handles adding a new boat from user input
     */
    public void addBoat() {
        System.out.print("Please enter the new boat CSV data          : ");
        String boatData = keyboard.nextLine();
        parseAndAddBoat(boatData);
    } //end of addBoat method

    /**
     * Handles removing a boat by name
     */
    public void removeBoat() {
        System.out.print("Which boat do you want to remove?           : ");
        String name = keyboard.nextLine();
        if (!boats.removeBoat(name)) {
            System.out.println("Cannot find boat " + name);
        }
    } //end of removeBoat method

    /**
     * Handles adding expenses to a boat
     */
    public void addExpense() {
        System.out.print("Which boat do you want to spend on?         : ");
        String name = keyboard.nextLine();
        Boat boat = boats.findBoat(name);

        if (boat == null) {
            System.out.println("Cannot find boat " + name);
        } else {
            System.out.print("How much do you want to spend?              : ");
            double amount = keyboard.nextDouble();
            keyboard.nextLine(); // consume the leftover newline

            if (boat.addExpense(amount)) {
                double expenses = boat.getExpenses();
                System.out.println("Expense authorized, $" + String.format("%.2f", expenses) + " spent.");
            } else {
                double remaining = boat.getRemainingBudget();
                System.out.println("Expense not permitted, only $" + String.format("%.2f", remaining) + " left to spend.");
            }
        }
    } //end of addExpense method

    /**
     *
     *
     * Runs the main program loop
     */
    public void runProgram() {
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        char choice;
        do {
            displayMenu();
            choice = keyboard.nextLine().toUpperCase().charAt(0);

            switch(choice) {
                case 'P':
                    System.out.println(boats.toString());
                    break;
                case 'A':
                    addBoat();
                    break;
                case 'R':
                    removeBoat();
                    break;
                case 'E':
                    addExpense();
                    break;
                case 'X':
                    saveToDB();  // Save data before exiting
                    System.out.println("\nExiting the Fleet Management System");
                    break;
                default:
                    System.out.println("Invalid menu option, try again");
            }
        } while (choice != 'X');
    } //end of runProgram method

    /**
     * Main method to start the program
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        BoatManagement program = new BoatManagement(args);
        program.runProgram();
    } //end of main method
} //end of BoatManagement class