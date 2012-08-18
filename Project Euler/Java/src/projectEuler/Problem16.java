package projectEuler;

import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args){
		BigInteger base = new BigInteger("2");
		int pow = 1000;
		BigInteger answer = base.pow(pow);
		String strAnswer = answer.toString();
		long total = 0;
		for(int i=0; i<strAnswer.length(); i++){
			total += Character.getNumericValue(strAnswer.charAt(i));
		}
		
		System.out.println("TOTAL :: "+total);
	}
}
