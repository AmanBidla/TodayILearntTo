import java.util.HashMap;
public class BooleanParenthesis{

public static void main(String[] args) {
	String expression="1^0|0|1";
	boolean result=true;
	HashMap<String,Integer> cache= new HashMap<String,Integer>();
	System.out.println(solve(expression,result,0,expression.length()-1,cache));
}
public static int solve(String expression, boolean result, int start, int end, HashMap<String,Integer> cache){
	String key=""+result+start+end;
	if(cache.containsKey(key)){
		return cache.get(key);
	}
	if(start==end){
		if(expression.charAt(start)=='1' & result){
 			return 1;
		}else if(expression.charAt(start)=='0' & !result){
 			return 1;
		}else{
 			return 0;
		}
	}
		int numberofways=0;
		if(result){
			for(int i=start+1;i<=end;i+=2){
				char operation=expression.charAt(i);
				if(operation=='&'){
					numberofways+=solve(expression,true,start,i-1,cache) * solve(expression,true,i+1,end,cache);
				}else if(operation=='|'){
					numberofways+=solve(expression,true,start,i-1,cache) * solve(expression,true,i+1,end,cache);
					numberofways+=solve(expression,false,start,i-1,cache)* solve(expression,true,i+1,end,cache);
					numberofways+=solve(expression,true,start,i-1,cache) * solve(expression,false,i+1,end,cache);
				}else if(operation=='^'){
					numberofways+=solve(expression,true,start,i-1,cache) * solve(expression,false,i+1,end,cache);
					numberofways+=solve(expression,false,start,i-1,cache)* solve(expression,true,i+1,end,cache);
				}
			}

		}else{
			// if result is false;
			for(int i=start+1;i<=end;i+=2){
				char operation=expression.charAt(i);
				if(operation=='&'){
					numberofways+=solve(expression,false,start,i-1,cache) * solve(expression,false,i+1,end,cache);
					numberofways+=solve(expression,true,start,i-1,cache)  * solve(expression,false,i+1,end,cache);
					numberofways+=solve(expression,false,start,i-1,cache) * solve(expression,true,i+1,end,cache);
						
				}else if(operation=='|'){
					numberofways+=solve(expression,false,start, i-1,cache) * solve(expression,false,i+1,end,cache);

				}else if(operation=='^'){
					numberofways+=solve(expression,false,start,i-1,cache)  * solve(expression,false,i+1,end,cache);
					numberofways+=solve(expression,true,start,i-1,cache)   * solve(expression,true,i+1,end,cache);
				}
				
			}
		}
			cache.put(key,numberofways);
	return numberofways;

	}


}