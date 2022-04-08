import java.util.*;
import static java.lang.System.out;

public class HugeInteger{
	private List<Integer> bignum;
	public HugeInteger(String num){
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
	
	
	private HugeInteger(List<Integer>bignum){
		this.bignum = bignum;
	}
	
	public HugeInteger addition(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		if(isPositive(bignum) && isNegative(that.bignum)){
			return subtract(new HugeInteger(toComplement(that.bignum)), s2_abs_s1, subtract_flag);
		}
		
		int len = Math.max(bignum.size(), that.bignum.size());
		List<Integer> num1 = copy(bignum, len);
		List<Integer> num2 = copy(that.bignum, len);
		List<Integer> result = new ArrayList<>();
		
		if(isNegative(bignum) && isNegative(that.bignum)){
			num1 = toComplement(num1);
			num2 = toComplement(num2);
			subtract_flag = true;
		}
		
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
		
		if(subtract_flag==true) result = toComplement(result);
		return new HugeInteger(result);
	}
	
	public HugeInteger subtract(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		if(isNegative(bignum) && isPositive(that.bignum)){
			HugeInteger new_bignum = new HugeInteger(toComplement(bignum));
			if (s2_abs_s1==false) subtract_flag = true;
			return new_bignum.addition(that, s2_abs_s1, subtract_flag);
		}
		
		int len = Math.max(bignum.size(), that.bignum.size());
		List<Integer> num1 = copy(bignum, len);
		List<Integer> num2 = copy(that.bignum, len);
		List<Integer> result = new ArrayList<>();
		
		if(isNegative(bignum) && isNegative(that.bignum)){
			HugeInteger new_bignum = new HugeInteger(toComplement(num2));
			if(s2_abs_s1==true)subtract_flag = true;
			return addition(new_bignum, s2_abs_s1, subtract_flag);
		}
		
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
		
		//out.println("result: " + result);
		if(s2_abs_s1==true) result = toComplement(result);
		return new HugeInteger(result);
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
	
	public boolean isEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		HugeInteger dif = subtract(that, s2_abs_s1, subtract_flag);
		String s = dif.toString();
		if(s=="0") return true;
		else return false;
	}
	
	public boolean isNotEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		HugeInteger dif = subtract(that, s2_abs_s1, subtract_flag);
		String s = dif.toString();
		if(s=="0") return false;
		else return true;
	}
	public boolean isGreaterThan(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		HugeInteger dif = subtract(that, s2_abs_s1, subtract_flag);
		String s = dif.toString();
		if(s.charAt(0) =='-') return false;
		else return true;
	}
	
	public boolean isLessThan(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		HugeInteger dif = subtract(that, s2_abs_s1, subtract_flag);
		String s = dif.toString();
		if(s.charAt(0) =='-') return true;
		else return false;
	}
	
	
	public boolean isGreaterThanOrEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		boolean cmp = isLessThan(that, s2_abs_s1, subtract_flag);
		if(cmp==false) return true;
		else return false;
		
	}
	

	public boolean isLessThanOrEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag){
		boolean less = isLessThan(that, s2_abs_s1, subtract_flag);
		boolean equal = isEqualTo(that, s2_abs_s1, subtract_flag);
		if(less==true || equal==true) return true;
		else return false;
	}

	
	public static boolean isZero(List<Integer> list){
		if(list.get(0)==0) return true;
		else return false;
	}
		
	private static boolean isNegative(List<Integer> list){
		int last = list.get(list.size() -1 );
		return last == 9999;
	}
	
	private static boolean isPositive(List<Integer> list){
		int last = list.get(list.size()-1);
		return last==0;
	}
	
	public static void main(String[] args){
	
		Scanner inputReader = new Scanner(System.in);
		out.println("Enter first integer: ");
		String s1 = inputReader.next();
		
		out.println("Enter second integer: ");
		String s2 = inputReader.next();
		
		boolean s2_abs_s1 = abs_compare(s1, s2);
		if(s2_abs_s1==true){
			String tmp = s1;
			s1 = s2;
			s2 = tmp;	
		}
		
		
		HugeInteger a = new HugeInteger(s1);
		HugeInteger b = new HugeInteger(s2);
		
		boolean subtract_flag = false;
		
		boolean is_equal = a.isEqualTo(b, s2_abs_s1, subtract_flag);
		out.println("Is the first integer equal to the second?\t" + is_equal);
		boolean cmp1 = a.isGreaterThanOrEqualTo(b, s2_abs_s1, subtract_flag);
		out.println("Is the first integer greater than or equal to the second?\t" + cmp1);
		boolean cmp2 = a.isLessThanOrEqualTo(b, s2_abs_s1, subtract_flag);
		out.println("Is the first integer less than or equal to the second?\t" + cmp2);

		
		if(s2_abs_s1==true) {
			boolean iszero = isZero(b.bignum);
			out.println("Is the first integer equal to zero?\t" + iszero);
			
			out.println(s2 + " + " + s1 + " = " + a.addition(b,s2_abs_s1, subtract_flag));
			out.println(s2 + " - " + s1 + " = " + a.subtract(b, s2_abs_s1, subtract_flag));
		}
		else{
			boolean iszero = isZero(a.bignum);
			out.println("Is the first integer equal to zero?\t" + iszero);
			out.println(s1 + " + " + s2 + " = " + a.addition(b,s2_abs_s1,subtract_flag));
			out.println(s1 + " - " + s2 + " = " + a.subtract(b, s2_abs_s1,subtract_flag));
		}
		
	}
	
}

