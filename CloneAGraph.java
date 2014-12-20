 class UndirectedGraphNode {
 	int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
    	label = x; 
    	neighbors = new ArrayList<UndirectedGraphNode>(); 
    }
 };
public class CloneAGraph{
	
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if(node==null){
          return node;
      }
      HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
      LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
      queue.add(node);
      UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
      map.put(node,newHead);
      while(!queue.isEmpty()){
          UndirectedGraphNode curr = (UndirectedGraphNode)queue.pop();
          List<UndirectedGraphNode> currNeighbors = curr.neighbors;
          for(UndirectedGraphNode neighbor:currNeighbors){
              if(!map.containsKey(neighbor)){
                  UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                  map.get(curr).neighbors.add(copy);
                  map.put(neighbor,copy);
                  queue.add(neighbor);
              }else{
                  map.get(curr).neighbors.add(map.get(neighbor));
              }
          }
      }
      return newHead;
    }
}