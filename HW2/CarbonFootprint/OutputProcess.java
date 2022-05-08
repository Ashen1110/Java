package classes;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class OutputProcess {
	
	//Given a number, return a string representation with thousands comma.

	public String toCommaNumber(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		return df.format(number);
	}

}
