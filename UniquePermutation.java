import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class UniquePermutation {


  public static List<List<Integer>> uniquePermutation(int [] array) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();     
        result.add(new ArrayList<Integer>());
        for(int i=0;i<array.length;i++){
           Set<List<Integer>> curr = new HashSet<List<Integer>>();
           for(List<Integer> r : result) {
            for(int j=0;j<r.size()+1;j++){

              r.add(j,array[i]);
                List<Integer> temp = new ArrayList<Integer>(r);
                r.remove(j);
                curr.add(temp);
            }
           }
           // If you uncomment below line then all permutation ( not just size of array will be shown)
           // []
           // [1 ]
           // [1 ]
           // [1 1 ]
           // [2 1 ]
           // [2 ]
           // [2 1 1 ]
           // [1 1 2 ]
           // [1 2 ]
           // [1 2 1 ]
           //result.addAll(new ArrayList<List<Integer>>(curr));
            result= new ArrayList<List<Integer>>(curr);
        }      
    return result;
  }

 

  public static void main(String[] args) {
    
    int [] array = {1,2,3};
    List<List<Integer>> lists = uniquePermutation(array);
    for(List<Integer> list : lists){

      System.out.print("[");
      for(Integer elem : list) {
        System.out.print(" "+elem+" ");
      }
      System.out.print("]\n");
    }
  }

 

}