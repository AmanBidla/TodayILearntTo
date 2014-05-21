import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Queue;
import java.util.PriorityQueue;

public class TrieST<Value> {
    private static final int R = 256;        // extended ASCII
    private static Queue q;

    private Node root;      // root of trie
    private int N;          // number of keys in trie


    // R-way trie node
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
        private int heapIndex;
        private int count=-1;
    }

    public TrieST(int n) {
        q = new PriorityQueue<Node>(n);
    }

   /**
     * Initializes an empty string symbol table.
     */

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and <tt>null</tt> if the key is not in the symbol table
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public int get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return 0;
        return  x.count;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return <tt>true</tt> if this symbol table contains <tt>key</tt> and
     *     <tt>false</tt> otherwise
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public boolean contains(String key) {
        return get(key) != 0;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is <tt>null</tt>, this effectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public void put(String key, Value val) {
        /*if (val == null) delete(key);
        else*/
         root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null) N++;
            x.val = val;
            if(x.count==-1) x.count=1;
            else x.count++;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return N;
    }

    /**
     * Is this symbol table empty?
     * @return <tt>true</tt> if this symbol table is empty and <tt>false</tt> otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns all keys in the symbol table as an <tt>Iterable</tt>.
     * To iterate over all of the keys in the symbol table named <tt>st</tt>,
     * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
     * @return all keys in the sybol table as an <tt>Iterable</tt>
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * Returns all of the keys in the set that start with <tt>prefix</tt>.
     * @param prefix the prefix
     * @return all of the keys in the set that start with <tt>prefix</tt>,
     *     as an iterable
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> results = new PriorityQueue<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x == null) return;
        if (x.val != null) results.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

     

     

    
    private static void readFile(String file ){
        try{

            Scanner sc = new Scanner(new File(file));
            
            int number=0;
            
                number = new Integer(sc.nextLine());
            String [] words = new String[number];

            for(int i=0;i<number;i++){
                words[i]=sc.nextLine();
            }

            for(int i=0;i<number;i++){
                st.put(words[i], i);
            }

            int freq = new Integer(sc.nextLine());

            System.out.println("freq is "+freq);
            for (String key : st.keys()) {
                System.out.println(key + " " + st.get(key));
            }
            

        }catch(IOException e){
            System.out.println(e.toString());
        }
        
    }

    /**
     * Unit tests the <tt>TrieSET</tt> data type.
     */
    public static void main(String[] args) {

        readFile(args[0]);
         
    }
}
