package projectEuler;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args){
		Integer[] a = {3,8,2,5,1,4,7,6};
		List<Integer> lst = Arrays.asList(a);
		System.out.println(lst.size());
		int val = lst.indexOf(3);
		Iterator iter = lst.listIterator();
		while(iter.hasNext()){

			System.out.println(iter.next() );
		}
		System.out.println( val);
	}
}
