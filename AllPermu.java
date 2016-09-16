import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AllPermu {


	public static List<List<Integer>> permutation(int [] array){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();

		if (array==null || array.length==0){
			return result;
		}

		dfs(array, result, 0);

		return result;
	}

	private static void dfs(int []array, List<List<Integer>> result, int index){
		 
		if(index>=array.length){			  			
			List<Integer> item = new ArrayList<Integer>();
			for (int i: array) {
				item.add(i);
			}
			result.add(item);
			return;
		}

		for(int i=index;i<array.length;i++) {
			//System.out.println(" i "+i+" index "+index);
			swap(array, i, index);
			dfs(array,result,index+1);
			swap(array, i, index);
		}

	}

	private static void swap(int []array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		
		int []array = {1,2,3};
		List<List<Integer>> result = permutation(array);
		for(List<Integer> re :result) {
			System.out.println(Arrays.toString(re.toArray()));
		}
	}

}