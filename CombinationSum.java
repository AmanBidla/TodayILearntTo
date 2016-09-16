import java.util.*;
public class CombinationSum{
 
    public static void main(String[] args) {
    	/*int [] num ={10,1,2,7,6,5 };
    	int target=8; */
        int target =4;
        int [] num ={1,2,3};
        
        List<List<Integer>> result = combinationSum(num,target);
    	System.out.println("target is "+target);
    	for(List<Integer> l:result){
            	System.out.println(" "+Arrays.toString(l.toArray())+" ");
         }         
    }

    public static List<List<Integer>> combinationSum(int [] array, int target) {
        
        List<Integer> item = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array==null || array.length==0){
            return result;
        }
        Arrays.sort(array);
        dfs(array, target, item, 0, result);
        return result;
    }

    private static void dfs(int [] array, int target, List<Integer> item, int index, List<List<Integer>> result) {
        int s=0;
        for(int i:item) {
            s+=i;
        }
        if(s>target){
            return;
        }
        if(s==target){
            result.add(new ArrayList<Integer> (item));
            return;
        }
        for(int i=index;i<array.length;i++){
            if(array[i]>target) continue;
            item.add(array[i]);
            dfs(array, target, item, i, result);
            item.remove(item.size()-1);
        }
    }


}