1import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class WordChain {
 

	public static int longest(Set<String> dict) {

		if(dict==null || dict.size()==0){
			return 0;
		}

		Map<String,Integer> map = new HashMap<>();
		int longest =0;

		for(String word : dict) {
			int len = helper(word, dict,map)+1;
			map.put(word, len);
			longest = Math.max(len, longest);
		}

		return longest;
 
  	}

  	private static int helper(String word, Set<String> dict, Map<String,Integer> map){

  		int result=0;
  		for(int i=0;i<word.length();i++) {

  			StringBuilder buf = new StringBuilder(word);
  			buf.deleteCharAt(i);
  			String tWord = buf.toString();

  			if (dict.contains(tWord)) {
  				
  				if (map.containsKey(tWord)) {
  					result = Math.max(map.get(tWord), result);
  				} else {
  					result = Math.max(helper(tWord,dict,map),result)+1;
  				}
  			}  			
  		}
  		return result;
  	}

   
  	public static void main(String[] args) {
  		
  		Set<String> dict = new HashSet<>();
  		String [] dictWords  = {"a", "b", "ab", "abc", "add"};
  		for(int i=0;i<dictWords.length;i++){
  			dict.add(dictWords[i]);
  		}
  		System.out.println(longest(dict));
  	}
}