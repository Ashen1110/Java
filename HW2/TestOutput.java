package classes.test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class TestOutput {

	public double toFloat(int digits, double number) {
		StringBuilder format = new StringBuilder();

		format.append("#.");
		for (int i = 1; i <= digits; i++) {
			format.append("#");
		}
		// format.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat(format.toString());
		return Double.valueOf(df.format(number)).doubleValue();
	}

	public String toCommaNumber(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		return df.format(number);
	}

	public void outputIntroduction() {
		System.out.println("\nHW2: CarbonFootprint");
		System.out.println("Name: Stephanie Lin (Student ID: 408410042)");
		System.out
				.println("\nThis program creates an array of disparate objects that share an interface.");
		System.out
				.println("Then it prints out the carbon footprint for the three objects, ");
		return;
	}

}
