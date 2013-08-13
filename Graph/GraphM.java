 
import java.util.Queue;
import java.util.ArrayDeque;

public class GraphM implements Graph{
	

	private GraphList [] vertices;
	private int [] mark;
	private int numEdge;

	private static int VISITED=1;
	private static int UNVISITED=0;

	public GraphM() {}

	public GraphM(int n){
		Init(n);
	}



	/* init function to initialize */
	public void Init(int n){
		
		System.out.println("inside init");
		vertices = new GraphList[n];
		mark = new int [n];
		numEdge=0;

		for(int i=0;i<n;i++){
			vertices[i]= new GraphList();
			
		}
	}

	/* get number of vertices */
	public int getN(){
		System.out.println("inside getN ");
		return vertices.length;
	}

	/* get number of Edges */
	public int getE(){
		System.out.println("inside getE");

		return numEdge;
	}

	/* set an edge between vertex v,u  of weight w*/
	public void setEdge(int i, int j,int w){

		System.out.println("inside setEdge");
		Edge currentEdge = new Edge(j,w);

		/* if edge already exists then update else insert new edge and increment numEdge */
		if(isEdge(i,j)){

			System.out.println(" updating edge ");
			vertices[i].remove();
			vertices[i].insert(currentEdge);
		
		}else{

			System.out.println(" new edge found ");
			numEdge++;
			/* insert edge sorted by vertex */
			for(vertices[i].moveToStart();
				vertices[i].currentPostion()<vertices[i].length();
				vertices[i].next()){

				if(vertices[i].getValue().getVertex()>j) break;
			}

			vertices[i].insert(currentEdge);
		}
	}

	/* remove edge (u,v) */
	public int remove(int i, int j){

		System.out.println("inside remove");
		/* if no edge then do nothing */
		if(vertices[i].length()==0) return mark.length;

		/* if there is an edge between u and v then remove */
		Edge currentEdge = null;
		if( isEdge(i,j)){
			vertices[i].remove();
			currentEdge = vertices[i].getValue();
		}

		if(currentEdge!=null){
			return currentEdge.getVertex();
		}

		return mark.length;
	}

	/* get first neigbour */
	public int first(int i){

		System.out.println("inside first");
		if(vertices[i].length()==0) return mark.length;

		vertices[i].moveToStart();

		Edge currentEdge = vertices[i].getValue();

		if (currentEdge!=null) 

			return currentEdge.getVertex();

		return mark.length;
	}

	/* get first neighbour to v after w */
	public int second(int v, int w){

		System.out.println("inside second");
		Edge secondEdge = null;

		if(isEdge(v,w)){

			vertices[v].next();

			secondEdge = vertices[v].getValue();
		}

		if(secondEdge!=null){

			return secondEdge.getVertex();
		}


		return mark.length;


	}


	/* return true if there is an edge of non zero weight between vertices u, w */
	public boolean isEdge(int u, int v){

		System.out.println("inside isEdge");
		if( vertices[u].length()==0)  return false;

		if(vertices[u].getValue().getVertex()==v) return true;

		for(vertices[u].moveToStart();
			vertices[u].currentPostion()<vertices[u].length();
			vertices[u].next()){

			if( vertices[u].getValue().getVertex()==v) return true;
		}

		return false;


	}

	/* get weight of an edge */
	public int weight(int i, int j){

		System.out.println("inside weight");
		Edge currentEdge = null;

		if( isEdge(i,j)) {

			currentEdge = vertices[i].getValue();

			return currentEdge.getWeight();

		}

		return mark.length;
	}


	/* mark the vertex with a value */
	public void setMark( int i, int value){

		System.out.println("inside set mark");
		mark[i]= value;

	}

	/* get the value of the marked vertex */
	public int getMark(int j){
 
 		return mark[j];
	}
	
	
	public void beforeTraversal(Graph g){
		int v;
		
		for(v=0;v<g.getN();v++){
			g.setMark(v, UNVISITED);
		}
	}

 	public static void BFS( GraphM G, int start){

 		System.out.println("inside BFS");
 		Queue q = new ArrayDeque();

 		q.add(start);

 		G.setMark(start, VISITED);

 		preVisit(G,start);

 		while( q.size()> 0){

 			int v = (Integer) q.remove();

 			for( int w = G.first(v); w< G.getN(); w = G.second(v,w)){
 				
 				System.out.println("next  vertex is "+w);
 				if( G.getMark(w)== UNVISITED){

 					G.setMark(w, VISITED);

 					q.add(w);
 				}
 	 			

 			}
 			
 			postVisit(G,v);

 		}


 	}

 	public static void  preVisit( GraphM G, int v){

 		System.out.println("pre visit of "+v);
 	}

 	public static void  postVisit( GraphM G, int v){

 		System.out.println("post visit of "+v);
 	}

 	public boolean isBipartie(Graph G, int start){

 		Queue q = new ArrayDeque();

 		G.setMark(start, VISITED);

 		int [] color = new int[ G.getN()];

 		for(int i=0;i<G.getN();i++)
 			color[i] = -1;

 		color[start]=1;

 		q.add(start);

 		while(q.size()>0){

 			int v = (Integer)q.remove();

 			for(int w = G.first(v); w< G.getN();w = G.second(v,w)){

 				if( G.getMark(w)==UNVISITED && color[w]==-1){

 					color[w] = 1- color[v];

 					G.setMark(w,VISITED);

 					q.add(w);
 				}else{

 					System.out.println(" is not isBipartie ");
 					return false;
 				}

 			}

 		}

 		System.out.println("is isBipartie");
 		return true;

 	}
}