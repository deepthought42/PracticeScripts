package CoderCharts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class magic_words_decrypter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = args[0];
		String dictFile = args[1];
		char[] dictMap = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] charLoc = new int[26];
				
		ArrayList<String> dict = new ArrayList<String>();
		try {
			 FileInputStream fstream = new FileInputStream(dictFile);
			// Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   String str;

		   while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str);
				
				while(token.hasMoreTokens()){
					String dictEntry = token.nextToken();
					dict.add(dictEntry);
					
				}
		    }
		    br.close();
		} catch (IOException e) { e.printStackTrace();}
		Collections.sort(dict);
		char temp = ' ';
		int dictionaryIndex = 0;
		String dictEntry;
		for(int h=0; h<dict.size(); h++){
			dictEntry = dict.get(h);
			if(dictEntry.charAt(0) != temp){
				for(int i=0;i<dictMap.length; i++){
					if(dictMap[i] == dictEntry.charAt(0)){
						charLoc[i] = dictionaryIndex;
						temp = dictEntry.charAt(0);
					}
				}
			}
			dictionaryIndex++;
		}
		
		try {
			 FileInputStream fstream = new FileInputStream(filename);
			// Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		   String str;
		   int charIndex = 0;
		   
		    while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str);
				
				while(token.hasMoreTokens()){
					String scrambled = token.nextToken();
					scrambled = scrambled.toUpperCase();
					for(int i=0; i<dictMap.length; i++){
						if(dictMap[i] == scrambled.charAt(0)){
							charIndex = i;
						}
					}
					if(scrambled.length()>2){
						for(int i=charLoc[charIndex]; i<dict.size(); i++){
							String dictWord = dict.get(i);
							if(dictWord.charAt(0) == scrambled.charAt(0) && dictWord.charAt(dictWord.length()-1) == scrambled.charAt(scrambled.length()-1) && dictWord.length() == scrambled.length()){
								for(int j=0; j<dictWord.length(); j++){
									for(int k=0; k<scrambled.length(); k++){
										if(dictWord.charAt(j) == scrambled.charAt(k)){
											scrambled = scrambled.substring(0,k) + scrambled.substring(k+1);
											break;
										}
									}
								}
							}
							if(scrambled.length() == 0){
								System.out.print(dictWord.toLowerCase() + " ");
								break;
							}
						}
					}
					else{
						System.out.print(scrambled.toLowerCase() + " ");
					}
				}
		    }

		    br.close();
		} catch (IOException e) { e.printStackTrace();}
	}
}
