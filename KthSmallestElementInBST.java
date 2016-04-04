public class KthSmallestElementInBST{

	private static int K=1, reached=0,showTime=0;

	private class Node{

		int value;
		Node left, right;

		Node(int value){
			this.value =value;
		}
	}

	public Node createTree(){

		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(20);

		root.left.left = new Node(3);
		root.left.right = new Node(8);
		root.left.right.left = new Node(7);

		root.left.left.left = new Node(-7);
		root.left.left.right = new Node(4);

		root.right.left = new Node(15);
		root.right.right = new Node(30);

		return root;
	}

	public void showTree(Node root){

		if(root==null) return;
		showTree(root.left);
		System.out.print(root.value+"-");
		showTree(root.right);

	}

	public static int KthSmallest(int K, Node root){

		 if(root==null||K<0) {
		 	return K;
		 }
		 K = KthSmallest(K,root.left);
		 //System.out.println("before K is "+K+ " and root is "+root.value+" reached "+reached);
		  --K;
		 //System.out.println("after K is "+K+ " and root is "+root.value+" reached "+reached);
		 if(K==0){
		 	//System.out.println(">>> K is "+K+ " and root is "+root.value+" reached "+reached);
		 	System.out.println("kth smallest is "+root.value);
		 	reached=1;
		 	return K;
		 }
		 K = KthSmallest(K,root.right);
		 return K;
	}

	public static void main(String[] args) {
		
		KthSmallestElementInBST km = new KthSmallestElementInBST();
		Node root = km.createTree();
		
		//km.showTree(root);
		KthSmallest(K,root);
		 
	}


}