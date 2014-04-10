public class DistinctSubString{

	private static int dynamic(String X, String Y){

		int M = X.length();
		int N = Y.length();
		int [][] dp = new int[N][M];

		if(X.charAt(0)==Y.charAt(0)){
			dp[0][0]=1;
		}


		for(int i=1;i<M;i++){
			if(X.charAt(i)==Y.charAt(0)){
				dp[0][i]=dp[0][i-1]+1;
				
			}else{
				dp[0][i]=dp[0][i-1];
			}
		}

		for(int i=1;i<N;i++){
			for(int j=1;j<M;j++){

				if(X.charAt(j)==Y.charAt(i)){
					dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
				}else{
					dp[i][j]=dp[i][j-1];
				}
			}
		}


		return dp[N-1][M-1];

	}

	public static void main(String[] args) {
		

		String X="rabbbit";
		String Y="rabbit";
		System.out.println(dynamic(X,Y));
	}

}