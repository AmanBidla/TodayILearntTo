import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BlockingQueue<T>{

	private Queue<T> queue = new LinkedList<T>();
	private int cap;

	public BlockingQueue(int cap){
		this.cap=cap;
	}


	public synchronized void put(T t) throws InterruptedException {
		if(isQueueFull()){
			System.out.println("waiting for someone to pick");
			wait();	
		} 
		queue.add(t);
		notifyAll();		
	}

	public synchronized T get() throws InterruptedException {
		if(isQueueEmpty()) {
			System.out.println("waiting to add ");
			wait();
		}
		notifyAll();
		T t = queue.remove();
		return t;
	}

	private boolean isQueueFull(){
		return queue.size()==cap;
	}

	private boolean isQueueEmpty(){
		return queue.size()==0;
	}

}

public class SynchronizedBlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new BlockingQueue<Integer>(4);
		ExecutorService e1 = Executors.newFixedThreadPool( 4 ) ;
		
		put(e1,2,queue);		 
		put(e1,4,queue);
		get(e1,queue);
		put(e1,6,queue);
		get(e1,queue);
		get(e1,queue);	  
 	
	}

	private static void put(ExecutorService e, final int val,final BlockingQueue<Integer> queue){
		e.execute( new Runnable(){
			@Override
			public void run(){
				try{
					System.out.println("adding "+val);
					queue.put(val)  ;
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
		});
	}
	private static void get(ExecutorService e,final BlockingQueue<Integer> queue){
		e.execute( new Runnable(){
			@Override
			public void run(){
				try{
					System.out.println("getting ...");
					System.out.println(queue.get());
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
		});
	}
}