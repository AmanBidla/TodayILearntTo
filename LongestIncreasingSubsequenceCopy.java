import java.util.Arrays;

public class LongestIncreasingSubsequenceCopy {


	public static int [] longest(int []array){
 		
		// dp [i] = max {1 + dp[j]} where j<i and array[j]<array[i]
		//		  = 1 otherwise

		int N = array.length;
		int [] dp = new int[N];
		int [] prev = new int[N];

		for(int i=0;i<N;i++){
			dp[i]=1;
			prev[i]=-1;
		}
		int ans=0;

		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(array[i]<array[j]){

					if(dp[i]+1>dp[j]){
						dp[j] = 1+dp[i];
						prev[j] = i;
					}

					if(dp[j]>dp[ans]){
						ans=j;
					}
				}
			}
		}
		int L = dp[ans];
		int [] seq = new int[L];
		for(int i=L-1;i>=0;i--){
			seq[i]= array[ans];
			ans = prev[ans];
		}

		return seq;

	}
	public static void main(String[] args) {
		
		int [] array = {5,1,8,1,9,2};
		int []result = longest(array);
		System.out.println(Arrays.toString(result));

	}
}