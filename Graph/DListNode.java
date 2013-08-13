public class DListNode<E>{

	/* value of the element in node */
	private E element;

	/* pointer to next node  */
	private DListNode<E> next;

	public DListNode(E element,DListNode<E> next){
		this.next= next;
		this.element=element;
	}

	/* constructor which sets creates a new header */
	public DListNode(DListNode<E> next){
		this.next = next;
	}

	/* getters and setters for next and element begins */
	public DListNode<E> setNext(DListNode<E> next){
		return this.next=next;
	}

	public DListNode<E> getNext(){
		return next;
	}


	public E getElement(){
		return element;
	}
	/* End of getters and setters for next and element */
}