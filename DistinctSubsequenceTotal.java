public class DistinctSubsequenceTotal{

	public static void main(String[] args) {
		
		String S="rabbbit";
		String T="rabbit";
		System.out.println( count(S,T));
	}


	public static int count(String S, String T){

		int SN = S.length();
		int TN = T.length();

		int [][] dp = new int[SN][TN];

		for(int i=0;i<SN;i++){
			dp[i][0]=1;
		}

		for(int i=1;i<SN;i++){
			for(int j=1;j<TN;j++){

				if(S.charAt(i)==T.charAt(j)){
					dp[i][j]+= dp[i-1][j]+dp[i-1][j-1];
				}else{
					dp[i][j]+= dp[i-1][j];
				}
			}
		}

		return dp[SN-1][TN-1];
	}
}