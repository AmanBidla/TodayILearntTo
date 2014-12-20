public class MaxSumPathBinaryTree{


	private class Node{

		int value;
		Node left,right;

		public Node(int value){
			this.value=value;
		}
	}


	public Node createTree(){

		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);

		return root;
	}

	public   int max;

	public int maxPathSum(Node root) {
     Integer[] val = new Integer[1];
     dfs(root,val);
     return val[0];
    }
    private int dfs(Node root,Integer [] val){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left,val);
        int right = dfs(root.right,val);
        int current = root.val;
        int currMax = Math.max(current, Math.max(current+left, current+right));
        if(val[0]==null){
            val[0]=current;
        }else{
            val[0]= Math.max(val[0],Math.max(left+right+current,currMax));
        }
        return currMax;
    }

	public static void main(String[] args) {
		MaxSumPathBinaryTree m = new MaxSumPathBinaryTree();
		Node root = m.createTree();
		System.out.println(m.max(root));

	}



}