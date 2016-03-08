import java.util.Set;
import java.util.HashSet;

public class AllUniquePrimeFactors {


	public static Set<Set<Integer>> allUniquePrimeFactors(int N, int lo, Set<Integer> line, Set<Set<Integer>> result) {
 		
 		for(int i=lo;i<N;i++) {

 			if(N%i==0 && N/i<i) {
               
               Set<Integer> set = new HashSet<Integer>(line);
               set.add(i);
               result = allUniquePrimeFactors(N/i, i, new HashSet<Integer>(set), result);
               set.add(N/i);
               result.add(set);
 			}
 		}

 		return result;

	}

	public static void main(String[] args) {
		
        Set<Integer> line = new HashSet<Integer>();
        Set<Set<Integer>> result = new HashSet<Set<Integer>>();
		result = allUniquePrimeFactors(24,2,line,result);
		print(result);
	}

	private static void print(Set<Set<Integer>> result) {
		
		StringBuilder buf = new StringBuilder();
		for(Set<Integer> set: result) {
			buf.append("[");
			for(Integer i:set){
                  buf.append(i);
                  buf.append(",");
			}
			buf.append("]\n");
		}
		System.out.println(buf);
	}
}