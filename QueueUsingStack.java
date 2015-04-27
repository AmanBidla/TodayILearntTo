import java.util.Stack;
import java.util.NoSuchElementException;



public class QueueUsingStack<E>{

	Stack<E> stack1 = new Stack<E>();
	Stack<E> stack2 = new Stack<E>();
	
	public void enqueue(E elem){

		stack1.push(elem);

	}

	public E dequeue(){

		if(stack1.isEmpty() && stack2.isEmpty()) throw new NoSuchElementException("No element to pop");

		if(stack2.isEmpty()){

			while(!stack1.isEmpty()){

				stack2.push(stack1.pop());
			}			
		}

		return stack2.pop();
	}

	public static void main(String[] args) {
	
	QueueUsingStack<Integer> q = new QueueUsingStack<Integer>();
	q.enqueue(2);
	q.enqueue(3);
	System.out.println(q.dequeue());
	q.enqueue(4);
	q.enqueue(5);
	System.out.println(q.dequeue());
	q.enqueue(14);
	System.out.println(q.dequeue());



	}
}