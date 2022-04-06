public class HugeInteger {
	private static final int MAX_DIGITS = 40;

	private int sign;

	private int mostSignificantDigitIndex;

	private int[] digits = new int[MAX_DIGITS];

	public HugeInteger() {
		this("0");
	}

	public HugeInteger(String s) {
		parse(s);
	}

	public HugeInteger add(HugeInteger val) {
		HugeInteger val1 = new HugeInteger(toString());
		//System.out.println("val1: "+val1.sign);
		HugeInteger val2 = new HugeInteger(val.toString());
		//System.out.println("val2: "+val2.sign);
		HugeInteger result = new HugeInteger();

		if (val1.sign == 0 && val2.sign == -1) {
			System.out.println("OK\n");
			return val1.subtract(val2);
		}
		if (val1.sign == -1 && val2.sign == 0) {
			//System.out.println("OK\n");
			return val1.subtract(val2);
		}

		int up = 0;

		for (int i = 0; i < MAX_DIGITS; i++) {
			int number = this.getDigit(i) + val.getDigit(i) + up;

			result.setDigit(i, number % 10);
			up = number / 10;
		}

		result.findMostSignificantDigit();

		return result;
	}

	public HugeInteger subtract(HugeInteger integer) {
		HugeInteger val1 = new HugeInteger(toString());
		HugeInteger val2 = new HugeInteger(integer.toString());
		HugeInteger result = new HugeInteger();
		/*
		if(val1.sign==-1 &&  val2.sign==0){
			result = val1.add(val2);
			result.sign = -1;
			return result;
		}
		if(val1.sign==0 && val2.sign==-1){
			val2.sign = 0;
			return val1.add(val2);
		}*/

		for (int i = 0; i < MAX_DIGITS; i++) {
			int number = val1.getDigit(i) - val2.getDigit(i);

			if (number < 0) {
				int proxIndex = i + 1;

				while (val1.getDigit(proxIndex) == 0 && proxIndex < val1.mostSignificantDigitIndex)
					proxIndex++;

				if (proxIndex <= val1.mostSignificantDigitIndex) {
					val1.setDigit(proxIndex, val1.getDigit(proxIndex) - 1);

					while (--proxIndex > i)
						val1.setDigit(proxIndex, 9);

					val1.setDigit(i, val1.getDigit(i) + 10);

					number = val1.getDigit(i) - val2.getDigit(i);
				} else {
					number = val2.getDigit(i) - val1.getDigit(i);
					sign = -1;
				}
			}

			result.setDigit(i, number % 10);
		}

		result.findMostSignificantDigit();

		return result;
	}

	private void findMostSignificantDigit() {
		for (int i = MAX_DIGITS - 1; i >= 0; i--) {
			if (getDigit(i) != 0) {
				mostSignificantDigitIndex = i;
				break;
			}
		}
	}

	private void parse(String s) {
		int len = s.length();
		if (len > MAX_DIGITS) throw new IllegalArgumentException("Number must be at most 40 digits");

		if (s.charAt(0) == '-') {
			sign = -1;
			mostSignificantDigitIndex = len - 2;
		} 
		else mostSignificantDigitIndex = len - 1;

		for(int i = 0; i < len; i++){
			char digit = s.charAt(len - i - 1);
			if (Character.isDigit(digit)) digits[i] = digit - 48;
		}
	}

	private int getDigit(int index) {
		return digits[index];
	}

	private void setDigit(int index, int number) {
		digits[index] = number;
	}

	@Override
	public String toString() {
		String integer = sign < 0 ? "-" : "";
		for (int i = mostSignificantDigitIndex; i >= 0; i--) integer += digits[i];

		return integer;
	}
	
	public static void main(String[] args) {
		HugeInteger integer1 = new HugeInteger("12345");
		HugeInteger integer2 = new HugeInteger("-1225");

		System.out.printf("%s + %s = %s%n", integer1, integer2, integer1.add(integer2));
		System.out.printf("%s - %s = %s%n", integer1, integer2, integer1.subtract(integer2));
	}

}
