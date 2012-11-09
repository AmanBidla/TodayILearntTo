public class SListNodeRandom{

	public int item;
	public SListNodeRandom next;
	public SListNodeRandom random;
	
	public SListNodeRandom(int item,SListNodeRandom next,SListNodeRandom random){
		this.item=item;
		this.next=next;
		this.random=random;
	}
	
	public SListNodeRandom getNext(){
		return next;
	}
	
	public void setNext(SListNodeRandom next){
		this.next=next;
	}
	
	public void setRandom(SListNodeRandom random){
		this.random=random;
	}
	
	public SListNodeRandom getRandom(){
		return random;
	}
	public int getItem(){
		return item;
	}

}