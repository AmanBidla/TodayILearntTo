import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class WordBreak2Copy {
  
	public static List<String> wordBreak2(String S, Set<String> dict){

		if((S==null) || (S.length()==0) || (dict ==null) || (dict.size()==0)){
			return new ArrayList<String>();
		}

		int maxLength= Integer.MIN_VALUE;
		for(String word: dict){
			maxLength = Math.max(maxLength,word.length());
		}

		return dfs(S,dict,0,maxLength);

	}

	private static Map<String,List<String>> dp = new HashMap<String,List<String>>();

	public static List<String> dfs(String S, Set<String> dict, int start, int max){

		List<String> result = new ArrayList<String>();
		if(start == S.length()){
			result.add("");
			return result;
		}

		for(int i=start+1;i<=start+max && i<=S.length();i++){

			String word = S.substring(start, i);
			if(dict.contains(word)){

				List<String> temp;
				if(dp.containsKey(word)){
					temp = dp.get(word);
				}else{
					temp = dfs(S,dict,i,max);
				}
				for(String t : temp){
					result.add(word + ((t.equals("")) ? "" : " ")+ t);
				}
			}
		}
		dp.put(S,result);
		return result;

	}

	public static void main(String[] args) {
		
		String S ="catsanddog";
		String[] array = {"cat", "cats", "and", "sand", "dog"};
		Set<String> dict = new HashSet<String>(Arrays.asList(array));
		List<String> result = wordBreak2(S,dict);
		System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
	}


}