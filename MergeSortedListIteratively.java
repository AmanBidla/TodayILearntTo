public class MergeSortedListIteratively{


	public List<Node> iterate( List<Node> l1,List<Node> l2){

		if(l1==null)
			return l1;
		if(l2==null)
			return l2;

		Node head;
		if(l1.data<=l2.data){
			head = l1;
		}else{
			head=l2;
			l2=l1;
			l1=head;
		}

		while(l1.next!=null && l2!=null){

			if(l1.next.data<l2.data){
				Node swap = l1.next;
				l1.next=l2;
				l2=swap;
			}
			l1=l1.next;
		}

		if(l1.next==null)
			l1.next=l2;

		return head;

	}

}