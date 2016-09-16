public class MITTextJustification {

 
	private static String SPACE =" ";
	public static void main(String[] args) {
		
		String S =  "Geeks for Geeks presents word wrap problem";
		System.out.println(S);		
		justify( S.split(" "), 15);
		//String [] words= {"Tushar","likes","to","write","code","at", "free", "time"};
		//justify( words, 12);
	}

	public static void justify(String []words, int screenLength) {

		int N = words.length;
		int [] dp = new int[N+1];
		int []parent = new int[N];



		for(int i=0;i<N;i++){
			dp[i]= badness(i+1,N,words,screenLength);
		}
		dp[N]=0; 

		for(int i=N-1;i>=0;i--) {			 
			for(int j=i+1;j<N;j++) {
				int cost = badness(i,j,words,screenLength);
				System.out.println("cost "+cost+" dp["+j+"] = "+dp[j]);				 
				if((cost + dp[j]) < dp[i] ){
					dp[i] = cost + dp[j];
					parent[i] = j;
					System.out.println("parent of "+i+" is at "+j);
				}
			}
		}
		/*int start=0; 
		for(int i=0;i<N;) {
			int j= parent[i];
			System.out.println(" parent of "+i+" is "+j);
			for(int k=i;k<=j;k++) {			 
					System.out.print(words[k]+" ");

			}	 		
			i=j;
			start=j+1;
			//System.out.println(); 			 
		}*/

	}

 	

	public static void costRecu(int i, int j, String[] word, int screenLength, int[][]mem) {

		if (mem[i][j]!=0) return mem[i][j];
		if(i==words.length) return 0;
		int cost = badness(i+1,N+1,words,screenLength);
		for(int k=i+1;k<N;k++){
			mem[i][j]= Math.min(mem[i][j],costRecu(i, k, word, screenLength,mem));	
			 		 
		}

		 

	}


	private static int badness(int start, int end, String[] words, int screenLength) {
		int totalLength=0;
		for(int i=start;i<end;i++) {
			totalLength += words[i].length();
			totalLength += SPACE.length();
		}
		if(totalLength > screenLength) return 100000;
		else {
			int cost =  (screenLength-totalLength);
			return cost * cost * cost;	
		}
		
	}
}