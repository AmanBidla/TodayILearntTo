public interface Graph {


	/* init function to initialize */
	public void Init(int n);

	/* get number of vertices */
	public int getN();

	/* get number of Edges */
	public int getE();

	/* set an edge between vertex v,u  of weight w*/
	public void setEdge(int v, int u,int w);

	/* remove edge (u,v)  and return edge */
	public int remove(int u, int v);

	/* get first neigbour */
	public int first(int v);

	/* get first neighbour to v after w */
	public int second(int v, int w);


	/* return true if there is an edge of non zero weight between vertices u, w */
	public boolean isEdge(int u, int v);

	/* get weight of an edge */
	public int weight(int i, int v);


	/* mark the vertex with a value */
	public void setMark( int i, int value);


	/* get the value of the marked vertex */
	public int getMark(int j);

}