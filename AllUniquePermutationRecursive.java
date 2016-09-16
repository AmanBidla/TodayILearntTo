import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AllUniquePermutationRecursive {


	public static List<List<Integer>> allUniq(int [] array) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);

		if(array==null || array.length==0){
			return result;
		}

		 
 		dfs(array,result,0);

 		return result;
 
	}

	private static void dfs(int []array,  List<List<Integer>> result, int index) {

		if(index == array.length) {		
			List<Integer> item = new ArrayList<Integer>();
			for(int i:array){
				item.add(i);
			}
			result.add(item);
			return ;
		}

		for (int i=index;i<array.length;i++) {
			
			swap(array, i, index);
			dfs(array,result,i+1);
			swap(array, i, index);
			while(i+1<array.length && array[i]== array[i+1]){
				i++;
			}
			 
		}
	}

	private static void swap(int [] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {

		int [] array = {1,1,2,2,3};
		List<List<Integer>> result = allUniq(array);
		for(List<Integer> re : result) {
			System.out.println(Arrays.toString(re.toArray()));
		}
	}
}