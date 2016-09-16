  
  class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

public class BinarryTreeFromInorderPreorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

        int NP = preorder.length;
        if(NP==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int stop=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                stop=i;
                break;
            }
        }
        int [] preorderLeft;
        int [] preorderRight;
        int [] inorderLeft;
        int [] inorderRight;
        
        if(stop>=0){
            preorderLeft = new int[stop];
            for(int i=0,index=1;i<stop;i++,index++){
                preorderLeft[i]=preorder[index];
            }
            preorderRight = new int[preorder.length-stop-1];
            
            for(int i=stop+1,index=0;i<preorder.length;i++,index++){
                preorderRight[index]=preorder[i];
            }
            inorderLeft = new int[stop];
            for(int i=0;i<stop;i++){
                inorderLeft[i]=inorder[i];
            }
            inorderRight = new int[inorder.length-stop-1];
            for(int i=stop+1,index=0;i<inorder.length;i++,index++){
                inorderRight[index]=inorder[i];
            }
            
        }else{
              
              preorderLeft = new int[0];
              preorderRight = new int[0];
              inorderRight = new int[0];
              inorderLeft = new int[0];
        }
        
        
        root.left = buildTree( preorderLeft, inorderLeft);
        root.right = buildTree( preorderRight, inorderRight );
             
        return root;
    }

}