class Node{

	Node left,right;
	int val;
	public Node(int val){
		this.val = val;
	}
}

class MinMax{

	int min;
	int max;
	boolean isBST;
	int size;
	public MinMax(){
		min=Integer.MIN_VALUE;
		max=Integer.MAX_VALUE;
		isBST=false;
		size=0;
	}
}

public class LargestBSTinSubTree {

	public static void main(String[] args) {
		

	}

	public static int largestBST(Node root){

		MinMax m = largest(root);
		return m.size;
	}

	public static MinMax largest(Node root){

		if(root==null) return new MinMax();

		MinMax leftMinMax = largest(root.left);
		MinMax rightMinMax = largest(root.right);
		MinMax m = new MinMax();
		if(!leftMinMax.isBST || !rightMinMax.isBST || leftMinMax.max>root.val || rightMinMax.min<=root.val){
			m.size=0;
			m.isBST=false;
			return m;
		}

		m.isBST=true;
		m.size = leftMinMax.size + rightMinMax.size+1;
		m.min = root.left!=null ? leftMinMax.min: root.val;
		m.max = root.right!=null ? rightMinMax.max:root.val;
		return m;
	}

}