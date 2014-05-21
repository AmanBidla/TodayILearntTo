public class TestLRUCache {


	public static void main(String[] args) {
		
		LRUCache<Integer,String> l = new LRUCache<Integer,String>(4);
		
		
		//l.put(5,"five");

		
		l.put(2,"two");
		l.put(3,"three");
		l.put(4,"four");
		l.put(1,"one");
	    l.get(1);
		l.get(2);
		l.get(2);
		l.get(2);

		 System.out.println(l.removeAndShow());
		 System.out.println(l.removeAndShow());
		 System.out.println(l.removeAndShow());
		 System.out.println(l.removeAndShow());
		 //System.out.println(l.removeAndShow());

	}
}