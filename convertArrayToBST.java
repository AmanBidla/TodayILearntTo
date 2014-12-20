 class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

public class convertArrayToBST {

    public TreeNode sortedArrayToBST(int[] num) {
        return construct(num,0,num.length-1);
    }
    
    public TreeNode construct(int[] array, int st, int end){
        
        if(st>end){
            return null;
        }
        
        if(st==end){
            return new TreeNode( array[st]);
        }
        
        int mid =(st+end)/2;
        TreeNode root = new TreeNode( array[mid]);
        root.left = construct(array,st,mid-1);
        root.right = construct(array,mid+1,end);
        return root;
    }
}