package projectEuler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class NumberTriangle {
	public static void main(String[] args){
		new NumberTriangle().run();
	}
	
	public void run() {
		int index = 0;
		ArrayList<Integer> vals = loadValues();
		//get buffered reader fo file
		int total = getLargestPathValue(vals, 0,0,0);
		System.out.println("TOTAL :: "+total);
	}
	
	public ArrayList<Integer> loadValues(){
		ArrayList<Integer> values = new ArrayList<Integer>();
		BufferedReader br = null;
		
		try {
			FileInputStream fstream = new FileInputStream("C://Users//bk100m//workspace//DemoCode//src//projectEuler//tree.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			br =  new BufferedReader(new InputStreamReader(in));
			String str;
			
			
			
			while((str = br.readLine() ) != null){
				StringTokenizer token = new StringTokenizer(str);
				
				while(token.hasMoreTokens()){
					str = token.nextToken();
					values.add(Integer.valueOf(str));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return values;
	}
	
	public int getLargestPathValue(ArrayList<Integer> array, int total, int index, int layer){
		if(index < array.size()){
			System.out.println("total :: " + total);
			System.out.println("Layer :: " + layer);
			System.out.println("Index :: " + index );
			System.out.println("Value at index :: " + array.get(index) + "\n");
			
			
			total += array.get(index);
			layer++;
			
			int total1 = getLargestPathValue(array, total, index+layer, layer);
			int total2 = getLargestPathValue(array, total, index+layer+1, layer);
			
			if(total1 > total2 && total1 > total){
				total = total1;
			}
			else if(total2 > total1 && total2 > total){
				total = total2;
			}
			System.out.println("Total 1 :: " + total1 );
			System.out.println("Total 2 :: " + total2 + "\n");
		}

		
		return total;
	}
	
}
