class Node{
	Node next;
	int val;
	public Node(int val,Node next){
		this.val=val;
		this.next=next;
	}
}
public class RemoveDuplicates{

	public static Node removeDup(Node head){

		Node current = head;

		while(current!=null){

			Node nextNode = current.next;
			if(nextNode!=null){

				if(nextNode.val==current.val){
					current.next=nextNode.next;
					current=current.next;
					nextNode=null;
				}else{

					current=nextNode;
				}
			}
		}

		return head;
	}

	public static void main(String[] args) {
		
		Node head = new Node(1,null);
		Node n1 = new Node(1,null);
		Node n2 = new Node(2,null);
		Node n3= new Node(3,null);
		Node n4 = new Node(3,null);

		head.next= n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;

		Node current = head;

		while(head!=null){
			if(head.next!=null)
			    System.out.print(head.val+"->");
			else
				System.out.print(head.val);
			head=head.next;
		}
		System.out.println("");
		head = current;
		head = removeDup(head);

		while(head!=null){
			if(head.next!=null)
			    System.out.print(head.val+"->");
			else
				System.out.print(head.val);
			head=head.next;
		}
		System.out.println("");
	}

}