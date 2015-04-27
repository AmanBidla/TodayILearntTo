import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayDeque;

public class MinSpanningTree{
	
	private double weight;

	private boolean[] marked;
	private Queue<Edge> minPriorityQueue;
	private Queue<Edge> queue;


	public MinSpanningTree(EdgeWeightGraph g){
		minPriorityQueue = new PriorityQueue<Edge>();
		queue = new ArrayDeque<Edge>();
		marked = new boolean[g.getVerticesCount()];
		visit(g,0);
		while(!minPriorityQueue.isEmpty()){

			Edge e = minPriorityQueue.remove();
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			queue.offer(e);
			if(!marked[v]) visit(g,v);
			if(!marked[w]) visit(g,w);
		}
	}

	private void visit(EdgeWeightGraph g, int v){
		marked[v]= true;
		for(Edge e: g.adj(v)){
			int w = e.other(v);
			if(!marked[w]) minPriorityQueue.add(e);
		}
	}

	public Iterable<Edge> getAllEdges(){
		return queue;
	}

	public double getWeight(){
		return weight;
	}


}