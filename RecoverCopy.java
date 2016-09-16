class Node{
	int val;
	Node left, right;
}
public class RecoverCopy {

	public static void fix(Node root){

		Node prev, a, b;

		while(root != null){

			root;
			if(curr.left != null){

				Node left = curr.left;
				while(left.right!=null && left.right!=curr){
					left = left.right;					
				}

				if(left.right==null){
					left.right = curr;	
					root = root.left;				
				} else{
					if(prev!=null && prev.val>root.val){
						a = prev;
					}
					b = root;
					prev  = root;
					left.right = null;
					root = root.right;
				}
			} else{
				
				if(prev!=null && prev.val>root.val){
					a = prev;
				}
				b = root;
				root = root.right;

			}
		}

		if(prev!=null && start!=null){
			int t = prev.val;
			prev.val=start.val;
			start.val = t;
		}
	}

}