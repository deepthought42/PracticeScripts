package FacebookHackerCup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import files.ReadWriteTextFile;

public class PreventingAlzheimers {
	public static void main(String[] args){
		File file = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\preventing_alzheimers.txt");
		List<String> inputLines = ReadWriteTextFile.getContents(file);
		
		int numTests = Integer.parseInt(inputLines.remove(0));
		String line1 = "";
		String line2 = "";
		String caseString = "";
		
		for(int i = 1; i <= numTests; i++){
			line1 = inputLines.remove(0);
			line2 = inputLines.remove(0);
			
			StringTokenizer token = new StringTokenizer(line1, " ");
			StringTokenizer token2 = new StringTokenizer(line2, " ");
			
			int numChildren = Integer.parseInt(token.nextToken());
			int divNum = Integer.parseInt(token.nextToken());
			
			System.out.println("Num children :: " + numChildren);
			System.out.println("Divisible Num :: " + divNum);
			
			List<Integer> childAges = new ArrayList<Integer>();
			while(token2.hasMoreTokens()){
				childAges.add(Integer.parseInt(token2.nextToken()));
			}
			
			int originalSum = 0;
			for(int age : childAges){
				originalSum += age;
			}
		
			boolean solutionFound;
			if(i>=4){
				System.out.println();
			}
			do{
				solutionFound = true;
				int idx = 0;
				for(int age : childAges){
					while(age%divNum != 0 && divNum != 1){
						age++;
						solutionFound=false;
					}
					childAges.set(idx, age);
					idx++;
					
				}
								
				for(int j = 0; j < childAges.size()-1; j++){
					int tempAge = childAges.get(j);
					//if(tempAge != 0){
						for(int k = j+1; k<childAges.size(); k++){
							
							if( tempAge != 0 && childAges.get(k)%tempAge == 0  && tempAge > divNum){
									childAges.set(k, childAges.get(k)+1);
								solutionFound=false;
							}
							else if(tempAge == childAges.get(k) && tempAge == divNum){
								childAges.set(k, childAges.get(k)+1);
							}
						}
					//}
				}
			}while(!solutionFound);
			
			int newSum = 0;
			if(i>4){
				System.out.println();
			}
			for(int age : childAges){
				newSum += age;
				System.out.println("Age " +age);
			}
			int diff = newSum - originalSum;
			
			caseString += "Case #"+ i+": "+diff+"\n";
			System.out.println(caseString);

		}
		

		File outFile = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\preventing_alzheimers_output.txt");
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
