public class SListNodeForMerge{

	public int item;
	public SListNodeForMerge next;
	
	public SListNodeForMerge(int item,SListNodeForMerge next){
		this.item=item;
		this.next=next;
	}

	public void setNext(SListNodeForMerge next){
		this.next=next;
	}
	public SListNodeForMerge getNext(){
		return next;
	}
	
	public int getItem(){
		return item;
	}
	public void setItem(int item){
		this.item=item;
	}
}