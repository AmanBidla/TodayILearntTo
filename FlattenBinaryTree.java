import java.util.Stack;

class  Node{

	Node left, right;
	int val;
	Node(int val, Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
}


public class FlattenBinaryTree{


	public static Node flatten(Node root){

		if(root==null || (root.left==null && root.right==null)) return root;

		Stack<Node> st = new Stack<Node>();
		Node curr = root;

		while( root!=null || !st.isEmpty()){

			if(root.right!=null){
				st.push(root.right);
			}

			if(root.left!=null){
				root.right = root.left;
				root.left = null;
			}else{
				if(!st.isEmpty())
					root.right= st.pop();
			}

			root = root.right;
		}

		return curr;
	}

	public static void main(String[] args) {
		
		Node root = new Node(1,null,null);
		root.left = new Node(2,null,null);
		root.right = new Node(5,null,null);
		root.left.left= new Node(3,null,null);
		root.left.right= new Node(4,null,null);
		root.right.right= new Node(6,null,null);

		Node result = flatten(root);
		while(result!=null){
			System.out.println(result.val);
			result=result.right;
		}


	}


} 