import java.util.List;
import java.util.ArrayList;


public class SearchInListy{

	private static List<Integer> listy = new ArrayList<Integer>();

	private static int elementAt(int i){

		if(i> listy.size()) return -1;
		else return listy.get(i);
	}

	private static int find(List<Integer> listy, int target){

		int left=0, right = Integer.MAX_VALUE;
		while( left < right ){

			int mid = left + (right-left)/2;
			if( elementAt(mid) == -1){
				right = mid;
			} else{

				if( elementAt(mid) == target ) return mid;

				if( elementAt(mid) < target ) left = mid+1;

				else right = mid;
			}

		}

		return -1;

	}

	public static void main(String[] args) {
		
		listy.add(1);
		listy.add(2);
		listy.add(3);
		listy.add(4);
		listy.add(5);

		System.out.println( find(listy,4) );
	}



}