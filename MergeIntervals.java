import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class  Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals {

	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add( new Interval(1,3));
		intervals.add( new Interval(2,6));
		intervals.add( new Interval(8,10));
		intervals.add( new Interval(15,18));
		List<Interval> result = merge(intervals);
		System.out.print("Intervals :");		
		for(Interval interval : intervals){
			System.out.print( "["+interval.start+","+interval.end+"]");
		}
		System.out.print("\nAfter merge :");
		for(Interval interval : result){
			System.out.print( "["+interval.start+","+interval.end+"]");
		}
		System.out.println();

	}

	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        //[1,3],[2,6],[8,10],[15,18],
        if(intervals == null || intervals.size()==0){
            return result;
        }
        
        
        
        Collections.sort( intervals, new Comparator<Interval> () {
           
           @Override
           public int compare(Interval v1, Interval v2){
               if (v1.start < v2.start) return -1;
               else if (v1.start > v2.start) return 1;
               else return 0;
           }
           
        });
        Interval prev = intervals.get(0);
        result.add(prev);
        
        for(int i=1;i<intervals.size();i++) {
            //[1,3],[2,6],[8,10],[15,18],
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start) {
                if(curr.end >= prev.end) {
                    prev.end= curr.end;    
                }
            } else {
                
                result.add(curr);
                prev = curr;
            }
            
        }
         
        return result;
         
    }


}