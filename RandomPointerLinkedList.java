class Node{

	Node next;
	Node random;
	int val;

	public Node(int val, Node next){
		this.next=next;
		this.val=val;
	}

}
public class RandomPointerLinkedList{


	public static void main(String[] args) {
		

			Node node = new Node(1,null);
			Node n2= new Node(2,null);
			Node n3 = new Node(3,null);
			Node n4 = new Node(4,null);
			Node n5 = new Node(5,null);

			node.next = n2;
			n2.next = n3;
			n3.next = n4;
			n4.next = n5;

			node.random=n3;
			n2.random=node;
			n3.random=n5;
			n4.random=n3;
			n5.random=n2;

			Node result = deepCopy(node);
			Node copyResult = result;

			while(result!=null){

				if(result.next!=null){
					System.out.print(result.val+"->");
				}else{
					System.out.print(result.val);
				}
				result = result.next;
			}
			System.out.println("");
			while(copyResult!=null){

				if(copyResult.next!=null){
					System.out.print(copyResult.random.val+"->");
				}else{
					System.out.print(copyResult.random.val);
				}
				copyResult = copyResult.next;
			}
			System.out.println("");


	}

	public static Node deepCopy(Node head){


		Node node = head;
		while(node!=null){

			Node copyNode = new Node(node.val,null);
			Node nextNode = node.next;
			node.next = copyNode;
			copyNode.next = nextNode;

			node = node.next.next;
		}

		node = head;

		while(node!=null){

			Node copyNode = node.next;
			Node random =node.random;
			copyNode.random=random.next;

			node = node.next.next;

		}

		node = head;
		Node copyhead = node.next;

		while(node.next.next!=null){

			Node copyNode =  node.next;
			Node nextNode = node.next.next;
			Node copyNextNode = nextNode.next;

			copyNode.next = copyNextNode;
			node.next = nextNode;
		}

		return copyhead;

	}


}