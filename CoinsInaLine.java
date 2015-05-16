public class CoinsInaLine{


	public static int max(int[]A){
		
		int N = A.length;
		int [][] dp = new int[N][N];

		for(int i=N-1;i>=0;i--){
			for(int j=i;j<N;j++){

				if(i==j) dp[i][j]= A[i];
			 	else if(i+1==j) dp[i][j] = Math.max( A[i], A[j]);
			 	else{

			 		int chooseHead = Math.min( dp[i+1][j-1], dp[i+2][j] )+ A[i];
			 		int chooseTail = Math.min ( dp[i][j-2], dp[i+1][j-1] )+ A[j];
			 		dp[i][j] = Math.max( chooseHead, chooseTail);
			 	}
			}
		}

		return dp[0][N-1];

	}

	public static void main(String[] args) {
		
		int [] A = { 3, 2, 2, 3, 1, 2 };
		System.out.println( max(A));
	}
}