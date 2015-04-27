import java.util.Arrays;
import java.util.Stack;

class Node{

	Node left,right;
	int val;
	Node(int val){
		this.val=val;
	}
}
public class BinaryTreeFromInordePostOrder{


	public static  Node convert(int inStart, int inEnd, int[] inorder, int postStart, int postEnd, int[] postOrder){

		if(inStart>inEnd || postStart>postEnd ) return null;
 
		 int rootVal = postOrder[postEnd];
		 Node root = new Node(rootVal);
		 int k=-1;
		 for(int i=0;i<inorder.length;i++){
		 	if(inorder[i]==rootVal){
		 		k=i;
		 		break;
		 	}
		 }

		  
		  root.left = convert(inStart,k-1,inorder,postStart,postStart+k-(inStart+1),postOrder);
		  root.right = convert(k+1,inEnd, inorder, postStart+k-(inStart), postEnd-1, postOrder);
		  

		 return root;
	}

	public static void main(String [] abc){


		int [] inorder ={4,2,5,1,6,7,3,8};
		int [] postOrder={4,5,2,6,7,8,3,1};

		Node root = convert(0,inorder.length-1, inorder, 0, postOrder.length-1, postOrder);
		 
		Stack<Node> st = new Stack<Node>();
		while(root!=null){
			st.push(root);
			root=root.left;
		}

		int [] array= new int[inorder.length];
		int c=0;
		while(!st.isEmpty()){
			Node node = st.pop();
			array[c++]= node.val;
			if(node.right!=null){
				node = node.right;
				while(node!=null){
					st.push(node);
					node=node.left;
				}
			}
		}

		System.out.println(Arrays.toString(array));

	}




}