import java.util.Arrays;

public class BalancedPartition {


	public static boolean canPartition(int []array){

		int N = array.length;

		int sum=0;
		for(int i:array){
			sum+=i;
		}

		// partition is possible only for even sum
		if(sum%2 !=0){
			return false;
		}

		boolean [][] dp = new boolean[(sum/2)+1][N+1];

		// if no elements are  present then no way you can get sum i
		for(int i=1;i<=(sum/2);i++){
			dp[i][0] = false;
		}

		// if sum =0, then do not pick up any element from array and you get your sum. can also be thought as empty set
        for(int i=0;i<=N;i++){
        	dp[0][i]=true;
        }  

        for(int i=1;i<=(sum/2);i++) {
        	for(int j=1;j<=N;j++) {

        		dp[i][j] = dp[i][j-1];
        		if(i>=array[j-1]){
        			dp[i][j] = dp[i][j-1] || dp[i-array[j-1]][j-1];
        		}
        		
        	}
        }

        return dp[sum/2][N];
	}

	public static void main(String[] args) {
		
		//int [] array = {1, 5, 3};
		//boolean result = canPartition(array);

		int array[] = {3, 1, 5, 19, 12};
		boolean result = canPartition(array);
		System.out.println("can partition "+Arrays.toString(array)+" : "+result);

	}
}