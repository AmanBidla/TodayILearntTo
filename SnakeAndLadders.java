
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Node{
	int vistedVertex;
	int distOfThisVertexFromSource;
	public Node(int vistedVertex, int distOfThisVertexFromSource){
		this.vistedVertex=vistedVertex;
		this.distOfThisVertexFromSource=distOfThisVertexFromSource;
	}
}


public class SnakeAndLadders {

	 final static int MAX_DICE_MOVES=6;

	 public static int[] build(){

	 	int M=6; // rows
	 	int N=5; // columns
	 	  
	 	// starts with 1 index  
	 	int [][] ladders = {{3,22},{5,8},{11,26},{20,29}};
	 	int [][] snakes ={{27,1},{17,4},{19,7},{21,9}};
	 	int [] array = new int[M*N];

	 	for(int i=0;i<array.length;i++){
	 		array[i]=-1;
	 	}

	 	for(int i=0;i<ladders.length;i++){
	 		int ladderStart = ladders[i][0];
	 		int ladderEnd = ladders[i][1];
	 		array[ladderStart]=ladderEnd;
	 	}

		for(int i=0;i<snakes.length;i++){
	 		int snakeStart = snakes[i][0];
	 		int snakeEnd = snakes[i][1];
	 		array[snakeStart]=snakeEnd;
	 	}

	 	//System.out.println(Arrays.toString(array));
	 	return array;

 	}

 	public static int minMoves(int[]array){

 		boolean []visited = new boolean[array.length];
 		Queue<Node> queue = new LinkedList<Node>();

 		visited[0]=true;
 		queue.add(new Node(0,0));
		 
 		while(!queue.isEmpty()){
 
 			Node visitedNode = queue.remove();
 			int v = visitedNode.vistedVertex;
 			if(v==array.length-1) {
 				 return visitedNode.distOfThisVertexFromSource;
 			} 
 			for(int j=v+1;j<=(v+6)&& j<array.length;j++){

 				if(!visited[j]){

 					int distOfThisVertexFromSource = visitedNode.distOfThisVertexFromSource+1;
 					
 					visited[j] = true;
 					Node nextNodeToVist;

 					if(array[j]!=-1){
 						 nextNodeToVist = new Node(array[j],distOfThisVertexFromSource);
 					}else{
 						nextNodeToVist = new Node(j,distOfThisVertexFromSource);
 					}
 					//System.out.println("adding "+nextNodeToVist.vistedVertex);
 					queue.add(nextNodeToVist);
 				}
 			}
 		}
 		return -1;
 	}
 

	 public static void main(String[] args) {
	  	
			int[] array = build();
			System.out.println("Min moves "+minMoves(array));
	  } 

}