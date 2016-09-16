public class KthSmallestElementInBST{

	private static int K=1, reached=0,showTime=0;

	private class Node{

		int value;
		Node left, right;

		Node(int value){
			this.value =value;
		}
	}

	public Node createTree(){

		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(20);

		root.left.left = new Node(3);
		root.left.right = new Node(8);
		root.left.right.left = new Node(7);

		root.left.left.left = new Node(-7);
		root.left.left.right = new Node(4);

		root.right.left = new Node(15);
		root.right.right = new Node(30);

		return root;
	}

	public void showTree(Node root){

		if(root==null) return;
		showTree(root.left);
		System.out.print(root.value+"-");
		showTree(root.right);

	}

	public static int kthSmallest(Node root, int k) {
        
        int leftCount= count(root.left);
        if(leftCount+1==k){
            return root.value;
        } else if(k>(leftCount+1)){
            k = k-(leftCount+1);
            return kthSmallest(root.right,k);
        } else{
            return kthSmallest(root.left,k);
        }
        
    }
    
    public static int count(Node node){
        if(node==null){
            return 0;
        }
        return 1+count(node.left)+count(node.right);
    }

	public static void main(String[] args) {
		
		KthSmallestElementInBST km = new KthSmallestElementInBST();
		Node root = km.createTree();
		
		for(int i=1;i<=10;i++) {
			System.out.println(i+"th smallest element is "+kthSmallest(root,i));
		} 
		kthSmallest(root,K);
		 
	}


}