public class DLinkedList<Node>{

 private Node head;
 private Node tail;
 private int capacity;
 private int size=0;

 public DLinkedList(int N){
 	Entry<String,String> entry = new Entry<>();
 	head = new Node(entry,null,null);
 	tail = head;
 	capacity = N;
 	int size=0;
 }

    public V put(Entry<String,String> entry){
 

	 	if(size<capacity){

	 		Node node = addNode(entry);	
	 	}

	 	

	 	size++;
    }

	private Node addNode(Entry<String,String > entry){

		Node node = new Node(entry, null,null);

	 	if(head.next==null){
	 		head.setNext( node );
	 		node.setPrev=(head );
	 	}else{

	 		tail.setNext(node);
	 		node.setPrev(tail);
	 	}

	 	tail = node;

	 	return node;

	}



}