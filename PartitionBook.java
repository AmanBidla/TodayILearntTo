import java.util.Arrays;

public class PartitionBook {


	public static int partition(int [] pages, int numberOfWorkers){

		int N = pages.length;
		int [][] dp = new int[N+1][numberOfWorkers+1];
		int [][] partitionHelper = new int[N+1][numberOfWorkers+1];
		int [] pSum = new int[N];

		pSum[0] = pages[0];
		for(int i=1;i<N;i++){
			pSum[i] = pSum[i-1]+ pages[i];
		}

		for(int i=1;i<=N;i++){
			dp[i][1] = pSum[i-1];
		}

		for(int i=1;i<=numberOfWorkers;i++){
			dp[1][i] = pSum[0];
		}

		for(int i=2;i<=N;i++){
			for(int j=2;j<=numberOfWorkers;j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=i;x++){
					int partition = Math.max(dp[x][j-1], pSum[i-1]-pSum[x-1]);
					if(partition < dp[i][j]){
						dp[i][j] = partition;
						partitionHelper[i][j] =x;
					}
				}
			}
		}

		//print(dp);

		printPartition(N-1,numberOfWorkers,partitionHelper,pages);

		return dp[N][numberOfWorkers];

	}

	private static void printPartition(int N, int k, int[][] partitionHelper, int [] pages) {
		if(k==1){
			print(0,N,pages);
		} else{
			printPartition(partitionHelper[N][k],k-1,partitionHelper,pages);
			print(partitionHelper[N][k]+1,N,pages);
		}
	}

	private static void print(int start, int end, int[] pages){
		for(int i=start;i<=end;i++){
			System.out.print(pages[i]+" ");
		}
		System.out.println();
	}
 	
 	private static void print(int[][] dp){
 		for(int i=0;i<dp.length;i++){
 			System.out.println(Arrays.toString(dp[i]));
 		}
 	}

	public static void main(String[] args) {
		
		int [] pages = {1,2,3,4,5,6,7,8,9};
		int numberOfWorkers =3;
		System.out.println(partition(pages,numberOfWorkers));
	}
}