public class RomanToInteger {

	public static void main(String[] args) {
		

		String S ="DCXXI";
		System.out.println(romanToInteger(S)); // should be 621

	}


	public static int romanToInteger(String S){

		if((S==null) || (S.length()==0)){
			return 0;
		}

		int pre = charToInt(S.charAt(0));
		int sum = pre;

		for(int i=1;i<S.length();i++){
			int curr = charToInt(S.charAt(i));
			if(curr > pre){
				sum = sum  - pre -pre;
			}
			sum += curr;
			pre = curr;
		}

		return sum;
	}

	private static int charToInt(char letter){

		switch(letter){

			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
		}
		return 0;
	}
	 
}