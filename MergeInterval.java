/**
* sort the interval based on the start time
* push the first interval to stack
* compare each interval start time with end time of top of stack
* if interval i th start time is more than  than start and end time of top of stack
* if interval i th  start time is between start and end time of top of stack then
*	 update top of stack with ith interval end time
*
*/

import java.util.Stack;
import java.util.Arrays;

 

public class MergeInterval{
	
	private static  Stack<Interval> st = new Stack<Interval>();

	class Interval implements Comparable<Interval>{

		public int startTime;
		public int endTime;

		public Interval(int startTime, int endTime){
			this.startTime=startTime;
			this.endTime=endTime;
		}

		@Override
		public int compareTo(Interval i){

			if(startTime <=i.startTime) return 0;
			return 1;
		}

		public boolean canMerge(Interval m){

 			if((startTime<=m.startTime) && (endTime>=m.startTime)) return true;
			else return false;
		}

		public String toString(){
			return ("{ "+startTime+" , "+endTime+" } ");
		}
	} 
	

	private static void findOverlapping(Interval[] setOne){

		//System.out.println(Arrays.toString(setOne));
		Arrays.sort(setOne);
		//System.out.println(Arrays.toString(setOne));
		st.push(setOne[0]);

		for(int i=1;i<setOne.length;i++){

			Interval in = st.peek();

			if(in.canMerge(setOne[i])){
 				in.endTime=setOne[i].endTime;
 			}else{
 				st.push(setOne[i]);
			}

		}

		System.out.println(Arrays.toString(st.toArray()));
	 

	}

	 

	public static void main(String[] args) {
		
		MergeInterval m = new MergeInterval();
		 Interval[] setOne = m.populate();

  
		findOverlapping(setOne);
	}

	public Interval[]  populate(){

		Interval[] setOne = new Interval[4];
		for(int i=0;i<4;i++){
			setOne[i]=new Interval(1,3);
		}
		setOne[0]=new Interval(1,3);
		setOne[1]=new Interval(2,4);
		setOne[2]=new Interval(5,7);
		setOne[3]=new Interval(6,8);

		return setOne;
	}	

}