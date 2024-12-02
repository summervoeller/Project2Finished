import java.io.Serializable;

/**
 * Represents a boat in the fleet management system
 * @author Summer Voeller
 */

public class Boat implements Serializable {
    private BoatType type;
    private String name;
    private short year;
    private String makeModel;
    private byte length;
    private double purchasePrice;
    private double expenses;

    /**
     * Creates a new Boat
     * @param type The type of boat
     * @param name The name of boat
     * @param year Year of manufacture
     * @param makeModel Make and model of boat
     * @param length Length in ft
     * @param purchasePrice Purchase price
     */

    public Boat(BoatType type, String name, short year, String makeModel,
                byte length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.year = year;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = 0.0;
    } //end of constructor method


    /**
     * Adds an expense to the boat if within budget
     * @param amount Amount to add to expenses
     * @return true if expense was added, false if over budget
     */

    public boolean addExpense(double amount) {
        if (expenses + amount <= purchasePrice) {
            expenses += amount;
            return true;
        }
        return false;
    } //end of addExpense method


    /**
     * Gets remaining budget for expenses
     * @return Amount left to spend on boat
     */

    public double getRemainingBudget() {
        return purchasePrice - expenses;
    } //end of getRemainingBudget method



    /**
     * Gets boat's name
     * @return Name of the boat
     */

    public String getName() {
        return name;
    } //end of getName method



    /**
     * Gets the purchase price
     * @return Original purchase price
     */

    public double getPurchasePrice() {
        return purchasePrice;
    } //end of getPurchasePrice method



    /**
     * Gets total expenses
     * @return Total maintenance expenses
     */

    public double getExpenses() {
        return expenses;
    } //end of getExpenses method



    /**
     * Returns string representation of boat
     * @return boat information
     */

    public String toString() {
        return String.format("%-8s%-20s%4d %-12s%3d' : Paid $ %8.2f : Spent $ %8.2f",
                type, name, year, makeModel, length, purchasePrice, expenses);
    } //end of toString method


} //end of Boat class