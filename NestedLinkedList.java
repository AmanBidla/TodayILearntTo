public class NestedLinkList implements Iterable<Integer> {

	private NestedLinkListNode root;
 	
 	public NestedLinkList(Node n){
 		this.root = n;
 	}

 	public Iterator<Integer> iterator(){
 		return new NestedLinkListIterator(this);
 	}

}	