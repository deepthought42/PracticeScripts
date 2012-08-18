package projectEuler;
import java.math.BigInteger;

public class Fibonacci {
	
	
	public static void main(String[] args){
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		BigInteger x = fibonacciOfLength(f1, f2, 1000);
		System.out.println("X :: "+x);
	}
	
	public int getFirstWithLength(int len){
		return 0;
	}
	
	public static BigInteger fibonacciOfLength(BigInteger v1, BigInteger v2, int valLen){
		String fibStr = "";
		int index = 2;
		while(fibStr.length() < valLen){
			index++;
			BigInteger temp = v2;
			v2 = v1.add(v2);
			v1 = temp;
			fibStr = v2.toString();
		}

		System.out.println("INDEX # :: "+index);
		return v2;
		
	}
	
	public static long fibonacci(long v1, long v2){
		long new_v = v1 + v2;
		String fibStr = Long.toString(new_v);
		if( fibStr.length() < 1000){
			//System.out.println("fib :: "+new_v);
			return fibonacci(v2,new_v);	
		}
		else{
			//System.out.println("TERM # :: "+term);
			return new_v;
		}
	}
}
