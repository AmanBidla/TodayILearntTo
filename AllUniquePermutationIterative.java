import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class AllUniquePermutationIterative{

	private static List<List<Integer>> allPermutation(int[] array){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add( new ArrayList<Integer>());
		int N = array.length;
		for(int i=0;i<N;i++){

			Set<List<Integer>> curr = new HashSet<List<Integer>>();
			for(List<Integer> l:result){
				for(int j=0;j<l.size()+1;j++){
					l.add(j,array[i]);
					List<Integer> temp = new ArrayList<Integer>(l);
					curr.add(temp);
					l.remove(j);
				}
			}

			result = new ArrayList<List<Integer>>(curr);
			//result.addAll(curr);
		}

		return result;
	}

	public static void main(String[] args) {

		int [] array={1,2,2};
		List<List<Integer>> result = allPermutation(array);
		for(List<Integer> list:result){
			Integer[] arrayList = list.toArray(new Integer[list.size()]);
			System.out.println(Arrays.toString(arrayList));
		}
	}

}