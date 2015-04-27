public class CoinExchangeCopy{



	public static  int coin(int amt, int [] deno){

		int [] dp = new int [amt+1];
		dp[0]=0;
		for(int i=1;i<=amt;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<deno.length;j++){
				if(deno[j]<=i && 1+dp[i-deno[j]] < dp[i]){
					dp[i]=1+dp[i-deno[j]];
				}
			}
		}

		return dp[amt];
	}

	public static void main(String[] args) {
		
		int amt=67;
		 
		int deno[] = {1, 5, 10, 25};

		System.out.println(coin(amt,deno));


	}
}