public class BinomialCoeff_DynamicProgramming {


	private static int binomial(int N,int K){

		int [] dp = new int[K+1];
		dp[0] =1; // NC0 = 1;
		for(int i=1;i<=N;i++){
			for(int j=Math.min(i,K);j>0;j--){
				dp[j] = dp[j] +dp[j-1];
			}
		}
		return dp[K];
	}
	public static void main(String[] args) {
		int result = binomial(5,2);
		System.out.println(result);
	}
}