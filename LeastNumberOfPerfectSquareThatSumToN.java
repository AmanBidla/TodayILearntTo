public class LeastNumberOfPerfectSquareThatSumToN {


	public static int leastNumber(int N) {

		int [] dp = new int[N+1];

		for(int i=0;i<=3;i++){
			dp[i] = i;
		}

		for(int i=4;i<=N;i++){
			dp[i] = i;
			for(int x=1;x<=i;x++) {
				if((x*x) > i) {
					break;
				} else {
					dp[i] = Math.min( dp[i], 1+ dp[i-(x*x)]);
				}
			}
		}

		return dp[N];
	}

	public static void main(String[] args) {
		
		System.out.println( leastNumber(6)); // 3 == 4 + 1 + 1
		System.out.println( leastNumber(13)); // 2 == 9 + 4
		System.out.println( leastNumber(12)); // 3 == 4 + 4 + 4
		System.out.println( leastNumber(4)); // 4 == 4 + 0 == but  dp[0] =0 ... so only 4 .... so least number is 1
		
	}
}