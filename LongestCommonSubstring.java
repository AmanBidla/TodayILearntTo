public class LongestCommonSubstring {


	public static int longestCommonSubstring(String X, String Y) {

		int M = X.length();
		int N = Y.length();
		int [][] dp = new int[M+1] [N+1];
		int max=0;

		for(int i=M-1;i>=0;i--){
			for(int j=N-1;j>=0;j--){
				if(X.charAt(i) == Y.charAt(j)) {
					dp[i][j] = dp[i+1][j+1]+1;
				} else {					 
					dp[i][j] = 1;					
				}

				if(max<dp[i][j]){
					max = dp[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		String X ="zabcx";
		String Y ="abcd";

		System.out.println(longestCommonSubstring(X,Y));

	}
}