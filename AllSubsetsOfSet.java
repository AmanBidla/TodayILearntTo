import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AllSubsetsOfSet{



	public static List<List<Integer>> getAllSubsets(int []A){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// sort A if you want result in an order
		for(int val: A){

			int size = result.size();
			for(int i=0;i<size;i++){
				List<Integer> temp = new ArrayList<Integer>(result.get(i));
				temp.add(val);
				result.add(temp);
			}
			result.add(new ArrayList<Integer>(Arrays.asList(val)));
		}
		result.add(new ArrayList<Integer>()); 
		return result;
	}
 
	////////////////////////////////////

		///// simple accepted soluton is above. 
		////  correct but complicated solution is below

	////////////////////////////////////

	private static List<List<Integer>> getAllSubsets(List<Integer> set,int index){

		List<List<Integer>> all = null;

		if(index == set.size()){
			all = new ArrayList<List<Integer>>();
			all.add(new ArrayList<Integer>());
		}else{
			all = getAllSubsets(set,index+1);
			List<List<Integer>> more = new ArrayList<List<Integer>>();
			int item = set.get(index);
			for(List<Integer> subsets:all){
				List<Integer> newSubset = new ArrayList<Integer>();
				newSubset.add(item);
				newSubset.addAll(subsets);
				more.add(newSubset);
			}

			all.addAll(more);
		}

		return all;
	}


	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		List<List<Integer>> all = getAllSubsets(list,0);
		int [] array = {1,2,3};
		all = getAllSubsets(array);
		all = subsetAnotherSolution(array);

		for(List<Integer> subset : all){
			show(subset);
		}
	}

	private static void show(List<Integer> set){
		System.out.print("[ ");
		for(int i:set){
			System.out.print(i+" ");
		}
		System.out.println("]");
	}


	public static List<List<Integer>> subsetAnotherSolution(int [] array) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if ((array == null) || (array.length==0)) {
			return result;
		}
		Arrays.sort(array);
		List<Integer> item = new ArrayList<Integer>();
		dfs(array,result,item,0);
		return result;
	}

	private static void dfs(int[]array, List<List<Integer>> result, List<Integer> item, int index){
		
		result.add(new ArrayList<Integer>(item));
		for(int i=index;i<array.length;i++) {
			//if(i>index && array[i]==array[i-1]) continue;
			item.add(array[i]);
			dfs(array,result,item,i+1);
			item.remove(item.size()-1);
		}
 
	}

	

}