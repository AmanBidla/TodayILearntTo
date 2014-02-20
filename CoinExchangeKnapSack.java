public class CoinExchangeKnapSack{


	public static void main(String[] args) {
		 
			knapsack();
		
	}

	public static void knapsack(){

		/* here N is the number of coins */
		/* W is amount for which you want to make change */

		int [] weight = {1,5,10,25};
		  
		int amount =67;
	
		solve(weight,amount);
		
		//makeChange(weight,amount);

	}

	public static void solve(int []deno,int amount){

		int N = amount;
 
		int [] dp = new int[N+1];
 		int [] sol = new int[N+1];
 
		for(int i=0;i<=N;i++)
			dp[i]=Integer.MAX_VALUE;

		dp[0]=0;
		int W = deno.length;

 		for(int n=1;n<=N;n++){
			int option1 = Integer.MAX_VALUE;
			for(int w=0;w<W;w++){
				if(deno[w]<=n && ((1+dp[n-deno[w]]) < dp[n] ) ){
					//System.out.println("w-deno[n] "+(n-deno[w]));
					int option2= 1+dp[n-deno[w]];
					dp[n] = Math.min(option1,option2);
					sol[n]=deno[w];
 				}
			} 			 
 		}
 		
 		printCoins(sol,amount);
  		
	} 

	public static void printCoins(int[]sol, int amount){
		if(amount>0){
			printCoins(sol,amount-sol[amount]);
			System.out.println(sol[amount]);
		}
 
	}
 
 	

}