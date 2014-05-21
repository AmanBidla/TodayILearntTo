import java.util.Comparator;
import java.util.Iterator;
 
 
public class Trie implements Iterable<Trie> {
    char key;
    double occurrence;
    boolean ending;
    Trie parent, firstChild, nextSibling;
    static Comparator<Trie> c = new Comparator<Trie>(){
        public int compare(Trie o1, Trie o2) {
            return (int)(o1.occurrence - o2.occurrence);
        }};
 
    Trie( char key, Trie parent ){
        this.key = key;
        if( parent != null )
            parent.addChild(this);
    }
     
    static public Comparator<Trie> getComparator(){
        return c;
    }
 
    void addChild( Trie child ){
        if( firstChild == null ){
            firstChild = child;
        }
        else{
            Trie t = firstChild;
            for( ; t.nextSibling != null; t = t.nextSibling );
            t.nextSibling = child;
        }
        child.parent = this;
    }
     
    Trie find( char ch ){
        for( Trie t = firstChild; t != null; t = t.nextSibling ){
            if( t.key == ch )
                return t;
        }
        return null;
    }
     
    double insert( char[] word, int from ){
        // return
        //      accumulated occurrence of the inserted word
        if( from == word.length )return 0;
 
        char ch = word[from];
        Trie child = find(ch);
        if( child == null ){
            child = new Trie(ch, this);
        }
        if( from == word.length-1 ){
            child.ending = true;
            return ++ child.occurrence;
        }
        return child.insert(word, from+1);
    }
 
    public String toString(){
        if( !ending )return "" + key;
        String s = "";
        for( Trie t = this; t.key != (char)0; t = t.parent ){
            s = t.key + s;
        }
        return s;
    }
     
    Trie minimum(){
        Trie child = firstChild;
        if( child == null )
            return this;
        for( ; child.firstChild != null; child = child.firstChild );
        return child;
    }
    Trie nextWord(){
        Trie t = nextSibling;
        if( t != null ){
            return t.minimum();
        }
        else{
            if( parent == null )return null;
            if( parent.ending )
                return parent;
            return parent.nextWord();
        }
    }
    public Iterator<Trie> iterator() {
        return new Iterator<Trie>(){
            Trie current = minimum(), nextElement = current;
            public boolean hasNext() {
                if( nextElement != null )return true;
                nextElement = current.nextWord();
                return nextElement != null;
            }
 
            public Trie next() {
                if( !hasNext() )
                    return null;
                current = nextElement;
                nextElement = null;
                return current;
            }
 
            public void remove() {
            }
             
        };
    }
}