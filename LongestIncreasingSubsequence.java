import java.util.Arrays;
public class LongestIncreasingSubsequence {

	private static void findLongestIncreasingsequence(int[] array) {

		System.out.println(Arrays.toString(array));
		int N = array.length;
		int [] dp = new int[N];
		int [] prev = new int[N];
		int ans=0;

		for(int i=0;i<N;i++){
			dp[i]=1;
			prev[i]=-1;
		}

		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				
				if(array[i]<=array[j]){
					
					if(dp[i]+1>dp[j]){
						dp[j]=dp[i]+1;
						prev[j]=i;	
					}
					
					if(dp[j]>dp[ans])
						ans = j;	
   				}

				
			}
		}

		int [] seq = new int[dp[ans]];
		int L = dp[ans];

		for(int i=L-1;i>=0;i--){
			seq[i]=array[ans];
			ans = prev[ans];
		}

		System.out.println(Arrays.toString(seq));
		System.out.println("max length is "+L);
                 
    }

	 

	public static void main(String[] args) {
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		//int [] array = {10, 22, 9, 33, 21, 50, 41, 60};
		int [] array = {5,1,8,1,9,2};

		//int [] array ={9, 11, 2, 13, 7, 15};
		//int m = l.longestIncreasingSubsequenceForArray(array);
		//System.out.println("LCS is "+m);
		findLongestIncreasingsequence(array);
		 
		 
	}

}