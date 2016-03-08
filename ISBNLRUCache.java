import java.util.Map;
import java.util.LinkedHashMap;

public class ISBNLRUCache<K,V> {


	private Map<K,V> map;

	public ISBNLRUCache(int capacity) {


		map = new LinkedHashMap<K,V>(){

			@Override
			public boolean removeEldestEntry(Map.Entry<K,V> entry){
				return this.size() > capacity; 
			}
		};
	}


	public V lookUp(K key){

		if(!map.containsKey(key)){
			return null;
		}

		V value = map.get(key);
		moveToFront(key, value);
		return value;
	}

	private void moveToFront(K key, V value){

		map.remove(key);
		map.put(key, value);
	}

	public V insert(K key, V value){		 
		V currentValue = map.get(key);
		if( !map.containsKey(key) ){
			map.put(key,value);
			return value;
		} else {			 
			moveToFront(key, currentValue);
			return null;
		}
	}
    
    public V erase(K key) { return map.remove(key); }


	public static void main(String[] args) {
	
		final int CAPACITY = 2;	
		ISBNLRUCache<Integer,Integer> c = new ISBNLRUCache<Integer,Integer>(CAPACITY);     
	    System.out.println("c.insert(1, 1)");
	    c.insert(1, 1);
	    System.out.println("c.insert(1, 10)");
	    c.insert(1, 10);
	    System.out.println("c.lookUp(2, val)");
	    assert(null == c.lookUp(2));
	    System.out.println("c.lookUp(1, val)");
	    assert(c.lookUp(1) == 1);
	    c.erase(1);
	    assert(null == c.lookUp(1));

	    c = new ISBNLRUCache<Integer,Integer>(CAPACITY);
	    c.insert(1, 1);
	    c.insert(2, 1);
	    c.insert(3, 1);
	    c.insert(4, 1);
	    assert(null == c.lookUp(1));
	    assert(null == c.lookUp(2));
	    assert(1 == c.lookUp(3));
	    assert(1 == c.lookUp(4));

	    c = new ISBNLRUCache<Integer,Integer>(CAPACITY);
	    c.insert(1, 1);
	    c.insert(2, 1);
	    c.insert(3, 1);
	    c.lookUp(2);
	    c.insert(4, 1);
	    assert(null == c.lookUp(1));
	    assert(1 == c.lookUp(2));
	    assert(null == c.lookUp(3));
	    assert(1 == c.lookUp(4));


	     // test update moves to front
	    c = new ISBNLRUCache<Integer,Integer>(CAPACITY);
	    c.insert(1, 1);
	    c.insert(2, 1);
	    c.insert(3, 1);
	    c.insert(2, 2);
	    c.insert(4, 1);
	    assert(null == c.lookUp(1));
	    assert(1 == c.lookUp(2));
	    assert(null == c.lookUp(3));
	    assert(1 == c.lookUp(4));

	    // test erase
	    c = new ISBNLRUCache<Integer,Integer>(CAPACITY);
	    c.insert(1, 1);
	    c.insert(2, 1);
	    c.erase(2);
	    c.insert(3, 3);
	    assert(1 == c.lookUp(1));
	    assert(null == c.lookUp(2));
	    assert(3 == c.lookUp(3));
	}

}