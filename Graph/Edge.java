public class Edge{

	private int vertex;
	private int weight;


	public Edge(int vertex,int weight){
		System.out.println("inside EDGE constructor");
		this.vertex=vertex;
		this.weight=weight;

	}

	public int getVertex(){
		System.out.println("inside get vertex");
		return vertex;
	}

	public int getWeight(){
		System.out.println("inside get weight");
		return weight;
	}
}