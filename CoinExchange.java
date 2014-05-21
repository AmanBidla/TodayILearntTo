public class CoinExchange{


	public static int minimumNumberOfWays(int []deno, int amount){
		int dp[] = new int[amount+1];
		dp[0]=0;
		for(int j=1;j<=amount;j++){
			dp[j]=Integer.MAX_VALUE;
			for(int i=0;i<deno.length;i++){
				if(deno[i]<=j && (1+dp[j-deno[i]] < dp[j]) )
					dp[j]=1+dp[j-deno[i]];
			}
		}

		//showdp(dp);

		return dp[amount];
	}

	private static void showdp(int []dp){
		for(int i=0;i<dp.length;i++){
			System.out.print(dp[i]+"\t");
		}
		System.out.println("");
	}

	public static int allNumberofWaysRecursive(int amount, int coins[]) {
    return findCombinationsCount(amount, coins, 0);
}

	public static int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
	    if (amount == 0)
	        return 1;
	    else if (amount < 0 || coins.length == checkFromIndex)
	        return 0;
	    else {
	        int withFirstCoin = findCombinationsCount(amount-coins[checkFromIndex  ], coins, checkFromIndex);
	        int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex+1);
	        return withFirstCoin + withoutFirstCoin;
	    }
	}
	public static int allNumberofWaysDynamicProgramming(int sum, int vals[]) {
        if (sum < 0) {
            return 0;
        }
        if (vals == null || vals.length == 0) {
            return 0;
        }

        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < vals.length; ++i) {
            for (int j = vals[i]; j <= sum; ++j) {
                dp[j] += dp[j - vals[i]];
            }
        }
        return dp[sum];
    }

	public static void main(String[] args) {
		    
		    int d[] = {1, 5, 10, 25};
		    int amount = 67; 
		    System.out.println("number of ways is "+minimumNumberOfWays(d,amount));
		    //assert(coins(d,amount)==6);
		    /*amount=4;
		    System.out.println("number of ways is "+coins(d,amount));
		    assert(coins(d,amount)==4); */
		    int numWays = allNumberofWaysDynamicProgramming(amount,d);
		    System.out.println("number of ways is "+numWays);
		    numWays = allNumberofWaysRecursive(amount,d);
		    System.out.println("number of ways is "+numWays);
			/*
		    int val[]={1,6,7};
		    int [] array ={1, 3, 2, 5, 4, 9};
		    int numWays = findCombinationsCount(9,array);
		    System.out.println("number of ways is "+numWays);
		    numWays = findCombinationsCountRecursive(9,array);
		    System.out.println("number of ways is "+numWays);
			System.out.println("number of ways is "+coins(array,9));
		    /*int [] d= {1,4,16,64};
		    int amount = 18;
		    System.out.println("number of ways is "+coins(d,amount));*/




	}

}