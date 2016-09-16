public class MinInsertsToConvetToPalindrome{
	
	public static void main(String[] args) {
		
		int val = min("abcc");		 
		System.out.println("min "+val);

	}

	private static int min(String S){

		if((S == null) || (S.length()==0)){
			return 0;
		}

		int N = S.length();
		
		int [][] dp = new int[N][N]; // stores the min insertions to convert S[i..j] to palindrome
		 
        
        for(int gapBetweenLetters=1;gapBetweenLetters<N;gapBetweenLetters++){
        	for(int left=0, right=gapBetweenLetters; right<N; left++,right++){
        		int val = 0;
        		if(S.charAt(left) == S.charAt(right)){
        			val = dp[left+1][right-1]; Congrats on your anniversary at HackerX !

Hope you are doing well.

        		}else{
        			val = Math.min(dp[left+1][right], dp[left][right-1])+1;
        		}
        		dp[left][right] = val;
        	}
        }

        return dp[0][N-1];

	}
}