import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
class Node {

	String name;
	int val;
	Map<Node,Node> children = new HashMap<Node,Node>();
	boolean processed=false;
	public Node(String name){
		this.name=name;
	}

	public Node(String name,int val){
		this(name);
		this.val=val;		
	}

	public void addChildren(Node p){

		if(!children.containsKey(p)){
			children.put(p,p);
		}
	}

}

public class ClassGraph {

	List<Node> vertices = new ArrayList<Node>();
	Map<String,Node> map = new HashMap<String,Node>();
	int edges=0;

	public Node addVertex(String name) {

		if(!map.containsKey(name)) {
			Node node = new Node(name);
			map.put(name,node);
			vertices.add(node);
		}
		return map.get(name);
	}

	public Node getNode(String name) {

		if(map.containsKey(name)) {
			map.get(name);
		}else{
			return addVertex(name);
		}
		return map.get(name);
	}


	public void addEdge(String from, String to){
		Node f = getNode(from);
		Node t = getNode(to);
		f.addChildren(t);
		edges++;
	}

	public void buildVertices(String []allProjects){
		for(String name:allProjects){
			addVertex(name);
		}
	}

	public void addEdges(String [][] deps){
		
		for(String [] dep: deps){
			addEdge(dep[0],dep[1]);
		}
	}

	public void show(){
		for(Node vertex:vertices){
			System.out.print(vertex.name);
			if(vertex.children.size()>0){
				System.out.print(" -> ");
				Set<Node> children = vertex.children.keySet();
				for(Node child:children){
					System.out.print(child.name+" -> ");
				}
			}
			System.out.println();
		}
	}

	public int removeDependentProject(Node[]order, List<Node> vertices,int offset){

		for(Node node: vertices){
 			if(!node.processed && node.children.size()==0){
				order[offset]=node;
				offset++;
 				node.processed=true;	
			}
		}

		return offset;

	}

	public Node[] buildOrder(List<Node>vertices){
		
		Node[] order = new Node[vertices.size()];
		int offset = removeDependentProject(order,vertices,0);
		int toBeProcessed =0;
		while(toBeProcessed<vertices.size()){
 			Node p = order[toBeProcessed];			 
			if(p==null) {
				System.out.println("Cyclic dependency");
				return null;
			}
			for(Node node:vertices){
				if(!node.processed && node.children.containsKey(p)) {
					node.children.remove(p);
				}
			}
			offset= removeDependentProject(order,vertices,offset);
			toBeProcessed++;
		}

		for(Node node:order){
			System.out.print(node.name+" -> ");
		}
		System.out.println();

		return order;



	}

 

	public static void main(String[] args) {
		String [] allProjects = {"a","b","c","d","e","f"};
		String [][] dependentProjects = {{"d","a"}, {"b","f"}, {"d","b"}, {"a","f"}, {"c","d"}};
		ClassGraph graph = new ClassGraph();
		//graph.getBuildOrder(allProjects,dependentProjects);
		graph.buildVertices(allProjects);
		graph.addEdges(dependentProjects);
		//graph.show();
		graph.buildOrder(graph.vertices);
	}



}