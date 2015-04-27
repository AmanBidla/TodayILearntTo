import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class UniquePermutation{


  private static Set<List<Integer>> unique(List<Integer> set, int index){

  	Set<List<Integer>> result;

  	if(set.size()==index){
  		result = new HashSet<List<Integer>>();
  		result.add( new ArrayList<Integer>());
  	}else{

  		result = unique( set, index+1);
  		int value = set.get(index);
  		Set<List<Integer>> more = new HashSet<List<Integer>>();
  		for(List<Integer> subset:result){
  			List<Integer> newSubset = new ArrayList<Integer>();
  			newSubset.add(value);
  			newSubset.addAll(subset);
  			more.add(newSubset);
  		}

  		result.addAll(more);
  	}

  	return result;
  }

  public static void main(String[] args) {
  	
  	List<Integer>  set = new ArrayList<Integer>();
  	set.add(1);
  	set.add(1);
  	set.add(2);
    Set<List<Integer>> setlist = unique(set,0);
    for(List<Integer> list:setlist){
      System.out.print("[");
       for(int i=0;i<list.size();i++){
             System.out.print(i+" ");
       }
       System.out.print("]\n");
    }

  }

}