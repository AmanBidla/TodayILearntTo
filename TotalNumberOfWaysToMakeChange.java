public class TotalNumberOfWaysToMakeChange{

	

	 private static void solve(int sum, int[]deno){
        if(sum==0){
            System.out.println("0");
            return;
        }
        
        int [][] dp = new int[sum+1][deno.length];
        
        for(int i=0;i<deno.length;i++){
            dp[0][i]=1;
            dp[1][i]=1;
         }
        
        for(int i=2;i<sum+1;i++){
            for(int j=0;j<deno.length;j++){
                int x = ((i-deno[j]) >=0) ? (dp[i-deno[j]][j]) : 0;
                int y = (j>0)?dp[i][j-1]:0;
                dp[i][j] = x+y;
            }
        }
        show(dp);
        System.out.println(dp[sum][deno.length-1]);
    }

    private static void show(int[][] matrix){
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			System.out.print(matrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    }

    public static void main(String[] args) {
    		
    		int[]array ={1,2,3};
    		int sum = 4;
    		solve(sum, array);

	}	
}