public class DungeonAndDragon{

	public static int health(int[][] dungeon){

		int M = dungeon.length;
		int N = dungeon[0].length;

		int [][] dp = new int[M][N];

		dp[M-1][N-1] = Math.max( 1, 1- dungeon[M-1][N-1]);

		for(int j=N-2;j>=0;j--){
			dp[M-1][j] = maxOfThree(1, 1-dungeon[M-1][j], dp[M-1][j+1]- dungeon[M-1][j]);
		}

		for(int i=M-2;i>=0;i--){
			dp[i][N-1] = maxOfThree(1, 1-dungeon[i][N-1] , dp[i+1][N-1]- dungeon[i][N-1]);
		}

		

		for(int i=M-2;i>=0;i--){
			for(int j=N-2;j>=0;j--){
				dp[i][j] = maxOfThree( 1, 1-dungeon[i][j] , Math.min ( dp[i+1][j]-dungeon[i][j] ,  dp[i][j+1]-dungeon[i][j] ) );
			}
		}

		return dp[0][0];

	}

	public static int maxOfThree(int a, int b, int c){
		return Math.max(Math.max(a,b) , c );
	}

	public static void main(String[] args) {
		
		int [][] dungeon = { {-2,-3,3}, {-5,-10,1}, {10,30,-5}};

		System.out.println(health(dungeon));
	}

}