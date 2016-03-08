import java.util.Stack;

public class SortStackWithOnlyOneAdditionalStack {


	public static Stack<Integer> sort(Stack<Integer> st, Stack<Integer> t) {

		if(st==null || st.isEmpty()) {
			return null;
		}

		while(true) {

			if (t.isEmpty()) {
				t.push(st.pop());
			}

			int peek = t.peek();
			while (!st.isEmpty() && st.peek()>=peek) {
				t.push(st.pop());
				peek = t.peek();
			}

			if (st.isEmpty()) {
				break;	
			} else {
				 
				int out = st.pop();
				while(!t.isEmpty() && out<t.peek()) {
					st.push(t.pop());
				}
				t.push(out);
				
			}

		}

		while(!t.isEmpty()) {
			st.push(t.pop());
		}

		return st;
	}

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(7);
		st.push(10);
		st.push(5);
		st.push(12);

		st.push(8);
		st.push(3);
		st.push(1);
		
		Stack<Integer> t = new Stack<Integer>();

		Stack<Integer> output = sort(st,t);
		if(output==null) {
			System.out.println("null");
		} else {
			show(output);
		}

		st = new Stack<Integer>();
		t = new Stack<Integer>();
		st.push(5);
		st.push(5);
		st.push(5);
		st.push(5);
		st.push(5);
		output = sort(st,t);
		if(output==null) {
			System.out.println("null");
		} else {
			show(output);
		}

		st = new Stack<Integer>();
		t = new Stack<Integer>();
		st.push(5);
		st.push(5);
		st.push(1);
		st.push(5);
		st.push(15);
		output = sort(st,t);
		if(output==null) {
			System.out.println("null");
		} else {
			show(output);
		}

	}

	private static void show(Stack<Integer> output) {
		System.out.println("|-|");
		while (!output.isEmpty()) {
			System.out.println(output.pop());
		}
		System.out.println("|-|");
	}

}