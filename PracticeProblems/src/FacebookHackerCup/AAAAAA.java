package FacebookHackerCup;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

import files.ReadWriteTextFile;

public class AAAAAA {
	public static void main(String[] args){
		File file = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\aaaaaa_example_input.txt");
		List<String> inputLines = ReadWriteTextFile.getContents(file);
		
		int numTests = Integer.parseInt(inputLines.remove(0));
		int numRows = 0;
		int numCols = 0;
		
		int idx = 1;
		String line = null;
		
		for(int i = 1; i <= numTests; i++){
			line = inputLines.get(idx);
			StringTokenizer token = new StringTokenizer(line, " ");
			
			numRows = Integer.parseInt(token.nextToken());
			numCols = Integer.parseInt(token.nextToken());
			
			int[][] lotGrid = new int[numRows][numCols];
		}
		
	
	}
}
