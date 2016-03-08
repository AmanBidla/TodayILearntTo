import java.util.Stack;

public class ExpressionCopy {

	public static void main(String[] args) {
		
		 String S ="3-(14-(3-2-1))+5";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

         S ="3-(1-(3-2))+5";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

         S ="()";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

        S="1-2";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

        S="(((((1))-2)+4))";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));
	}

	private static int parse(String expression){
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<expression.length();i++){

			if(expression.charAt(i) >='0' || expression.charAt(i) <='9' ) {

				 int start = i;
				 int j = i+1;
				 while(j<expression.length() && expression.charAt(j) >='0' && expression.charAt(j) <='9') {
				 	j++;
				 }
				 String number = expression.substring(i, j);
				 stack.push(number);
				 i=j;	
			} else if (expression.charAt(i) != ')'){
				stack.push(String.valueOf(expression.charAt(i)));
			} else {

				while( !stack.peek().equals("(") ){

					int result = evaluate( stack.pop(), stack.pop(), stack.pop());
					if(stack.peek().equals("(")) {
						stack.pop();
						stack.push(String.valueOf(result));
						break;
					}
					stack.push(String.valueOf(result));
				}
			}
		}

		Stack<String> reverse = new Stack<String>();
		while(!stack.isEmpty()) {
			reverse.push(stack.pop());
		}

		while(reverse.size() > 1){
			String a = reverse.pop();
			String op = reverse.pop();
			String b = reverse.pop();
			int result = evaluate( b, op, a);
			reverse.push(String.valueOf(result));
		}
		return Integer.parseInt(reverse.pop());
	}

	private static int evaluate(String a, String op, String b){
		int v1 = Integer.parseInt(a);
		int v2 = Integer.parseInt(b);
		if(op.equals("-")) {
			return v2-v1;
		} else {
			return v1+v2;
		}
	}
}