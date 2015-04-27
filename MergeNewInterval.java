import java.util.List;
import java.util.ArrayList;

class Interval {
	int start,end;

	public Interval(int start, int end){
		this.start=start;
		this.end=end;
	}

	public String toString(){

		return "[ "+start+","+end+" ]";
	}
}
public class MergeNewInterval {

	public static void main(String[] args) {
		
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1,2));
		list.add(new Interval(3,5));
		list.add(new Interval(6,7));
		list.add(new Interval(8,10));
		list.add(new Interval(12,16));

		Interval newInterval= new Interval(4,9);

		List<Interval> afterMerge = mergeNewInterval(list,newInterval);

		for(Interval interval:afterMerge){
			System.out.println(interval.toString());
		}
	}


	public static List<Interval> mergeNewInterval(List<Interval> list, Interval newInterval){

		List<Interval> result = new ArrayList<Interval>();

		for(Interval interval:list){

			if(interval.end< newInterval.start){
				result.add(interval);
			}else if(interval.start> newInterval.end){
				result.add(newInterval);
				newInterval=interval;
			}else if( interval.end >= newInterval.start || interval.start <=newInterval.end){

				newInterval = new Interval( Math.min(interval.start, newInterval.start),
											Math.max(interval.end, newInterval.end));
			}
		}

		result.add(newInterval);
		return result;
	}


}