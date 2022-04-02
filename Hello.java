public class Hello{
	public static int gvar;
	public static void say(String s){
		short x = 10;
		System.out.println(s+x);
	}
	public static void breakcontinue(){
		int i, j;
		outerLoop:
		for(i=0; i<30; i++){
			System.out.println(i);
			innerLoop:
			for(j=0; j<30; j++){
				if(j==50 && i==50) break outerLoop;
			}
		}
		say("Loop terminated.");
	}
	
	public static void main(String[] argv){
		say("Hello, world");
		breakcontinue();
	}
}
