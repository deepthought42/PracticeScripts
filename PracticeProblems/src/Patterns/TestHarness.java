package Patterns;

import java.util.ArrayList;
import java.util.List;

public class TestHarness {
	public static void main(String[] args){
		double maxVal = 10.0;
		double currentDecimal = 0.0;
		String longestVal = "";
		
		
		for(double i = 2; i <= maxVal; i++){
			currentDecimal = 1/i;
			System.out.println(currentDecimal);
			
			String decimalString = Double.toString(currentDecimal);
			decimalString = decimalString.substring(2);
			int power = 1, lam = 1;
			int tortoise = 0;
			int hare = 1;
			
			try{
				while(decimalString.charAt(tortoise) != decimalString.charAt(hare) ){
					tortoise++;
					hare += 2;
				}
			}
			catch(IndexOutOfBoundsException e){
				continue;
			}
			
			int mu = 0;
			try{
				while(decimalString.charAt(tortoise) != decimalString.charAt(hare) ){
					tortoise++;
					mu++;
				}
			}
			catch(IndexOutOfBoundsException e) {
				continue;
			}
			
			lam = tortoise+1;
			hare = tortoise+1;
			try{
				while(decimalString.charAt(tortoise) != decimalString.charAt(hare)){
					hare++;
					lam++;
				}
			}catch(IndexOutOfBoundsException e){
				continue;
			}
			
			System.out.print("DECIMAL :: " + decimalString + "\t");
			System.out.println("MU :: " + mu + "  LAM :: "+ lam );
			System.out.println("repeated vals :: "+decimalString.substring(mu, lam));
			System.out.println("substring length :: " + decimalString.substring(mu, lam).length());
			System.out.println("==============================================================");
		}
	}
}
