public class MinCutToPalindrome{

	public static int minCut(String S){

		if(S==null || S.length()==0) return 0;
		int N = S.length();

		int []dp = new int[N+1];
		boolean [][] P = new boolean[N][N];

		for(int i=0;i<=N;i++)
			dp[i]= N-i;

		for(int i=N-1;i>=0;i--){
			for(int j=i;j<N;j++){
				if(S.charAt(i)==S.charAt(j)){

					if(i==j || i+1==j || P[i+1][j-1]){

						dp[i]= Math.min(dp[i], dp[j+1]+1);
						P[i][j]=true;
					}
				}
			}
		}

		return dp[0]-1;

	}

	public static void main(String[] args) {
		
		String S="ababbbabbababa";
		System.out.println(minCut(S));
	}

}