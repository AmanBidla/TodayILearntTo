import java.util.Arrays;
public class LIS{


	private static int[] max(int [] array){
		 	
		 	int N = array.length;
		 	int [] dp = new int[N];
		 	int [] prev = new int[N];

		 	Arrays.fill(dp,1);
		 	Arrays.fill(dp,-1);

		 	for(int i=0;i<N;i++){
		 		for(int j=0;j<i;j++){
		 			if(array[j]<array[i] && (1+dp[j]>dp[i])){
		 				dp[i]=1+dp[j];
		 				prev[i]=j;
		 			}
		 		}
		 	}

		 	int bc=0;
		 	for(int i=0;i<N;i++){
		 		if(dp[bc]<dp[i]){
		 			bc=i;
		 		}
		 	}

		 	int LN = dp[bc];
		 	int [] longest = new int[LN];

		 	for(int i=bc;i!=-1&&LN>0;i=prev[i]){
 		 		longest[--LN]= array[i];
		 	}

		 	return longest;

	}

	public static void main(String[] args) {
		
		int [] array ={2, 6, 3, 4, 1, 2, 9, 5, 8};
		System.out.println(Arrays.toString(max(array)));
	}
}