import java.util.List;
import java.util.ArrayList;


public class RestoreIpAddress {

	static char DOT = '.';

	public static List<String> restore(String S) {

		List<String> result = new ArrayList<String>();

		if (S==null || S.length()==0) {
			return result;
		}

		int len = S.length();
		char [] curr = new char [len+3];
		
		int pos =0;
		int start =0;
		int rem = 4;
		char [] digits = S.toCharArray();

		dfs(digits,curr,result,pos,start,rem,len);

		return result;
	}

	public static void dfs(char [] digits, char []curr, List<String> result, int pos, int start, int rem, int len) {

		System.out.println("pos "+pos+"rem "+ rem +" start "+start+" len "+len);

		if ( (start>len) || (len-start > 3*rem) || (len-start < rem) ) {
			return;
		}

		if (start == len  && rem==0){
			result.add(String.valueOf(curr));
			return;
		}

		if (rem<4) {
			curr[pos++]=DOT;			 
		}

		int num=0;

		for(int i=0;i<Math.min(3,(len-start));i++) {
			  
			num = (10*num)+ (int) (digits[i]-'0');

			if(i>0 && num<10){
				return;
			}

			if(num<=255){
				curr[pos+i] = digits[start+i];
				dfs(digits,curr,result, pos+i+1, start+i+1, rem-1, len);
			}
		}
	}

	public static void main(String[] args) {
		
		String S= "25525511135";
		List<String> result = restore(S);
		for(String ip : result){
			System.out.println(ip);
		}
	}
}