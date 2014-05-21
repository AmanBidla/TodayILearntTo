public class LinkedListMain{

	
		static class LinkedListNode {
			
			private LinkedListNode next,random;
			private int value;

			public LinkedListNode(LinkedListNode next, LinkedListNode random, int val){
				this.next=next;
				this.random=random;
				this.value =val;
			}
			public void setNext(LinkedListNode node){
				this.next= next;
			}
			public LinkedListNode getNext(){
				return next;
			}
		}

		static class LinkedList{
				

			private LinkedListNode head;
			private int size;			

			public LinkedList(){
				head= new LinkedListNode(null,null,0);
			} 	

			public void add(int val){
				LinkedListNode node = new LinkedListNode(null,null,val);
				System.out.println("value "+val+" and "+(head.getNext()==null));
				if(head.getNext()==null){
					head.setNext(node);
					System.out.println("added "+val);
				}else{
					LinkedListNode curr = head.next;
					while(curr.next==null){
						curr= curr.next;
					}
					curr.next=node;
				}
			}

			public void random(){
				
				LinkedListNode node = head.next;
				while(node!=null){
					LinkedListNode random = node.next.next;
					if(random==null) random = head.next;
					node.random=random;
					node= node.next;
				}

			}

			public void show(){

				LinkedListNode node = head;
				while(node!=null){
					System.out.print(node.value+">");
				}
				System.out.print("NULL");
				System.out.println();
			}

		
		}



	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		l.add(2);
		l.add(4);
		l.add(6);
		l.add(8);
		l.random();

		


	}

}
