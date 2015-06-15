import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class ShortestDistaneBetweenWordsInDocument{

	private static Map<String,List<Integer>> wordsToIndex = new HashMap<>();	

	public static void process(List<String> words){
		
		for(int i=0;i<words.size();i++){
			String word = words.get(i);
			List<Integer> indexes = wordsToIndex.get(word);
			if(indexes==null) indexes = new LinkedList<>();
			indexes.add(i);
			wordsToIndex.put(word, indexes);
		}
	}


	public static int find(String w1, String w2){

		if(w1==null || w2==null || w1.length()==0 || w2.length()==0) return 0;
		if(w1.equals(w2)) return 0;
		if(!wordsToIndex.containsKey(w1) || !wordsToIndex.containsKey(w2)) return 0;
		return min(w1,w2);
	}

	public static int min(String w1, String w2){

		List<Integer> l1 = wordsToIndex.get(w1);
		List<Integer> l2 = wordsToIndex.get(w2);

		int k1=0,k2=0;
		int min= Integer.MAX_VALUE;
		while(k1<l1.size() && k2<l2.size()){

			int diff = Math.abs( l1.get(k1)-l2.get(k2));
			min = Math.min(diff,min);

			if(l1.get(k1)<l2.get(k2)) k1++;
			else k2++;
		}

		return min;
	}

	public static void main(String[] args) {
		
		process(Arrays.asList("the", "quick", "brown", "fox", "quick"));
		System.out.println(find("fox","the")); // 3
		System.out.println(find("the","quick")); //2
		System.out.println(find("quick","quick")); //1
	}


}