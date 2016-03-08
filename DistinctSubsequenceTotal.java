public class DistinctSubsequenceTotal {

	public static void main(String[] args) {
		
		String S ="rabbbit";
		String T ="rabbit";
		assert(3==distinct(S,T));
		System.out.println("S :"+S+"\nT :"+T+"\n"+distinct(S,T));
		S ="ABCDE";
		T="ACE";		 
		assert(1==distinct(S,T));
		System.out.println("S :"+S+"\nT :"+T+"\n"+distinct(S,T));
		S ="A";
		T="B";
		assert(0==distinct(S,T));
		System.out.println("S :"+S+"\nT :"+T+"\n"+distinct(S,T));
		S="ccc";
		T="c";
		assert(3==distinct(S,T));
		System.out.println("S :"+S+"\nT :"+T+"\n"+distinct(S,T));
	}

	public static int distinct(String S, String T){

		int SN = S.length();
		int TN = T.length();

		int [][] dp = new int[SN][TN];

 		for(int i=0;i<SN;i++){

 			if(S.charAt(i)==T.charAt(0)){
 				dp[i][0]=1;
 			}
 		}


		for(int i=1;i<SN;i++){
			for(int j=0;j<TN;j++){

				dp[i][j] = dp[i-1][j];
				if (S.charAt(i)== T.charAt(j)) {
					if(j==0) {
						dp[i][j]+=1;
					} else {
						dp[i][j] += dp[i-1][j-1];	
					}					
				}
			}
		}

		return dp[SN-1][TN-1];

	} 

}