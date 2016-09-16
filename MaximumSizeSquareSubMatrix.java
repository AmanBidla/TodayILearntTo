public class MaximumSizeSquareSubMatrix {

	public static void main(String[] args) {
		
		int [][] matrix = { {0, 1, 1, 0, 1}, 
                   			{1, 1, 0, 1, 0}, 
                   			{0, 1, 1, 1, 0},
                   			{1, 1, 1, 1, 0},
                   			{1, 1, 1, 1, 1},
                   			{0, 0, 0, 0, 0}
                   		  };

		int result = maxSizeSquareSubMatrix(matrix);
		System.out.println("max size is "+result);                   		  
	}

	private static int maxSizeSquareSubMatrix(int [][] matrix){


		int M = matrix.length;
		int N = matrix[0].length;

		int [][] dp = new int[M][N];

		for(int i=0;i<N;i++){
			dp[0][i] = matrix[0][i];
		}

		for(int i=0;i<M;i++){
			dp[i][0] = matrix[i][0];
		}

		for(int i=1;i<M;i++){
			for(int j=1;j<N;j++){
				if(matrix[i][j]==0){
					dp[i][j]=0;
				} else {
					dp[i][j] = Math.min( dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) +1;
				}
			}
		}

		int maxValue=Integer.MIN_VALUE, minI=0, minJ=0;

		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(maxValue<dp[i][j]){
					maxValue = dp[i][j];
					minI = i;
					minJ = j;
				}
			}
		}
		//System.out.println("maxValue : "+maxValue+" minI : "+minI+" minJ : "+minJ);
		for(int i=minI;i>(minI-maxValue);i--){
			for(int j=minJ;j>(minJ-maxValue);j--){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		return maxValue;
	}




}