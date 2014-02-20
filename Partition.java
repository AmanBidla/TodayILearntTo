import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Partition {

	public static List<int[]> partition(int n){

		List<int[]> partition = new ArrayList<int[]> ();
		List<Integer> partial = new ArrayList<Integer>();
		partition(n,partial,partition);
		return partition;
	}


	public static void partition(int n,List<Integer>partial, List<int[]> partition){

		if(n==0) partition.add(toArray(partial));
		else{

			 for(int i=n;i>0;i--){

			 	if(partial.isEmpty() || partial.get(partial.size()-1)>=i){
			 		partial.add(i);
			 		partition(n-i,partial, partition);
			 		partial.remove(partial.size()-1);
			 	}
			 }

		}

	}

	public static int[] toArray(List<Integer> list){

		int [] array = new int[list.size()];
		int counter=0;
		for(int i:list){
			array[counter]=i;
			counter++;
		}
		return array;
	}

	public static void main(String[] args) {
		
		List<int[]> partition = partition(5);
		for(int[] array:partition)
		System.out.println(Arrays.toString(array));
		assert(partition.size()==7);
	}

}