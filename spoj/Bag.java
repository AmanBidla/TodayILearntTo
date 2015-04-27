import java.util.NoSuchElementException;
import java.util.Iterator;


public class Bag<Item> implements Iterable<Item>{

    private int N;
    private Node<Item> first;

    private static class Node<Item> {

        private Node<Item> next;
        private Item item;

    }


    public int size(){
        return N;
    }

    public void add(Item item){

        Node<Item> old = first;
        first = new Node<Item>();
        first.item=item;
        old.next=first;
        N++;
    }

    public Iterator<Item> iterator(){
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>{

        public Node<Item> current;
        public ListIterator(Node<Item> first){
            current =first;
        }

        public boolean hasNext(){
            return current.next!=null;
        }

        public void remove(){

        }

        public Item next(){
            if(!hasNext()) throw new NoSuchElementException("No next Item");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }



}