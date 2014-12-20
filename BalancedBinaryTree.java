
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class BalancedBinaryTree{


 	  public boolean isBalanced(TreeNode root) {
    	
 		if(root==null){
 			return true;
 		}
 		int val= isBalancedTree(root);
        
        if(val==-1) return false;
        
        return true;
    }

    private int isBalancedTree(TreeNode root){

    	if(root==null){
    		return 0;
    	}
    	int lVal = isBalancedTree(root.left);
    	
    	if(lVal==-1){
    		return -1;
    	}

    	int rVal = isBalancedTree(root.right);

    	if(rVal==-1){
    		return -1;
    	}

    	if(Math.abs(lVal-rVal)>1){
    		return -1;
    	}

    	return lVal>rVal?lVal+1:rVal+1;

    }
}