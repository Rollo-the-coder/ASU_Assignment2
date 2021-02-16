// CSE 110     : <Spring 2021>
// Assignment  : <assignment #2>
// Author      : <Erik Christian Gotta> & <1222628953>
// Description : <Code that can compute the materials and costs required for a specified road construction project>

import java.util.Scanner;

public class Assignment2 {
    
    public static void main(String[] args) {
        // Declare and instantiate a Scanner
        Scanner sc = new Scanner(System.in);

        // Declare and initialize variables
        //input variables
        double lengthRoad;
        int numberLanes;
        int depthAsphalt;
        int daysToComplete;

        //calculated variables 
        //(Materials Needed)
        double truckloadsAsphalt;
        double stoplights; 
        double coduitPipes; 
        double crewMemebers;

        //(Cost of Materials)
        double asphaltCost;
        double stoplightsCost;
        double coduitPipesCost;
        double laborCost;
        double totalCost;

        // Collect inputs
        System.out.print("Length of road project (miles)  :   ");
        lengthRoad = sc.nextDouble();

        System.out.print("Number of lanes                 :   ");
        numberLanes = sc.nextInt();
        //Forces user to enter lanes 1-8
        if (numberLanes > 8 || numberLanes < 1) {
            System.out.println("Please start over, lanes can only be numbers 1-8");
            System.exit(0);
        }

        System.out.print("Depth of asphalt (inches)       :   ");
        depthAsphalt = sc.nextInt();

        System.out.print("Days to complete project        :   ");
        daysToComplete = sc.nextInt();
        
        // Compute required values 
        //Calculations of amount of truck loads of asphalt
        //12 inches in a foot, 1 cubic foot == 150 lbs (150/12 = 12.5)
        double asphaltTonsPerInchDepth = 12.5;
        double amountTruckCarriesPounds = 10000;
        double feetPerLane = 12;
        final int feetPerMile = 5280;
        truckloadsAsphalt = (asphaltTonsPerInchDepth * depthAsphalt) * (numberLanes * feetPerLane) * (lengthRoad * feetPerMile) / amountTruckCarriesPounds;
        int roundedTruckloadsAsphalt = (int) Math.ceil(truckloadsAsphalt);

        //Calculations of the total amount of stoplights for the project
        int stoplightsAtIntersection = 2;
        stoplights = (stoplightsAtIntersection + numberLanes) * (Math.floor(lengthRoad));

        //Calculations of the total amount of conduit pipes needed
        int coduitPipeLengthFeet = 24;
        coduitPipes = (lengthRoad * feetPerMile) / coduitPipeLengthFeet;
        int roundedConduitPipes = (int) Math.ceil(coduitPipes);

        //Calculations of total crew members needed
        crewMemebers = (50 * lengthRoad * numberLanes) / daysToComplete;
        int roundedCrewMembers = (int) Math.ceil(crewMemebers);

        //Asphalt cost calculation
        double asphaltPerTon = 200;
        int asphaltTonsPerTruck = 5;
        asphaltCost = asphaltPerTon * roundedTruckloadsAsphalt * asphaltTonsPerTruck;

        //Stoplights cost calculation
        double singleStoplightCost = 25000;
        stoplightsCost = stoplights * singleStoplightCost;

        //Coduit pipes cost calculation
        double coduitSinglePipeCost = 500;
        coduitPipesCost = roundedConduitPipes * coduitSinglePipeCost;

        //Labor cost calculation
        double workingHoursPerDay = 8;
        double wagePerHour = 25;
        laborCost = daysToComplete * workingHoursPerDay * wagePerHour * roundedCrewMembers;

        //total cost calculation
        totalCost = asphaltCost + stoplightsCost + coduitPipesCost + laborCost;

        // Display results
        System.out.println("=== Amount of Materials Needed ===");
        System.out.println("Truckloads of asphalt   :   " + roundedTruckloadsAsphalt);
        System.out.println("Stoplights              :   " + (int) stoplights);
        System.out.println("Conduit pipes           :   " + roundedConduitPipes);
        System.out.println("Crew members needed     :   " + roundedCrewMembers);
        System.out.println("=== Cost of Materials ============");
        System.out.printf("Cost of asphalt         :   $%.2f", asphaltCost); 
        System.out.println();
        System.out.printf("Cost of stoplights      :   $%.2f", stoplightsCost);
        System.out.println();
        System.out.printf("Cost of coduit pipes    :   $%.2f", coduitPipesCost);
        System.out.println();
        System.out.printf("Cost of labor           :   $%.2f", laborCost);
        System.out.println();
        System.out.println("=== Total Cost of Project ========");
        System.out.printf("Total cost of project   :   $%.2f", totalCost);
        System.out.println();

        sc.close();
    }

}
