package classes.Cars;
import classes.*;


public class Car implements CarbonFootprint {

	private static double FOOTPRINT_PER_MILE_PER_GALLON = .08765;

	private String id;
	private double miles;
	private double milesPerGallon;

	public Car(String id, double miles, double milesPerGallon) {
		setId(id);
		setMiles(miles);
		setMilesPerGallon(milesPerGallon);
	}

	@Override
	public double getCarbonFootprint() {
		return ((FOOTPRINT_PER_MILE_PER_GALLON * getMiles()) / getMilesPerGallon());
	}

	//get parameters
	public String getId() {
		return id;
	}

	public double getMiles() {
		return miles;
	}

	public double getMilesPerGallon() {
		return milesPerGallon;
	}

	//set parameters
	public void setId(String id) {
		this.id = id;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public void setMilesPerGallon(double milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}

	//print
	public String toString() {
		OutputProcess output = new OutputProcess();
		StringBuilder string = new StringBuilder();
		string.append(getId());
		string.append("\nMiles Travelled: " + output.toCommaNumber(getMiles()));
		string.append("\nMiles per gallon: "+ output.toCommaNumber(getMilesPerGallon()));
		return string.toString();
	}

}
