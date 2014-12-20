public class ReorderLinkedList{

	public void reorderList(ListNode head) {
     if(head==null || head.next==null){
         return;
     }   
     ListNode slow=head;
     ListNode fast=head;
     while(fast!=null && fast.next!=null && fast.next.next!=null){
         slow = slow.next;
         fast = fast.next.next;
     }
     ListNode second = slow.next;
     slow.next = null;
     second = reverse(second);
     merge(head,second);
    }
    
    private ListNode reverse(ListNode node){
        if(node==null || node.next==null){
            return node;
        }
        ListNode pre = node;
        ListNode curr = node.next;
        while(curr!=null){
            ListNode t = curr.next;
            curr.next = pre;
            pre = curr;
            curr = t;
        }
        node.next = null;;
        return pre;
    }
    
    private void merge(ListNode first,ListNode second){
        if(first==null || second==null){
            return;
        }
        ListNode p1 = first;
        ListNode p2= second;
        while(p2!=null){
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1=t1;
            p2=t2;
        }
    }
}