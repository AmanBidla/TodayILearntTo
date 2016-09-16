import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Combi {
  
	private static List<List<Integer>> combinations(int target, int [] array){

		List<List<Integer>> result = new ArrayList<List<Integer>>(); 


		if (target<0 || array==null || array.length==0){
			return result;
		}

		Arrays.sort(array);

		List<Integer> item = new ArrayList<Integer>();

		dfs(target,array,result,item,0);
		return result;
	}

	private static void dfs(int target,int [] array, List<List<Integer>> result, List<Integer> item, int start) {


		int sum=0;

		for(int i: item){
			sum+=i;
		}
		//System.out.println("sum "+sum);

		if(sum==target){
			result.add(new ArrayList<Integer>(item));			 
			return;
		}

		if (sum>target){
			return;
		}
   
		for(int i=start;i<array.length;i++) {
			item.add(array[i]);
			dfs(target,array, result,item,i);
			item.remove(item.size()-1);
			while((i+1)<array.length && array[i]==array[i+1]){
				i++;
			}
		}

	}

	public static void main(String[] args) {
		
		int target =7;
		int [] array = {2, 3, 6, 7};
		List<List<Integer>> result = combinations(target,array);
		for(List<Integer> item : result) {
			System.out.println(Arrays.toString(item.toArray()));
		}
	}

}