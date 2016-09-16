import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Interval implements Comparable<Interval> {

	int start,end;

	public Interval(int start, int end){
		this.start= start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval that) {

		if(this.start<that.start) return -1;
		if(this.start>that.start) return 1;
		return 0;
	}
 
}

public class FindOverlappingInterval {


	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(12,14));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(13,15));
		intervals.add(new Interval(5,10));
		List<Interval> result = findOverlapping(intervals);
		for(Interval interval : result) {
			System.out.print("("+interval.start+","+interval.end+") ");
		}

	}

	public static List<Interval> findOverlapping(List<Interval> intervals) {

		Collections.sort(intervals);

		Interval base = intervals.get(0);
		Interval compareInterval = new Interval(base.start, base.end); 
		List<Interval> result = new ArrayList<Interval>();

		//{1, 3} {12, 14} {2, 4} {13, 15} {5, 10}
		for(int i=1;i<intervals.size();i++){

			Interval curr = intervals.get(i);
			if(doesOverlap(compareInterval,curr)){
				result.add(base);
				result.add(curr);
				compareInterval.start = Math.min(base.start, curr.start);
				compareInterval.end = Math.max(base.end, curr.end);
			} else {
				compareInterval = curr;
				base = curr;
			}
		}
		return result;
	}

	private static boolean doesOverlap(Interval v1, Interval v2) {

		if(v2.start>=v1.start && v2.end<=v1.end)  return true;
		if(v2.start>=v1.start && v2.start<=v1.end) return true;
		return false;
	}

}