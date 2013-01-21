public class EditDistance {
	
	
	public static void main(String abd[]){
		System.out.println("edit distance = "+editDistance("cat","bat"));
	}
	
	public static int editDistance(String x, String y){
		
	 	int M = x.length();
		int N = y.length();
		
		int table[][]= new int[M+1][N+1];
		
		table[0][0]=0;
		
		for(int i=1;i<=M;i++){
			table[i][0]=i;
		}
		for(int j=1;j<=N;j++){
			table[0][j]=j;
		}
		
		int diff=0;
		for(int i=1;i<=M;i++){
			for(int j=1;j<=N;j++){
				if(x.charAt(i-1)!=y.charAt(j-1)){
					diff=1;
				}
				
				int back= table[i][j-1]+1;
				int top = table[i-1][j]+1;
				int diag = table[i-1][j-1]+diff;
				diff=0;
				int minOne = Math.min(back,top);
				int minTwo = Math.min(minOne,diag);
				table[i][j]=minTwo;
			}
		}
	
			
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println("");
		}
		
		return table[M-1][N-1];
		
	}
	
	
}