import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;


class Node{

	Node left,right;
	int val;
	public Node(int val){
		this.val=val;
	}

}

public class LevelOrderTraversal {


	public static void main(String[] args) {
		
		Node root = createTree();
		List<List<Integer>> result = levelOrder(root);
		for(List<Integer> r : result){
			System.out.println(Arrays.toString(r.toArray()));
		}

	}

	private static Node createTree(){

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		 	
		return root;
	}

	public static List<List<Integer>> levelOrder(Node root){

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null){
			return result;
		}

		Queue<Node> current = new LinkedList<Node>();
		Queue<Node> next = new LinkedList<Node>();

		current.add(root);
		List<Integer> list = new ArrayList<Integer>();
		int currentSum =0; int count =0;
		while( !current.isEmpty() ){

			Node node = current.remove();

			if(node.left != null){
				next.add(node.left);
			}

			if(node.right != null){
				next.add(node.right);
			}

			list.add(node.val);
			currentSum += node.val;
			count ++;

			if(current.isEmpty()){

				current = next;
				result.add(list);
				next = new LinkedList<Node>();
				list = new ArrayList<Integer>();
				double avg = (double) currentSum/count;
				currentSum =0; count=0;
				System.out.println( " avg "+avg);
			}
		}
		return result;

	}



}