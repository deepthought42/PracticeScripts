package projectEuler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileMaster {
	
	public static BufferedReader reader(String filename) throws IOException{
		BufferedReader br = new BufferedReader(null);
		DataInputStream in = null;
		//start reading in values
		//try {
		 FileInputStream fstream = new FileInputStream(filename);
		// Get the object of DataInputStream
		  in = new DataInputStream(fstream);
		  br =  new BufferedReader(new InputStreamReader(in));
		//}catch (IOException e) { 
		//	e.printStackTrace();
		//}
		return br;		

	}
}
