import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationsCopy {


	public static List<List<Integer>> combi(int [] array, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}

		dfs(result, item, list,0,array,target);
		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> item, List<Integer> list, int start, int []array, int total) {

		int sum =0;
		for(int i=0;i<item.size();i++) {			 
			sum+=item.get(i);			 
		}

 
		if(sum>total){
			return;
		}

		if(total==sum){
			result.add(new ArrayList<Integer>(item));
			return;
		}

		for(int i=start;i<list.size();i++) {
			item.add(list.get(i));
			dfs(result, item, list, i, array,total);
			item.remove(item.size()-1);
		}
	}

	public static void main(String[] args) {

		int [] array = {2,3,6,7};
		int total = 7;
		List<List<Integer>> result = combi(array,total);
		for(int i=0;i<result.size();i++){
			System.out.println(Arrays.toString(result.get(i).toArray()));
		}

	}


 }