package projectEuler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem13 {
	public static void main(String[] args){
		String numFile = args[0];
		int[] val1 = new int[100];
		int[] val2 = new int[100];
		//load each number from String into val2 array from end to beginning of String
		int[] sum = new int[100];
		
		//start reading in values
		try {
			 FileInputStream fstream = new FileInputStream(numFile);
			// Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String str;

		   while ((str = br.readLine()) != null) {
				for(int j=str.length()-1; j>=0; j--){
					val2[(str.length()-1)-j] = Character.getNumericValue(str.charAt(j)); 
				}
							
				int tempSum = 0;
				int remainder = 0;
				for(int i=0; i<val2.length; i++){
					tempSum = remainder + val1[i] + val2[i];
					if(tempSum>9){
						remainder = 1;
						tempSum = tempSum % 10;
					}
					else{
						remainder = 0;
					}
					sum[i] = tempSum;
				}
				//set val1 to sum
				val1 = sum.clone();
		   }
		}catch (IOException e) { e.printStackTrace();}
		
		for(int i=sum.length-1; i>=0; i--){
			System.out.print(sum[i]);
		}
	}
	
	private static ArrayList<Integer> clone(ArrayList<Integer> list){
		ArrayList<Integer> listCopy = new ArrayList<Integer>();
		
		for(int i=0; i<list.size(); i++){
			listCopy.add(list.get(i));
		}
		return listCopy;
	}
}
