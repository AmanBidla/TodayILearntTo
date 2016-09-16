class Node{

	Node left,right;
	int val;
	public Node(int val){
		this.val=val;
	}
}

public class HouseRobberIII{
 
	public static int rob(Node root) {
        
        if(root == null){
            return 0;
        }
        
        int [] max = thief(root);
        return Math.max(max[0], max[1]);
    }
    
    private static int[] thief(Node root){
        int []max = new int[2];
        if(root == null) {
            return max;
        }
        int [] left = thief(root.left);
        int [] right = thief(root.right);
        
        max[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        max[1] =root.val+left[0]+right[0];
        return max;
    }

    public static void main(String[] args) {
    	
    	//[1,null,4,3,null,null,2]
    	Node root = new Node(1);    	 
    	root.right = new Node(4);
    	root.right.left = new Node(3);
    	root.right.left.left = new Node(2);

    	System.out.println(rob(root)); // expecting 6
    }


}