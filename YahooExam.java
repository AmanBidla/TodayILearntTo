/*
Sample Input
BOUND 2
SET a 2
SET b 4
GET b
SET c 5
GET a
DUMP


Sample Output
4
NULL
b 4
c 5

sugiv@yahoo-inc.com */

public class Solution<K,V>{


 private final Map<K,Entry<K,V>> map = new HashMap<K,Entry<K,V>>();
 private Entry <K,V> old;
 private final int CACHE_SIZE;

 public Solution(int size){
 	if(size<0) throw new IllegalArgumentException("")
 }



}