public class HowManyTreesWithinNNodes{

	public static void main(String[] args) {
		

		System.out.println(countTrees(4));
	}

	static int countTrees(int iNodeCount) {

        int [] dp = new int [iNodeCount];
        return catalan(dp,iNodeCount);
    }

    static int catalan(int[]dp, int N){
        
        if(N==0 || N==1){
            return 1;
        }
        int left=0, right=0, sum=0;
        for(int i=1;i<=N;i++){
            
            if(dp[i-1]==0){
                dp[i-1] = catalan(dp,i-1);
            }
            left = dp[i-1];
            if(dp[N-i]==0){
                dp[N-i]= catalan(dp,N-i);
            }
            right = dp[N-i];
            sum+=left *right;
        }
        return sum;
    }





}