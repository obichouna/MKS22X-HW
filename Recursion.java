public class Recursion{
	
	public static String name(){
		return "Bichouna,Othman";
	}
	
	public static double sqrt(double n){
		if (n < 0){
			throw new IllegalArgumentException();
		}else{
			return helper(n, 1);
		}
	}
	
	
	public static double helper(double n, double guess){
		double betterGuess = (n / guess + guess) / 2;
		if(closeEnough(betterGuess * betterGuess, n)){
			return betterGuess;
		}
		return helper(n, betterGuess);
	}
	public static boolean closeEnough(double a, double b){
		return (Math.abs(a - b) < .00000000001);
	}
}
