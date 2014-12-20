import java.util.Stack;
public class ValidParenthesis{

	public static boolean isValid(String s) {
    	
    	if(s==null){
    		return false;
    	}else if( s.length()==0 ){
    		return true;
    	}else if( (s.length()%2)!=0 ){
    		return false;
    	}
    	Stack<Character> st = new Stack<Character>();
    	char [] array = s.toCharArray();
    	for(int i=0;i<array.length;i++){
    		char c = array[i];
    		switch(c){
    			case '(' :{
    							st.push(c);
    							break;
    					   }
				case '[' :{
    							st.push(c);
    							break;
    					   }
    			case '{' :{
    							st.push(c);
    							break;
    					   }
    			case ')' :{
    							if(st.isEmpty()){
    								return false;
    							}
    							char v = st.pop();
    							if( v!='(' ){
    								return false;
    							}
    							break;
    					   }
    			case '}' :{
    							if(st.isEmpty()){
    								return false;
    							}
    							char v = st.pop();
    							if( v!='{' ){
    								return false;
    							}
    							break;
    					   }
    			case ']' :{
    							if(st.isEmpty()){
    								return false;
    							}
    							char v = st.pop();
    							if( v!='[' ){
    								return false;
    							}
    							break;
    					   }
    		}
    	}    	
    	if(!st.isEmpty()){
    		return false;
    	}

    	return true;
    }

    public static void main(String[] args) {
    	
    	String s ="()[{]]";
    	System.out.println(s +" is  "+isValid(s));
    	s ="([{()()()}])";
    	System.out.println(s +" is  "+isValid(s));
    	s =	")}{({))[{{[}";
    	System.out.println(s +" is  "+isValid(s));

    }
}