import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MedianOfMedians{


	public static  int findMedian (List<Integer> list, int start, int end, int k){

		System.out.println("start "+start+" end "+end+" ");
		if((end-start+1)<=5){
			Collections.sort(list.subList(start, end));
			System.out.println("start "+start+" k "+k+" end "+end+" ");
			return start+k-1;
		}
		
		
		for(int i=0;i<(end+1)/5; i++ ){

			int left = i*5;
			int right = left+4;

			

			if(right>end)
				right=end;

			int median = findMedian(list, left, right,2);

			exch( list, median, i);
			System.out.println("i "+i +" left  "+left+" right "+right+" "+" median "+median);

		}

		return findMedian(list, 0, (end+1)/5, (end+1)/10);

	}

	public static void main(String[] args) {
		
		int [] array = {10,2,4,8,6,7,5,9,3,1};

		//11,12,17,20,13,15,19,14,18
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}
		int median = findMedian(list,0,array.length-1, (array.length)/2);

		System.out.println( array[median] );
	}

	public static void exch(List<Integer> list, int a, int b){
		System.out.println("before "+list.get(a)+" and "+list.get(b));
		Collections.swap(list, a, b);
		System.out.println("after "+list.get(a)+" and "+list.get(b));
	}

}