package classes.test;
import classes.*;
import classes.Bicycles.*;
import classes.Cars.*;
import classes.Buildings.*;
import java.util.ArrayList;

public class TestCarbonFootprint {

	public static void main(String[] args) {
		TestOutput service = new TestOutput();
		ArrayList<CarbonFootprint> footprintItems = new ArrayList<CarbonFootprint>();
		double totalFootprint = 0;

		// Print out an introduction.
		service.outputIntroduction();

		// Create list of different objects that implement the
		// CarbonFootprint interface.
		try {
			footprintItems.add(new Building("Building", 2, 100, 100, 100, 100, 100, 100, 0));
			footprintItems.add(new Car("Car", 10000, 25));
			footprintItems.add(new Bicycle("Bicycle", 1000, Bicycle.PowerSource.CHEESEBURGERS));

			// Loop through all items and print out the information.
			for (CarbonFootprint item : footprintItems) {
				double footprint = item.getCarbonFootprint();
				totalFootprint += footprint;
				System.out.println("\nItem: " + item.toString());

				System.out.println("\tCarbon footprint: "
						+ service.toCommaNumber(service.toFloat(2, footprint))
						+ " Metric Tons of CO2");
			}

			System.out.println("\nTotal carbon footprint for this session: "
					+ service.toFloat(2, totalFootprint)
					+ " Metric Tons of CO2");
		} catch (Exception exception) {
			System.out.println("Error computing the carbon footprint.");
		}
	}
}
