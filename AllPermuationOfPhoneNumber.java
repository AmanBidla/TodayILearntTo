import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPermuationOfPhoneNumber {


	private static String [] ph =	

	{ "", "", "abc",
	  "def", "ghi", "jkl",	
	  "mno", "pqrs", "tuv",
	  "wxyz", ""
	};


	public static List<String> permutation(String num) {
		List<String> result =new ArrayList<String>();
		permute(num,result,0,"");
		return result;
	}

	private static void permute(String S, List<String>result, int index, String path) {

		if(path.length()==S.length()){
			result.add(new String(path));
		} else {
			for(int i=index;i<S.length();i++) {
				//System.out.println(ph[Integer.parseInt(String.valueOf(S.charAt(i)))]);
				char [] array = ph[Integer.parseInt(String.valueOf(S.charAt(i)))].toCharArray();
			
				if(array.length>0){
						 
				 	for(char ch : array){
				 		path += String.valueOf(ch);
				 		permute(S,result,i+1,path);
				 		path = path.substring(0,path.length()-1);
				 	}
				}
			}
		}
	}

	public static void main(String[] args) {
		String num ="23";
		List<String> result = permutation(num);
		System.out.println(Arrays.toString(result.toArray(new String[0])));

	}


}