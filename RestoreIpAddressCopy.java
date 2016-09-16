import java.util.List;
import java.util.ArrayList;

public class RestoreIpAddressCopy {


	public static List<String> restore(String S){

		int len = S.length();
		char [] digits = S.toCharArray();
		char [] array = new char[len+3];
		int pos=0;
		int start=0;
		int rem=4;
		List<String> result = new ArrayList<String>();

		dfs(digits, array, result, pos, rem, start, len);
		return result;
	}

	private static void dfs(char [] digits, char [] array, List<String> result, int pos, int rem,  int start, int len) {

		if( (start>len) || ((len-start)>3*rem) || ((len-start)<rem) ){
			return;
		}

		if(start==len && rem==0){
			result.add(String.valueOf(array));
			return;
		}

		if(rem<4){
			array[pos++]='.';
		}

		int num=0;

		for(int i=0;i<Math.min(len-start,3);i++){

			num =  num*10+ (int)(digits[i]-'0');

			if(i>0 && num<10){
				return;
			}

			if(num<=255){
				array[pos+i] = digits[start+i];
				dfs(digits, array, result, pos+i+1, rem-1, start+i+1, len);
			}

		}
	}

	public static void main(String[] args) {
		
		String S= "25525511135";
		List<String> result = restore(S);
		System.out.println(result.size());
		for(String ip : result){
			System.out.println(ip);
		}
	}
}