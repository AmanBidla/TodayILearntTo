public class CoinGameOptimum{


	private static int dynamic(int [] array){
		int N = array.length;
		int [][] dp = new int[N][N];

		for(int i=0;i<N;i++){
			dp[i][i]=array[i];
		}

		for(int i=1;i<N;i++){
			dp[i-1][i]=Math.max(array[i-1],array[i]);
		}

		for(int i=1;i<N;i++){
			for(int j=1;j<i;j++){

				if((i!=j)&&(i!=(j+1)) && ((i+2 )<N) && ((j-2)>=0)){
	 				int option1 = Math.min(dp[i+1][j-1], dp[i+2][j])+array[i];
					int option2 = Math.min(dp[i+1][j-1], dp[i][j-2])+array[j];
					dp[i][j]= Math.max( option1, option2);
				}
			}
		}

		return dp[0][N-1];

	}

	public static void main(String[] args) {
			int [] array ={8, 15, 3, 7};
			System.out.println(dynamic(array));
	}


}