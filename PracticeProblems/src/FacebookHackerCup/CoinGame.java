package FacebookHackerCup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import files.ReadWriteTextFile;

public class CoinGame {
	
	public static void main(String[] args){
		int leastMoves = 0;
		File file = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\coins_game.txt");
		List<String> inputLines = ReadWriteTextFile.getContents(file);
		
		int numTests = Integer.parseInt(inputLines.remove(0));
		String line = "";
		String caseString = "";
		for(int i = 1; i <= numTests; i++){
			line = inputLines.remove(0);
						
			StringTokenizer token = new StringTokenizer(line, " ");
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			int C = Integer.parseInt(token.nextToken());
			
			int h = K / N;
			int res;
			if (h * N >= C) {
				res = C;
			} else {
				int cnt = K / (h + 1);
				res = C + N - cnt;
			}
			
			caseString +="Case #"+i+": "+res +"\n";
			leastMoves = 0;
		}
		
		File outFile = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\coins_game_output.txt");
		try {
			ReadWriteTextFile.setContents(outFile, caseString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


