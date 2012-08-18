package projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;

public class problem29 {

		public static void main(String[] args){
			ArrayList<BigInteger> values = getPowerCombos(2, 100, 2, 100);
			System.out.println(Math.pow(100,100));
			
			/*for(long val : values){
				System.out.println(val);
			}*/
			System.out.println("Total Unique Numbers :: " + values.size());
		}
		
		public static ArrayList<BigInteger> getPowerCombos(int aLow, int aHigh, int bLow, int bHigh){
			
			BigInteger val;
			BigInteger temp1;
			
			ArrayList<BigInteger> uniqueCombos = new ArrayList<BigInteger>();
			for(int i=aLow; i<=aHigh; i++){
				for(int j=bLow; j <= bHigh; j++){
					temp1 = new BigInteger(Integer.toString(i));
										
					val = temp1.pow(j);
					if(!uniqueCombos.contains(val)){
						uniqueCombos.add(val);
					}
				}
			}
			return uniqueCombos;
		}
}
