public class isSymmetricBinaryTree{


	public boolean isSymetric(Node root){

		return isMirror(root.left, root.right);
	}

	public boolean isMirror(Node left, Node right){

		if(left==null || right==null) return left==null && right==null;

		return left.val==right.val && isMirror(left.left, left.right)  && isMirror(right.left,right.right);

	}
}