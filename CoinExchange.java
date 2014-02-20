public class CoinExchange{


	public static int coins(int []deno, int amount){
		int dp[] = new int[amount+1];
		dp[0]=0;
		for(int j=1;j<=amount;j++){
			dp[j]=Integer.MAX_VALUE;
			for(int i=0;i<deno.length;i++){
				if(deno[i]<=j && (1+dp[j-deno[i]] < dp[j]) )
					dp[j]=1+dp[j-deno[i]];
			}
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		    int d[] = {1, 5, 10, 25};
		    int amount = 67;
		    System.out.println("number of ways is "+coins(d,amount));
		    assert(coins(d,amount)==6);
		    amount=4;
		    System.out.println("number of ways is "+coins(d,amount));
		    assert(coins(d,amount)==4);


	}

}