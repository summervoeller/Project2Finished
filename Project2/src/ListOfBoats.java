import java.io.Serializable;
import java.util.ArrayList;

/**
 * Manages a collection of boats in the fleet
 * @author Summer Voeller
 */


public class ListOfBoats implements Serializable {
    private ArrayList<Boat> boats;  // list to store all boats


    /**
     * Creates a new empty list of boats
     */

    public ListOfBoats() {
        boats = new ArrayList<Boat>();
    } //end of constructor method



    /**
     * Adds a boat to the fleet
     * @param boat The boat to add
     */
    public void addBoat(Boat boat) {
        boats.add(boat);
    } //end of addBoat method



    /**
     * Removes a boat from the fleet by name
     * @param name Name of boat to remove
     * @return true if boat was removed, false if not found
     */

    public boolean removeBoat(String name) {
        for (int i = 0; i < boats.size(); i++) {
            if (boats.get(i).getName().replaceAll("\\s+", "")
                    .equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                boats.remove(i);
                return true;
            }
        }
        return false;
    } //end of removeBoat method


    /**
     * Finds a boat by name
     * @param name Name of boat to find
     * @return The found boat or null if not found
     */

    public Boat findBoat(String name) {
        for (Boat boat : boats) {
            if (boat.getName().replaceAll("\\s+", "")
                    .equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                return boat;
            }
        }
        return null;
    } //end of findBoat method


    /**
     * Calculates total paid for all boats
     * @return Sum of purchase prices
     */

    public double getTotalPaid() {
        double total = 0;
        for (Boat boat : boats) {
            total += boat.getPurchasePrice();
        }
        return total;
    } //end of getTotalPaid method



    /**
     * Calculates total spent on all boats
     * @return Sum of all expenses
     */
    public double getTotalSpent() {
        double total = 0;
        for (Boat boat : boats) {
            total += boat.getExpenses();
        }
        return total;
    } //end of getTotalSpent method



    /**
     * Returns formatted fleet report
     * @return Formatted string with all boats and totals
     */

    public String toString() {
        String report = "Fleet report:\n";
        for (Boat boat : boats) {
            report += "    " + boat.toString() + "\n";
        }
        report += String.format("    %-47s : Paid $ %8.2f : Spent $ %8.2f",
                "Total", getTotalPaid(), getTotalSpent());
        return report;
    } //end of toString method


} //end of ListOfBoats class