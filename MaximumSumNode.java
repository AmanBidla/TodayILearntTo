public class MaximumSumNode {
	
	private static class Node{

		Node left, right;
		int value;
		public Node(Node left, Node right,int value){
			this.left=left;
			this.right=right;
			this.value=value;
		}
	}

	private static Node targetNode = null;

	private static void findMaxNode(Node root,int maxSum,int currSum){

		if(root==null) return;;

		currSum+= root.value;

		if(root.left==null && root.right==null){
			//System.out.println("current sum "+currSum+" maxSum "+maxSum+" compare "+(maxSum<currSum));
			if(maxSum<currSum){
				maxSum=currSum;
				
				//System.out.println("target "+maxNode.value);
				targetNode= root;
				return;
			}
 		}
 
	 	findMaxNode(root.left,maxSum,currSum);
	 	findMaxNode(root.right,maxSum,currSum);		 
	 
	}

	private static boolean showPathToMax(Node root, Node target){

		if(root==null) return false;
		if((root==target) || showPathToMax(root.left,target) || showPathToMax(root.right,target)){
			System.out.println(target.value);
		}
		return false;
	}

	public static void main(String[] args) {
		
		Node root = new Node(null,null,10);
		root.left = new Node(null,null,-2);
		root.right = new Node(null,null,7);
		root.left.left = new Node(null,null,8);
		root.left.right = new Node(null,null,-4);

		findMaxNode(root);

	}
	

	private static void findMaxNode(Node root){
		if(root==null) return;
		int max = Integer.MIN_VALUE;
		findMaxNode(root,max,0);
		//System.out.println("sum is "+sum);
		System.out.println("taget is "+targetNode.value);
		showPathToMax(root,targetNode);

	}

}