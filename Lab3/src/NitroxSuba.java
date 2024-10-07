import java.util.Scanner;
//=============================================================================
public class NitroxSuba {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);

    //STATIC VARIABLES
    private static final double FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;

    //INPUTS
    public static void main(String[] args) {

        System.out.print("Enter dive depth in feet: ");
        int depth = keyboard.nextInt();
        System.out.print("Enter percentage oxygen in gas: ");
        int oxygenPercentage = keyboard.nextInt();
        // COMPUTING PPO2

        double ambientPressure;
        double oxygenPressure;


        ambientPressure = (depth/ FEET_PER_ATMOSPHERE) + 1;
        oxygenPressure = ambientPressure * oxygenPercentage / 100;
        // DISPLAYING WARNINGS

        char opgGroup;
         opgGroup = (char)((int)(oxygenPressure * 10) + (int)'A');

        // EXCEEDS?

        boolean exceedsMaximal;
        exceedsMaximal = oxygenPressure > MAX_O2_PRESSURE;

        boolean exceedsContingency;
        exceedsContingency = oxygenPressure > CONTINGENCY_O2_PRESSURE;


        // Display results

        System.out.println("Ambient Pressure : " + ambientPressure);
        System.out.println("O2 pressure : " + oxygenPressure);
        System.out.println("O2 group : " + opgGroup);
        System.out.println("Exceeds maximal O2 pressure : " + exceedsMaximal);
        System.out.println("Exceeds contingency O2 pressure : " + exceedsContingency);


    }


//---------------------------------------------------------------------------

} // end of NitroxScuba class
