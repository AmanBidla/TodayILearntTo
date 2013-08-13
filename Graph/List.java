public interface List<E> {

	/* clears list */
	public void clear();

	 
	/* insert item after the curernt position */
	public void insert(E item);

	/* append item to end of list */
	public void append(E item);


	/* delete item from list and returns deleted items */
	public E remove();


	/* move to start position */
	public void moveToStart();

	/* move to end of list */
	public void moveToEnd();

	/* move p positions ahead */
	public void movePPositions(int p);

	/* get total number of items */
	public int length();

	/* move one position right. if end of list then no change */
	public void next();

	/* move one position left. if starting position then no change */
	public void prev();

	/* return current postion */
	public int currentPostion();

	/* get value of current element */
	public E getValue();

}	