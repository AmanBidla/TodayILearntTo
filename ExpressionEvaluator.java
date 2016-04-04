import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionEvaluator {

	private static String EMPTY ="";
	private static String DOLLAR = "$";
	private static String ADD = "$";
	private static String MULTIPLY = "$";
	public static void main(String[] args) {
		
		String S ="105";
		int target =5;		 
		List<String> result = new ArrayList<String>();
		eval(S,target,result,"",0,0);
		print(result);

		/*String S ="456";
		int target = 15;
		List<String> result = new ArrayList<String>();
		eval(S,target,result,"",0,0);
		print(result);*/

	}

	private static void print(List<String> result){

		String[] array = result.toArray(new String[result.size()]);
		System.out.println(Arrays.toString(array));
	}

 
	public static void eval(String S, int target,List<String> result,String tmp, int curr, int prev) {

		System.out.println("S "+S+" target "+target+" tmp "+tmp+" curr "+curr+" prev "+prev); 

		if(curr == target){
			String exp = new String(tmp);
			result.add(exp);
			return;
		}
 

 		for(int i=1;i<=S.length();i++){

 			String currString = S.substring(0,i);
 			System.out.println("currString "+currString);
 			if(currString.length()>1 && currString.charAt(0)=='0'){
 				return;
 			}
 			int currNum = Integer.parseInt(currString);
 			System.out.println("currNum "+currNum);
 			String next = S.substring(i);
 			System.out.println("next "+next);
 			if(tmp.length() !=0){
 				eval(next,target,result,tmp+"*"+currNum,(curr-prev)+prev*currNum,prev*currNum);
 				eval(next,target,result,tmp+"+"+currNum,curr+currNum,currNum);
 				eval(next,target,result,tmp+"-"+currNum,curr-currNum,-currNum);
 			}else{
 				eval(next,target,result,currString,currNum,currNum);
 			}
 		}
		 
		  
	}
}