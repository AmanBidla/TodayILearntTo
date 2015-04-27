public class EdgeWeightGraph{
	
	private final int vertices;
	private int edges;
	private Bag<Edge> [] adj;

	public EdgeWeightGraph(int v){

		vertices=v;
		this.edges=0;
		adj= (Bag<Edge>[])   new Bag[v];

		for(int i=0;i<v;i++){
			adj[i]= new Bag<Edge>();
		}		
	}

	public int getVerticesCount(){
		return vertices;
	}

	public void addEdge(Edge e){
		int v= e.either();
		int w= e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		edges++;
	}

	public Iterable<Edge> adj( int v){
		return adj[v];
	}	 

}