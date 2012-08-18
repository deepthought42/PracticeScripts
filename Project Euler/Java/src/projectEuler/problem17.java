package projectEuler;

public class problem17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totalLetters = 0;
		for(int num=1; num<=1000; num++){
			String number = Integer.toString(num);
			int length = number.length();
			for(int i=0; i<length; i++){
				if(number.charAt(i)=='1'){
					if(i==length-1){
						totalLetters+=3;
					}
					else if(i==length-2){
						
						if(number.charAt(length-1)=='0'){
							totalLetters+=3;
						}
						else if(number.charAt(length-1)=='1'){
							totalLetters+=6;
						}
						else if(number.charAt(length-1)=='2'){
							totalLetters+=6;
							System.out.println("value is 12!");
						}
						else if(number.charAt(length-1)=='3'){
							totalLetters+=8;
						}
						else if(number.charAt(length-1)=='4'){
							totalLetters+=8;
						}
						else if(number.charAt(length-1)=='5'){
							totalLetters+=7;
						}
						else if(number.charAt(length-1)=='6'){
							totalLetters+=7;
						}
						else if(number.charAt(length-1)=='7'){
							totalLetters+=9;
						}
						else if(number.charAt(length-1)=='8'){
							totalLetters+=8;
						}
						else if(number.charAt(length-1)=='9'){
							totalLetters+=8;
						}
						i++;
					}
					else if(i==length-3){
						//how is the word 'and' determined to be added.
						totalLetters+=10;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=11;
					}
				}
				else if(number.charAt(i)=='2'){
					if(i==length-1){
						totalLetters+=3;
					}
					else if(i==length-2){
						totalLetters+=6;
					}
					else if(i==length-3){
						totalLetters+=10;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=11;
					}
				}
				else if(number.charAt(i)=='3'){
					if(i==length-1){
						totalLetters+=5;
					}
					else if(i==length-2){
						totalLetters+=6;
					}
					else if(i==length-3){
						totalLetters+=12;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=13;
					}
				}
				else if(number.charAt(i)=='4'){
					if(i==length-1){
						totalLetters+=4;
					}
					else if(i==length-2){
						totalLetters+=5;
					}
					else if(i==length-3){
						totalLetters+=11;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=12;
					}
				}
				else if(number.charAt(i)=='5'){
					if(i==length-1){
						totalLetters+=4;
					}
					else if(i==length-2){
						totalLetters+=5;
					}
					else if(i==length-3){
						totalLetters+=11;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=12;
					}
				}
				else if(number.charAt(i)=='6'){
					if(i==length-1){
						totalLetters+=3;
					}
					else if(i==length-2){
						totalLetters+=5;
					}
					else if(i==length-3){
						totalLetters+=10;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=11;
					}
				}
				else if(number.charAt(i)=='7'){
					if(i==length-1){
						totalLetters+=5;
					}
					else if(i==length-2){
						totalLetters+=7;
					}
					else if(i==length-3){
						totalLetters+=12;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=13;
					}
				}
				else if(number.charAt(i)=='8'){
					if(i==length-1){
						totalLetters+=5;
					}
					else if(i==length-2){
						totalLetters+=6;
					}
					else if(i==length-3){
						totalLetters+=12;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=13;
					}
				}
				else if(number.charAt(i)=='9'){
					if(i==length-1){
						totalLetters+=4;
					}
					else if(i==length-2){
						totalLetters+=6;
					}
					else if(i==length-3){
						totalLetters+=11;
						if(number.charAt(length-1)!='0' || number.charAt(length-2)!='0'){
							totalLetters+=3;
						}
					}
					else if(i==length-4){
						totalLetters+=12;
					}
				}
			}

			
			System.out.print("Number = "+number+"\t");
			System.out.println("Total Letters = "+totalLetters);
		}
		System.out.println("Total Letters = "+totalLetters);
	}

}
