import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BestMeetingPoint {


	public static int bestMeetinPointDist(int[][] grid){

		if(grid==null || grid.length==0){
			return 0;
		}

		int N = grid.length;
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> cols = new ArrayList<Integer>();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(grid[i][j]==1){
					rows.add(i);
					cols.add(j);
				}
			}
		}

		int midRow = rows.get( rows.size()/2);
		Collections.sort(cols);
		int midCol = cols.get( cols.size()/2);

		return minDist(rows,midRow)+minDist(cols,midCol);
	}

	private static int minDist(List<Integer> points, int origin){
		int dist =0;
		for(int point : points){
			dist += Math.abs(point-origin);
		}
		return dist;
	}

	public static void main(String[] args) {
		
		int [][] grid = {
							{1,0,0,0,1},
							{0,0,0,0,0},
							{0,0,1,0,0}
						};
		int result = bestMeetinPointDist(grid);
		System.out.println(result);						
	}
}