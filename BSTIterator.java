import java.util.Stack;
import java.lang.IllegalStateException;
 
class Node{

	Node left, right;
	int val;

	Node(int val,Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;
	}

}

public class BSTIterator{

	Stack<Node> st;

	public BSTIterator(Node root){
		st= new Stack<Node>();
		while(root!=null){
			st.push(root);
			root=root.left;
		}
	}

	public boolean hasNext(){
		return !st.isEmpty();
	}

	public int next(){

		if(!hasNext())throw new IllegalStateException("No such element");
		Node node = st.pop();
		int result = node.val;
		if(node.right!=null){
			node= node.right;
			while(node!=null){
				st.push(node);
				node=node.left;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		Node root = new Node(8,null,null);
		Node l2 = new Node(3,null,null);
		Node r2 = new Node(10,null,null);
		Node l31 = new Node(1,null,null);
		Node r32 = new Node(6,null,null);
		Node l41 = new Node(4,null,null);
		Node r41 = new Node(7,null,null);
		Node r33 = new Node(14,null,null);
		Node l43 = new Node(13,null,null);

		root.left = l2;
		root.right = r2;
		l2.left= l31;
		l2.right=r32;
		r32.left=l41;
		r32.right=r41;
		r2.right=r33;
		r33.left=l43;

		BSTIterator b = new BSTIterator(root);
		while(b.hasNext()){
			int value = b.next();
			System.out.println(value);
		}
	}

}