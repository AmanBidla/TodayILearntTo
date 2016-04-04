public class ReverseInteger {


	public static int reverse(int N){

		int rev =0;
		while(N/10 >0){

			rev = rev *10+ N%10;
			N =N/10;
		}

		if(N%10>0){
			rev = rev*10+N%10;
		}
		return rev;
		
	}

	public static void main(String[] args) {
		
		System.out.println(reverse(321));
	}
}