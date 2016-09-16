import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NumberOfIslandsII {


	private static List<Integer> numberOfIslands(int m, int n, int[][] positions){

		List<Integer> result = new ArrayList<Integer>();
		if(m<=0 || n<=0){
			return result;
		}
		int count=0;
		int [] roots = new int[m*n];
		Arrays.fill(roots,-1);
		int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
		for(int [] position : positions){
			int root = (n*position[0]) +position[1];
			roots[root] = root;
			count++;
			for(int [] dir: dirs){
				int x = position[0] + dir[0];
				int y = position[1] + dir[1];
				int nb = (n*x)+y;

				if(x<0 || y<0 || x>=m || y>=n || roots[nb]==-1){
					continue;
				}
				int rootNb = find(roots, nb);
				if( root != rootNb){
					roots[root] = rootNb;
					root = rootNb;
					count--;
				}
			}
			result.add(count);
		}
		return result;
	}

	private static int find(int[] roots, int id){
		while(id != roots[id]){
			roots[id] = roots[roots[id]];
			id= roots[id];
		}
		return id;
	}

	public static void main(String[] args) {
		
		int [][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		List<Integer> result = numberOfIslands(3,3, positions);
		System.out.println(Arrays.toString(result.toArray()));
	}
}