import java.util.Queue;
import java.util.LinkedList;
class Node {

	Node left, right;
	int val;

	public Node(int val, Node right, Node left){
		this.right=right;
		this.left=left;
		this.val=val;
	}
}
public class MinDepthBinaryTree{

	public static int minDepth(Node root){

		if(root==null) return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Queue<Integer> cq = new LinkedList<Integer>();
		cq.add(1);

		while( !q.isEmpty()){

			Node node = q.remove();
			int count = cq.remove();

			if(node.left!=null){
				q.add( node.left );
				cq.add( count +1 );

			}

			if(node.right!=null){
				q.add( node.right );
				cq.add( count +1 );
			}

			if( node.right==null && node.left==null){
				return count;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		
		Node root = new Node(5,null,null);
		root.left = new Node(6,null,null);
		root.right = new Node(8,null,null);

		root.left.left = new Node(4,null,null);
		root.left.right = new Node(3,null,null);

		root.left.right.left = new Node(2,null,null);
		root.left.right.right = new Node(12,null,null);

		root.right.right = new Node(14,null,null);
		root.right.right.left = new Node(16,null,null);

		System.out.println( minDepth(root));



	}


}