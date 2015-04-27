public class MyHashMap<K,V>{

	private double LOAD_FACTOR = 0.75;
	private Entry[] entryTable;
	private int elemCount;;
	private int size;

	public MyHashMap(int N){
		this.N = N;
		entryTable = new Entry<K,V> [N];
		elemCount=0;
	}

	public static class Entry
	{
		K key;
		V val;
		Entry<K,V> next=null;
	 	public Entry(K key, V val){
	 		this.key=key;
	 		this.val=val;
	 	}	 	 
	 	// getters and setters
	}

	/**
	 * Insert your super-mega-hash-function below :)
	 */
	private static final int hash(int h)
	{
	    h ^= (h >>> 20) ^ (h >>> 12);
	    return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public void put(K key, V value)
	{

		if (elemCount>(N*loadFactor)) 
			resize();
		int index = hash(key.hashCode())%N;
		if (table[index]==null) 
			table[index] = new Entry<K,V>(key,value);
		else
		{
			Entry<K,V> cur = table[index];
			while(true) {
				
				if (cur.getKey().equals(key)){
					cur.setValue(value);
					break;
				}
		if (cur.next()==null) break;
		cur = cur.next();
		}
		cur.setNext(new Entry(key,value));
		}
		}
		public V get(K key)
		{
		int index = hash(key.hashCode())%table.length;
		if (table[index]==null) return null;
		else
		{
		Entry cur = table[index];
		while(true)
		{
		if (cur.getKey().equals(key))
		{
		return cur.getValue();
		}
		if (cur.next()==null) break;
		cur = cur.next();
		}
		return null;
	}
	}
	public void resize()
	{
	int newSize = table.length*1.5;
	Entry[] newTable = new Entry[newSize];
	for (int i=0; i<table.length; i++) newTable[i]=table[i];
	table = newTable;
	}
	//contructors, getters and setters below
	...
	}
 