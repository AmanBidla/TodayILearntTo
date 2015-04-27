class Node{

	int val;
	Node left, right;

	public Node(int val, Node left, Node right){
		this.left=left;
		this.right=right;
		this.val=val;
	}
}
public class MaxPathSum{

	static int max=0;

	public static int max(Node root){

		if(root==null) return 0;
		max = root.val;
		find(root);
		return max;
	}

	private static int find(Node root){

		if(root==null) return 0;

		int left = Math.max( find(root.left), 0);
		int right= Math.max( find(root.right),0);

		max = Math.max(max, root.val+left+right);
		return root.val+Math.max(left, right);
	}

	public static void main(String[] args) {
		
		Node root = new Node(1,null,null);
		Node left = new Node(2,null,null);
		Node right = new Node(3,null,null);
		root.left =left;
		root.right =right;
		System.out.println(max(root));

	}


}