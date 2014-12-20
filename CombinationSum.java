import java.util.*;
public class CombinationSum{


	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();        
        List<Integer> sol = new ArrayList<Integer>();
        int sum=0,level=0;
        Arrays.sort(num);
        result=combin(num,target,sum,level,result,sol);
        return result;
    }
    private List<List<Integer>> combin(int [] num,int target, int sum, int level,List<List<Integer>> result,List<Integer> sol ){
        //System.out.println( Arrays.toString(sol.toArray())+" and sum "+sum);
        if(sum>target){
            return result;
        }
        if(sum==target){
        	List<Integer> copy = new ArrayList<Integer>(sol);
            result.add(copy);           
            return result;
        }
        for(int i=level;i<num.length;i++){
            sol.add(num[i]);
            sum+=num[i];
            result=combin(num,target,sum,i,result,sol);
            sol.remove(sol.size()-1);
            sum-=num[i];
            
        }
        
        return result;
    }

    public static void main(String[] args) {
    	int [] num ={10,1,2,7,6,1,5 };
    	int target=8;
    	CombinationSum c = new CombinationSum();
    	List<List<Integer>> result = c.combinationSum2(num,target);
    	System.out.println("target is "+target);
    	for(List<Integer> l:result){
            	System.out.println(" "+Arrays.toString(l.toArray())+" ");
         }         
    }
}