public class LinkedList{
				

			private LinkedListNode head;
			private int size;			

			public LinkedList(){
				head= new LinkedListNode(null,null,0);
			} 

			public LinkedListNode getHead(){
				return head;
			}

			public void add(int val){
				LinkedListNode node = new LinkedListNode(null,null,val);
				System.out.println("value "+val+" and "+(getHead().getNext()==null));
				if(getHead().getNext()==null){
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