import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Solution<K,V>{


 private final Map<K,Entry<K,V>> map = new HashMap<K,Entry<K,V>>();
 private Entry <K,V> oldest;
 private final int CACHE_SIZE;

 public Solution(int size){
 	if(size<0) throw new IllegalArgumentException("negative num");
 	this.CACHE_SIZE =size;
 }
 
 private static class Entry<K,V>{
	 
	 K key;
	 V value;
	 Entry<K,V> left,right;
	 
	 public Entry(K key,V value){
		 this.key = key;
		 this.value = value;
	 }
	 public Entry<K,V> addLeft(Entry<K,V> left){
		 this.left =left;
		 if(left!=null) left.right=this;
		 return this;
		
	 }
	 public Entry<K,V> addRight(Entry<K,V> right){
		 this.right =right;
		 if(right!=null) right.left=this;
		 return this;
	 }
	 
	 public Entry<K,V> inBetween(Entry<K,V> left, Entry<K,V> right){
		 return this.addLeft(left).addRight(right);
	 }

	 public void remove(){
		 if(this.left!=null) this.left.addRight(this.right);
		 if(this.right!=null) this.right.addLeft(this.left);
		 this.left = this.right= null;
	 }
	 
	 
	 
 }
 
 
 public void addFirst(Entry<K,V> entry){
	 remove(entry);
	 if(oldest==null) oldest = entry.addLeft(entry);
	 else entry.inBetween(oldest.left,oldest);
	 
 }
 
 public synchronized void  put(K key, V value){
	 Entry <K,V>  entry = new Entry<K,V>(key,value);
	 map.put(key,entry);
	 addFirst(entry);
	 if(removeEldestEntry()){
		 remove(oldest);
	 }
	 
 }
 
 public boolean removeEldestEntry(){
	 return map.size()>CACHE_SIZE;
 }
 
 public void remove(Entry<K,V> entry){
	 if(entry!=null){
		 if(entry==oldest) oldest = entry.right;
		 entry.remove();
	 }
 }
 
 public synchronized V get(K key){
	 Entry<K,V> entry = map.get(key);
	 if(entry!=null){
		 addFirst(entry);
		 return entry.value;
	 }
	 return null;
 }
 
 
 public static void main(String[] args) {
	 int cacheSize=2;
	 Solution<String, Integer> s=null ;
	 readInput(s); 
	 
}

private static void readInput(Solution<String, Integer> s) {
	
	String _command_1="";
	String _command_2="";
	String _command_3="";
	
	if(_command_1.equals("BOUND")){
		s = new Solution<String, Integer>(Integer.parseInt(_command_2));;
	}
	
	else if(_command_1.equals("SET")){
		s.put(_command_2,Integer.parseInt(_command_2));
	}
	
	
}



}