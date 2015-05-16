import java.util.PriorityQueue;
import java.util.NoSuchElementException;

public class IndeMinPQ<K extends Comparable<K>> extends PriorityQueue<K> {
	
	private Comparable<K>[] keys;
	private int NMAX;
	private int N;

	public IndeMinPQ(int NMAX){
		if(NMAX<0) throw new IllegalArgumentException();
		this.NMAX=NMAX;
		keys = (Comparable<K>[]) new Comparable[NMAX+1];	
	}

	public void insert(int i, Comparable key){
		if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        N++;
        super.add(key); 
        keys[i] = key;         
	}

 
	public void increaseKey(int i, Comparable key) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0) throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;         
    }


    public static void main(String[] args) {
    	

    }

}