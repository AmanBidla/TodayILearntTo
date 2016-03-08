import java.util.Stack;

public class MinStack<Integer> extends Stack<Integer> {

	private Stack<Integer> st;

	public MinStack(){
		st = new Stack<Integer>();
	}

	public void push(Integer elem){

		Integer minElem = getMinElement();
		if(minElem.compareTo(elem) <=0 ){
			st.push(elem);			
		} 
		super.push(elem);
	}

	public static void main(String[] args) {
		
		MinStack<Integer> minStack = new MinStack<Integer>();
	}

	private Integer getMinElement(){
		return st.peek();
	}

}