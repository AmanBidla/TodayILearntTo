import java.util.Stack;

class Node{

	Node left,right;
	int val;
	public Node(int val){
		this.val=val;
	}

}
public class CountDuplicatesInBinarySearchTree{
/*				  5     
               /     \ 
            3          10 
          /   \        /   \ 
         2     4     8    10 
              /      / \ 
              3     5   8
                          \ 
                            8

                            */

 
	public static void main(String[] args) {
		
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(10);

		Node l11 = root.left;
		l11.left = new Node(2);
		l11.right = new Node(4);

		Node r22 = l11.right;		 
		r22.left = new Node(3);

		Node r11 = root.right;
		r11.left = new Node(8);
		r11.right = new Node(10);

		Node r21 = r11.left;
		r21.left = new Node(5);
		r21.right = new Node(8);
		r21.right.right = new Node(8);

		System.out.println(" count is "+(countRecursive(root,null)-1));

	}	
	
	static int count=0;
	public static int countRecursive(Node root, Node prev){

			if(root==null) return 0;
			if(prev!=null){
				if(prev.val==root.val) count++;
			}
			return count+countRecursive(root.left,root)+countRecursive(root.right,root);

	}


	public static int count(Node root){

		int prev =Integer.MAX_VALUE;
		int count=0;
		Stack<Node> st = new Stack<Node>();
		while(!st.isEmpty() || root!=null){

			if(root!=null){
				st.push(root);
				root=root.left;

			}else{

				root = st.pop();
				if(root.val==prev){
					count++;
				}else{
					prev=root.val;
				}

				root=root.right;
			}
		}

		return count;
	}

}