class Node{
	Node left, right;
	int data;
	int leftCount;
}

public class KthSmallestElementInBST_O_of_H {


	public static Node root;

	public static Node insert(Node root,Node node){

		if(root==null){
			root = node;
			return root;
		}

		Node curr = root;
		Node currParent = root;

		while (curr != null) {

			currParent = curr;
			if(node.data<curr.data){
				curr.leftCount++;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		if (node.data<currParent.data) {
			currParent.left = node;
		} else {
			currParent.right = node;
		}

		return root;
	}

	public static Node KthSmallestNode(int k){

		if(root==null){
			return null;
		}

		Node curr = root;
		while (curr != null) {

			if( curr.leftCount+1==k){
				return curr;
			} else if(k> curr.leftCount) {
				k = k-(curr.leftCount+1);
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		return null;
	}

	public static int KthSmallest(int k){
		Node node = KthSmallestNode(k);
		if(node ==null){
			return Integer.MAX_VALUE;
		} else {
			return node.data;
		}
	}

	public static void main(String[] args) {
		
		int array[] = { 20, 8, 22, 4, 12, 10, 14 };
		buildTree(array);		  
		for(int i=1;i<=array.length;i++) {
			System.out.println(i+"th smallest element is "+KthSmallest(i));
		}
	}

	public static void buildTree(int[] array) {
		
		for(int i=0;i<array.length;i++) {
			Node node = new Node();
			node.data = array[i];
			root = insert(root,node);
		}
	}


}