public class RangeMinimumTemp{



	public static void create(int []A, int [][] M){

		int N = A.length;		 
		int i, j;
 		System.out.println("M breath "+M[0].length);
   
  //initialize M for the intervals with length 1
      for (i = 0; i < N; i++)
          M[i][0] = i;
  //compute values from smaller to bigger intervals
      	for (j = 1; 1 << j <= N; j++)
          	for (i = 0; i + (1 << j) - 1 < N; i++)	{
              if (A[M[i][j - 1]] < A[M[i + (1 << (j - 1))][j - 1]])
                  M[i][j] = M[i][j - 1];
              else
                  M[i][j] = M[i + (1 << (j - 1))][j - 1];  		  
          }

          for(int l=0;l<N;l++){
          	for(int o=0;o<5;o++){
          		System.out.print(M[l][o]+" ");
          	}
          	System.out.println("");
          }

	}

	
 
    public static int RMQ(int[][] M, int[] A, int i, int j) {
 
        int k = (int) Math.log(j - i + 1);
        //int k = log2(j-i+1);
        if (A[M[i][k]] <= A[M[j - (1 << k) + 1][k]])
            return M[i][k];
        else
            return M[j - (1 << k) + 1][k];
    }


    public static void main(String[] args) {
    	 int[] A = { 2, 4, 3, 1, 6, 7, 8, 9, 1, 7 };
    	 int N = A.length;

		 int [][] M = new int [N][5];	
    	 create(A,M);

    	 System.out.println(RMQ(M,A,0,2));

    }





	public static int log2(int N){
    	if(N <= 0) throw new IllegalArgumentException();
    	return 31 - Integer.numberOfLeadingZeros(N);
	}
}