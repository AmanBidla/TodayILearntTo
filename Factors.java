import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Factors {


	public static void dfs(int num, int factor,List<Integer> item, List<List<Integer>> result) {
		int p=1;
		for(int i:item){
			p*=i;
		}
		if(p>num){
			return;
		}
		if(num==p){
			result.add(new ArrayList<Integer>(item));
			return;
		} else{
			//System.out.println("factor :"+factor);
			for(int i=factor;i<=num/2;i++) {
				if(num%i==0){
					item.add(i);
					//System.out.println(num+"/"+i+"="+(num/i));
					dfs(num, i, item,result);
					item.remove(item.size()-1);
				}				
			}
		}
	}

	public static void dfs_new(int num, int factor,List<Integer> item, List<List<Integer>> result) {
	  
	  for(int i=factor;i<=num/2;i++){

	  	if(num%i==0){
	  		item.add(i);
	  		int quotient = num/i;
	  		item.add(quotient);
	  		result.add(new ArrayList<Integer>(item));
	  		item.remove(item.size()-1);
	  		dfs_new(quotient,i,item,result);
	  		item.remove(item.size()-1);
	  	}

	  }
		
	 
	}

	public static List<List<Integer>> factors(int num) {

			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> item = new ArrayList<Integer>();
			//dfs(num,2,item, result);
			dfs_new(num,2,item,result);
			return result;
	}

	public static void main(String[] args) {
		
		int num =23848713;
		//int num =32;
		List<List<Integer>> result = factors(num);
		for(List<Integer> r : result) {
			System.out.println(Arrays.toString(r.toArray()));
		}
	}
}