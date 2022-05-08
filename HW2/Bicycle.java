package classes.Bicycles;

import classes.*;

/*
65g CO2e: powered by bananas
90g CO2e: powered by cereals with milk
200g CO2e: powered by bacon
260g CO2e: powered by cheeseburgers
2800g CO2e: powered by air-freighted asparagus

source: http://www.guardian.co.uk/environment/2010/jun/08/carbon-footprint-cycling
*/

public class Bicycle implements CarbonFootprint {

	private static double FOOTPRINT_PER_MILE_AVERAGE = 50;
	private static double FOOTPRINT_PER_MILE_BY_BANANAS = 65;
	private static double FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK = 90;
	private static double FOOTPRINT_PER_MILE_BY_BACON = 200;
	private static double FOOTPRINT_PER_MILE_BY_CHEESEBURGERS = 260;
	private static double FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS = 2800;

	private static double GRAM_TO_METRIC_TON_MULTIPLIER = .000001;


	public enum PowerSource {
		AVERAGE_PERSON {
			public String toString() {
				return "Average Person";
			}
		},
		AIR_FREIGHTED_ASPARAGUS {
			public String toString() {
				return "Air-Freighted Asparagus";
			}
		},
		BACON {
			public String toString() {
				return "Bacon";
			}
		},
		BANANAS {
			public String toString() {
				return "Bananas";
			}
		},
		CEREAL_WITH_MILK {
			public String toString() {
				return "Cereal with milk";
			}
		},
		CHEESEBURGERS {
			public String toString() {
				return "Cheeseburgers";
			}
		};
	}

	private String id;
	private double miles;
	private Bicycle.PowerSource powerSource;

	/*
	 Constructor to create the Bicycle object. 
	 * id: The ID of the Bicycle
	 * miles: Number of miles traveled
	 * powerSource: The power source used
	 */
	
	public Bicycle(String id, double miles, Bicycle.PowerSource powerSource) {
		setId(id);
		setMiles(miles);
		setPowerSource(powerSource);
	}

	/*
	 * Method to return the carbon footprint for a Bicycle.
	 */
	 
	@Override
	public double getCarbonFootprint() {
		double footprint = 0;
		switch (getPowerSource()) {
		case AIR_FREIGHTED_ASPARAGUS:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS;
		case BACON:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BACON;
		case BANANAS:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BANANAS;
		case CEREAL_WITH_MILK:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK;
		case CHEESEBURGERS:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CHEESEBURGERS;
		default:
			footprint = getMiles() * FOOTPRINT_PER_MILE_AVERAGE;
		}

		// Convert final footprint to metric tons.
		return footprint * GRAM_TO_METRIC_TON_MULTIPLIER;
	}

	// get parameters
	public String getId() {
		return id;
	}

	public double getMiles() {
		return miles;
	}

	public Bicycle.PowerSource getPowerSource() {
		return powerSource;
	}


	//set parameters
	public void setId(String id) {
		this.id = id;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public void setPowerSource(Bicycle.PowerSource powerSource) {
		this.powerSource = powerSource;
	}

	public String toString() {
		OutputProcess output = new OutputProcess();
		StringBuilder string = new StringBuilder();
		string.append(getId());
		string.append("\nMiles Traveled: " + output.toCommaNumber(getMiles()));
		string.append("\nPowered by: " + getPowerSource().toString());
		return string.toString();
	}
}
