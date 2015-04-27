import java.util.Stack;

public class CheckIfValidParenthesis{

	public static void main(String[] args) {
		
		String S="((((([[[]]])))))";
		System.out.println( isValid(S)); // return true
		S="((([])))[]";
		System.out.println( isValid(S)); // return true
		S="((([[()]])))(";
		System.out.println( isValid(S)); // return false
	}

	public static boolean isValid(String S){

		if(S==null || S.length()==0) return false;
		Stack<Character> st = new Stack<Character>();
		int N = S.length();
		for(int i=0;i<N;i++){

			char a = S.charAt(i);
			if( (a=='(') || (a=='[')) st.push(a);
			if( a==')'){
				if(st.isEmpty() || st.peek()!='(') return false;
				st.pop();
			}
			else if(a==']'){
				if(st.isEmpty() || st.peek()!='[') return false;
				st.pop();
			}
		}

		return st.isEmpty();
	}

}