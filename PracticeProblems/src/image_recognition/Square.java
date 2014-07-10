package image_recognition;

public class Square {
	static boolean isSquarePresent(Character[][] arr){
		
		int leftBound = -1; 
		int rightBound = -1; 
		int upperBound = -1;
		int lowerBound = -1;
		
		leftBound = findLeftBound(arr);
		upperBound = findUpperBound(arr);
		
		
		lowerBound = findLowerBound(arr);
		rightBound = findRightBound(arr);
		
		boolean isSquare = false;
		boolean isSquareFilled = false;
		if(leftBound >=0 && rightBound >= 0 && upperBound >=0 && lowerBound >= 0){
			isSquare = isSquare(leftBound, upperBound, lowerBound, rightBound);
			
			if(isSquare){
				isSquareFilled = isSquareFilled(arr, leftBound, upperBound, lowerBound, rightBound);
				if(isSquareFilled){
					return true;
				}
				
			}
		}
		
		//System.out.println("IS SQUARE? :: " + isSquare + "\t IS SQUARE FILLED? :: " + isSquareFilled);
		return false;
	}
	
	
	static int findLeftBound(Character[][] arr){

		for(int x1 = 0; x1 < arr.length; x1++){
			for(int y1 = 0; y1 < arr.length; y1++){
				if(arr[x1][y1] == '#'){
					//System.out.println("LEFT BOUND :: " + x1);
					return x1;
				}
			}
		}
		
		return -1;
	}

	static int findUpperBound(Character[][] arr){
		
		for(int y1 = 0; y1 < arr.length; y1++){
			for(int x1 = 0; x1 < arr.length; x1++){
				if(arr[x1][y1] == '#'){
					//System.out.println("UPPER BOUND :: " + y1);
					return y1;
				}
			}
		}
		return -1;
	}

	static int findLowerBound(Character[][] arr){
		
		for(int y = arr.length-1; y >= 0; y--){
			for(int x = 0; x < arr.length; x++){
				if(arr[x][y] == '#'){
					//System.out.println("LOWER BOUND :: " + y);
					return y;
				}
			}
		}
		return -1;
	}
	
	static int findRightBound(Character[][] arr){
		
		for(int x = arr.length-1; x >=0 ; x--){
			for(int y = 0; y < arr.length; y++){
				if(arr[x][y] == '#'){
					//System.out.println("RIGHT BOUND :: " + x);
					return x;
				}
			}
		}
		
		return -1;
	}
	
	static boolean isSquare(int leftBound, int upperBound, int lowerBound, int rightBound){
		
		if((lowerBound - upperBound) == (rightBound - leftBound)){
			return true;
		}
		return false;
	}
	
	static boolean isSquareFilled(Character[][] arr, int leftBound, int upperBound, int lowerBound, int rightBound){
		
		for(int x = leftBound; x <= rightBound; x++){
			for(int y = upperBound; y <= lowerBound; y++){
				if(arr[x][y] != '#'){
					return false;
				}
			}
		}
		return true;
	}
}
