public class SListRandom{

	public SListNodeRandom  head,tail;
	public int size;
	
	public SListRandom(){
		head=createSListNodeRandom(0,null,null);
		tail=head;
		size=0;
	}
	
	public SListNodeRandom createSListNodeRandom(int item,SListNodeRandom next, SListNodeRandom random){
		return new SListNodeRandom(item,next,random);
	}
	
	public SListNodeRandom getHead(){
		return head;
	}
	
	public SListNodeRandom getTail(){
		return tail;
	}
	public void printAll(SListNodeRandom node){
		while(node!=null){
			System.out.println(node.getItem()+" ");
			node=node.getNext();
		}
	}
	public  SListNodeRandom clone(){
		SListNodeRandom current= getHead().getNext();
		SListNodeRandom copy,copyNext;
		
		while(current!=null){
			copy=createSListNodeRandom(current.getItem(),null,null);
			copyNext=current.getNext();
 			current.setNext(copy);
			copy.setNext(copyNext);
			current=copyNext;
		}
		
		System.out.println("created cloned");
		printAll(getHead().getNext());
		current= getHead().getNext();
		while(current!=null){
			current.getNext().setRandom(current.getRandom().getNext());
			current=current.getNext().getNext();
		}
		copyNext=getHead().getNext().getNext();
		current=getHead().getNext();
		copy=getHead().getNext().getNext();
		while(current!=null){
			System.out.println("current "+ current.getItem());
			System.out.println("copy "+ copy.getItem());
			if(current.getNext().getNext()!=null){
			current.setNext(current.getNext().getNext());
			copy.setNext(copy.getNext().getNext());
			current=current.getNext();
			copy=copy.getNext();
			}else{
				break;
			}
		}
		return copyNext;
	}
	
	public void insertInFront(int item){

		if(head.getNext()==null){
			SListNodeRandom temp = createSListNodeRandom(item,null,null);
			tail =temp;
 			head.setNext(temp);
		}else{
 			SListNodeRandom temp = createSListNodeRandom(item,null,null);
			tail.setNext(temp);
			tail=temp;
		}
		size++;
	}
	
	public SListNodeRandom find(int number){
		SListNodeRandom current = getHead().getNext();
		while(current!=null){
			if(current.getItem()==number)
				return current;
				current=current.getNext();
		}
		return null;
	}
	
	public String toString(){
		SListNodeRandom current = getHead().getNext();
		String st="";
		while(current!=null){
 			st+=""+current.getItem()+",";
			current=current.getNext();
		}
		st=st.substring(0,st.length()-1);
		return st;
	}

}