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
	
	public BigInteger addition(BigInteger that){
		/*
		if(isNegative(that.bignum)){
			return subtract(new BigInteger(toComplement(that.bignum)));
		}
		*/
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
			//out.println("result = " + result);
			//out.println("carry = " + carry);
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
	
	private static boolean isNegative(List<Integer> list){
		int last = list.get(list.size() -1 );
		return last == 9999;
	}
	
	private static boolean isPositive(List<Integer> list){
		int last = list.get(list.size()-1);
		return last==0;
	}
	
	public static void main(String[] args){
		BigInteger a = new BigInteger("9999999999999999999999999999999999999999");
		BigInteger b = new BigInteger("1");
		out.println(a + " + " + b + " = \n" + (a.addition(b)));
	}
	
}


/*
9999999999999999999999999999999999999999
10000000000000000000000000000000000000000
*/



