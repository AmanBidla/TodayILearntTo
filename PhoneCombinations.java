import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class PhoneCombinations {


	public static List<List<Integer>> combinations(int K, int sum) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		int start=1;
		 
		 
		 
		dfs(K,item, result, sum, start);
		return result;
	}

	private static void dfs(int K, List<Integer> item, List<List<Integer>> result,int sum, int start){

		int currSum=0;
		for(int i:item){
			currSum+=i;
		}

		if(currSum>sum){
			return;
		}


 		
 		if(currSum==sum && item.size()==K){
 			result.add(new ArrayList<Integer>(item));
 			return;
 		}

 		for(int i=start;i<=9;i++){
 			item.add(i);
 			dfs(K,item,result,sum,i+1);
 			item.remove(item.size()-1);
 		}
 
	}


 

	public static void main(String[] args) {
		
	 	int sum = 9;
	 	int K = 3;
	 	List<List<Integer>> result = combinations(K,sum);
	 	for(List<Integer> r : result ){
	 		System.out.println(Arrays.toString(r.toArray()));
	 	}

	}
}