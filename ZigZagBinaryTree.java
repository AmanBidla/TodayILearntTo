import java.util.Stack;

public class ZigZagBinaryTree{

	static class Node {
		Node left, right;
		int value;
		Node(int val){
			this.value = val;
		}
	}

	private static void zigzag(Node root){

		if(root == null) return;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);

		do{

			while(!s1.isEmpty()){
				Node node = (Node)s1.pop();
				System.out.print(node.value+"\t");
				if(node.left!=null) s2.push(node.left);
				if(node.right!=null) s2.push(node.right);
			}
			System.out.println();
			while(!s2.isEmpty()){
				Node node = (Node) s2.pop();
				System.out.print(node.value+"\t");
				if(node.right!=null) s1.push(node.right);
				if(node.left!=null) s1.push(node.left);
			}
			System.out.println();
			

		}while(!s1.isEmpty() || !s2.isEmpty());
	}

	public static void main(String[] args) {
		

		Node root = new Node(2);
		Node l1 = new Node (21);
		Node r1 = new Node(16);
		root.left = l1;
		root.right =r1;

		Node l2 = new Node (34);
		Node r2 = new Node(89);
		l1.left =l2;
		l1.right=r2;

		Node l3 = new Node (45);
		Node r3 = new Node(64);

		r2.left = l3;
		r2.right = r3;

		zigzag(root);

	}


}