import java.util.NoSuchElementException;
import java.util.Iterator;

public class NestedLinkListIterator implements Iterator<Integer>{

	private NestedLinkListNode n1,n2;

	public NestedLinkListIterator(NestedLinkList list){
		n1=list.root;
		n2=null;
	}

	@Override
	public boolean hasNext(){
		return (n1!=null || n2!=null);
	}

	@Override
	public Integer next(){

		if(n1==null && n2==null)
			throw new NoSuchElementException();
		else{
			int value;
			if(n2==null){
				value = n1.value;
				n2=n1.nestedNode;
				n1=n1.next;
			}else{
				int val = n2.value;
				n2=n2.next;
			}
		}
		return value;
	}

	@Override
	public void remove(){

	}

}