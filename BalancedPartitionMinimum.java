public class BalancedPartitionMinimum {


	private static int minimumPartition(int [] array) {

		int sum=0;
		for(int a: array) {
			sum+=a;
		}

		int N = array.length;

		boolean [][] dp = new boolean[sum+1][N+1];

		for(int i=0;i<=N;i++){
			dp[0][i] = true;
		}

		for(int i=1;i<=sum;i++){
			dp[i][0]= false;
		}

		for(int i=1;i<=sum;i++){
			for(int j=1;j<=N;j++){
				dp[i][j] = dp[i][j-1];
				if(i>=array[j-1]) {
					dp[i][j] = dp[i][j-1] || dp[i-array[j-1]] [j-1];
				}
			}
		}

		int maxDiff = Integer.MAX_VALUE;

		for(int i=sum/2;i>=0;i--){
			if(dp[i][N]) {
				maxDiff = sum-2*i;
				break;
			}
		}

		return maxDiff;

	}
	public static void main(String[] args) {
		
		//int [] array = {1, 6, 11, 5};
		int [] array = {3, 1, 4, 2, 2, 1};
		System.out.println(minimumPartition(array));


	}
}