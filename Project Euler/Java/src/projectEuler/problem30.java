package projectEuler;

import java.util.ArrayList;

public class problem30 {
	public static void main(String[] args){
		int sum = 0;
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for(int i=10; i<400000; i++){
			sum = getSumOfFifthPowers(i);
			if(sum == i){
				vals.add(i);
			}
		}
		
		int total = 0;
		for(int tempVal : vals){
			total += tempVal;
		}
		
		System.out.println("Sum of values is :: " + total);
	}
	
	public static int getSumOfFifthPowers(int val){
		String vals = Integer.toString(val);
		int total = 0;
		int pow = 0;
		int digit = 0;
		
		for(int i=0; i<vals.length(); i++){
			digit = Character.getNumericValue(vals.charAt(i));
			pow = (int) Math.pow(digit, 5);
			total += pow;
		}
		return total;
	}
	
}
