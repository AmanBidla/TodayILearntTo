package com.sreeprasad.algorithms.makingChange;


public class MakingChange {

    public static void main(String[] args) {

        int[]array ={1,2,3};
        int sum = 4;
        makeChange(array, sum);

    }

    public static void makeChange(int []deno, int sum) {

        int N = deno.length;
        int[][] dp= new int[N+1][sum+1];

        for(int i=0;i<=N;i++) {
            dp[i][0] =0;
        }

        for(int i=0;i<=sum;i++) {
            dp[0][i]=i;
        }

        for(int i=1;i<N;i++) {
            for(int j=1;j<=sum;j++) {
                if(j<deno[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-deno[i]]+1);
                }
            }
        }

        System.out.println(dp[N][sum]+" min coins ");

        printMatrix(sum, N, dp);

        int i=N-1,j=sum;
        printCoins(i,j,dp,deno,sum);
    }

    private static void printMatrix(int sum, int n, int[][] dp) {
        for(int i=0;i<= n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printCoins(int i, int j, int [][]dp, int []array,int sum){

        if(i<0|| j<0){
            return;
        }
        //System.out.println("i "+i+" j "+j);
        if(dp[i][j]!=0) {
            //System.out.println(">> here");
            int value = dp[i][j];
            while(dp[i][j]==value){
                if(array[i]<=sum) {
                    System.out.print(array[i] + " ");
                    //System.out.println(" i "+i+" j "+j);
                    if(sum-array[i]==0){
                        System.out.println();
                        return;
                    }
                    printCoins(i, sum-array[i], dp, array, sum-array[i]);
                }
                i--;
            }
        }
    }
}



