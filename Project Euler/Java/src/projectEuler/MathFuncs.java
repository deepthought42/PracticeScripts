package projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class MathFuncs {
	public static void main(String[] args){
		ArrayList<Long> abundants = getAbundantInts(28123);
		//ArrayList pairSums = getAbundantPairSums(abundants);
		
		ArrayList<Long> nonAbundantPairSums = new ArrayList();
		for(long i=1; i<=28123; i++){
			nonAbundantPairSums.add(i);
		}
		
		nonAbundantPairSums = removeAbundantPairs(abundants, nonAbundantPairSums);
		long sum = getSum(nonAbundantPairSums);
		System.out.println("SUM :: "+sum);
	}
	
	public static ArrayList removeAbundantPairs(ArrayList<Long> abundants, ArrayList<Long> list){
		long list_size = abundants.size();
		System.out.println("LIST SIZE :: "+list_size);
		long pairSum;
		for(int i=0; i<list_size; i++){
			for(int j=i; j<list_size; j++){
				pairSum = abundants.get(i) + abundants.get(j);
				if(!(pairSum > 28123)){
					list.remove(pairSum);
				}
			}
		}
		
		return list;
	}
	
	public static ArrayList getAbundantInts(int limit){
		ArrayList<Long> abundantNums = new ArrayList<Long>();
		ArrayList<Long> divisors;
		for(int i=12; i<=limit; i++){
			divisors = getDivisors(i);
			long sum = getSum(divisors);
			if(sum > i){
				abundantNums.add((long)i);
			}
		}
		return abundantNums;
	}
	 
	public static long getAmicablePairsSums(int x){
		ArrayList<Long> AmicablePairs = new ArrayList();
		ArrayList<Long> divList1;
		ArrayList<Long> divList2;
		long sum;
		long sum2;
		
		for( int a=1; a<x; a++){
			divList1 = getDivisors(a);
			sum = getSum(divList1);
			
			divList2 = getDivisors(sum);
			sum2 = getSum(divList2);

			if(sum != sum2 && sum2 == a){
				if(!AmicablePairs.contains(sum)){
					AmicablePairs.add(sum);
				}
				
				if(!AmicablePairs.contains(sum2)){
					AmicablePairs.add(sum2);
				}
			}	
		}
		
		long finalSum = getSum(AmicablePairs);
		return finalSum;
	}
	public static BigInteger factorial(int x){
		if(x == 1){
			return BigInteger.valueOf(x);
		}
		BigInteger fact = BigInteger.valueOf(x);
		
		return fact.multiply(factorial(--x));
	}
	
	public static ArrayList getDivisors(long x){
		ArrayList<Long> pairs = new ArrayList<Long>();
		
		for(int i=1; i<= (x/2); i++){
			if(x%i == 0){
				pairs.add((long)i);
			}
		}
		return pairs;
	}
	
	public static long getSum(ArrayList<Long> x){
		Iterator<Long> iter = x.iterator();
		long sum = 0;
		while(iter.hasNext()){
			sum += iter.next();
		}
		return sum;
	}
	
	public static int[] generatePrimeList(int num){
		int[] primeList = new int[num];		
		int pCount = 0;
		
			for (int i=2; pCount < num; i++){
				if(isPrime(i)){
					primeList[pCount] = i;
					pCount = pCount+1;
				} // end if
			} // end for
		
		return primeList;
	}
	
	public static boolean isPrime(int num){
		double root = Math.sqrt(num);
		
		for (int i=2; i<root+1; i++){
			if (num%i == 0 && num != i){
				return false;
			}
		}
		return true;
	}
}
