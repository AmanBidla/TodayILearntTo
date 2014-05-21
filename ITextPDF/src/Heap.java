import java.util.Comparator;
import java.util.Iterator;
 
 
public class Heap<T> implements Iterable<T>{
    int size;
    T[] data;
    Comparator<T> c;
    public Heap( int capacity, Comparator<T> c ){
        this.size = 0;
        data = (T[])(new Object[capacity]);
        this.c = c;
    }
    public void add( T o ){
        if( size == data.length ){//full
            int cr = c.compare(o, data[0]);
            if( cr <= 0 )return;//throw those less than the current minimum
            data[0] = o;
            Heapify( 0 );
        }
        else{
            data[size++] = o;
            decreaseKey(size-1);
        }
    }
 
    void Heapify( int i ){
        int l = left(i);
        int r = right(i);
        int min = i;
        if( l < size && c.compare(data[l], data[min]) < 0 ){
            min = l;
        }
        if( r < size && c.compare(data[r], data[min]) < 0 ){
            min = r;
        }
        if( min != i ){
            swap( min, i );
            Heapify( min );
        }
    }
     
    void decreaseKey( int i ){
        for( ; i > 0; ){
            int p = parent(i);
            if( c.compare(data[i], data[p]) >= 0 ){
                break;
            }
            swap( i, p );
            i = p;
        }
    }
    void swap( int i, int j ){
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    int parent( int i ){
        return (i-1)/2;
    }
    int left( int i ){
        return 2*i+1;
    }
    int right( int i ){
        return 2*i+2;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int current;
            public boolean hasNext() {
                return current < size;
            }
            public T next() {
                return data[current++];
            }
            public void remove() {
                System.arraycopy(data, current+1, data, current, size-current-1);
                --size;
            }
        };
    }
}