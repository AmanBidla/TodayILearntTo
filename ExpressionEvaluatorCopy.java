import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionEvaluatorCopy{

	public static List<String> evaluate(String S, int target){

		List<String> result = new ArrayList<String>();
		eval(S,target,result,"",0,0);
		return result;		
	}

	private static void eval(String S,int target, List<String>result, String tmp, int curr, int prev){


		if(curr==target){
			String exp = new String(tmp);
			result.add(exp+"="+target);
			return;
		}


		for(int i=1;i<=S.length();i++){

			String currStr = S.substring(0,i);
			if(currStr.length()>1 && currStr.charAt(0)=='0'){
				return;
			}

			int currNum = Integer.parseInt(currStr);
			String next = S.substring(i);
			if(tmp.length()!=0){

				eval(next,target,result,tmp+"*"+currNum, curr-prev+prev*currNum,prev*currNum);
				eval(next,target,result,tmp+"+"+currNum, curr+currNum,currNum);
				eval(next,target,result,tmp+"-"+currNum, curr-currNum, currNum);
			}else{
				eval(next,target,result,currStr,currNum,currNum);
			}
		}

	}

	public static void main(String[] args) {
		

		String S ="105";
		int target = 5;
		List<String> result = evaluate(S,target);
		System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
	}
}