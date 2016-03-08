import java.util.PriorityQueue;
import java.util.Comparator;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class MergeKSortedList {

	public static void main(String[] args) {
		
		//[[1,6,8], [3,5,9]]
		ListNode [] lists = new ListNode[3];
		ListNode one = new ListNode(1); one.next = new ListNode(6); one.next.next = new ListNode(8);		
		ListNode two = new ListNode(3); two.next = new ListNode(5); two.next.next = new ListNode(9);
		ListNode three = new ListNode(2); three.next = new ListNode(7);
		lists[0] = one;
		lists[1] = two;
		lists[2] = three;		 
		print(mergeKLists(lists));


		ListNode [] listsTestTwo = new ListNode[2];
		listsTestTwo[0] = new ListNode(1);
		listsTestTwo[1] = new ListNode(0);
		print(mergeKLists(listsTestTwo));
		


		ListNode [] listsTestThree = new ListNode[2];
		ListNode oneCopy = new ListNode(1); oneCopy.next = new ListNode(6); oneCopy.next.next = new ListNode(8);		
		listsTestThree[0]= one; 
		listsTestThree[1]= oneCopy;
		print(mergeKLists(listsTestThree));


		ListNode [] listsTestFour = new ListNode[2];
		listsTestFour[0]= null; 
		listsTestFour[1]= null;
		print(mergeKLists(listsTestFour));


	}

	public static ListNode mergeKLists(ListNode[] lists) {
        
        if( (lists == null) || (lists.length ==0) ){
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode> ( lists.length, new Comparator<ListNode>(){

        		@Override
        		public int compare(ListNode l1, ListNode l2) {

        			if(l1.val < l2.val) return -1;
        			else if(l1.val > l2.val) return 1;
        			else return 0;
        		}
        });
        

        for(ListNode listNode : lists){
        	if(listNode != null) {
        		queue.add(listNode);	
        	}        	
        }

        ListNode head = new ListNode(-100);
        ListNode p = head;

         

        while(!queue.isEmpty()) {

        	ListNode temp = queue.remove();
        	 
        	p.next = temp;
        	if(temp.next != null){
        		temp = temp.next;
        		queue.add(temp);
        	}

        	p = p.next;
        }

        return head.next;
         
    }

    private static void print(ListNode result){

    	while(result!=null){
    		System.out.print(result.val+" -> ");
    		result = result.next;
    	}
    	System.out.println();
    }

 
    
     
}