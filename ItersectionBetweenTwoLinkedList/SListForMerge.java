public class SListForMerge{
	
	public SListNodeForMerge head;
	int size;
	
	
	public SListForMerge(){
		head=createSListNodeForMerge(0,head);
		size=0;
	}
	
	public SListNodeForMerge createSListNodeForMerge (int item,SListNodeForMerge next){
		return new SListNodeForMerge(item,next);
	}
	
	public SListNodeForMerge getHead(){
		return head;
	}
	
	public SListNodeForMerge intersection(SListForMerge l1, SListForMerge l2){
		
		if((l1!=null)&&(l2!=null)){
			
			System.out.println("first list ");
			System.out.println(l1.toString());
			System.out.println("second list ");
			System.out.println(l2.toString());
			int s1=0,s2=0;
			SListNodeForMerge c1=l1.getHead().getNext();
			SListNodeForMerge c2=l2.getHead().getNext();
			while(c1!=null){
				s1++;
				c1=c1.getNext();
			}
			while(c2!=null){
				s2++;
				c2=c2.getNext();
			}
			boolean isS1=false;
			int d=Math.abs(s1-s2);
			if(s1>s2)
				isS1=true;
			if(isS1){
				c1=l1.getHead().getNext();
				c2=l2.getHead().getNext();
			}else{
				c1=l2.getHead().getNext();
				c2=l1.getHead().getNext();
			}
			
			for(int i=0;i<d;i++)
					c1=c1.getNext();
			while(c1!=null && c2!=null){
					if(c1==c2)
						return c1;
					else{
						c1=c1.getNext();
						c2=c2.getNext();
					}						
				}
					return null;
		}
		if((l1==null)&&(l2!=null)) return l2.getHead();
		else if((l2==null) && (l1!=null)) return l1.getHead();
		else
			return null;
	}
	
	public void insertBack(int item){
		SListNodeForMerge current=head;
		while(current.getNext()!=null){
			current=current.getNext();
		}
		current.setNext(createSListNodeForMerge(item,null));
	}
	
	public SListNodeForMerge find (int item){
		SListNodeForMerge current=head.getNext();
		while(current!=null){
			if(current.getItem()==item)
				return current;
			else
				current=current.getNext();
		}
		return null;
	}
	
	public void insertFront(int item){
		
		if(head.getNext()==null){
			SListNodeForMerge temp = createSListNodeForMerge(item,null);
			head.setNext(temp);
		}else{
		 SListNodeForMerge temp = createSListNodeForMerge(item,head.getNext());
		 head.setNext(temp);
		}
		size++;
	}
	
	public String toString(){
		SListNodeForMerge current= head.getNext();
		String st="";
		while(current!=null){
			st+=current.getItem()+",";
			current=current.getNext();
		}
		st=st.substring(0,st.length()-1);
		return st;
	}
}