class Node{

	Node left,right;
	int val;
	public Node(int val, Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;	
	}
}
public class DiameterOfTree{

	 

	public static int[] diameter(Node root){
 	 	

 	 	 int [] result={0,0}; // 1st element is diameter and 2nd element is height
 	 	 if(root==null){ return result;};

 	 	 int [] leftResult = diameter(root.left);
 	 	 int [] rightResult = diameter(root.right);
 	 	 result[1]=Math.max(leftResult[1], rightResult[1])+1;
 	 	 int rootDiam = leftResult[1]+rightResult[1]+1;
 	 	 int leftDiam = leftResult[0];
 	 	 int rightDiam = rightResult[0];
 	 	 result[0]= Math.max(rootDiam, Math.max(leftDiam, rightDiam));

 	 	 return result;

	}


  /* Constructed binary tree is 
            1
          /   \
        2      3
      /  \
    4     5
  */
	public static void main(String[] args) {
			
		Node root = new Node(1,null,null);
		root.left = new Node(2,null,null);
		root.right = new Node(3,null,null);

		Node left = root.left;
		left.left = new Node(4,null,null);
		left.right = new Node(5,null,null);
		System.out.println(diameter(root)[0]);

	}


}