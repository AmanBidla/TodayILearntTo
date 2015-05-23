import java.util.Arrays;

public class SparseArrayRangeMinimumQuery{

	private static int[] fastLookup;
	private static int[] powerArray;
	private static int [][] dp;
	private static int [] A;

	public static void main(String[] args) {
		 
		int [] array  = {31,41,59,26,53,58,97,93};
		A = array;
		System.out.println("original array "+Arrays.toString(array));
		System.out.println();
		sparseArray(A);
		int i=0,j=A.length-1;
		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[smallest(i,j)]);		 

		i=4;j=array.length-1;
		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[smallest(i,j)]);
		 
		i=1;j=2;
		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[smallest(i,j)]);
		 
	}

	public static void sparseArray(int []A){
		int N = A.length;
		fastLookup(N);
		power(N);
		int logN = fastLookup[N];
		dp = new int[N][logN+1];

		for(int i=0;i<N;i++){
			dp[i][0]=i;
		}

		for(int j=1;(1<<j)<=N;j++){
			for(int i=0;(i+(1<<j)-1)<N;i++){
				int l = dp[i][j-1];
				int h = dp[i+(1<<(j-1))][j-1];

				if(A[l]<A[h]) 	dp[i][j]=l;
				else    		dp[i][j]=h;	
			}
		}
 
	}

	public static int smallest(int i , int j){

		int col = fastLookup[j-i+1];
		int p = powerArray[col];
		int s = j-p+1;

		if(i==s) return dp[i][col];

		

		int l = dp[i][col];
		int h = dp[s][col];

		if(A[l]<A[h]) 	return l;
		else 			return h;
	}

 	public static void power(int N){

 		powerArray = new int[N+1];
 		int p=1;

 		for(int i=1;i<=N;i++){
 			p*=2;
 			powerArray[i]=p;
 		}

 	}

 	public static void fastLookup(int N){

 		fastLookup = new int[N+1];
 		int count =0;
 		int nextPowerOfTwo=2;

 		for(int i=2;i<=N;i++){

 			if(i==nextPowerOfTwo){
 				nextPowerOfTwo*=2;
 				count++;
 			}

 			fastLookup[i]=count;
 		}
 	}
}