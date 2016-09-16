import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;



public class SimpleAutoCompleteWithTrie {

	static class TrieNodeWithSet{
		TrieNodeWithSet[] children;
		Set<String> words;
		public TrieNodeWithSet(){
			children = new TrieNodeWithSet[256];
			words = new HashSet<String>();
		}
	}

	private static TrieNodeWithSet TrieRoot = new TrieNodeWithSet(); 

	public static String[] autoComplete(String input){
		if(input == null || input.length() == 0) return null;
		TrieNodeWithSet curNode = TrieRoot;
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			if(curNode.children[ch] == null) 
				curNode.children[ch] = new TrieNodeWithSet();
			curNode = curNode.children[ch];
		}
		String[] res = new String[curNode.words.size()];
		int i=0;
		for(String word : curNode.words){
			res[i++] = input + word;
		}
		return res;
	}

	public static void addWordToTrie(String word){
		if(word == null || word.length() == 0) return;
		TrieNodeWithSet curNode = TrieRoot;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(curNode.children[ch] == null) 
				curNode.children[ch] = new TrieNodeWithSet();
			curNode = curNode.children[ch];
			curNode.words.add(word.substring(i+1));
		}
	}

	public static void main(String[] args) {
		

		String [] array = {"San Diego", "San Francisco", "Oakland"};
		for(String word : array) {
			addWordToTrie(word);
		}
		String s ="San";
		String[] result = autoComplete(s);
		System.out.println(Arrays.toString(result));
	}


}