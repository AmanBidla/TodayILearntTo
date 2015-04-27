import java.util.Stack;

class Node{

	 Node left, right;
	 int val;
	 public Node(Node left, Node right , int val){
	 	this.left=left;
	 	this.right=right;
	 	this.val=val;
	 }
}



public class BinaryTreeToLinkedList {

	private static void show(Node root){
		while(root!=null){
			if(root.right!=null)
			 System.out.print( "[ "+root.val+" ]->");
			else
			 System.out.print( "[ "+root.val+" ]");
			root=root.right;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		
		Node root = new Node(null,null,1);
		root.left = new Node(null,null,2);
		root.right = new Node(null,null,5);

		root.left.left = new Node(null,null,3);
		root.left.right = new Node(null,null,4);

		root.right.left = new Node(null,null,6);
		root.right.right = new Node(null,null,7);
		//inorder(root);
		Node node = flatten(root);
		show(node);

	}

	private static void inorder(Node root){

		if(root.left!=null){
			inorder(root.left);
		}
		System.out.print("["+root.val+"]->");
		if(root.right!=null){
			inorder(root.right);
		}

	}




	private static Node flatten (Node root){

		Stack<Node> st = new Stack<Node>();
		if(root==null) return null;
		Node node = root;
		while ( node!=null || !st.isEmpty()){

			 if(node.right!=null){
			 	st.push(node.right);
			 }

			 if(node.left!=null){
			 	node.right= node.left;
			 	node.left = null;
			 }else{

			 	if( !st.isEmpty()){
			 		Node newNode = st.pop();
			 		node.right = newNode;
			 	}
			 }

			 node = node.right;

		}

		return root;

	}

}