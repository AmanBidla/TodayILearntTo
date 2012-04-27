import java.util.Stack;
public class StackSort{


	public static void main(String ab[]){
		
	Stack <Integer> st = new Stack<Integer>();
	st.push(new Integer(4));
	st.push(new Integer(9));
	st.push(new Integer(2));
	st.push(new Integer(12));
	st.push(new Integer(100));
	st.push(new Integer(1));
	st.push(new Integer(-1));		
	sort(st);
 		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
	
	
	
public static void sort(Stack<Integer> s){
	if(!s.isEmpty()){
		int x= s.pop();
		sort(s);
		insert(x,s);
		
	}

}

public static void  insert(int x, Stack <Integer> s){
	 

	if(!s.isEmpty()){
	int y= (Integer)(s.peek());
	 
		if(x<y){
			s.pop();
			insert(x,s);
			s.push(y);
		}else{
			s.push(x);
		}
	}else{
		s.push(x);
	}

}


}