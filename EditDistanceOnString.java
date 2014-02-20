import java.lang.Math;
public class EditDistanceOnString {


	private String x=null,y=null;

	public static void main(String[] args) {
		EditDistanceOnString s = new EditDistanceOnString();
		String x="SNOWY";
		String y="SUNNY";
		System.out.println(s.editDistance(x,y));
		;
		
		System.out.println(s.knapSack());;
		s.test();
	}

 	public int knapSack(){
		int N =4;
		int W=10;

		int [] weight= new int [N+1];
		int [] value= new int [N+1];


		int [] allWeightValues ={6,3,4,2};
		int [] allValues ={30,14,16,9};

		for(int i =1;i<weight.length;i++)
		{
			weight[i]=allWeightValues[i-1];
			value[i]=allValues[i-1];
		}


		//System.out.println("N is "+N+" W is "+ W);

		//boolean [][] keepOrDont = new boolean [N+1][W+1];
		int [][] dp = new int [N+1][W+1];

		//System.out.println("row length is "+dp.length);
		//System.out.println("col length is "+dp[0].length);
		 
		for(int i=0;i<W+1;i++)
		{
			dp[0][i]=0;
		}

		
		for(int i=1;i<=N;i++)
		{
			for(int w=0;w<=W;w++)
			{
				if( weight[i]> w)
				{

					dp[i][w] = dp[i-1][w];
					//System.out.println("i is "+i+" w is "+w+" and cell value is "+dp[i][w]);


				}else{

					dp[i][w] = Math.max( dp[i-1][w] , value[i]+ dp[i-1][ w-weight[i]]);
					//System.out.println("i is "+i+" w is "+w+" and cell value is "+dp[i][w]);
					
				}

			}
		}

		//show(dp,N+1,W+1);
		return dp[N][W];


	}

	public void show(int[][] dp,int N, int W)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<W;j++)
			{
				System.out.print(dp[i][j]+"");
			}
			System.out.println("");
		}
	}


	public void test (){


		int N=4;
		int W=10;
 
		int [] weight =new int [N+1];
		int [] weightValue = {6,3,4,2};
		int [] value = new int[N+1];
		int [] valueArray ={30,14,16,9};
		boolean [] []sol = new boolean [N+1][W+1];
		
		for(int i=0;i<N;i++)
		{
			/*value[i]=(int)Math.random()*17;
			weight[i]=(int)Math.random()*23;*/
			value[i]= valueArray[i];
			weight[i]=weightValue[i];

		}

		int [][] dp =  new int [N+1][W+1];

		for(int i=1;i<=N;i++){
			for(int w=0;w<=W;w++){
				
				int option1= dp[i-1][w];

				int option2=Integer.MIN_VALUE;
				if(weight[i]<=w) 
					option2=(value[i]+ dp[i][w-weight[i]]);

				dp[i][w] = Math.max(option1,option2);
				sol[i][w]= (option1>option2);

			}
		}

		boolean []take= new boolean[N+1];
		for(int i=N,w=W;i>0;i--)
		{
 			if(sol[i][w]) {
				take[i]=true;
				w=w-weight[i];
			}else
				take[i]=false;
		}

		for(int i=0;i<N;i++){
			System.out.println("item of weight "+weight[i]+" of value "+value[i]+"  - "+take[i]);
		}

		System.out.println("max is "+dp[N][W]);

	}

	public int editDistance(String x, String y)
	{
		int M =x.length();
		int N = y.length();

		int [][] dp = new int [M][N];

		for(int i=0;i<M;i++)
		{
			dp[0][i]= i;
		}

		for(int j=0;j<N;j++)
		{
			dp[j][0]=j;
		}

		for(int i=1;i<M;i++)
		{
			for(int j=1;j<N;j++)
			{
 				dp[i][j]= Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+(x.charAt(i)==y.charAt(j)?0:1));
			}
			
		}

		

		return dp[M-1][N-1];

	}
}