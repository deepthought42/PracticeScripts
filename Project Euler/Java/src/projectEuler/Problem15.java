package projectEuler;

import java.math.BigInteger;

public class Problem15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger n = new BigInteger("20");
		System.out.println(factorial(n.multiply(new BigInteger("20"))));
		BigInteger total = factorial(n.multiply(new BigInteger("2"))).divide((factorial(n).multiply(factorial(n))));
	}
	
	public static BigInteger factorial(BigInteger n){
		if(n.equals(new BigInteger("1"))){
			return n;
		}
		else{
			return n.multiply(factorial(n.subtract(new BigInteger("1"))));
		}
	}

}
