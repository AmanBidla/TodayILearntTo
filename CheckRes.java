import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class CheckRes{

	public static void main(String[] args) {
		
 		List<Integer> list = new ArrayList<Integer>();
 		int N=3;
 		/*
 		list.add(1);
 		list.add(1);
 		list.add(2);
 		*/
 		for(int i=1;i<=3;i++){
 			list.add(i);
 		}

 		Set<ArrayList<Integer>>result = new HashSet<ArrayList<Integer>>();
 		List<Integer> prefix = new ArrayList<Integer>();
 		permute(result,prefix,list);
 		for(List<Integer> l: result){
 			Iterator it = l.iterator();
 			while(it.hasNext()){
 				System.out.print(it.next()+",");
 			}
 			System.out.println("");
 		}

	}

	public static void permute(Set<ArrayList<Integer>> result, List<Integer> prefix, List<Integer> list){

		int N = list.size();
		if(N==0){
			result.add( new ArrayList<Integer>(prefix));
			return;
		}

		for(int i=0;i<N;i++){

			int item = list.get(i);
			prefix.add(item);
			list.remove(i);
			permute(result, prefix,list);
			list.add(i,item);
			prefix.remove(prefix.size()-1);
		}


	}
}