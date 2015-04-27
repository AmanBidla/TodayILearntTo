import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutationIterative{

	private static List<List<Integer>> allPermutation(int[] array){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add( new ArrayList<Integer>());
		int N = array.length;
		for(int i=0;i<N;i++){

			List<List<Integer>> curr = new ArrayList<List<Integer>>();
			for(List<Integer> l:result){
				for(int j=0;j<l.size()+1;j++){
					l.add(j,array[i]);
					List<Integer> temp = new ArrayList<Integer>(l);
					curr.add(temp);
					l.remove(j);
				}
			}

			result= new ArrayList<List<Integer>>(curr);			
		}

		return result;
	}

	public static void main(String[] args) {

		int [] array={1,2,3};
		List<List<Integer>> result = allPermutation(array);
		for(List<Integer> list:result){
			Integer[] arrayList = list.toArray(new Integer[list.size()]);
			System.out.println(Arrays.toString(arrayList));
		}
	}

}