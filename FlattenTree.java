import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class LNode {

	public LNode next;
	public int val;

	public LNode(int val){
		this.val=val;
	}

}

class Node{

	public int val;
	public Node left, right;
	public Node(int val){
		this.val = val;
	}

}

public class FlattenTree {


	public static void main(String[] args) {
		FlattenTree ft = new FlattenTree();
		Node root = ft.populateTree();
		ft.showTree(root);
		LNode lNode = ft.flattenTree(root);
		ft.showLinkedList(lNode);
	}

	private void showLinkedList(LNode lNode){

		while(lNode != null){
			System.out.print(lNode.val+" -> ");
			lNode = lNode.next;
		}
		System.out.println("null");
	}

	private Node populateTree(){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.right = new Node(6);
		return root;

	}

	private void showTree(Node root){

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.println(root.val);
		while( !queue.isEmpty()) {

			Node curr = queue.remove();
			if(curr.left != null){
				System.out.print(curr.left.val+",");
				queue.add(curr.left);
			}
			if(curr.right != null){
				System.out.print(curr.right.val);
				queue.add(curr.right);
			}
			if(curr.left != null || curr.right != null) {
				System.out.println();	
			}			
		}

	}


	public LNode flattenTree(Node root){

		if(root == null){
			return null;
		}


		Stack<Node> st = new Stack<Node>();
		st.push(root);
		LNode temp = new LNode(-100);
		LNode lNode = temp;
		while( !st.isEmpty()) {

			Node curr = st.pop();
			lNode.next= new LNode(curr.val);
			lNode = lNode.next;
			if(curr.right!=null){
				st.push(curr.right);
			}

			if(curr.left != null){
				st.push(curr.left);
			}
		}

		return temp.next;
	}


}