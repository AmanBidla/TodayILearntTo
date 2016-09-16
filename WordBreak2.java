import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class WordBreak2 {

	 Map<Integer,List<String>> cache = new HashMap<Integer,List<String>>();

	public  List<String> wordBreak2(String S, Set<String> dict) {
  		 
		int len = lengthOfLongestWord(dict);	 
		return dfs(S,0,len,dict);				 
	}
   
	private  int lengthOfLongestWord(Set<String> dict){
		int len =-1;
		for(String word: dict)
			len = Math.max(len, word.length());		
		return len;
	}

	private  List<String> dfs(String S, int start, int maxLen, Set<String> dict) {

		List<String> words = new ArrayList<String>();
		int N = S.length();
		//System.out.println("start "+start);
		if(start==N){
			words.add("");
			return words;
		}

		for(int i=start+1;i<=(maxLen+start) && i<=N;i++) {
			
			String tempWord = S.substring(start,i);
			if(dict.contains(tempWord)) {
				List<String> tempList;
				if(cache.containsKey(i)) {
					tempList = cache.get(i);
				} else{
					tempList = dfs(S,i,maxLen,dict);					
				}
				//words.add(tempWord);
				for(String word : tempList){
					words.add(tempWord +(word.equals("")?"":" ") +word);
				}	
			}			
		}

		cache.put(start,words);
		return words;
		 
	} 

 

	public static void main(String[] args) {
		WordBreak2 wordBreak2 = new WordBreak2();
		testCaseFour(wordBreak2);
	}

	public static void testCaseFour(WordBreak2 wordBreak2) {

		String S = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		String [] array =  {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for(String word: array){
			dict.add(word);
		}
		
		List<String> result = wordBreak2.wordBreak2(S,dict);		 
		System.out.println("result : ");
		for(String r : result){
			System.out.println(">>> "+r);
		}
		System.out.println("size "+result.size());



	}

	private static void testCaseThree(WordBreak2 wordBreak2) {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");		  
		String S ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> result = wordBreak2.wordBreak2(S,dict);		 
		System.out.println("result : ");
		for(String r : result){
			System.out.println(">>> "+r);
		}
		System.out.println("size "+result.size());
	}

	private static void testCaseTwo(WordBreak2 wordBreak2) {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");		  
		String S ="aaa";
		List<String> result = wordBreak2.wordBreak2(S,dict);
		System.out.println("result : ");
		for(String r : result){
			System.out.println(">>> "+r);
		}
	}

	private static void testCaseOne(WordBreak2 wordBreak2) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		String S ="catsanddog";
		List<String> result = wordBreak2.wordBreak2(S,dict);
		System.out.println("result : ");
		for(String r : result){
			System.out.println(r);
		}
	}

}