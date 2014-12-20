   class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; next = null; }
   }
	 
 
  
   class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
  
public class convertLinkedListToBST {
    public TreeNode sortedListToBST (ListNode head) {
         if(head==null){
            return null;
        }
        ListNode copy=head;
        int len = length(copy);
        if(len==1){
            return new TreeNode(head.val);
        }
        int mid=len/2;
        ListNode leftHead=null;
        ListNode left=leftHead;
        for(int i=0;i<mid;i++){
            if(left==null){
                left=head;
                leftHead=left;
            }else{
                left.next=head;
                left=left.next;
            }
            head=head.next;
        }
        if(left!=null){
            left.next=null;
        }
        TreeNode root = new TreeNode(head.val);
        head=head.next;
        ListNode rightHead=null;
        ListNode right=rightHead;
        for(int i=mid+1;i<len;i++){
            if(right==null){
                right=head;
                rightHead=right;
            }else{
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        if(right!=null){
            right.next=null;    
        }
        
        root.left= sortedListToBST(leftHead);
        root.right= sortedListToBST(rightHead);
        return root;
    }
    
    public int length(ListNode head){
        if(head==null){
            return 0;
        }
        if(head.next==null){
            return 1;
        }
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }


    public static void main(String[] args) {
    	
    	ListNode head = new ListNode(3);
    	ListNode next = new ListNode(5);
    	head.next = next;
    	next = new ListNode(8);
    	head.next.next = next;

    	convertLinkedListToBST c = new convertLinkedListToBST();
    	TreeNode node = c.sortedListToBST(head);

    }

}

 