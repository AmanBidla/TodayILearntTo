public class MaxDiameter {
	
	/* O(N) solution */
	private static int [] dimension(Node root){

		int [] result = new int[2];
		if(root==null) return result;
		int leftResult = dimension(root.left);
		int rightResult = dimension(root.right);
		int ht = Math.max( leftResult[1],rightResult[1])+1;
		int rootDiam = leftResult[1]+rightResult[1]+1;
		int leftDiam = leftResult[0];
		int righDiam = rightResult[0];
		result[0]= Math.max(rootDiam, Math.max(leftDiam,righDiam));
		result[1]=ht;
		return result;
	}



}