import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

class MaxHeapComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2){
		return o2-o1;
	}
}
public class MedianOfStreamingNumbers {

	private static int count;
	private static int sum =0;

	public static void add(int num){
		sum+=num;
		maxHeap.add(num);
		if(count%2==0){
			if(minHeap.isEmpty()){
				count++;
				return;
			} else{

				if(minHeap.peek()<maxHeap.peek()){

					int minHeapPeek = minHeap.poll();
					int maxHeapPeek = maxHeap.poll();
					minHeap.offer(maxHeapPeek);
					maxHeap.offer(minHeapPeek);
				}
			}
		} else{
			minHeap.offer(maxHeap.poll());			
		}
		count++; 
	}

	private static Queue<Integer> minHeap  = new PriorityQueue<Integer>();
	private static Queue<Integer> maxHeap  = new PriorityQueue<Integer>(10,new MaxHeapComparator());

	private static double median(){
		if(count%2!=0){
			return Double.valueOf(maxHeap.peek());
		} else{
			return (maxHeap.peek() + minHeap.peek())/2.0;
		}
	}

    private static double average() {
    	return sum/2;
    }	

    public static void main(String[] args) {
    	add(1);
    	add(5);
		add(10);
		add(12);
		add(2);
		System.out.println(median()); // should be 5
    }


}