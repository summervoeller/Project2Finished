import java.util.Scanner;
//=============================================================================
public class GeoffsTaxes {

    //Final Constants that dont change
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double HIGH_TAX_RATE = 0.25;
    private static final double MEDIUM_TAX_RATE = 0.10;
    private static final double LOW_TAX_RATE = 0.03;
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH =200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;


    //Start of Main method
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double income = 0.0;
        double deduction = 0.0;
        double incomeOrDeduction;
        double taxableIncome;
        char taxGroup;
        double taxOwed;



        do {

            System.out.print("Enter next amount : ");       // 1.1.1 Prompt user
            incomeOrDeduction = keyboard.nextDouble();                 // 1.1.2 Input value

            if (incomeOrDeduction > 0) {                               // 1.1.3 If positive
                income += incomeOrDeduction;                           // 1.1.3.1 Add to income

            }else {
                if (incomeOrDeduction < 0) {                          // 1.1.4 If negative
                    deduction += Math.abs(incomeOrDeduction);              // 1.1.4.1 Add (absolute) to deduction
                }
            }

            } while (incomeOrDeduction != 0) ;                              // 1.1 Repeatedly until 0.0 is entered

        taxableIncome = computeTaxableIncome(income,deduction);
        taxGroup = computeTaxGroup(taxableIncome);
        taxOwed = computeTax(taxableIncome,taxGroup);
        displayTaxInfo(income, deduction, taxableIncome,taxGroup, taxOwed);


    } //End of Main


    //Compute Taxable Income 1st Method
    public static double computeTaxableIncome(double income, double deduction) {
        double taxableIncome;
        if (income >= deduction) {                 //2.1 If income >= deduction then taxable is income - deduction, else
            taxableIncome = income - deduction;
        } else {
            taxableIncome = 0.0;                   //2.2 Taxable is 0.0
        }
        return taxableIncome;
    }


    //Compute Tax Group 2nd Method
    public static char computeTaxGroup( double taxableIncome) {
        if (taxableIncome >= STINKING_RICH) {                  //3.1 If taxable >= 500000
            return 'S';                                 //3.1.1 Group is S, else
        } else if (taxableIncome >= QUITE_RICH) {           //3.2 If taxable >= 200000
            return 'Q';                                 // 3.2.1 Group is Q, else
        } else if (taxableIncome >= MIAMI_POOR) {           //3.3 If taxable >= 100000
            return 'M';                                 //3.3.1 Group is M, else
        } else if (taxableIncome >= AVERAGE) {            //3.4 If taxable >= 50000
            return 'A';                                 //3.4.1 Group is A, else
        } else if (taxableIncome >= REALISTIC) {            //3.5 If taxable >= 20000
            return 'R';                                 //3.5.1 Group is R, else
        } else {
            return 'P';                                 //3.6 Group is P
        }
    }


    //Compute Tax 3rd Method
    private static double computeTax(double taxableIncome, char taxGroup) {
        switch (taxGroup) {                             //4.1 Depending on the group
            case 'S':                                   //4.1.1 For S and Q
            case 'Q':
                return taxableIncome * HIGH_TAX_RATE;   //4.1.1.1 Tax is 25% of taxable
            case 'M':                                   // 4.1.2 For M
                return taxableIncome * MEDIUM_TAX_RATE;  // 4.1.2.1 Tax is 10% of taxable
            case 'A':                                   //4.1.3 For A and R
            case 'R':
                return taxableIncome * LOW_TAX_RATE;    //4.1.3.1 Tax is 3% of taxable
            case 'P':                                   //4.1.4 For P
                return 0.0;                             //4.1.4.1 Tax is 0.0
            default:  //break statement                 //4.1.5 For other groups
                System.out.println("Error!");           //4.1.5.1 Error!
                return 0.0;
        }
    }


    //Display Tax Info 4th Method
    private static void displayTaxInfo(double income, double deduction, double taxableIncome, char taxGroup, double taxOwed) {
        System.out.println("Income          = $"      + income);                      //5.1 Display income
        System.out.println("Deductions      = $" + deduction);               //5.2 Display deduction
        System.out.println("Taxable income  = $" + taxableIncome);       //5.3 Display taxable
        System.out.println("Tax group       = " + taxGroup);                      //5.4 Display group
        System.out.println("Tax owed        = $" + taxOwed);                   //5.5 Display tax
    }
} // End of the Class