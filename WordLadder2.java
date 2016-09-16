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

	 public static void bfs(String start, String end, Map<String,List<String>> nodeNeighbours, Map<String,Integer> distMap, Set<String> dict){

	 	for(String word: dict){
	 		nodeNeighbours.put(word, new ArrayList<String>());
	 	}
	 	nodeNeighbours.put(start, new ArrayList<String>());
	 	 
	 	Queue<String> queue = new LinkedList<String>();
	 	queue.offer(start);
	 	distMap.put(start,0);

	 	while(!queue.isEmpty()){

	 		String currWord  = queue.poll();
	 		int currDist = distMap.get(currWord);
	 		List<String> neighbours = getNeighbours(currWord, dict);

	 		for(String neighbour : neighbours){
	 			nodeNeighbours.get(currWord).add(neighbour);	
	 			if(!distMap.containsKey(neighbour)){
	 				distMap.put(neighbour, currDist+1);
	 				if(!neighbour.equals(end)){
	 					queue.offer(neighbour);
	 				}
	 			}
	 		}
	 	}

	 }

	 public static void showNeighbours(Map<String,List<String>> nodeNeighbours) {

	 	for(String key: nodeNeighbours.keySet()){ 
	 		List<String> r = nodeNeighbours.get(key);
	 		System.out.println(key+" : "+ Arrays.toString(r.toArray(new String[r.size()])));
	 	}
	 }

	 public static void dfs(String curr, String end, Map<String,List<String>> nodeNeighbours,Map<String,Integer> distMap, List<String> item, List<List<String>> result){

	 	item.add(curr);
	 	if(end.equals(curr)){
	 		result.add(new ArrayList<String>(item));
	 		 
	 	}else{
		 	List<String> neighbours = nodeNeighbours.get(curr);
		 	for(String neighbour : neighbours){

		 		if(distMap.get(curr)+1 == distMap.get(neighbour)){
		 			dfs(neighbour,end,nodeNeighbours,distMap,item,result);
		 		}
		 	} 
	 	}
	 	item.remove(item.size()-1);
	 } 

	 public static List<String> getNeighbours(String word, Set<String> dict){

	 	List<String> result = new ArrayList<String>();
	 	for(int i=0;i<word.length();i++){
	 		char [] array = word.toCharArray();
	 		for(char a='a'; a<='z';a++){

	 			array[i]=a;
	 			String newWord = new String(array);

	 			if(!newWord.equals(word) && dict.contains(newWord)){
	 				result.add(newWord);
	 			}
	 		}
	 	}
	 	return result;
	 }

	public static void showDist(Map<String,Integer> distMap){
		for(String key: distMap.keySet()){
			System.out.println(" key "+key+" : "+distMap.get(key));
		}
	}

	public static void main(String[] args) {
		
		String start ="hit";
		String [] array = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>(Arrays.asList(array));
		String end ="cog";
		dict.add(end);
		Map<String,List<String>> nodeNeighbours = new HashMap<String,List<String>>();
		Map<String,Integer> distMap = new HashMap<String,Integer>();
		bfs(start,end,nodeNeighbours,distMap,dict);
		//showDist(distMap);
		//showNeighbours(nodeNeighbours);

		List<String> item = new ArrayList<String>(); 
		List<List<String>> result = new ArrayList<List<String>>();
		dfs(start, end, nodeNeighbours,distMap,item,result);
		for( List<String> r : result){
			System.out.println(Arrays.toString(r.toArray(new String[r.size()])));
		}

		//System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
	}
}