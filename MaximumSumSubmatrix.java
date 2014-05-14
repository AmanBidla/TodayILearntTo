 

public class MaximumSumSubmatrix{
	
	private static int [][] A;
	private static int N;

	public static void main(String[] args) {
		int [][] matrix = {{0, -2, -7, 0}, {9, 2, -6, 2}, {-4, 1, -4, 1},{-1, 8, 0, -2}};
 		System.out.println(" maximum sum of sub matrix is "+maxSum(matrix));
	}

	public static int  maxSum(int [][] matrix){
		int N = matrix.length;
		int [][] dp = new int[N][N];

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(j==0) dp[j][i]=matrix[j][i];
				else dp[j][i]= dp[j-1][i]+matrix[j][i];
			}
		}

		int max=matrix[0][0];
		
		int []sum = new int[N];
		int []pos = new int[N];
		int localMax=0,top=0,left=0,right=0,bottom=0;
		for(int i=0;i<N;i++){
			for(int k=i;k<N;k++){

				reset(sum);
				reset(pos);

				sum[0]= dp[k][0]-((i==0)?0:dp[i-1][0]);

				for(int j=1;j<N;j++){

					if(sum[j-1]>0){

						sum[j]=sum[j-1]+dp[k][j]-((i==0)?0:dp[i-1][j]);
						pos[j]= pos[j-1];
					
					}else{

						sum[j]=dp[k][j]-((i==0)?0:dp[i-1][j]);
						pos[j]=j;

					}

					if(sum[localMax]<sum[j]){
						localMax=j;
					}

				}// kandane ends here


				if(max<sum[localMax]){

					max=sum[localMax];
					top = i;
					left =pos[localMax];
					right = localMax;
					bottom = k;
				}

			}
		}

		int [][] output = new int [bottom -top +1][right-left+1];
		
		for(int i=top,l=0;i<=bottom;i++,l++){
			for(int j=left,k=0;j<=right;j++,k++){
				output[l][k]= matrix[i][j];	
			}
		}

		show(output);

		return max;

		 
	}

	private static void reset(int [] temp){

		for(int i=0;i<N;i++){
			temp[i]=0;
		}

	}
	private static void show(int [][] output){
 		for(int i=0;i<output.length;i++){
			for(int j=0;j<output[0].length;j++){
				System.out.print(output[i][j]+" ");
			}
			System.out.println("");
		}
	}
 
}