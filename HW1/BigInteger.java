import java.util.*;
import static java.lang.System.out;

public class BigInteger{
	private List<Integer> bignum;
	public BigInteger(String num){
		//取數字
		String n = num.charAt(0) == '-' ? num.substring(1) : num;
		bignum = new ArrayList<>();
		int n_len = n.length();
		//每4個字一個int
		for(int i=n_len-4; i>-4; i-=4){
			bignum.add(Integer.parseInt(n.substring(i>=0 ? i : 0,i+4)));
		}
		
		//補位
		int bignum_len = (bignum.size()/8 +1)*8;
		for(int i=bignum.size(); i<bignum_len; i++){
			bignum.add(0);
		}
		//負數轉補數
		bignum = num.charAt(0)=='-' ? toComplement(bignum) : bignum;
	}
	
	
	private BigInteger(List<Integer>bignum){
		this.bignum = bignum;
	}
	
	public BigInteger addition(BigInteger that, boolean k){
		if(isNegative(that.bignum)){
			return subtract(new BigInteger(toComplement(that.bignum)), k);
		}
		int len = Math.max(bignum.size(), that.bignum.size());
		List<Integer> num1 = copy(bignum, len);
		List<Integer> num2 = copy(that.bignum, len);
		List<Integer> result = new ArrayList<>();
		
		int carry = 0;
		for(int i=0; i<len-1; i++){
			int c = num1.get(i) + num2.get(i) + carry;
			if(c<10000) carry = 0;
			else{
				c -= 10000;
				carry = 1;
			}
			result.add(c);
		}
		if(carry == 1){
			if(isPositive(num1)) result.add(1);
			else result.clear();
			for(int i= 0; i<8; i++){
				result.add(0);
			}
			
		}
		else {
			int isPos = isPositive(num1) ? 0 : 9999;
			result.add(isPos);
		}
		
		return new BigInteger(result);
	}
	
	public BigInteger subtract(BigInteger that, boolean k){
		if(isNegative(that.bignum)){
			return addition(new BigInteger(toComplement(that.bignum)), k);
		}
		
		int len = Math.max(bignum.size(), that.bignum.size());
		List<Integer> num1 = copy(bignum, len);
		List<Integer> num2 = copy(that.bignum, len);
		List<Integer> result = new ArrayList<>();
		
		int borrow = 0;
		for(int i=0; i<len-1; i++){
			int b = num1.get(i) - num2.get(i) - borrow;
			if(b>-1) borrow = 0;
			else{
				b+=10000;
				borrow = 1;
			}
			result.add(b);
		}
		if(borrow==1){
			if(isNegative(num1)) result.add(9998);
			else result.clear();
			for(int i=0; i<8; i++){
				result.add(9999);
			}
		}
		else{
			int isNeg = isNegative(num1) ? 9999 : 0;
			result.add(isNeg);
		}
		
		
		if(k==true) result = toComplement(result);
		BigInteger ans = new BigInteger(result);
		return ans;
	}

	//if |integer2| > |integr1| return true
	private static boolean abs_compare(String integer1, String integer2){
		String a1 = integer1.charAt(0) == '-' ? integer1.substring(1) : integer1;
		String a2 = integer2.charAt(0) == '-' ? integer2.substring(1) : integer2;
		int a1_len = a1.length();
		int a2_len = a2.length();
		if(a1_len < a2_len) return true;
		if(a1_len == a2_len){
			for(int i=0; i<a1_len; i++){
				if(a2.charAt(i) > a1.charAt(i)) return true;
				else if(a2.charAt(i) < a1.charAt(i)) return false;
			}
		}
		return false;
	}
	
	public String toString(){
		List<Integer> num = isNegative(bignum) ? toComplement(bignum) : bignum;
		StringBuilder builder = new StringBuilder();
		int num_len = num.size();
		for(int i=num_len-1; i>-1; i--){
			builder.append(String.format("%04d", num.get(i)));
		}  
		while(builder.length()>0 && builder.charAt(0) == '0'){
			builder.deleteCharAt(0);
		}
		String k = isNegative(bignum) ? builder.insert(0, '-').toString() : builder.toString();
		return builder.length() == 0 ? "0" : k;
	}
	
	private static List<Integer> toComplement(List<Integer> num){
		List<Integer> comp = new ArrayList<>();
		for(Integer i: num){
			comp.add(9999-i);
		}
		comp.set(0, comp.get(0)+1);
		return comp;
	}
	private static List<Integer> copy(List<Integer> num, int newLength){
		List<Integer> n = new ArrayList<>(num);
		int n_len = n.size();
		for(int i=n_len; i<newLength; i++){
			n.add(isPositive(num) ? 0 : 9999);
		} 
		return n;
	}
	/*
	public boolean isGreaterThanOrEqualTo(BigInteger that){
		
	}
	
		/*
	public boolean isLessThanOrEqualTo(BigInteger that){
		
	}
	*/
	
	private static boolean isNegative(List<Integer> list){
		int last = list.get(list.size() -1 );
		return last == 9999;
	}
	
	private static boolean isPositive(List<Integer> list){
		int last = list.get(list.size()-1);
		return last==0;
	}
	
	public static void main(String[] args){
	
		/*
		BigInteger integer1 = new BigInteger("12345");
		BigInteger integer2 = new BigInteger("-1548");
		out.printf("%s + %s = %s%n", integer1, integer2, integer1.addition(integer2));
		out.printf("%s - %s = %s%n", integer1, integer2, integer1.subtract(integer2));
		*/
		Scanner inputReader = new Scanner(System.in);
		out.println("Enter first integer: ");
		String s1 = inputReader.next();
		
		out.println("Enter second integer: ");
		String s2 = inputReader.next();
		
		boolean k = abs_compare(s1, s2);
		if(k==true){
			String tmp = s1;
			s1 = s2;
			s2 = tmp;	
		}
		
		BigInteger a = new BigInteger(s1);
		BigInteger b = new BigInteger(s2);
		
		if(k==true) {
			out.println(s2 + " + " + s1 + " = " + a.addition(b,k));
			out.println(s2 + " - " + s1 + " = " + a.subtract(b, k));
		}
		else{
			out.println(s1 + " + " + s2 + " = " + a.addition(b,k));
			out.println(s1 + " - " + s2 + " = " + a.subtract(b, k));
		}
		
	}
	
}


/*
9999999999999999999999999999999999999999
10000000000000000000000000000000000000000
*/



