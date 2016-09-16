import java.util.Map;
import java.util.HashMap;

public class LRUCache<K,V> {

	private static class Node<K,V>{

		K key;
		V value;
		Node<K,V> prev,next;

	}

	private Node<K,V> head,tail;
	private int size;
	private Map<K,Node<K,V>> map = new HashMap<>();

	public LRUCache(int size) {
		this.size = size;
		head = new Node<K,V>();
		tail = new  Node<K,V>();
		head.next = tail;
		tail.prev = head;		
	}

	public synchronized void put(K key, V value){

		Node<K,V> node = new Node<K,V>();
		node.key = key;
		node.value = value;
		map.put(key,node);
		moveToFront(node);

	}

	private void moveToFront(Node<K,V> node) {

		if(isCacheFull()){
			removeEldest();
		}
		Node<K,V> first = head.next;
		insertInBetween(head, first,node);
	}

	private boolean isCacheFull(){
		return map.size()>size;
	}

	private void removeEldest() {
		Node<K,V> last = tail.prev;
		if(!last.equals(head)){
			last.prev.next = tail;
			tail.prev = last.prev;
			map.remove(last.key);
			last = null;
		}
	}

	private void insertInBetween(Node<K,V> left, Node<K,V> right, Node<K,V> toInsert) {
		left.next = toInsert;
		toInsert.prev = left;
		right.prev = toInsert;
		toInsert.next = right;
	}

	public synchronized V get(K key) {

		if(!map.containsKey(key)){
			return null;
		}

		Node<K,V> node =  disJoin(map.get(key));
		moveToFront(node);
		return node.value;

	}


    private Node<K,V> disJoin(Node<K,V> node){

        Node<K,V> left = node.prev;
        Node<K,V> right = node.next;

        left.next = right;
        right.prev = left;

        return node;

    }

	public void print() {
		if(head != null){
			Node<K,V> nextNode = head.next;
			while(!nextNode.equals(tail)){				 
				System.out.print("["+nextNode.key+","+nextNode.value+"] ");				 
				nextNode= nextNode.next; 
				if(!nextNode.equals(tail)){
					System.out.print(",");
				}
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {

		LRUCache<String,Integer> lru = new LRUCache<String,Integer>(4);

		lru.put("a",1); 
		lru.put("b",2);
		lru.put("c",3);
		lru.put("d",4);
		System.out.println(lru.get("b"));
		lru.print();
		lru.put("e",5);
		System.out.println(lru.get("c"));
		lru.print();
		System.out.println(lru.get("d"));
		lru.print();
		

		
	}
}	