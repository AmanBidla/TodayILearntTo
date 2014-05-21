public class LinkedListNode {
			
			 LinkedListNode next,random;
			 int value;

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