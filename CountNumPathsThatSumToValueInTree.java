import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Node {

	public int val;
	public Node left, right;
	public Node(int val){
		this.val = val;
	}
	
}

public class CountNumPathsThatSumToValueInTree{


	public int countNumberOfPathsThatAddsToSum(Node root, int targetSum){

		if(root == null){
			return 0;
		}

		Map<Integer, Integer> sumToNumPaths = new HashMap<>();
		sumToNumPaths.put(0,1);
		return count(root, 0, targetSum, sumToNumPaths);

	}

	private int count(Node root, int runningSum, int targetSum, Map<Integer, Integer> map){

		if(root == null){
			return 0;
		}

		runningSum += root.val;
		updateMap(map, runningSum,1);
		int sum = runningSum - targetSum;
		int totalPaths = map.containsKey(sum) ? map.get(sum) : 0;
		totalPaths += count( root.left, runningSum, targetSum, map);
		totalPaths += count( root.right, runningSum, targetSum, map);
		updateMap(map, runningSum, -1);
		return totalPaths;
	}

	private void updateMap(Map<Integer,Integer> map, int key, int delta){
		if(!map.containsKey(key)){
			map.put(key, 0);
		}
		map.put(key, map.get(key)+1);
	}

	public static void main(String[] args) {
		
		CountNumPathsThatSumToValueInTree count = new CountNumPathsThatSumToValueInTree();
		Node root = count.populateTree();
		count.showTree(root);
		int targetSum = 8;
		int totalPaths = count.countNumberOfPathsThatAddsToSum(root, targetSum);
		System.out.println("Total number of paths that adds up to "+targetSum+" is "+totalPaths);

	}

	private void showTree(Node root){

		if(root== null){
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.println(root.val);
		while(!queue.isEmpty()){

			Node curr = queue.remove();
			
			if(curr.left!=null){
				System.out.print(curr.left.val+",");
				queue.add(curr.left);
			}
			if(curr.right!=null){
				System.out.print(curr.right.val);
				queue.add(curr.right);
			}
			if(curr.left!=null|| curr.right!=null) {
				System.out.println("");
			}
			
		}

	}

	private Node populateTree(){

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
		root.right.right = new Node(11);

		root.left.left = new Node(3);
		root.left.right = new Node(1);
		root.left.right.right = new Node(2);
		root.left.left.left = new Node(3);
		root.left.left.right  = new Node(-2);

		return root;
	}


}