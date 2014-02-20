public class KnapSack{


	public static void main(String[] args) {
		
		if(args.length==0) System.out.println("please enter N (max items) and W(max weight)");
		else{
			int N = Integer.parseInt(args[0]);
			int W = Integer.parseInt(args[1]);
			knapsack(N,W);
		}
	}

	public static void knapsack(int N, int W){

		int [] profit = new int[N+1];
		int [] weight = new int[N+1];

		for(int i=0;i<=N;i++){
			profit[i]=(int) (Math.random()*1000);
			weight[i]=(int) (Math.random()*W);
		}


	    System.out.println("item "+"\t"+"profit"+"\t"+"weight");
	    for(int i=0;i<=N;i++)
	    	System.out.println(i+"\t"+profit[i]+"\t"+weight[i]);

		solve(profit, weight,N,W);

	}

	public static void solve(int []profit, int[]weight, int N, int W){

		int [][] dp  = new  int[N+1][W+1];
		boolean [][] sol =  new boolean[N+1][W+1];

		for(int n=1;n<=N;n++){
			for(int w=0;w<=W;w++){
				int option1 = dp[n-1][w];
				int option2 = Integer.MIN_VALUE;

				if(weight[n]<=w)
					option2=dp[n-1][w-weight[n]]+profit[n];

				dp[n][w] = Math.max(option1, option2);
				sol[n][w] = option2 > option1;
			}
		}

		boolean [] take = new boolean[N+1];
		int totalValue =0;
		for(int n=N,w=W;n>=0;n--){
			if(sol[n][w]) {
				take[n]=true;
				w=W-weight[n];				 
			}else
				take[n]=false;
		}

		System.out.println("item "+"\t"+"profit"+"\t"+"weight"+"\t"+"take"+"\t"+"total Value");
		for(int i=0;i<=N;i++)
			System.out.println(i+"\t"+profit[i]+"\t"+weight[i]+"\t"+take[i]+"\t"+((take[i])?(totalValue+=profit[i]):0));

		System.out.println("total value is "+totalValue);
		


	}

}