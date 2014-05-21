import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
 public class AllPairSubSetSum {



 private static int dynamicTotal(int[] numbers, int sum)
    {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int currentSum =0;
        for (int i = 0; i < numbers.length; i++)
        {
            currentSum += numbers[i];
            for (int j = Math.min(sum, currentSum); j >= numbers[i]; j--)
                dp[j] += dp[j - numbers[i]];
        }

        return dp[sum];
    }

     


    private static void subsetDynamicProgramming(int [] array, int sum){

        int N = array.length;
        boolean [][] dp = new boolean[sum+1][N+1];
        for(int i=0;i<=sum;i++)
            dp[i][0]=false;
        for(int i=0;i<=N;i++)
            dp[0][i]=true;
         for(int i=1;i<=sum;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=dp[i][j-1];
                if(array[j-1]<=i){
                    dp[i][j]=dp[i][j-1] || dp[i- array[j-1]][j-1];
                }
            }
        }
         int j=sum;
        for(int i=N;i>=1&&j>=0;i--){
            if(!dp[j][i-1]){
                System.out.print(array[i-1]+" ");
                j= j-array[i-1];
            }
        }
    }

     

    private static void subsetRecursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial){
        int N = numbers.size();
        int s =0;
        for(int x:partial) 
            s+=x;
        if(s>target) return;
        if(s==target){
            //System.out.println("sum of "+Arrays.toString(partial.toArray())+" = "+target);
            for(int i=0;i<partial.size();i++){
                System.out.println((i+1)+" \t"+partial.get(i));
            }
        }else{
            for(int i=0;i<N;i++){
                ArrayList<Integer> remaining = new ArrayList<Integer>();
                int n = numbers.get(i);
                for(int j=i+1;j<N;j++){
                    remaining.add(numbers.get(j));
                }
                ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
                partial_rec.add(n);
                subsetRecursive(remaining,target,partial_rec);
            }
        }
    }


public static void main(String[] args) {
    /*int [] array ={1, 3, 2, 5, 4, 9};
    int sum =9;
    int totalRecursive =0;
    System.out.println("array is "+Arrays.toString(array)+" and sum is "+sum);
    int totalNumberOfWays = dynamicAlternateive(sum,array);
    System.out.println("total number of ways to reach target "+sum+" is "+totalNumberOfWays);
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int x:array){
        numbers.add(x);
    }
    subsetRecursive(numbers,9,new ArrayList<Integer>());
    System.out.println("using dynamic programming");
    subsetDynamicProgramming(array,sum);

    */
    int [] array = {18897109, 12828837, 9461105, 6371773, 5965343, 5946800, 5582170, 5564635, 5268860, 4552402, 4335391, 4296250, 4224851, 4192887, 3439809, 3279833, 3095313, 2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 2149127, 2142508, 2134411};
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int x:array){
        numbers.add(x);
    }
    //subsetDynamicProgramming(array,100000000);
    subsetRecursive(numbers,100000000,new ArrayList<Integer>());
 

}

}