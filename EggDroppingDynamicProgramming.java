public class EggDroppingDynamicProgramming {


	public static  int minFloors(int numberOfEggs, int numberOfFloors) {


		if(numberOfFloors==0 || numberOfFloors==1){
			return 1;
		}

		if(numberOfEggs==1){
			return numberOfFloors;
		}

		int [][] dp = new int[numberOfEggs+1] [numberOfFloors+1];
		// dp [number of eggs][number of floors] = 1 + Math.min(Math.max( dp[number of eggs-1][x floor -1], dp[number of eggs][k - x floors])) 
		// where x ∈ {1,2,...K} where K is the total number of floors

		// if there are 0 floors, number of min floors to determine egg break is 0
		// if there are 1 floor, number of min floors to determine egg break is 1
		for(int i=1;i<=numberOfEggs;i++) {
			dp[i][0] =0;
			dp[i][1] = 1;
		}

		// if there is only 1 egg, then you have to try all i floors and check at which floor egg breaks.
		for(int i=1;i<=numberOfFloors;i++){
			dp[1][i] = i;
		}

		for(int i=2;i<=numberOfEggs;i++){
			for(int j=2;j<=numberOfFloors;j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int x=2;x<=j;x++){
					int minFloors = 1+ Math.max(dp[i-1][x-1], dp[i][j-x]);
					if (minFloors<dp[i][j]) {
						dp[i][j] = minFloors;
					}
				}	
			}
		}

		return dp[numberOfEggs][numberOfFloors];

	}

	public static void main(String[] args) {
		
		int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+minFloors(n, k)); 
	}


}