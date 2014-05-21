import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Iterator;

public class LRUCache<K, V> {
 
	//Maximum capacity for the LRU cache.
	private final int capacity;
	//Queue to store the recently used keys.
	private ConcurrentLinkedQueue<K> queue;
	//Key-Value store to maintain the actual object.
	private ConcurrentHashMap<K, V> map;
 
	/**
	 * Initial capacity for the LRU Cache.
	 * @param capacity
	 */
	public LRUCache(final int capacity) {
		this.capacity = capacity;
		this.queue	= new ConcurrentLinkedQueue<K>();
		this.map	= new ConcurrentHashMap<K, V>(capacity);
	}
 
	/**
	 * Check whether the items exists in the cache. Returns null if key doesn't exists in the cache.
	 * @param key
	 * @return 
	 */
	public V get(final K key) {
		/*
		if(key == null) {
			throw new NullPointerException();
		}
		if (map.containsKey(key)) {
			queue.remove(key);
		}else throw new IllegalArgumentException ("no such key"+key);
		queue.add(key); */
		return map.get(key);
	}
 	
	 public V removeAndShow(){
	 	K key = queue.poll();
	 	V value =  map.get(key);
	 	map.remove(key);
	 	return value;
	 }
	/**
	 * Add new value to the LRU Cache. If the key already exists, 
	 * the key will be promoted to the front of the cache.
	 * Neither the key nor the value can be null.
	 * @param key
	 * @param value
	 * @throws NullPointerException
	 */
	public synchronized void put(final K key, final V value) {
		if(key == null || value == null) {
			throw new NullPointerException();
		}
		if (map.containsKey(key)) {
			queue.remove(key);
		}
		while (queue.size() >= capacity) {
			K expiredKey = queue.poll();
			if (expiredKey != null) {
				map.remove(expiredKey);
			}
		}
		queue.add(key);
		map.put(key, value);
	}
}