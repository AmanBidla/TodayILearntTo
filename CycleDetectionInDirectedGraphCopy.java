import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


class Node<V>{
	Node<V> next;
	V item;
}

class Bag<V> implements Iterable<V>{

	Node<V> first;
	int N;

	public Bag(){
		first = null;
		N = 0;
	}

	public void addItem(V item){
		Node<V> oldFirst = first;
		first = new Node<V>();
		first.item = item;
		first.next = oldFirst;
	}

	public Iterator<V> iterator(){
		return new ListIterator<V> (first);
	}

	class ListIterator<V> implements Iterator<V>{

		Node<V> curr;
		public ListIterator(Node<V> first){
			this.curr = first;
		}

		public boolean hasNext(){
			return curr!=null;
		}

		public V next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			V item = curr.item;
			curr =curr.next;
			return item;
		}

		public void remove(){

		}
	}
}

class Graph {

	int V,E;
	Bag<Integer>[] adj;

	public Graph(int vertices){
		this.V = vertices;
		adj = (Bag<Integer>[]) new Bag[vertices];
		for(int v=0;v<vertices;v++){
			adj[v] = new Bag<Integer>();
		}
		this.E =0;
	}

	public void addEdge(int v, int w){		 
		adj[v].addItem(w);		 
		E++;
	}

	public Iterable<Integer>  getAdj(int w){
		return adj[w];
	}

}

public class CycleDetectionInDirectedGraphCopy{

	private static int [] edgeTo;
	private static boolean []marked;
	private static boolean []onStack;
	private static Stack<Integer> cycle;

	public void checkAndPrintCycle(Graph graph){

		edgeTo = new int[graph.V];
		marked = new boolean[graph.V];
		onStack = new boolean[graph.V];
		cycle = null;

		for(int v=0;v<graph.V;v++){
			 
			if(!marked[v] && cycle==null){
				dfs(v,graph);
			}
		}

		if(cycle!=null){

			while(!cycle.isEmpty()){
				System.out.print(cycle.pop());
				if(cycle.size()>0){
					System.out.print(",");
				}
			}
			System.out.println();
		}else{
			System.out.println("No cycle");
		}
	}

	public void dfs(int v, Graph graph){
		marked[v]=true;
		onStack[v]=true;
		for(int w: graph.getAdj(v)){

			if(cycle !=null){
				return;
			} else if( !marked[w]){
				edgeTo[w]=v;
				dfs(w,graph);
			} else if(onStack[w]){
				System.out.println("Found cycle");
				cycle = new Stack<Integer>();
				for(int x=v; x!=w; x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);		 
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}

	  public Graph buildCyclicDirectedGraph(){
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(2,0);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,3); // loop to itself

        marked = new boolean[vertices];
        onStack = new boolean[vertices];
        edgeTo = new int[vertices];
        cycle = null;
        return graph;

    }

    public static void main(String[] args) {
    	
    	CycleDetectionInDirectedGraphCopy sol = new CycleDetectionInDirectedGraphCopy();
    	Graph graph  = sol.buildCyclicDirectedGraph();
    	sol.checkAndPrintCycle(graph);

    }

}