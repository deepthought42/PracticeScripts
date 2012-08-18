package projectEuler;

import java.util.Arrays;

public class LexicographicPermutations {
	public static void main(String[] args){
		int[] v = new int[10];
		int n = 2;
		long permNumber = 1;
		
		for(int i=0; i <= n; i++){
			v[i] = i;
		}
		printv(v, n);
		
		boolean done = true;
		do{
			/*if(!(done = next(v,n))){
				++permNumber;
				printv(v, n);
			}*/
			if(permNumber == 1000000){
				break;
			}
		}while(!done);
		printv(v, n);
	}
	
	public static String next_lexicographic_permutation(String currPermutation){
		
		int[] digits = new int[currPermutation.length()];
		for(int i=0; i<digits.length; i++){
			digits[i] = currPermutation.charAt(i);
		}
		int maxIndex = currPermutation.length()-1;
		int prevValue = digits[maxIndex];
		int currValue = digits[maxIndex];
		
		for(int i=0; i <= maxIndex; i++){
			currValue = digits[i];
			if(i == 0 && currValue == 3){
				return currPermutation;
			}
			if(currValue < prevValue){
				int[] prefix = Arrays.copyOfRange(digits, 0, i);
				int[] suffix = Arrays.copyOfRange(digits, i, maxIndex);
				int nextStart = min(suffix);
				
			}
		}		
		return "";
	}
	
	/**]
	 * Take an array of integers and finds the lowest value
	 * @param array array of integers
	 * @return lowest integer value in array
	 */
	public static int min(int[] array){
		int min = 0;
		for(int i=0; i<array.length; i++){
			if(min > array[i]){
				min = array[i];
			}
		}
		return min;
	}
	
	public static void swap(int[] v, int pos1, int pos2){
		int temp = v[pos1];
		v[pos1] = v[pos2];
		v[pos2] = temp;
	}
	
	public static void printv(int[] v, int n){
		for(int i = 0; i<= n; i++){
			System.out.print(v[i]);
		}
		System.out.println("\n");
	}
}
