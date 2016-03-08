import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class AllSubsetsCopy {


	public static List<List<Integer>> allSubsets(int[] array){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if((array==null) || (array.length==0)){
			return result;
		}

		Arrays.sort(array);
		for(int val: array){
			int size = result.size();
			for(int i=0;i<size;i++){
				List<Integer> t = new ArrayList<>(result.get(i));
				t.add(val);
				result.add(t);
			}			
			result.add(new ArrayList<>(Arrays.asList(val)));
		}
		result.add(new ArrayList<>());

		return result;
	}


	public static void main(String[] args) {
		
		int [] array = {1,2,3};
		List<List<Integer>> result = allSubsets(array);
		for(List<Integer> r : result){
			System.out.println( Arrays.toString(r.toArray()));
		}
	}

}