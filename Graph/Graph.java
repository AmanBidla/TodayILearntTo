import java.util.List;
import java.util.ArrayList;

public class Graph {


	static int VERTICES;
	static int EDGES;
	List<List<Integer>> bag;

	public Graph (int VERTICES){
		this.VERTICES = VERTICES;
		bag = new ArrayList<List<Integer>>();
		for(int i=0;i<VERTICES;i++){
			List<Integer> list = new ArrayList<Integer>();
			bag.add(list);
		}
	}

	public static void main(String[] args) {
		
	}

	public void addEdge(int v,int w){
		System.out.println("adding edge between "+v+" and "+w);
		validate(v);
		validate(w);
		EDGES++;
		bag.get(v).add(w);
		bag.get(w).add(v);
		System.out.println(" number of edges connecting 0 is "+bag.get(0).size());
	}

	public boolean validate(int v){
		if(v<0 || v>VERTICES) throw new IndexOutOfBoundsException("vertex "+v+" should be between 0 & "+VERTICES);
		return true;
	}

	public List<Integer> adj(int w){
		validate(w);
		return bag.get(w);
	}


	public void connectedEdges(){

		for(int i=0;i<VERTICES;i++) {
			System.out.print(i+":");
			List<Integer> adjVertices = bag.get(i);	
			System.out.println("size of edges "+adjVertices.size());		
			for(int j=0;j<adjVertices.size();j++){
				System.out.print(adjVertices.get(j));
				if(j!=adjVertices.size()-1){
					System.out.print("->");
				}
			}
			System.out.println();
		}
	}
}