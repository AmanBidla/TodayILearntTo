class Node{

	int data;
	Node next;
	public Node(int data, Node next){
		this.data=data;
		this.next=next;
	}

}
public class MergeSortedListIteratively{

	public static void main(String[] args) {
			Node l1 = new Node(0,null);
			Node l2 = new Node(3,null);
			Node l3 = new Node(5,null);
			Node l4 = new Node(9,null);
			l1.next=l2;
			l2.next=l3;
			l3.next=l4;
			 
			Node n1 = new Node(2,null); 
			Node n2 = new Node(4,null);
			Node n3 = new Node(6,null);
			Node n4 = new Node(10,null);
			n1.next=n2;
			n2.next=n3;
			n3.next=n4;
			Node merge = iterate(l1,n1);
			while(merge!=null){
				if(merge.next==null){
					System.out.print("["+merge.data+"]");
				}else{
					System.out.print("["+merge.data+"]->");	
				}
				merge=merge.next;
			}
			System.out.println("");

	}

	public static Node iterate( Node l1,Node l2){

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

			if(l1.next.data>l2.data){
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