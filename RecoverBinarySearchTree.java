class Node{
	Node left,right;
	int val;
	public Node(int val){
		this.val = val;
	}
}
public class RecoverBinarySearchTree {


	public static void recover(Node root){

		if(root ==null){
			return;
		}
		Node pre =null, a=null, b=null;

		while(root != null) {

			if(root.left!=null){

				Node predecessor = root.left;

				while(predecessor.right!=null && predecessor.right != root){
					predecessor = predecessor.right;
				}

				if(predecessor.right==null){
					predecessor.right = root;
					root = root.left;
				} else {

					if(pre!=null && pre.val > root.val){
						if(a==null){
							a =pre;
						}
						b =root;
					}
					pre =root;
					predecessor.right=null;
					root =root.right;
				}
			} else {
				// root has  no left child
				if(pre!=null && pre.val > root.val){
					if(a==null){
						a =pre;
					}
					b =root;
				}
				pre =root;
				root = root.right;

			}
		}

		if(a!=null && b!=null){
			int temp = a.val;
			a.val = b.val;
			b.val = temp;
		}
	}

	public static void main(String[] args) {
		
		// use java -ea RecoverBinarySearchTree

		//[2,null,3,1]
		Node root = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(1);
		recover(root);

		// [1,null,3,2]
		assert root.val==1:"incorrect value";
		assert root.left==null:"incorrect value";
		assert root.right.val==3:"incorrect value";
		assert root.right.left.val==2:"incorrect value";

	}


}