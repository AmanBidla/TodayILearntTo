import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class PrintTimeStampDiff {


	public static void print(Queue<Double> q1, Queue<Double> q2) {

		Queue<Double> p1 = new PriorityQueue<Double>();
		Queue<Double> p2 = new PriorityQueue<Double>();

		int i=0;

		while(true) {

				double v1 = q1.remove();
				double v2 = q2.remove();

				if(!p2.isEmpty()) {

					double pv2 = p2.peek();
					if(Math.abs(v1-pv2) < 1.0) {
						System.out.println("("+v1+","+pv2+")");						 
					}

				} else{
					p2.add(v2);
				}

				if(!p1.isEmpty()) {

					double pv1 = p1.peek();
					if(Math.abs(pv1-v2) < 1.0) {
						System.out.println("("+pv1+","+v2+")");						 
					}

				} else{
					p1.add(v1);
				}


			

				if(Math.abs(v1-v2)<1.0) {
					System.out.println("("+v1+","+v2+")");
				}

				if(i==2){
					break;
				}
				i++;
				 
		}
	}

	public static void main(String[] args) {
		
		Queue<Double> q1 = new LinkedList<Double>();
		Queue<Double> q2 = new LinkedList<Double>();

		q1.add(0.2);
		q1.add(1.4);
		q1.add(3.0);

		q2.add(1.0);
		q2.add(1.1);
		q2.add(3.5);

		print(q1,q2);

	}




}