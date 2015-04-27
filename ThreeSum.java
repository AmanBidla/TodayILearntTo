import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ThreeSum{

	public static List<List<Integer>> trip(int[] num) {
    List<List<Integer>> result = new ArrayList<List<Integer>> ();
    ArrayList<Integer> sol = new ArrayList<Integer>();
     if(num.length==0 || num.length<3){
         return result;
     }
     Arrays.sort(num);
     for(int i=0;i<num.length;i++){
         int target = 0-num[i];
         int st = i+1;
         int end = num.length-1;
         while(st<end){
             if(num[st]+num[end]==target){
                 sol.add(num[i]);
                 sol.add(num[st]);
                 sol.add(num[end]);
                 st++;
                 end--;
                 while( (st<end) && num[st]==num[st-1]) st++;
                 while( (st<end) && num[end]==num[end+1]) end--;
                 result.add(sol);
                 sol = new ArrayList<Integer>();
             }else if(num[st]+num[end]<target){
                 st++;
             }else{
                 end--;
             }
             if(i<num.length-1)
            while(i+1<num.length-1 && num[i]==num[i+1]) i++;
         }
     }
     return result;
    }

	public static void main(String[] args) {
		int A[] = {-1, 0, 1, 2, -1, -4};
    	List<List<Integer>> ans = trip(A);
    	Iterator it = ans.iterator();
     	while(it.hasNext()){
    		List<Integer> list = (List<Integer>) it.next();
    		System.out.println(list);    		 
    	}

	}

}