import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak2{

	public static void main(String[] args) {
		
		input1();
	}

	private static void input1(){
      String S = "catsanddog";
      Set<String> dict = new HashSet<String>();
      dict.add("cat");
      dict.add("cats");
      dict.add("and");
      dict.add("sand");
      dict.add("dog");
      List<String> list = wordBreak2(S,dict);
      for(String w:list){
        System.out.println(w);
      }

    }

	 

	private static List<String> wordBreak2(String S, Set<String> dict){


		List<Integer> [] starts = new List[S.length()+1];
		int maxLen = maxLengthOfWordInDict(dict);
		starts[0] = new ArrayList<Integer>();

		for(int i=1;i<=S.length();i++){
			for(int j=i-1; j>= (i-maxLen) && j>=0;  j--){

				if(starts[j] == null){
					continue;
				}

				if(dict.contains(S.substring(j,i))){

					if(starts[i] == null){
						starts[i] = new ArrayList<>();
					}

					starts[i].add(j);
				}
			}
		}

		List<String> result = new ArrayList<>();
		if( starts[S.length()] == null){
			return result;
		}

		dfs(result, dict, S, "", starts, S.length() );

		return result;
	}

	private static void dfs(List<String> result, Set<String> dict, String S, String path, List<Integer>[] starts, int end) {

		if(end == 0){
			result.add(path.substring(1));
		} else {

			for(Integer start: starts[end]){
				String word = S.substring(start, end);
				if(dict.contains(word)){
					dfs(result, dict, S, " "+word+path,starts, start);
				}
			}
		}
	}

	private static int maxLengthOfWordInDict(Set<String> dict){

		int maxLen = Integer.MIN_VALUE;
		for(String word: dict){

			maxLen = Math.max(maxLen, word.length());
		}

		return maxLen;
	}

}