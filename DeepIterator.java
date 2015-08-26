import java.util.Iterator;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DeepIterator implements Iterator<Integer>{

	private Stack<Iterator<Integer>> st = new Stack<Iterator<Integer>>();
	private Integer top=null;

	public DeepIterator(Iterable itr){
		st.push(itr.iterator());
	}

	@Override
	public boolean hasNext(){
		if(top!=null) return true;
		
		while(!st.isEmpty()){
			Iterator<Integer> iterator = st.peek();
			if(iterator.hasNext()){

				Object t = iterator.next();
				if(t instanceof Integer){
					top = (Integer) t;
					return true;
				}else if (t instanceof Iterable){
					Iterable<Integer> nextIterable = (Iterable<Integer>) t;
					Iterator<Integer> nextIterator = nextIterable.iterator();
					st.push(nextIterator);
				}else throw new RuntimeException ("No such data type");
			}else{
				st.pop();
			}
		}
		return false;
	}

	@Override
	public Integer next() throws NoSuchElementException {
		if(hasNext()){
			Integer t = top;
			top =null;
			return t;
		}

		throw new NoSuchElementException("No such element ");
	}

	@Override
	public void remove(){

	}


	public static void main(String[] args) {
		
		List list = new LinkedList();
		list.add(1);
		list.add(2);
		List l1 = new LinkedList();
		l1.add(3);
		l1.add(4);
		List l2 = new LinkedList();
		l2.add(5);
		l1.add(6);
		list.add(l1);
		list.add(7);
		list.add(8);

		DeepIterator deepIterator = new DeepIterator(list);
		List<Integer> newList = new LinkedList<Integer>();

		while(deepIterator.hasNext()){
			newList.add( deepIterator.next());
		}

		Iterator<Integer> it = newList.iterator();
		while(it.hasNext()){
			System.out.print( it.next()+" -> ");
		}
		System.out.println("NULL");



	}

}