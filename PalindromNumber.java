public class PalindromNumber{


	private static boolean isPaindrome(int N){

		if(N<0) return false;
		int div =1;
		while(N/div>=10) div*=10;

		while(N!=0){

			int left = N/div;
			int right = N%10;

			if(left!=right) return false;

			N=(N%div)/10;
		 	div/=100;
		}
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(isPaindrome(232));
	}
}