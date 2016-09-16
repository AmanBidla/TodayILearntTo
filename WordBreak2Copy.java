public class WordBreak2Copy {


	public static List<String> wordBreak2(Set<String> dict, String S) {

		List<String> empty = new ArrayList<String>();
		if(S==null || S.length()==0){
			return empty;
		}

		int maxLength = 0;
		for(String word: dict) {
			maxLength = Math.max(maxLength, word.length());
		}

		return dfs(S,dict,0,maxLength);
	}

	public List<String> dfs(String S, Set<String> dict, int start, int maxLength) {
		
	}
}