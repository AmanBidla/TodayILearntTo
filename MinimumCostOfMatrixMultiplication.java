public class  MinimumCostOfMatrixMultiplication {


	private static int minMatrixMult(int[] matrices) {

		int N = matrices.length;
		int [][] dp = new int[N][N]; // dp[i][j] cost of multi matrices[i...j]
		int [][] seq = new int[N][N]; // to seq[i][j] denotes k for optimal splitting in 
									  // computing matrices[i..j]=matrices[i...k] * matrices[k+1....j]


		for(int i=1;i<N;i++){
			dp[i][i]=0;
		}

		int q;

		for(int L=2;L<N;L++){
			for(int i=1;i<N-L+1;i++){
				int j=(i+L-1);
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					q = dp[i][k]+dp[k+1][j]+ (matrices[i-1]*matrices[k]*matrices[j]);
					if(q<dp[i][j]){
						dp[i][j] =q;
						seq[i][j] = k;
					}
				}
			}
		}

		String result = recoverAndPrint(seq,0,N-1,matrices);
		System.out.println(result);
		return dp[1][N-1];

	}

  
	private static String recoverAndPrint(int [][] seq,int i, int j, int []matrices){
		 String S="";
		 if(i==j){
		 			 	 
		 	if((i+1)==matrices.length){
		 		S = "("+matrices[i-1]+"*"+matrices[i]+")";
		 	}else if(i>=1) {
		 		S = "("+matrices[i]+"*"+matrices[i+1]+")";
		 	}
	
		 } else {

		 	int k = seq[i][j];
 
		 	String X = recoverAndPrint(seq,i,k,matrices);
		 	String Y = recoverAndPrint(seq,k+1,j,matrices);

		 	if(X.length()==0 && Y.length()==0){
		 		 return S;
		 	} else if(X.length()==0){
		  
		 		S =Y;
		 	} else if(Y.length()==0){

		 		S =X;		 		
		 	} else {
		 		
		 		S = "("+X+"*"+Y+")";		 	
		 	}
		 	 
		
		 }
		 return S;


	}

	public static void main(String[] args) {
 


		int [] matrices = {40, 20, 30, 10, 30} ;
		int result = minMatrixMult(matrices);
		System.out.println(result);
		/*
		int [] another = {10, 20, 30, 40, 30} ;
		result = minMatrixMult(another);
		System.out.println(result);*/
	}
}