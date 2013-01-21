 import java.util.Stack;
public class InfixToPostFix{

	public static void main(String abc[]){
		String infix ="2*3-4/5";
		/* output should be 23*45/-
 		String infix ="A*(B+C)/D"; 
	    output should be ABC+*D/  */
		postfix(infix);	 
	}
	
	 
	
	public static void postfix(String x)
	{
		StringBuffer postfix = new StringBuffer();
		String po="";
		Stack <Character> st =new Stack<Character>();
		char [] infix = x.toCharArray();
		for(int i=0;i<infix.length;i++){
		 char c = x.charAt(i);
		
		 if ((c=='*') || (c=='/') || (c=='+') || (c=='-')){
				while(!st.isEmpty() && (priority(st.peek())>= priority(c)))
					po+=st.pop();
					st.push(c);
		}else if(c=='('){
			st.push(c);
		}else if(c==')'){
			while(st.peek()!='(' && !st.isEmpty())
				po+=st.pop();
			st.pop();
		}else 
			po+=c;
		
			
		}
		while(!st.isEmpty())
			//postfix.append(st.pop());
			po+=st.pop();
//		System.out.println(postfix.toString());
		System.out.println(po);
	 }
	
	public static int priority(Object obj){
		if((obj.equals('+'))||(obj.equals('-')))
			return 1;
		else if((obj.equals('*'))||(obj.equals('/')))
			return 2;
		else
			return 0;
	}
}