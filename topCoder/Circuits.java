public class Circuits{
	/* initalize variable */
	
	private static int N,M,j,i;
	private static String inner,innerCost;
	private static String innerCircuit[],innerCircuitCost[];
	private static boolean adj[][];
	private static int innerCircuitAdj[][];
	
	public static void main(String abd[]){
		
	/*String [] connects = {"1 2","2",""};
	String [] costs = {"5 3","7",""};*/
	
	/*String [] connects = {"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""};
	String [] costs = {"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""};*/
	
	/*String [] connects ={"1","2","3","","5","6","7",""};
	 String [] costs ={"2","2","2","","3","3","3",""};*/
	
	/*String [] connects ={"","2 3 5","4 5","5 6","7","7 8","8 9","10",
		 "10 11 12","11","12","12",""};
 	String [] costs ={"","3 2 9","2 4","6 9","3","1 2","1 2","5",
		 "5 6 9","2","5","3",""};*/
	
	String [] connects =	{"","2 3","3 4 5","4 6","5 6","7","5 7",""};
 	String [] costs ={"","30 50","19 6 40","12 10","35 23","8","11 20",""};
	
	
	System.out.println(howFurther(connects,costs));	
	
	}
	
	
	public static int howFurther(String [] connects,String [] costs){
		
		/* find the total length of circuits */
		N=connects.length;
		
		/* initialize the adjacency matrix */
		adj=new boolean[N][N];
		
		/* initialze the cost for circuits */
		innerCircuitAdj=new int[N][N];
		
		/*populate the adjacency matrix and cost matrix */
		for(i=0;i<N;i++){
			inner=connects[i];
			innerCost=costs[i];
			if((inner!="")&&(innerCost!="")){
				innerCircuit=inner.split("\\s");
				innerCircuitCost=innerCost.split("\\s");
				M=innerCircuit.length;
				for(j=0;j<M;j++){
					adj[i][Integer.parseInt(innerCircuit[j])]=true;
					adj[Integer.parseInt(innerCircuit[j])][i]=true;
  					innerCircuitAdj[i][Integer.parseInt(innerCircuit[j])]=Integer.parseInt(innerCircuitCost[j]);
					//innerCircuitAdj[Integer.parseInt(innerCircuit[j])][i]=Integer.parseInt(innerCircuitCost[j]);
				}
			}
		}
	
	/* print the cost matrix */	
	/*	for(i=0;i<N;i++){
			for(j=0;j<N;j++){
				System.out.print(innerCircuitAdj[i][j]);
			}
			System.out.println(" ");
		}
	*/	
		
		int maxi=-1;
		/* perform dfs from each vertex and find the maximum distance from each vertex to ever other vertex */
		for(i=0;i<N;i++){
			maxi=Math.max(maxi,dfs(i,-1));
		}
		/* since we start from -1 add maximum value +1 to get exact cost */
		return maxi+1;
		
	}
	
	/* calculates the distance from each v to each vertex further */
	public static int dfs(int v, int further){
		
		int maxi=-1;
		/* peform dfs on vertex v */
		for(int i=0;i<N;i++){
			/* if there is an edge from v to i then perform dfs 
				cost of longest path is 
				the maximum cost from v to i plus maximum cost from i to next vertex connected to i */
			if(adj[i][v]){
				if((i!=further) &&(innerCircuitAdj[i][v]!=0))
				maxi=Math.max(maxi,dfs(i,v)+innerCircuitAdj[i][v]);
			}
		}
		return maxi;
		
	}
}