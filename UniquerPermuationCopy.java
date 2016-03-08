import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class UniquerPermuationCopy {


	private static List<List<Integer>> permuationCopy(List<Integer> num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if( num  == null  || num.size() == 0) {
			return result;
		}
		result.add( new ArrayList<Integer> ());
		for(int i=0;i<num.size();i++){
			Set<List<Integer>> curr = new HashSet<List<Integer>>();
			for(List<Integer> r : result) {
				for(int j=0; j < r.size()+1;j++) {
					r.add(j,num.get(i));
					List<Integer> t = new ArrayList<Integer>(r);
					curr.add(t);
					r.remove(j);	
				}				
			}
			result = new ArrayList<List<Integer>>( curr );
		}
		return result;
	}


	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		List<List<Integer>> result = permuationCopy(list);

		for( List<Integer> r : result ){

			System.out.print("[");
			for(int i : r){
				System.out.print(" "+i);
			}
			System.out.println("]");
		}


	}

}