package projectEuler;

import java.util.ArrayList;

public class Problem14 {
	public static void main(String[] args){
		ArrayList<Integer> chain = new ArrayList<Integer>();
		ArrayList<Integer> tempChain = new ArrayList<Integer>();
		long longestChainSize = 0;
		long longestChainVal = 0;
		int chainSize = 0;
		long n;
		for(long i=1; i<1000000; i++){
			chainSize = 0;
			//tempChain.clear();
			n=i;
			while(n!=1){
				//System.out.println("N :: "+n);
				//tempChain.add(n);
				chainSize++;
				if(n%2 == 0){
					n = n/2;
				}
				else{
					n = 3*n +1;
				}
			}
			/*if(tempChain.size() > chain.size()){
				chain = (ArrayList<Integer>) tempChain.clone();
			}*/
			if(chainSize > longestChainSize){
				longestChainSize = chainSize;
				longestChainVal = i;
				//System.out.println("Chain size :: "+longestChainSize+"\t Chain Val :: "+longestChainVal);
			}
			System.out.println("i :: "+i);
		}
		
		//for(int j=0; j<chain.size(); j++){
			System.out.println("--------------------------------------------------");
			System.out.println("Longest Chain size :: "+longestChainSize+"\t Chain Val :: "+longestChainVal);
		//}
	}
}
