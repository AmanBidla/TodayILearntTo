import java.util.*;

class Bag<Item> implements Iterable<Item> {

	private Node<Item> first;
	private int N;

	private static class Node <Item> {

		Item item;
		Node<Item> next;

	}

	public void add(Item item){
		Node<Item> old = first;
		first = new Node<Item>();
		first.item = item;
		first.next = old;
		N++;
	}

	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> curr;
		public ListIterator(Node<Item> node){ this.curr= node;}
		public boolean hasNext(){ return curr!=null; }
		public Item next(){ 
			if(!hasNext()) throw new UnsupportedOperationException("No node");
			Item item = curr.item;
			curr = curr.next;
			return item; 
		}
		public void remove(){ }

	}
 
}

class Graph {

	public final int vertices;
	public int edges;
	public Bag<Integer>[] adj;

	public Graph (int vertices){
		this.vertices =vertices;
		adj = (Bag<Integer>[]) new Bag[vertices];
		for(int i=0;i<vertices;i++){
			adj[i]= new Bag<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);	
		edges++;
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

}


public class AlienLanguage {

	private static Map<Character,Integer> symbolKey = new HashMap<Character,Integer>();
	private static Map<Integer,Character> symbolValue = new HashMap<Integer,Character>();

	private static Stack<Integer> postOrder = new Stack<Integer>();
	private static boolean []marked;
 
	private static Graph createGraph(int vertices){		 
		Graph graph = new Graph(vertices);
		marked = new boolean[vertices];
		return graph;
	}

	private static int getCountOfDistinctLetters(String [] array) {
		int [] map = new int[256]; 
		int count=0;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].toCharArray().length;j++){
				if(map[array[i].charAt(j)-'a']==0){
					map[array[i].charAt(j)-'a']++;
					symbolKey.put(array[i].charAt(j),count);
					symbolValue.put(count,array[i].charAt(j));
					count++;
				} 
			}
		}
		return count;
	}

	private static void createEdgesInGraph(Graph graph, String []array) {

		for(int i=0;i<array.length-1;i++){
			createEdge(array[i],array[i+1],graph);
		}

	}

	private static void createEdge(String word1, String word2, Graph graph) {

		int i=0;
		int j=0;
		while(i<word1.length() && j<word2.length() && word1.charAt(i)==word2.charAt(j)){
			i++; j++;
		}

		if(i<word1.length() && j<word2.length()){
			
			int v = symbolKey.get(word1.charAt(i));
			int w = symbolKey.get(word2.charAt(j));
			//System.out.println("adding edge between "+symbolValue.get())
			graph.addEdge(v,w);
		}
	}

	private static void dfs(Graph graph){

		for(int v=0;v<graph.vertices;v++) {
			if(!marked[v]){
				dfs(graph,v);
			}
		}

	}

	private static void dfs(Graph graph , int v) {

		marked[v]=true;
		for(int w:graph.adj(v)){
			if(!marked[w]){
				dfs(graph,w);
			}
		}
		postOrder.push(v);
	}

	public static void main(String[] args) {
		
		//String [] words = {"baa", "abcd", "abca", "cab", "cad" };
		String [] words = {"caa", "aaa", "aab"};
		int vertices = getCountOfDistinctLetters(words);
		Graph graph = createGraph(vertices);
		createEdgesInGraph(graph,words);
		dfs(graph);
		showOrder();
	}

	private static void showOrder(){
		 
		while(!postOrder.isEmpty()){
			int v = postOrder.pop();
			System.out.print(symbolValue.get(v));			  
			if(postOrder.size()>0)
				System.out.print(",");
		}
		System.out.println();
	}


 	 


}