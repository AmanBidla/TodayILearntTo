class Node{
		Node left,right;
		int val;
		Node(int val){
			this.val=val;
		}
		public String toString(){
			String s = this.val+"";
			if(this.left!=null)
			s+= this.left.toString();
			if(this.right!=null) 
				s+= this.right.toString();
			return s;
		}
	}
public class BinaryTreeFromInorderPreorder {

	private Node construct(int preSt, int preEnd, int [] pre, int inSt, int inEnd, int[] in){
		System.out.println("preend "+preEnd+" preSt "+preSt);
		if((preEnd-preSt)==0){
			return null;//new Node(pre[preSt]);
		}

		Node root = new Node(pre[preSt]);

		int k=0;

		for(int  i=inSt;i<inEnd;i++){
			if(i==root.val){
				k=i;
				break;
			}
		}
		System.out.println("preSt+1 "+(preSt+1)+" preSt+1+k "+(preSt+1+k)+" k "+k);

		root.left= construct(preSt+1,preSt+1+k,pre,inSt,k+1,in);
		root.right = construct(preSt+k+1, preEnd,pre,k+1,inEnd,in);
		return root;
	}

	public  Node construct(int[] pre, int[] in){
		return construct(0,pre.length,pre,0,in.length,in);
	}

	

	public static void main(String[] args) {
		int []pre ={7,10,4,3,1,2,8,11};
		int [] in ={4,10,3,1,7,11,8,2};
		BinaryTreeFromInorderPreorder b = new BinaryTreeFromInorderPreorder();
		Node root = b.construct(0, pre.length-1,pre,0,in.length-1,in);
		//System.out.println(root.toString());
		//b.inOrder(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);

	}

	private void inOrder(Node root){

		if(root==null)
			return;
		if(root.left!=null){
			inOrder(root.left);
		}
		System.out.println(root.val);
		if(root.right!=null){
			inOrder(root.right);
		}
	}

}