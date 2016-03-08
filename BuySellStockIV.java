import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BuySellStockIV {

    public static int maxProfit(int k, int[] prices) {
    
	    if(prices == null || prices.length==0){
	        return 0;
	    }


	    int N = prices.length;

	    if(k >= N){
	    	maxProfit2(prices);
	    }
	    int [][] local = new int[N][k+1];
	    int [][] global = new int[N][k+1];
	    
	    for(int i=1;i<N;i++){
	        int diff = prices[i]-prices[i-1];
	        for(int j=1;j<=k;j++){
	            local[i][j] = Math.max( Math.max(diff,0)+ global[i-1][j-1],local[i-1][j]+ diff);
	            global[i][j]= Math.max(local[i][j], global[i-1][j]);
	        }
	    }
	    
	    return global[N-1][k];
        
    }

    private static int maxProfit2(int [] prices) {

    	int N = prices.length;
    	int diff =0;
    	for(int i=1;i<N;i++){
    		diff += Math.max(0,(A[i]-A[i-1]));
    	}

    	return diff;

    }

    public static void main(String[] args) {
    	
    	int k = 1000000000;

    	
    	try{
    		BufferedReader buf = new BufferedReader( new FileReader( new File("input.txt")));
    		String lines = null;
    		while( (lines=buf.readLine())!=null ){    			 
    			String[] lineArray = lines.split(",");
    			int [] array = new int[lineArray.length];
    			for(int i=0;i< lineArray.length;i++){
    				array[i]= Integer.parseInt(lineArray[i]);
    				System.out.println("adding price "+lineArray[i]);
    			}

    			System.out.println(" k "+k+"  days "+lineArray.length);
    			System.out.println(maxProfit(k,array));		
    		}

    	}catch(FileNotFoundException e){
    		System.out.println(e);
    	}catch(IOException io){
    		System.out.println(io);
    	}
    	
    	//
    }
}