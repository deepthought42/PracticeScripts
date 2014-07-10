package permutations;

public class TestHarness {
	public static void main(String[] args){
		int[] sequence = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i = 1; i < 1000000; i++){
			Permutation.nextPermutation(sequence);
		}
		
		for(int i = 0; i < sequence.length; i++){
			System.out.print(sequence[i]);
		}
	}
}
