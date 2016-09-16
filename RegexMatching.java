public class RegexMatching {



	  public static boolean regex(String s, String p) {
        if(s==null || p==null){
            return false;
        }
        
        int M = s.length();
        int N = p.length();
        boolean [][] dp = new boolean [M+1][N+1];
        dp[0][0] = true;
        for(int i=0;i<=M;i++){
            for(int j=1;j<=N;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2] || (i>0  && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2)=='.') && dp[i-1][j]);
                } else {
                    dp[i][j] = i>0 && dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='.');
                }
            }
        }
        return dp[M][N];
    }

	public static void main(String[] args) {
		
 
		System.out.println("S = accccccb and P = ac*b "+regex("accccccb","ac*b"));// → true

		System.out.println("S = aa and P =a "+regex("aa","a"));// → false
		System.out.println("S = aa and P =aa "+regex("aa","aa"));// → true
		System.out.println("S = aaa and P=aa"+regex("aaa","aa"));// → false
		System.out.println("S = aa and P=a* "+regex("aa","a*"));// → true
		System.out.println("S = aa and P=* "+regex("aa",".*"));// → true
		System.out.println("S = ab and P =.*"+regex("ab",".*"));// → true
		 
		System.out.println("S = aab and P = c*a*b "+regex("aab","c*a*b"));// → true
	}
}