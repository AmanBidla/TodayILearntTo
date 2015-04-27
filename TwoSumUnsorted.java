import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSumUnsorted{

	public static void main(String[] args) {
		
		int [] array={2,7,11,15};
		int target=18;
		System.out.println( Arrays.toString(sum(array,target)));
	}

	public static int[] sum(int [] array, int target){		

		
		int [] result = new int[2];

		if(array==null || array.length==0){
			return result;
		}

		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int N = array.length;

		for(int i=0;i<N;i++){

			if(map.containsKey(array[i])){
				int index = map.get(array[i]);
				result[0]=index+1;
				result[1]=i+1;
			}else{
				map.put(target-array[i],i);
			}
		}

		return result;

	}
}