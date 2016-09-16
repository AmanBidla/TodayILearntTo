public class TextJustificationAnotherApproach {


	static int minSpaceCost(String[] strArr, int lineWidth) {

        int N = strArr.length;
        int [] dp = new int[N];
        minSpace(dp,strArr,lineWidth);
        for(int i=0;i<N;i++) {
        	System.out.print(dp[i]+" ");
        }
        System.out.println();
        return -1;
         
    }

    private static void minSpace(int[]dp, String[]array, int LEN) {

        int N = array.length;
        int cost=0;
        
        for(int i=0;i<N;i++){
            
            cost = LEN-array[i].length();
            dp[i]= Math.min(dp[i], ((i-1)<0)?0:dp[i-1])+(1<<cost);
            for(int j=i-1;j>=0;j--){
                cost = cost-(array[j].length()+1);
                if (cost<0) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i],((j-1)<0)?0:dp[j-1])+(1<<cost);
                }
            }
            
        }
    }

    public static void main(String[] args) {
    	
    	String S = "Geeks for geeks presents word wrap problem";
    	int LEN = 15;
    	int result = minSpaceCost(S.split(" "),LEN);
    	System.out.println(result);
    }


}