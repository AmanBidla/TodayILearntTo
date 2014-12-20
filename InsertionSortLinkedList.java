class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  	}
public class InsertionSortLinkedList{
	
  	public static void main(String[] args) {
  		ListNode n1 = new ListNode(2);
  		ListNode n2 = new ListNode(3);
  		ListNode n3 =new ListNode(4);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 =new ListNode(1);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		insertionSortList(n1);
		show(n1);
  	}	

  	private static void show(ListNode head){
  		
  		while(head!=null){
  			System.out.println(head.val);
  			head = head.next;
  		}
  	}   
	public static ListNode insertionSortList(ListNode node) {
        
       if(node==null || node.next==null){
           return node;
       }
       ListNode head = null;
       while(node!=null){
           ListNode curr = node;
           node = node.next;
           if( head ==null || curr.val<head.val ){
               curr.next = head;
               head = curr;
           }else{
               ListNode p = head;
               while(p!=null){
                   if( p.next==null || curr.val<p.next.val ){
                       curr.next = p.next;
                       p.next = curr;
                       break;
                   }
                   p=p.next;
               }
           }
       }
       return head;
    }

}