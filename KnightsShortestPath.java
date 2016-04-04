import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class Node{
	int vistedX;
	int vistedY;
	int distanceFromThisVertexToSource;
	public Node(int vistedX, int vistedY,int distanceFromThisVertexToSource){
		this.vistedX=vistedX;
		this.vistedY=vistedY;
		this.distanceFromThisVertexToSource=distanceFromThisVertexToSource;
	}
}
public class KnightsShortestPath {

	public static int shortest(int N, int startX, int startY, int endX, int endY) {

		boolean [][]visited = new boolean[N][N];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(startX, startY,0));
		visited[startX][startY]=true;
		while(!queue.isEmpty()) {

			Node visitedNode = queue.remove();
			
			if((visitedNode.vistedX == endX) && (visitedNode.vistedY==endY)){
				return visitedNode.distanceFromThisVertexToSource;
			}else{
				List<Node> nodesToVisitNext = buildNextNodesToVisit(visitedNode.vistedX,visitedNode.vistedY,N,visitedNode.distanceFromThisVertexToSource,visited);
				for(Node nodesToVisit : nodesToVisitNext){

					if(!visited[nodesToVisit.vistedX][nodesToVisit.vistedY]){
						visited[nodesToVisit.vistedX][nodesToVisit.vistedY]=true;
						queue.add(nodesToVisit);
					}
				}
			}			
		}
		return -1;

	}

	public static List<Node> buildNextNodesToVisit(int x, int y, int N,int dist,boolean[][]visited){
 
		int[] xmoves = {2,1,-1,-2,-2,-1,1,2};
    	int []ymoves = {1,2,2,1,-1,-2,-2,-1};

		List<Node> nodesToVisit = new ArrayList<Node>();
		for(int i=0;i<xmoves.length;i++){

			int newX = xmoves[i]+x;
			int newY = ymoves[i]+y;
			if(newX>=0 && newX<N && newY>=0 && newY<N && !visited[newX][newY]){
				System.out.println("next node from ("+x+","+y+") is  ("+newX+","+newY+")");
				nodesToVisit.add(new Node(newX,newY,(dist+1)));
			}
		}
		return nodesToVisit;		 
	}

	public static void main(String[] args) {
		
		int N = 64;
		int startX=0;
		int startY=0;
		int endX=7;
		int endY=7;
		System.out.println("shortest path from ("+startX+","+startY+") to ("+endX+","+endY+") is "+shortest(N,startX,startY,endX,endY));


	}





}