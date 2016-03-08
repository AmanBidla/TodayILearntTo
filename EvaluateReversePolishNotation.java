import java.util.Stack;

public class EvaluateReversePolishNotation{

	private static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		
		 String [] tokens = {"2", "1", "+", "3", "*"};
		 System.out.println( evalRPN(tokens)); // should be 9

		 String [] test = {"4", "13", "5", "/", "+"};
		 System.out.println( evalRPN(test)); // should be 6
	}
	
    public static int evalRPN(String[] tokens) {
    	
    	for(String token : tokens){

    		if(isNumber(token)){
    			stack.push(token);
    		}else{

    			int a = Integer.parseInt(stack.pop());
    			int b = Integer.parseInt(stack.pop());
    			stack.push(String.valueOf(evaluate( a, b, token)));

    		}
    	}

    	return Integer.parseInt(stack.pop());
        
    }

    private static int evaluate(int a, int b, String symbol){

    	if(symbol.equals("+")) return a + b;
    	else if(symbol.equals("-")) return b - a;
    	else if(symbol.equals("/")) return b / a;
    	else return a * b;
    }

    private static boolean isNumber(String token){

    	try{

    		int v = Integer.parseInt(token);
    	}catch(NumberFormatException e){
    		return false;
    	}

    	return true;
    }


}