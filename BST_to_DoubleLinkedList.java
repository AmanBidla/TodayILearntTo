class NodePair{

	Node prev,head;
	public NodePair(Node prev, Node head){
		this.prev = prev;
		this.head = head;
	}

}

class Node {

	Node left,right;
	int val;

	public Node(int val){
		this.val = val;
	}
}
public class BST_to_DoubleLinkedList {


	public static Node toList(Node root){

		Node prev=null;
		Node head = null;
		NodePair nodePair = new NodePair(prev,head);
		toList(root,nodePair);	 
		return nodePair.head;
	}

	public static void printVal(Node root){

		if(root ==null){
			System.out.println("null");
		}else{
			System.out.println(root.val);
		}

	}

	public static void printVal(NodePair nodePair){

		System.out.print("prev is ");
		printVal(nodePair.prev);
		System.out.print("head is ");
		printVal(nodePair.head);

	}

	public static void printAll(Node root, NodePair nodePair){
		System.out.print("root is ");
		printVal(root);
		printVal(nodePair);
	}

	public static NodePair toList(Node root, NodePair nodePair) {

		if(root==null){
			return nodePair;
		}
		//printAll(root,nodePair);

		toList(root.left,nodePair);
		
		root.left = nodePair.prev;

		if(nodePair.prev != null){
			nodePair.prev.right = root;
		}else{
			//System.out.println("head is Root "+root.val);
			nodePair.head = root;
		}

		nodePair.head.left = root;
		Node right = root.right;		 
		root.right = nodePair.head;
		nodePair.prev = root;
		 
		 
		//printAll(root,nodePair);
		toList(right,nodePair);

		return nodePair; 
	}

	public static void main(String[] args) {
		
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		System.out.print("Inorder traversal : "); 
		printTree(root);
		System.out.println("null");
		Node head = toList(root);
		//System.out.println(head==null);
		printList(head);
		//System.out.print("Singly linked toList traversal : "); 
		//printSingleList(head);
	}

	public static void printTree(Node root){
		if(root == null){
			return;
		}
		if(root.left != null){
			printTree(root.left);
		}
		System.out.print(root.val);
		System.out.print("->");
		if(root.right !=null){
			printTree(root.right);			
		}
	}

	public static void printSingleList(Node root){

		while(root!=null){
			System.out.print(root.val);
			System.out.print("->");
			root = root.right;
		}
		System.out.println("null");
	}

	public static void printList(Node root){

		if(root == null){
			return;
		}

		System.out.println("moving right");
		System.out.print(root.val);
		System.out.print("->");
		 
		Node curr = root.right;
		while(!root.equals(curr)){
			
			System.out.print(curr.val);
			System.out.print("->");
			curr = curr.right;

		}
		System.out.println("null");
		
		System.out.println("moving left");
		curr = root.left;
		System.out.print(root.val);
		System.out.print("->");

		while(!root.equals(curr)){
			
			System.out.print(curr.val);
			System.out.print("->");
			curr = curr.left;

		}
		System.out.println("null");
	}


}