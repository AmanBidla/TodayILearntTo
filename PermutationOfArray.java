import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;


public class PermutationOfArray {

	public static void main(String[] args) {
		
		int [] array ={1,1,2};
		List<List<Integer>> result = permutation(array);		 
		for(List<Integer> list:result){
			Integer []show = new Integer[list.size()];
			list.toArray(show);			
			System.out.println( Arrays.toString(show));
		}

	}


	public static List<List<Integer>> permutation (int []array){

		int N = array.length;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add( new ArrayList<Integer>() );

		for(int i=0;i<N;i++){
			Set<List<Integer>> curr = new HashSet<List<Integer>>();
			for(List<Integer> l: result){
				for(int j=0;j<l.size()+1;j++){

					l.add(j,array[i]);					 
					List<Integer> temp = new ArrayList<Integer>(l);
					curr.add(temp);
					l.remove(j);
				}
			}
			result = new ArrayList<List<Integer>>(curr);
		}
	return result;		

	}

}