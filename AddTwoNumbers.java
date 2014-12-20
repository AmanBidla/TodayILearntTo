public class AddTwoNumbers{


 
  
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode p1=l1,p2=l2,newHead = new ListNode(0);
        ListNode p3 = newHead;
        int carry=0;
        while( p1!=null || p2!=null ){
            if(p1!=null){
                carry+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                carry+=p2.val;
                p2=p2.next;
            }
            p3.next = new ListNode(carry%10);
            p3=p3.next;
            carry/=10;
        }
        if(carry==1){
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }
}
