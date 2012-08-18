package projectEuler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class NameScore {

	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static void main(String[] args){
		ArrayList<String> names = loadNames();
		String[] namesArray = new String[names.size()];
		names.toArray(namesArray);
		Arrays.sort(namesArray);
		
		int[] totals = new int[names.size()];
		long tot = 0;
		String name = "";
		char tmp;
		int unicodeVal;
		int score;
		for(int j=0; j < namesArray.length; j++ ){
			name = namesArray[j];
			score = 0;
			for(int i=0; i<name.length(); i++){
				tmp = name.charAt(i);
				unicodeVal = Character.getNumericValue(tmp);
				unicodeVal -= 9;
				score+=unicodeVal;
			}
			score *= j+1;
			totals[j] = score;
			tot += score;
		}
		System.out.println("Grand Total :: "+tot);
	}
	
	public static ArrayList<String> loadNames(){
		ArrayList<String> values = new ArrayList<String>();
		BufferedReader br = null;
		
		try {
			FileInputStream fstream = new FileInputStream("C://Users//bk100m//workspace//DemoCode//src//projectEuler//names.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			br =  new BufferedReader(new InputStreamReader(in));
			String str;
			StringTokenizer tok;
			
			
			while((str = br.readLine() ) != null){
				tok = new StringTokenizer(str, "\",\"");
				while(tok.hasMoreTokens()){
					values.add(tok.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return values;
	}
}
