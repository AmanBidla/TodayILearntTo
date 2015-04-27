import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackUsingQueue<E>{



	Queue<E> q1 = new LinkedList<E>();
	Queue<E> q2 = new LinkedList<E>();

	public void push(E elem){
		q1.add(elem);
	}


	public E pop(){

		if(q1.isEmpty() && q2.isEmpty()) throw new NoSuchElementException("No element to pop");

		while(q1.size()>1){
				q2.add( q1.remove());
		}
			
		E elem = q1.remove();

		// swap q1 and q2
		Queue<E> temp = q1;
		q1=q2;
		q2=temp;

		return elem;
	}


	public static void main(String[] args) {
		
		StackUsingQueue<Integer> st = new StackUsingQueue<Integer>();
		st.push(2);
		st.push(3);
		System.out.println(st.pop());
		st.push(4);
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.push(23);
		System.out.println(st.pop());


	}
}