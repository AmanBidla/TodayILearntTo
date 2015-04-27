public class Node{

	final Entry entry;
	Node prev, next;
	
	public Node(Entry entry,Node prev, Node next){
		this.entry = entry;
		this.next=next;
		this.prev=prev;
	}

	public Entry getEntry(){
		return entry;
	}

	public void setNext(Node next){
		this.next=next;
	}

	public void setPrev(Node prev){
		this.prev=prev;
	}

	public Node getPrev(){
		return prev;
	}

	public Node getNext(){
		return next;
	}

}