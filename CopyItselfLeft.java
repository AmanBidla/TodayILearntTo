class Node{

	Node left,right;
	int val;
	public Node(int val){
		this.val=val;
	}
}

public class CopyItselfLeft{

	public static void copyNodeToLeft(Node node){

		if(node == null){
			return ; 
		}
		copyNodeToLeft(node.left);
		copyNodeToLeft(node.right);
		Node copy = new Node(node.val);
		Node oldLeft = node.left;
		node.left = copy;
		copy.left = oldLeft;

	}

	public static void main(String[] args) {
		
		Node node = new Node(10);
		node.left = new  Node(5);
		node.right = new Node(15);

		//inOrder(node);
		copyNodeToLeft(node);
		inOrder(node);
	}

	public static void inOrder(Node node){
		if(node == null){
			return;
		}
		 
		inOrder(node.left);		 
		System.out.println(node.val);
		inOrder(node.right);

	}

}