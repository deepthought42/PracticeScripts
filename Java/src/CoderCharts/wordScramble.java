package CoderCharts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class wordScramble {
	public static void main(String[] args){
		String filename = args[0];
		try {
			 FileInputStream fstream = new FileInputStream(filename);  
			// Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   String str;
		   String newStr = "";
		    while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str);
				String tempWord;
				int wordLen;
				while(token.hasMoreTokens()){
					tempWord = token.nextToken();
					wordLen = tempWord.length();
					
					if(wordLen>2){
						char[] wordChars = tempWord.toCharArray();
						for(int i=1; i<wordLen; i++){
							int exchange = i + (int)(Math.random() * (((wordLen-2) - i) + 1));
							char temp = wordChars[i];
							wordChars[i] = wordChars[exchange];
							wordChars[exchange] = temp;

						}
						String newWord = "";
						for(int i=0;i<tempWord.length();i++){
							newWord += wordChars[i];
						}
						System.out.print(newWord + " ");
					}
					else{
						System.out.print(tempWord + " ");
					}
				}
				
		    }
		    br.close();
		} catch (IOException e) { e.printStackTrace();}
	}
	
	public static String shuffle(String word){
		int wordLen = word.length()-1;
		char[] wordChars = word.toCharArray();
		for(int i=1; i<wordLen; i++){
			int exchange = i + (int)(Math.random() * (((wordLen-1) - i) + 1));
			
			char temp = wordChars[i];
			wordChars[i] = wordChars[exchange];
			wordChars[exchange] = temp;

		}
		String newWord = "";
		for(int i=0;i<word.length();i++){
			newWord += wordChars[i];
		}
		return newWord;
	}
}
