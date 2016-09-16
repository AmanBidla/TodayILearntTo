import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class CoinExchange{


	public static int minimumNumberOfWays(int []deno, int amount){
		int dp[] = new int[amount+1];
		dp[0]=0;
		int []prevCoin = new int[amount+1];
		//System.out.println("Sum\t Min\t coin added");
		for(int j=1;j<=amount;j++){
			dp[j]=Integer.MAX_VALUE;
			for(int i=0;i<deno.length;i++){
				if(deno[i]<=j && (1+dp[j-deno[i]] < dp[j]) ){				
					dp[j]=1+dp[j-deno[i]];
					//System.out.println(j+"\t "+dp[j]+"\t "+deno[i]);
					prevCoin[j]=deno[i];
				}
					
			}
		}

		int result = dp[amount];

		List<Integer> coinsAdded = new ArrayList<Integer>();
		for(int i=amount;i>=1;){
			coinsAdded.add(prevCoin[i]);
			int j=i;
			i=amount-prevCoin[i];
			amount = amount - prevCoin[j];
		}
		 
		System.out.println( Arrays.toString(coinsAdded.toArray()));

		//showdp(dp);

 
		return result;
	}

	private static void showdp(int []dp){
		for(int i=0;i<dp.length;i++){
			System.out.print(dp[i]+"\t");
		}
		System.out.println("");
	}
	 

    public static int totalNumberOfWays (int sum, int[] array){

    	int N = array.length;
    	int [][] dp = new int[sum+1][N];

    	for(int i=0;i<N;i++){
    		dp[0][i] = 1;
    	}
    	for(int i=1;i<=sum;i++){
    		for(int j=0;j<N;j++){
    			int x = i>=array[j] ? dp[i-array[j]][j] : 0;
    			int y = j>0 ? dp[i][j-1] : 0;
    			dp[i][j] = x+y;
    		}
    	}
    	return dp[sum][N-1];
    }

	public static void main(String[] args) {
		    
		    int d[] = {1, 5, 10, 25};		    
			//int []d ={1, 3,  5};
		    int amount = 67; 
		     
		    System.out.println("min number of ways is "+minimumNumberOfWays(d,amount));
		    System.out.println("total number of ways is "+totalNumberOfWays(amount,d));
		    //assert(coins(d,amount)==6);
		    /*amount=4;
		    System.out.println("number of ways is "+coins(d,amount));
		    assert(coins(d,amount)==4); */
		    //int numWays = allNumberofWaysDynamicProgramming(amount,d);
		    //System.out.println("number of ways is "+numWays);
		    //numWays = allNumberofWaysRecursive(amount,d);
		    //System.out.println("number of ways is "+numWays);
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