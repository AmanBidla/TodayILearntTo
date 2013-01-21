 public class Marketing{
	
	private static  int N,M,i,j,totalValue=0,total=1;;
	private static boolean [][]adj;
	private static String inner;
	private static String innerString[];
	private static int color[];
	private static boolean oddCycle=false;
	
	
	public static void main(String abd[]){
	
	//String []compete = {"1 4","2","3","0",""};
	//String []compete = {"1","2","0"};
	//String[] compete={"1","2","3","0","0 5","1"};
	String[] compete={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	//String[] compete={"1","2","3","0","5","6","4"};
		System.out.println(marketingIdea(compete));
	}
	
	
	public static int marketingIdea(String []compete){
		
	/* get the length of the string */
	N=compete.length;
	
	/* create adjacency list */
	adj=new boolean[N][N];
	
	/* create array to check if vertex is visited or not visited */
	color=new int[N];
	
	/* create adjacency list */
	for(i=0;i<N;i++){
		inner=compete[i];
		innerString=inner.split("\\s");
		M=innerString.length;
		for(j=0;j<M;j++){
			if(innerString[j]!=""){
				adj[i][Integer.parseInt(innerString[j])]=true;
				adj[Integer.parseInt(innerString[j])][i]=true;
			}
		}
	}
	
	/* initialize all vertex as not visited i.e 0 */
	for(i=0;i<N;i++){
		color[i]=0;
	}
	
	/* perform dfs on each vertex */
	for(i=0;i<N;i++){
		if(color[i]==0){
			totalValue++;
			dfs(i,1);
		}
	}
	/* if odd cycle return -1 */
	if(oddCycle)
		return -1;
	/* find the total solution and raise it power of 2
		let me explain :
		suppose there are 4 vertices and the solution is
		Black, White, White, Black then the alternate solution is
		White, Black, Black, White.
		So for each solution there is a mirror image solution also */ 
	   
	while(totalValue-- >0)
		total*=2;

	return total;
		
	}
	
	/* dfs on each vertex */
	public static void dfs(int i, int colorValue){
		
		/* if vertex is not visited and  if vertex is same color as parent then 
			odd cycle is present */
		if(color[i]!=0){
			if(color[i]!=colorValue){
				oddCycle=true;
			}
			return;
		}
		/* mark vertex as visited */
		color[i]=colorValue;
		
		/* peform dfs on each vertex */
		for(int j=0;j<N;j++){
			if(adj[i][j]){
				dfs(j,3-colorValue);
			}
		}
	}
	
}