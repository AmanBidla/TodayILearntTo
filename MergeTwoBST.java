import java.util.Queue;
import java.util.LinkedList;

class NodePair{

	Node prev,head;
	public NodePair(Node prev, Node head){
		this.prev = prev;
		this.head = head;
	}

}

class Node {

	Node left,right;
	int val;

	public Node(int val){
		this.val = val;
	}
}
public class MergeTwoBST {

	public static Node buildTreeOne(){
        Node root = new Node(5);
        root.left = new Node(2);
        root.right  = new Node(10);
        return root;
    }
    
    public static Node buildTreeTwo(){
        Node root = new Node(6);
        root.left = new Node(4);
        root.right  = new Node(11);
        return root;
    }

	public static Node toList(Node root){

		Node prev=null;
		Node head = null;
		NodePair nodePair = new NodePair(prev,head);
		toList(root,nodePair);	 
		return nodePair.head;
	}

	public static void printVal(Node root){

		if(root ==null){
			System.out.println("null");
		}else{
			System.out.println(root.val);
		}

	}

	public static void printVal(NodePair nodePair){

		System.out.print("prev is ");
		printVal(nodePair.prev);
		System.out.print("head is ");
		printVal(nodePair.head);

	}

	public static void printAll(Node root, NodePair nodePair){
		System.out.print("root is ");
		printVal(root);
		printVal(nodePair);
	}

	public static NodePair toList(Node root, NodePair nodePair) {

		if(root==null){
			return nodePair;
		}
		 

		toList(root.left,nodePair);
		
		 

		if(nodePair.prev != null){
			nodePair.prev.right = root;
		}else{
			//System.out.println("head is Root "+root.val);
			nodePair.head = root;
		}
 
		Node right = root.right;		 		 
		nodePair.prev = root;
		root.left = null; 
		 
		//printAll(root,nodePair);
		toList(right,nodePair);


		return nodePair; 
	}

	static Node copy;

	public static void main(String[] args) {
			
		// build tree
		Node rootOne = buildTreeOne();
		Node rootTwo = buildTreeTwo();
		

		// convert to single linked list
		rootOne = toList(rootOne); 
		
		rootTwo = toList(rootTwo);
		printSingleList(rootOne);
		printSingleList(rootTwo);


		// merge single linked list
		Node root = merge(rootOne, rootTwo);
  		printSingleList(root); 

  		int N = lengthOfList(root);
  		copy  = root;
  		Node bstRoot = convertToBST(0,N-1);
  		//System.out.println("bst val "+bstRoot.val);
  		printLevelOrderTree(bstRoot);
	}

	public static Node convertToBST(int start, int end){

		if(start > end) return null;

		int mid = (start+end)/2;
		Node left = convertToBST(start,mid-1);
		Node root = new Node(copy.val);		
		copy = copy.right;
		Node right = convertToBST(mid+1,end);
		root.left = left;
		root.right = right;
		return root;
	}

	public static Node merge(Node rootOne, Node rootTwo){

		if(rootOne==null) return rootTwo;
		if(rootTwo==null) return rootOne;

		Node fakeHead = new Node(-100);
		Node head = fakeHead;
		while(rootOne !=null && rootTwo !=null){

			if(rootOne.val<rootTwo.val){
				head.right =rootOne;
				rootOne = rootOne.right;
			}else if(rootOne.val>rootTwo.val){
				head.right =rootTwo;
				rootTwo = rootTwo.right;
			}else{
				head.right =rootTwo;
				rootTwo = rootTwo.right;
				rootOne = rootOne.right;
			}
			head = head.right;
		}

		if(rootOne!=null){
			head.right = rootOne;
		}
		if(rootTwo!=null){
			head.right = rootTwo;
		}

		return fakeHead.right;

	}

	public static void printLevelOrderTree(Node root){
        
        if(root == null){
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Node> curr = new LinkedList<Node>();
        //System.out.println("root val "+root.val);
        queue.add(root);
        while(!queue.isEmpty()){
            
            Node node = queue.remove();
            System.out.print(node.val);
            if(node.left !=null){
                curr.add(node.left);
            }
            if(node.right!=null){
                curr.add(node.right);
            }
            
            if(queue.isEmpty()){
                queue = curr;
                curr = new LinkedList<Node>();
                System.out.println();
            }
        }
        
    }


	public static void printTree(Node root){
		if(root == null){
			return;
		}
		if(root.left != null){
			printTree(root.left);
		}
		System.out.print(root.val);
		System.out.print("->");
		if(root.right !=null){
			printTree(root.right);			
		}
	}

	public static void printSingleList(Node root){

		while(root!=null){
			System.out.print(root.val);
			System.out.print("->");
			root = root.right;
		}
		System.out.println("null");
	}

	public static int lengthOfList(Node root){
		int N=0;
		while(root !=null){
			root = root.right;
			N++;
		}
		System.out.println("length is "+N);
		return N;
	}

	 


}