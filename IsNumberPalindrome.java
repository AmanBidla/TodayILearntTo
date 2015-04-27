public class IsNumberPalindrome {


	private static boolean isPalindrome(int num){

		if(num<-1) return false;

		int div=1;
		while((num/div)>=10){
			div*=10;
		}

		while( num!=0 ){

			int left = num/div;
			int right = num%10;

			if(left!=right) return false;

			num = (num%div)/10;
			div /=100;
		}

		return true;
	}

	public static void main(String[] args) {
		
		int num =235153;
		System.out.println( isPalindrome(num));
	}
}