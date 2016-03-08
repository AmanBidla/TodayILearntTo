import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Interval{

	int st,end;
	public Interval(int st, int end){
		this.st=st;
		this.end = end;
	}

	@Override
	public String toString(){
		return "["+st+","+end+"]";
	}
}
public class MergeIntervalTwo{

	public static void main(String[] args) {
		//[1,3],[2,6],[8,10],[15,18],
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add( new Interval(1,3));
		intervals.add( new Interval(2,6));
		intervals.add( new Interval(8,10));
		intervals.add( new Interval(15,18));
		List<Interval> result  = merge(intervals);
		for(Interval interval : result){
			System.out.println(interval);
		}
	}


	public static List<Interval> merge(List<Interval> list){

		Collections.sort(list, new Comparator<Interval>(){

			@Override
			public int compare(Interval i1, Interval i2){
				return i1.st-i2.st; 
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval i = list.get(0);
		for(int j=1; j<list.size();j++){

			if( i.st > list.get(j).end){
				result.add(list.get(j));
			} else if(i.end < list.get(j).st){
				result.add(i);
				i=list.get(j);
			} else if( (list.get(j).end >= i.st) || (list.get(j).st <= i.end)){
				i = new Interval( Math.min(i.st, list.get(j).st), Math.max(i.end, list.get(j).end));
			}
		}

		result.add(i);
		return result;
	}
}