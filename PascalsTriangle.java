public class PascalsTriangle{


	public static void main(String[] args) {
		
		int N=5;
		pascalTriangleGoodFormat(N);
	}


	private static void pascalTriangleGoodFormat(int N){

		for(int i=0;i<N;i++){
			int number =1;
			System.out.format("%"+((N-i)*2)+"s","");
			for(int j=0;j<=i;j++){
				System.out.format("%4d", number);
				number =(number * (i-j)/(j+1));
			}
			System.out.println("");
		}
	}


	public static void pascal(int N){


		int [][] dp = new int[N+1][];
		dp[1] = new int [1+2];
		dp [1][1] = 1;

		for(int i=2;i<=N;i++){
			dp[i]= new int [i+2];
			for(int j=1;j<dp[i].length-1;j++){
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}

		for(int i=1;i<=N;i++){
			for(int j=1;j<dp[i].length-1;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
	}
}