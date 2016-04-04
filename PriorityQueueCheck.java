import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class PriorityQueueCheck {

	public static void main(String[] args) {
		
		Queue<Integer> maxQueue = new PriorityQueue<Integer>(2,new Comparator<Integer>(){

			@Override
			public int compare(Integer v1, Integer v2){
				if(v1<v2) return 1;
				else if(v1>v2) return -1;
				else return 0;
			}
		});
		int [] array = {7,1,23,12,9,30,2,50,2};
		
		for(int i=0;i<array.length;i++){
			maxQueue.add(array[i]);
		} 
		System.out.println(maxQueue.peek());
		maxQueue.poll();
		System.out.println(maxQueue.peek());
	}



}