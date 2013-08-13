public class DList<E> {

	/* header points head of list, tail points to last element and current points to current element of list */
	private DListNode<E> head;
	private DListNode<E> tail;
	/* need to be protected as current is accessed by other classes */
	protected  DListNode<E> current;

	/* keeps count of nodes in list */
	private int counter;

	/* public constructor */
	public DList(){
		current = head = tail =  new DListNode(null) ;
	}

	public DList(int n){
		counter = n;
	}

	/* clears list */
	public void clear(){

		current = head = tail = new DListNode<E>(null);
	}


	 
	/* insert item after the curernt position */
	public void insert(E item){

		current.setNext(new DListNode<E>(item,current.getNext()));

		if(tail == current) tail = current.getNext();

		counter++;

	}

	/* append item to end of list */
	public void append(E item){

		tail = tail.setNext(new DListNode<E>(item,null));

		counter++;

	}


	/* remove current item from list and returns deleted items */
	public E remove(){

		if(current==head) return null;

		E element = current.getNext().getElement();

		if(current.getNext()==tail)  tail = current;

		current.setNext(current.getNext().getNext());

	 	counter --;

	 	return element;

	}


	/* move to start position */
	public void moveToStart(){
		System.out.println("inside move to start");
		current = head;
	}

	/* move to end of list */
	public void moveToEnd(){
		current= tail;
	}

	/* move p positions ahead */
	public void movePPositions(int p){

		assert (p<0 || p>counter): "p out of range";

		for(int i=0;i<p;i++){
			current = current.getNext();
		}
	}

	/* get total number of items */
	public int length(){
		return counter;
	}

	/* move one position right. if end of list then no change */
	public void next(){
		if(current== tail) return;
		current = current.getNext();
		 
	}

	/* move one position left. if starting position then no change */
	public void prev(){
		if(current== head) return;
		 DListNode<E> temp = head;
		 while(temp.getNext()!=current){
		 	temp = temp.getNext();
		 }
		 current =temp;

	}

	/* return current postion */
	public int currentPostion(){
		System.out.println("inside current position");
		int i;
		DListNode<E> temp = head;
		for(i=0;temp!=current;i++)
			temp = temp.getNext();

		System.out.println("current position is "+i);
		return i;
	}

	/* get value of current element */
	public E getValue(){
		if(current.getNext()==null) return null;
		return current.getNext().getElement();
	}





}