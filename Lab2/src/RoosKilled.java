import java.util.Scanner;
//=============================================================================
public class RoosKilled {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //Constants
    private static final double PROBABILITY_CONSTANT =1.47;
    private static final double AVG_ROAD_WIDTH_KM =0.01;

    //INPUTS
    public static void main(String[] args) {

//----Variables to hold system values
        double sideOfSquare, roadLength;
        int numRoos;
        double areaOfSquare;
        double rooDensity;
        double roadSurfaceArea;
        double expectedKills;
        int roosKilled;
        int injuries;


//----Gather data
        System.out.print("Enter side of square in km  : ");
        sideOfSquare = keyboard.nextDouble();

        System.out.print("Enter road length in km     : ");
        roadLength = keyboard.nextDouble();

        System.out.print("Enter number of 'roos: ");
        numRoos = keyboard.nextInt();

//----Calculations
        areaOfSquare = sideOfSquare * sideOfSquare;
        rooDensity = numRoos / areaOfSquare;
        roadSurfaceArea = AVG_ROAD_WIDTH_KM * roadLength;

        expectedKills = rooDensity * roadSurfaceArea * PROBABILITY_CONSTANT;
        roosKilled = (int)expectedKills;
        injuries = (expectedKills - roosKilled)==0?0:1;





//----Display results
        System.out.println("Expected number of kills is " + roosKilled  );
        System.out.println("Expected number of injuries is " + injuries  );
    } // end of main method
} // end of class GasLaw
// -----------------------------------------------------------------------------
//==
