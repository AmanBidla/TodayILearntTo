public class NextSmallestMultiple {


	public static int nextSmallest(int a,int b, int N) {


		int [] dp = new int[N+1];

		dp[0] =1;
		int i5=1, i7=1;
		int nextMultipleOfFive = i5*5;
		int nextMultipleOfSeven = i7*7;

		for(int i=1;i<=N; i++){

			int next = Math.min(nextMultipleOfSeven, nextMultipleOfFive);			 

			if(next == nextMultipleOfFive) {
				i5++;
				nextMultipleOfFive = i5*5;
				
			} else if (next == nextMultipleOfSeven) {
				i7++;
				nextMultipleOfSeven = i7*7;				 
			}
			dp[i] = next;
		}

		return dp[N];
	}

	public static void main(String[] args) {
		
		int a=5, b=7, n=8;
		System.out.println( nextSmallest(a,b,n)); // should be 25
	}
}