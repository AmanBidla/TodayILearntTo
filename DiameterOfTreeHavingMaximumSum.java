class Node{

	Node left,right;
	int val;
	public Node(int val, Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;	
	}
}
public class DiameterOfTreeHavingMaximumSum{

	  

  /* Constructed binary tree is 
            -1000
          /   \
        2      3000
      /  \
    1000  1000
  */

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print("  " + root.val);
            inorder(root.right);
        }

    }


	public static void main(String[] args) {
			
		Node root = new Node(-1000,null,null);
		root.left = new Node(2,null,null);
		root.right = new Node(3000,null,null);

		Node left = root.left;
		left.left = new Node(1000,null,null);
		left.right = new Node(1000,null,null);		 
		 
		////// ////// ////// ////// 
		/// USE BELOW CODE     ///
		///// ////// ////// ////// 
		maxVal=0;
		maxDiameter(root);
		System.out.println(maxVal);

	}

	static int maxVal=0;
	private static int maxDiameter(Node root){

		if(root == null){
			return 0;
		}else{

			int leftSum = maxDiameter(root.left);
			int rightSum = maxDiameter(root.right);
			int currSum =0;
			if(leftSum<0 && rightSum<0){
				currSum = root.val;
			}else{
				currSum = Math.max(root.val+leftSum+rightSum, Math.max(leftSum,rightSum));
			}
			if(currSum>maxVal){
				maxVal=currSum;
			}
			return Math.max(leftSum,rightSum)+root.val;
		}

	}


}