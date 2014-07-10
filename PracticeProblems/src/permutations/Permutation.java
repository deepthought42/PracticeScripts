package permutations;

public class Permutation {
	public static boolean nextPermutation(int[] sequence){
		int i = sequence.length -1;
		while(i > 0 && sequence[i - 1] >= sequence[i]){
			i--;
		}
		
		//Are we at the last permutation yet?
		if(i == 0){
			return false;
		}
		
		//let sequence[i-1] be the pivot
		//find rightmost element that exceeds the pivot
		int pivot = sequence.length - 1;
		
		while(sequence[pivot] <= sequence[i-1]){
			pivot--;
		}
	
		//sequence[j] becomes new pivot
		//assertingtion : j>=1
		
		//swap the pivot with j
		int temp = sequence[i-1];
		sequence[i-1] = sequence[pivot];
		sequence[pivot] = temp;
	    
		pivot = sequence.length -1;
		while(i < pivot){
			temp = sequence[i];
			sequence[i] = sequence[pivot];
			sequence[pivot] = temp;
			i++;
			pivot--;
		}
		return true;
	}
}
