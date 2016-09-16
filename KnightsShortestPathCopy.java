import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

class Node{

	int x,y;
	int distFromSource;
	public Node(int x, int y, int distFromSource){
		this.x=x;
		this.y=y;
		this.distFromSource=distFromSource;
	}
}

public class KnightsShortestPathCopy {

	private static int N = 8;

	public static void main(String[] args) {
		
		 System.out.println(shortest(0,0,7,7));
	}

	public static int shortest(int startX, int startY, int endX, int endY) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(startX, startY,0));
		boolean [][] visited = new boolean[N][N];

		while(!queue.isEmpty()){

			Node curr = queue.poll();
			if((curr.x == endX) && (curr.y == endY)){
				return curr.distFromSource;
			} else {

				List<Node> nextMoveNodes = getNextMoveNodes(curr);
				for(Node nextMoveNode : nextMoveNodes){

					if(!visited[nextMoveNode.x][nextMoveNode.y]){
						visited[nextMoveNode.x][nextMoveNode.y]=true;
						queue.offer(nextMoveNode);
					}
				}				
			}
		}
		return -1;
	}

	public static List<Node> getNextMoveNodes(Node curr){

		List<Node> result = new LinkedList<Node>();
		int [] xMoves = {1,2,-1,2,-1,-2,1,2,};
		int [] yMoves = {2,1,2,-1,-2,-1,-2,-1};

		for(int i=0;i<xMoves.length;i++){

			int newX = curr.x+xMoves[i];
			int newY = curr.y+yMoves[i];
			if(newX>-1 && newX<N && newY>-1 && newY<N){
				Node next = new Node(newX, newY, curr.distFromSource+1);
				result.add(next);	
			}
			
		}
		return result;
	}


	 
}