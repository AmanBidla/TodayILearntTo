import java.util.Stack;

class ListNode{

	ListNode next=null;
	int val=0;

	public ListNode(ListNode next,int val){
		this.next=next;
		this.val=val;
	}
}

class TreeNode{

	TreeNode left, right;
	int val;

	public TreeNode(int val){
		this.val=val;
	}
}

public class LinkedListToBinaryTree{

	private static ListNode listNode;
	private static TreeNode root;

	public static void main(String[] args) {
		
		ListNode head = new ListNode(null,1);
		head.next = new ListNode(null,2);
		head.next.next = new ListNode(null,3);
		head.next.next.next = new ListNode(null,4);
		head.next.next.next.next = new ListNode(null,5);
		head.next.next.next.next.next = new ListNode(null,6);

		TreeNode result = convert(head);
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(result!=null){
			st.push(result);
			result=result.left;
		}

		while(!st.isEmpty()){

			TreeNode node = st.pop();
			System.out.println(node.val);
			if(node.right!=null){
				node = node.right;
				while(node!=null){
					st.push(node);
					node=node.left;
				}
			}
			
		}



	}

	public static TreeNode convert(ListNode head){

		if(head==null){
			return null;
		}

		listNode = head;
		int length = findLength(head);
		TreeNode result = convert(0,length-1);
		return result;
	}

	private static int findLength(ListNode head){
		ListNode curr = head;
		int count =0;
		while(curr!=null){
			count++;
			curr = curr.next;
		}

		return count;
	}

	private static TreeNode convert(int start, int end){

		if(start>=end) return null;

		int mid = (start+end)/2;

		TreeNode left = convert(0, mid-1);
		TreeNode root = new TreeNode(listNode.val);
		listNode = listNode.next;
		TreeNode right = convert(mid+1, end);

		root.left = left;
		root.right =right;

		return root;
	}
}