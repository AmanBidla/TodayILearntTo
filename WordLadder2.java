import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Arrays;

public class WordLadder2 {

	static Map<String, String> edgeTo = new HashMap<String,String>();
	static Map<String,Integer> distTo = new HashMap<String,Integer>();
	static Set<String> visited = new HashSet<String>();
	public static List<String> wordLadder(String start, Set<String> dict,String end){

		Queue<String> queue = new LinkedList<String>();
		for(String word : dict){
			distTo.put(word,Integer.MAX_VALUE);	
		}
		distTo.put(start,0);		
		queue.add(start);
		visited.add(start);
		while(!queue.isEmpty()){
			String word = queue.remove();
			for(String adjWord : getAdjacentWord(word,dict)){
				if(!visited.contains(adjWord)){
					edgeTo.put(adjWord,word);
					distTo.put(adjWord,distTo.get(word)+1);
					visited.add(adjWord);
					queue.add(adjWord);
				}
			}
		}

		return pathTo(end);
 
	}

	public static List<String> getAdjacentWord(String word, Set<String> dict){

		List<String> result = new ArrayList<String>();
		for(int i=0;i<word.length();i++){
			char [] array = word.toCharArray();
			for(char a='a';a<='z';a++){
				array[i]=a;
				String newWord = new String(array);
				if(dict.contains(newWord)){
					result.add(newWord);
				}
			}
		}
		return result;
	}

	public static List<String> pathTo(String end){
 
		Stack<String> result = new Stack<String>();
		for(String w=end; distTo.get(w)!=0; w=edgeTo.get(w)){
			result.push(w);
		}
		return new ArrayList<String>(result);
	}

	public static void main(String[] args) {
		
		String start ="hit";
		String [] array = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>(Arrays.asList(array));
		String end ="cog";
		List<String> result = wordLadder(start,dict,end);
		System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
	}
}