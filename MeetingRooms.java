import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    @Override
    public String toString(){
    	return "{"+start+","+end+"}";
    }
}


public class MeetingRooms{

	public static void main(String[] args) {
		 
		Interval [] array = {new Interval(7,10), new Interval(2,4)};
		System.out.println(canAttendMeetings(array)); // true
		Interval [] array2 = { new Interval(0, 30),new Interval(5, 10),new Interval(15, 20)};
		System.out.println(canAttendMeetings(array2)); // false
	}

	public static boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals == null) {
            return false;
        }
        
        if(intervals.length<2){
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval v1, Interval v2){
                return v1.start-v2.start;
            }
        });
        
        for(Interval i:intervals){
        	System.out.println(i.toString());
        }

        Interval prev = intervals[0];
        
        for(int i=1;i<intervals.length;i++) {
            Interval curr = intervals[i];
            if(curr.start<=prev.end || (curr.start>=prev.start && curr.end<=prev.end)){
                return false;
            }else{
                prev = curr;
            }
            
        }
        
        return true;
        
        
    }




}