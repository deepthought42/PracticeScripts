package projectEuler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18 {
	public static void main(String[] args){
		int[][] tree = new int[15][15];
		String filename = args[0];
		try {
			 FileInputStream fstream = new FileInputStream(filename);
			// Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   String str;
		   int x = 0;
		   int y = 0;
		   while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str);
				
				while(token.hasMoreTokens()){
					String num = token.nextToken();
					tree[x][y] = Integer.parseInt(num);
					y++;
				}
				x++;
				y=0;
		   }
		}catch (IOException e) { e.printStackTrace();}
	}
	
	public static int findMaxPath(int[][] tree, int x){
		int total = 0;
		int newTotal = 0;
			
			//return tree[x][x] + findMaxPath(tree, x);
			return tree[x][x+1] + findMaxPath(tree, x+1);
		//return total;
	}
}
