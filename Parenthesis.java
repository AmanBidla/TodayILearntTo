import java.util.Map;
import java.util.HashMap;

public class Parenthesis {
	

	private static int dynamic(String exp, boolean result, int st, int end, Map<String,Integer> dp){

		String key =""+result+st+end;
 		
		if(dp.containsKey(key)){
 			return dp.get(key);
		}

		if(st==end){
  			if(exp.charAt(st)=='1' && result==true){
 				return 1;
			}

			else if(exp.charAt(st)=='0' && result==false){
 				return 1;
				
			}
			else
				return 0;
		}

		int c=0;

		if(result){


			for(int i=st+1;i<=end;i+=2){

		    char op = exp.charAt(i);
 
				//true
				if(op=='&')
					c+= dynamic(exp,true,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
				else if(op=='|'){
					c+=dynamic(exp,true,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
 					c+=dynamic(exp,false,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
 					c+=dynamic(exp,true,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
 				}else if(op=='^'){
					c+=dynamic(exp,true,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
					c+= dynamic(exp,false,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
				}

			}

		}else{

			for(int i=st+1;i<=end;i+=2){

		    char op = exp.charAt(i);
 
				if(op=='&'){
					c+=dynamic(exp,true,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
					c+=dynamic(exp,false,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
					c+=dynamic(exp,false,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
				}else if(op=='|'){

					c+=dynamic(exp,false,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
				}else if(op=='^'){
					c+=dynamic(exp,false,st,i-1,dp) * dynamic(exp,false,i+1,end,dp);
					c+=dynamic(exp,true,st,i-1,dp) * dynamic(exp,true,i+1,end,dp);
				}
 
			}

		}

		dp.put(key,c);
		return c;

	}

	public static void main(String[] args) {
		

		Map<String,Integer> dp = new HashMap<String,Integer>();
		String exp ="1^0|0|1";
		boolean result =true;
		System.out.println("exp is "+exp);

		System.out.println(dynamic(exp,result,0,exp.length()-1,dp));

	}
}