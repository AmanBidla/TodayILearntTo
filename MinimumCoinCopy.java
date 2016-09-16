public class MinimumCoinCopy {

	public static int minCoins(int total, int []coins){

		int N = coins.length;
		int [][] dp = new int[total+1][N+1];

		for(int i=0;i<=total;i++){
			dp[i][0]=0
		}

		for(int i=0;i<=N;i++){
			dp[0][i] = 0;
		}

		for(int i=1;i<=total;i++){			 
			for(int j=0;j<N;j++){
				if(i>=array[j] && 1+dp[i-array[j]] > dp[j]){
					dp[j] = 1+ dp[i-array[j]];
				}
			}
		}

		return dp[total][N];

	}
}