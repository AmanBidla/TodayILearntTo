public class InterleavingStrings{

    public boolean isInterleave(String s1, String s2, String s3){

        if(s3==null) return false;

        if(s1==null){
            return s3.equals(s2);
        }

        if(s2==null){
            return s3.equals(s1);
        }

        int M = s1.length();
        int N = s2.length();
        int O = s3.length();

        if((M+N) > O) return false;

        boolean [][] dp = new boolean[M+1][N+1];

        dp[0][0]=true;

        for(int i=1;i<=M;i++){
            char lastchar_S1 = s1.charAt(i-1);
            char lastchar_S3 = s3.charAt(i-1);
            if( dp[i-1][0] && lastchar_S1== lastchar_S3){
                dp[i][0]=true;
            }
        }

        for(int j=1;j<=N;j++){
            char lastchar_S2 = s2.charAt(j-1);
            char lastchar_S3 = s3.charAt(j-1);
            if( dp[0][j-1] && lastchar_S2 == lastchar_S3){
                dp[0][j]=true;
            }
        }

        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                
                char lastchar_S1 = s1.charAt(i-1);
                char lastchar_S2 = s2.charAt(j-1);
                char lastchar_S3 = s3.charAt(i+j-1);

                if( (dp[i-1][j] && lastchar_S1==lastchar_S3) || (dp[i][j-1] && lastchar_S2==lastchar_S3)){
                    dp[i][j]=true;
                } 
            }
        }

        return dp[M][N];

    }

    public static void main(String[] args) {
    	InterleavingStrings i = new InterleavingStrings();
    	//System.out.println(i.isInterleave("a","b","aba"));
        System.out.println(i.isInterleave("aabcc","dbbca","aadbbbaccc"));

    }
}