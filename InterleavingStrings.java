public class InterleavingStrings{


if(s3==null){
            return false;
        }
        
        if(s1==null || s1.length()==0){
            if(s2!=null){
                return s3.equals(s2);
            }else{
                return false;
            }
        }
        
        if(s2==null || s2.length()==0){
            if(s1!=null){
                return s3.equals(s1);
            }else{
                return false;
            }
        }
        
        int M=s1.length();
        int N=s2.length();
        int O=s3.length();
        
        if(O>(M+N)){
            return false;
        }
        
        
        boolean dp[][]= new boolean[M+1][N+1];
        
        
        
        for(int i=0;i<=M;i++){
            for(int j=0;j<=N;j++){
                 
                 if(i==0 && j==0){
                     dp[i][j]=true;
                 }
                 
                   if(i==0 && j!=0 && s3.charAt(j-1)==s2.charAt(j-1)){
                     dp[i][j]=dp[i][j-1];
                 }
                 
                 
                 else  if(j==0 && i!=0 && s3.charAt(i-1)==s1.charAt(i-1)){
                     dp[i][j]=dp[i-1][j];
                 }
                 
                   else if( i+j-1<O && i>0 && j>0 && s3.charAt(i+j-1)==s1.charAt(i-1) && s3.charAt(i+j-1)!=s2.charAt(j-1)){
                     dp[i][j]=dp[i-1][j];
                 }
                 
                   else if(i+j-1<O && i>0 && j>0 &&s3.charAt(i+j-1)==s2.charAt(j-1) && s3.charAt(i+j-1)!=s1.charAt(i-1)){
                     dp[i][j]=dp[i][j-1];
                 }
                 
                   else if( i+j-1<O && i>0 && j>0 && s3.charAt(i+j-1)==s1.charAt(i-1) && s3.charAt(i+j-1)==s2.charAt(j-1)){
                     dp[i][j]=dp[i-1][j]||dp[i][j-1];
                 }
            }
        }
           return dp[M][N];
    }


    public static void main(String[] args) {
    	InterleavingStrings i = new InterleavingStrings();
    	System.out.println(i.isInterleave("a","b","aba"));

    }
}