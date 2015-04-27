class Node{

	Node next;
	int val;
	public Node(int val){
		this.val=val;
	}
}
public class MiddleElement{


	public static void main(String[] args) {
		
		Node head = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		System.out.println( middle(head).val);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		System.out.println( middle(head).val);


	}


	public static Node middle(Node head){

		Node slow=head,fast=head;
		while(fast!=null& fast.next!=null && fast.next.next!=null){

			 slow=slow.next;
			 fast=fast.next.next;					
		} 


		if(fast!=null && fast.next!=null){
			slow=slow.next;
		}


		return slow;

	}
}