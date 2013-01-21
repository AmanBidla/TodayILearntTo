

public class LCS {	


	public static void main(String []ad){
    	System.out.println("LCS = "+LCS("GTATATATATACC","GTTCCTAATA"));
	}

	
	public static int LCS(String x, String y){
		
		int M = x.length();
		int N = y.length();
		
		int [][] table = new int[M+1][N+1];
		
		for(int i=0;i<M;i++){
 			table[i][0]=0;
		}
		
		for(int j=0;j<N;j++){
			table[0][j]=0;
		}
		
		for(int i=1;i<=M;i++){
			for(int j=1;j<=N;j++){
				if(x.charAt(i-1)==y.charAt(j-1)){
					table[i][j]=table[i-1][j-1]+1;
				}else{
					table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
				}
			}
		}
		
		return table[M][N];
		
		
		
	}
	
	
}