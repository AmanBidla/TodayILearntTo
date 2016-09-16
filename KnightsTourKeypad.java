import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class KnightsTourKeypad {

	private static int total=0;
	  

	public static void main(String[] args) {
		
		int result = numPhoneNumbers(1,5);
		System.out.println(result);
	}

	private static int numPhoneNumbers(int startingNum, int remainingNum){
          
        int[][] nextMoves = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{1,7,0},{2,6},{1,3},{2,4}};
        int N = remainingNum;         
        int [][] dp = new int[N][N];
         
        return numbers(startingNum, remainingNum,nextMoves,dp);
         
    }
 
        

    private static int numbers(int startingNum, int remainingNum,int [][] nextMoves, int[][]dp ) {
       	
        int sum =0;

		System.out.println("startingNum : "+startingNum+" remainingNum : "+remainingNum);        

        if(startingNum<dp.length){ 
        	System.out.println("dp["+(remainingNum-1)+"]["+startingNum+"]");
        	if(dp[remainingNum-1][startingNum]>0) {  
         		return dp[remainingNum-1][startingNum];
         	}
        }
        
 


        if(remainingNum==1){
             return 1;
         }
          
              	 
        for(int nextNum : nextMoves[startingNum]) {
        	//System.out.println ("next num "+nextNum);
            sum+=numbers(nextNum,remainingNum-1,nextMoves,dp);
        }
        
       System.out.println("startingNum : "+startingNum+" remainingNum : "+remainingNum+" sum : "+sum);        
       	if(startingNum<dp.length){ 
        	dp[remainingNum-1][startingNum]=sum;
    	}

        return sum;
    }
    
     
}