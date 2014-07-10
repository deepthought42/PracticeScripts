package FacebookHackerCup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import files.ReadWriteTextFile;

public class LabelMaker {
	static long packageCount = 0;
	static int currentIdx = 1; 
	static StringBuffer labelVal = null;
	public static void main(String[] args){
		File file = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\labelmaker.txt");
		List<String> inputLines = ReadWriteTextFile.getContents(file);
		
		int numTests = Integer.parseInt(inputLines.remove(0));
		String labels = "";
		long numPackages = 0;
		String cases = "";
		
		for(int t = 1; t< numTests; t++){
			System.out.println("Starting test :: " + t);
			String line = inputLines.remove(0);
			StringTokenizer token = new StringTokenizer(line, " ");
			
			labels = token.nextToken();
			numPackages = Long.parseLong(token.nextToken());
			
			System.out.println("getting minimum label length...");
			int labelLen = getMinLabelLength(labels.length(), numPackages);
			
			packageCount = nMinusOneCombinations(labels.length(), labelLen-1);
			System.out.println(packageCount);
			while(packageCount <= numPackages){
				
				makeLabels(labels, new StringBuffer(), numPackages, labelLen++);
				currentIdx = 1;
			}
			cases += "Case #"+t+": ";
			cases += labelVal + "\n";
			System.out.println(labelVal);
			packageCount = 0;
			labelVal = null;
		}
		File outFile = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\labelmaker_output.txt");
		try {
			ReadWriteTextFile.setContents(outFile, cases);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cases);	
	}
	

	public static void makeLabels(String labels, StringBuffer labelOut, long desiredCount, int setSize){
		
		for(int i = 0; i < labels.length(); i++){		
				labelOut.append(labels.charAt(i));
				
				
				
				if(desiredCount <= packageCount + power(labels.length(), setSize-currentIdx)){
					if(currentIdx < setSize){
						currentIdx++;
						
						makeLabels(labels, labelOut, desiredCount, setSize);
					}
					if(labelOut.length() == setSize){
						packageCount++;
						
						if(packageCount >= desiredCount){
							
							if(labelVal == null){
								labelVal = labelOut;
							}
							return;
						}
					}
				}
				packageCount = setPackageCount(labels, setSize-currentIdx, packageCount);
				labelOut.deleteCharAt(labelOut.length()-1);	
		}
		currentIdx--;
	}
	
	public static int getMinLabelLength(long seqLen, long desiredLabelVal){
		int labelLen = 1;
		if(seqLen == 1){
			return (int)desiredLabelVal;
		}
		for(int i = 1; power(seqLen, i) < desiredLabelVal; i++ ){
			labelLen = i;
		}
		return labelLen;
	}
	
	public static long setPackageCount(String labels, int expectedSetSize, long currentTotal){
		currentTotal += power(labels.length(), expectedSetSize);
		return currentTotal;
	}
	
	public static long nMinusOneCombinations(long labelSetLength, int setSize){
		long totalCombinations = 0;
		long pow = 0;
		for(int i = 1; i <= setSize;i++){
			pow = power(labelSetLength, i);
			totalCombinations += pow;
		}
		
		/*System.out.println("============================================");
		System.out.println("setSize :: " + setSize);
		System.out.println("labelSetLength :: " + labelSetLength);
		System.out.println("total combos   :: " + totalCombinations);
		System.out.println("============================================");
		*/
		return totalCombinations;
	}
	
	public static long power(long a, long b){
		long pow = 1;
		for(int i = 1; i <= b; i++){
			pow *= a;
		}
		
		return pow;
	}
}
