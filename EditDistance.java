public class EditDistance {
	
	
	public static void main(String abd[]){
		//System.out.println("edit distance = "+minDistance("cat","bat"));
		//true =1 
		/*System.out.println("edit distance = "+minDistance("cat","dog")); //false
		 System.out.println("edit distance = "+minDistance("cat","cats")); //true
		 System.out.println("edit distance = "+minDistance("cat","cut")); //true
 		 System.out.println("edit distance = "+minDistance("cat","cast")); //true
 		 System.out.println("edit distance = "+minDistance("cat","at")); //true */
 		 System.out.println("edit distance = "+minDistance("sea","eat")); //false
 		 System.out.println("edit distance = "+minDistance("sea","eat")); //false
  		 System.out.println("edit distance = "+minDistance("a","b")); //false
 		 System.out.println("edit distance = "+minDistance("a","b")); //false

	}
	
	 
	


  public static int minDistance(String word1, String word2) {
        
     if( word1==null || word2==null || word1.equals(word2) ) 
        return 0;
     if(word1.length()==0 )
        return word2.length();
     if(word2.length()==0)
        return word1.length();
     int M = word1.length();
     int N = word2.length();
     int [][] dp = new int[M+1][N+1];
     for(int i=0;i<=M;i++){
         dp[i][0]=i;
     }
     for(int i=0;i<=N;i++){
         dp[0][i]=i;
     }
     for(int i=1;i<=M;i++){
         for(int j=1;j<=N;j++){
             char a =word1.charAt(i-1);
             char b =word2.charAt(j-1);
             dp[i][j] = Math.min( (dp[i-1][j])+1 , Math.min( (dp[i][j-1]+1), ((dp[i-1][j-1])+((a!=b)?1:0)) ) );
         }
     }
     return dp[M][N];
    }     
	
}