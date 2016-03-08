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


public class MeetingRoomsAnotherSolution{

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
         
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        
        for(int i=0;i<intervals.length;i++){
        	startTimes[i]=  intervals[i].start;
        	endTimes[i]=  intervals[i].end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        for(int i=1;i<intervals.length;i++){
        	if(startTimes[i]<endTimes[i-1]){
        		return false;
        	}
        }
         
        return true;
        
        
    }




}