public class TextJustification {

    public int [] justify(int array[], int M) {
        
         int N = array.length;
         int [][] extra = new int[N+1][N+1]; 
         // extra[i][j] = number of extra spaces if words from i to j are put in single line.

         int [][] dp = new int[N+1][N+1];
         // dp[i][j] = cost of putting words from i to j in single line.

         int []cost = new int[N+1];
         // cost[i] = optimum cost of putting i words in single line.

         int [] p = new int[N+1];
         // used to back track and print solution.

         for(int i=1;i<=N;i++){
            extra[i][i] = M - array[i-1];
            for(int j=i+1;j<=N;j++){
                extra[i][j] = extra[i][j-1]-array[j-1]-1;
            }
         }

         for(int i=1;i<=N;i++){
            for(int j=i;j<=N;j++) {
                
                if (extra[i][j]<0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (extra[i][j] >= 0 && j==N){
                    dp[i][j] =0;
                } else {
                    dp[i][j] = extra[i][j]*extra[i][j];
                }
            }
         }

         cost[0] =0;

         for (int j=1;j<=N;j++) {
            cost[j] = Integer.MAX_VALUE;
            for (int i=1;i<=j;i++) {
                if(cost[i-1]!= Integer.MAX_VALUE
                    && dp[i][j] != Integer.MAX_VALUE
                    && cost[j]> cost[i-1]+ dp[i][j]) {

                    cost[j] = cost[i-1]+ dp[i][j];
                    p[j] = i;
                }
            }
         }
        System.out.printf("printing solution \n"); 
        printSolution(p,N);
        return p;

    }

    private static int printSolution(int[] P, int N) {
        int k;
        System.out.printf("P[N] %d \n",P[N]);
        if(P[N]==1){
            k= 1;
        } else {
            k= printSolution(P,P[N]-1)+1;
        }
        System.out.printf("Line # %d has words from %d to %d \n", k, P[N],N);
        return k;
    }
    
    public static void main(String args[]){
        //String S = "hi samueljohnse, your uber is arriving now!";
        String S =  "Geeks for Geeks presents word wrap problem" ;
        String words1[] = S.split(" ");
        TextJustification awl = new TextJustification();
        int [] array = new int[words1.length];
        for(int i=0;i<array.length;i++){
            array[i] = words1[i].length();
        }
        int [] p = awl.justify(array, 15);
        printSolution(p,words1,words1.length);
    }

    private static int printSolution(int []P,String[] words, int N){
        int k;
        if(P[N]==1){
            k=1;
        } else {
            k = printSolution(P,words,P[N]-1)+1;
        }
        for(int i=P[N]-1;i<N;i++){
            System.out.print(words[i]);
            if(i+1 != N){
                System.out.print(" ");
            }
        }
        System.out.println();
        return k;
    }
}