import java.util.Set;
import java.util.HashSet;

public class LongestConsequtiveElements{

	public static void main(String[] args) {
		
		int [] array ={100, 4, 200, 1, 3, 2};
		System.out.println( longest(array));

	}

	public static int longest(int [] array){

		int N = array.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i:array){
			set.add(i);
		}

		int max=1;

		for(int elem:array){
			int count=1;
			int prev = elem-1;
			int next = elem+1;

			// check if prev element exists
			while(set.contains(prev)){
				set.remove(prev);
				prev--;
				count++;
			}

			// check if next element exists
			while(set.contains(next)){

				set.remove(next);
				next++;
				count++;
			}

			max = Math.max(max,count);
		}

		return max;

	}
}