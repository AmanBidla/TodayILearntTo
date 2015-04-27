import java.util.List;
import java.util.ArrayList;


public class TotalMinTrianglePath{


	public static void main(String[] args) {
		

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);

		int N = list.size();
		int [][] dp = new int[N][N];

		System.out.println(min(list,dp,0,0));


	}

	public static int min(List<List<Integer>> list, int[][] dp,int index, int level){


		if(level == list.size()){
			return 0;
		}

		int result = dp[level][index];
		if(result!=0){
			return result;
		}

		int current = list.get(level).get(index);

		result = Math.min( (current + min(list,dp,index+1,level+1)), (current+min(list,dp,index,level+1)) );

		dp[level][index]=result;

		return result;

	}
}