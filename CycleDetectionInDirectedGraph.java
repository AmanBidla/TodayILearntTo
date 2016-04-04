import java.util.*; 

class Bag<Item> implements Iterable<Item>{

	static class Node<Item> {
		private Item item;
		private Node<Item> next;		
	}

	private Node<Item> first;
	private int N;


	public void add(Item v){
		Node<Item> old = first;
		first = new Node<Item>();
		first.item = v;
		first.next=old;
		N++;	
	}

	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item>{

		private Node<Item> curr;
		private ListIterator(Node<Item> node){
			this.curr = node;
		}

		public boolean hasNext(){ return curr!=null; }
		public void remove(){ }
		public Item next() {
			if(hasNext()){
				Item item = curr.item;
				curr = curr.next;
				return item;
			}
			throw new NoSuchElementException();
		}
	}



}


class Graph{

	
	private Bag<Integer> [] adj;
	public int V;
	private int E;

	 


	public Graph(int V){
		this.V= V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++){
			adj[i] = new Bag<Integer>();
		}
		this.E=0;
	}

	public void addEdge(int v, int w) {		 
		 adj[v].add(w);
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

}

public class CycleDetectionInDirectedGraph {


	private static boolean [] marked;
	private static boolean []onStack;
	private static int[] edgeTo;
	private static Stack<Integer> cycle;

	public static Graph buildCyclicDirectedGraph(){
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
		
		
        Graph graph = buildNonCyclicDirectedGraph();
        checkAndPrintCycle(graph);
         
        graph = buildCyclicDirectedGraph();
        checkAndPrintCycle(graph);
          
	}


	public static void checkAndPrintCycle(Graph graph){

		for(int v=0;v<graph.V;v++){
			if(!marked[v] && cycle == null){
				dfs(graph,v);
			}
		}

		if(hasCycle()){

			System.out.println(cycle.size());
        	System.out.println("Cycle detected.\n Cycle is [");

        	while(cycle.isEmpty()){
        		System.out.print(cycle.pop());
        	}
        	System.out.println("]");
        }
	}

	public static void dfs(Graph graph, int v){

		onStack[v]=true;
		marked[v]=true;
		for(int w:graph.adj(v)) {

			if(cycle !=null){
				return;
			}
			else if(!marked[w]){
				edgeTo[v]=w;
				dfs(graph,w);
			}else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x=v;x !=w;x=edgeTo[w]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}

		}
		onStack[v]=false;
	}

	public static boolean hasCycle(){
		return cycle != null;
	}

	public static Iterable<Integer> cycle(){
		return cycle;
	}

    public static Graph buildNonCyclicDirectedGraph(){
    	int vertices=4;
		Graph graph = new Graph(vertices);
		graph.addEdge(0,2);
		graph.addEdge(0,1);
		graph.addEdge(2,3);
		graph.addEdge(1,3); // loop to itself


        marked = new boolean[vertices];
        onStack = new boolean[vertices];
        edgeTo = new int[vertices];
        cycle = null;

		return graph;

	}
    



}