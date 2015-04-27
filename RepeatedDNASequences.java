import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class RepeatedDNASequences{

		public static void main(String[] args) {
			
			String S ="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
			List<String> result = repeated(S);
			for(String st:result){
				System.out.println(st);
			}
		}



		public static List<String> repeated(String S){
  			List<String> result = new ArrayList<String>();
			int N = S.length();
		
		  Map<Character, Integer> map = new HashMap<Character, Integer>();
		  map.put('A', 0);
		  map.put('C', 1);
		  map.put('G', 2);
		  map.put('T', 3);
		  Set<Integer> temp = new HashSet<Integer>();
		  Set<Integer> added = new HashSet<Integer>();
		  int hash = 0;
		  for (int i = 0; i < N; i++) {
		    if (i < 9) {
		       //each ACGT fit 2 bits, so left shift 2
		       hash = (hash << 2) + map.get(S.charAt(i));
		    } else {
		       	hash = (hash << 2) + map.get(S.charAt(i));
		       //make length of hash to be 20
		       hash = hash & (1 << 20) - 1;
		       if (temp.contains(hash) && !added.contains(hash)) {
		         result.add(S.substring(i - 9, i + 1));
		         added.add(hash); //track added
		       } else {
		         temp.add(hash);
				}
			}
		}

 		 return result;
		}

		 


}


	
