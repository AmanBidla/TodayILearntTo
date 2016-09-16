public class PhonePadKnightsTour {


	private static int [][] nextMoves = 
	{

		{4,6},{6,8},{7,9},
		{4,8},{0,3,9},{},
		{1,7,0},{2,6},{1,3},
			{2,4}
	};

	public static int knightsTour(int start, int length){

		int [][] dp  = new int[length][length];

		return count(start, length, dp, nextMoves); 

	}

	private static int count(int start, int length, int [][] dp, int [][] nextMoves) {

		int sum=0;
		if(length==1){
			return 1;
		}

		if(start<length && dp[length-1][start]>0){
			return dp[length-1][start];
		}

		for(int i : nextMoves[start]) {
			sum += count(i, length-1, dp, nextMoves);
		}

		if(start<length){
			dp[length-1][start] = sum;
		}

		return sum;

	}

	public static void main(String[] args) {
		
		System.out.println(knightsTour(1,10));
	}
}