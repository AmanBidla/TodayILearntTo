public class LongestPalindromSubsequence{

	public static void main(String[] args) {
		
		String s ="AGTCMCTGA";
		System.out.println(longest(s));

	}

	private static int longest(String s){
 	
		int N = s.length();
		int [][] dp = new int[N][N];

		for(int i=0;i<N;i++){

			dp[i][i]=1;
		}


		for(int gap=1;gap<N;gap++){
			for(int i=0;i<N-gap;i++){
				int j= gap+i;
				if((s.charAt(i)==s.charAt(j)) && (gap==1)){
					dp[i][j]=1;
				}else if(s.charAt(i)==s.charAt(j)){
					dp[i][j]= dp[i+1][j-1]+2;
				}else{
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}

		return dp[0][N-1];
	}

}