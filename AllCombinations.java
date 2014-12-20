import java.util.*;
public class AllCombinations{


	public List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> sol = new ArrayList<Integer>();
    	dfs(n,k, 1,sol,result);
    	return result;   
    }

    private void dfs(int end, int k, int level, List<Integer> sol, List<List<Integer>> result ){

    	if(k==sol.size()){
    		List<Integer> copy = new ArrayList<Integer>(sol);
    		result.add(copy);
    		return ;
    	}
    	for(int i=level;i<=end;i++){
    		sol.add(i);
    		dfs(end,k,i+1,sol,result);
    		sol.remove(sol.size()-1);    		
    	}
    }

    public static void main(String[] args) {
    	AllCombinations c = new AllCombinations();
 		List<List<Integer>> result = c.combine(4,2);   	
 		for(List<Integer> r:result){
 			System.out.println(Arrays.toString(r.toArray()));
 		}
    }

}