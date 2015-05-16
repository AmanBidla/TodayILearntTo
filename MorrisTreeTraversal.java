class Node{

	Node left, right;
	int val;
	public Node(int val,Node left, Node right){
		this.left=left;
		this.right=right;
		this.val=val;
	}
}
public class MorrisTreeTraversal{


	public static void morris(Node root){

		if(root==null) return;
		while(root!=null){

			if(root.left==null){

				visit(root);
				root=root.right;

			}else{

				Node left = root.left;
				while(left.right!=null && left.right!=root)
					left = left.right;

				if(left.right==null){

					left.right=root;
					root=root.left;

				}else{

					left.right=null;
					visit(root);
					root=root.right;

				}
			}

		}

		System.out.println("");

	}

	public static void main(String[] args) {
		
		Node root = new Node(10,null,null);
		root.left = new Node(5,null,null);
		root.right = new Node(18,null,null);

		Node left = root.left;
		left.left = new Node(1,null,null);
		left.right = new Node(6,null,null);

		Node right = root.right;
		right.left = new Node(11,null,null);
		right.right = new Node(20,null,null);

		morris(root);
	}


	public static void visit(Node root){
		System.out.print(root.val+" - ");
	}

}