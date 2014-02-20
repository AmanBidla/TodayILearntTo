import java.util.Random;


class Node{

	Node next;
	int value;
}

public class MergeTwoLinkedList{

public static void main(String[] args) {
	
	Node l1 =createSortedList();
	Node temp =l1;
	showAll(temp);
	Node l2 =createSortedList();
	Node templ2 = l2;
	temp =l2;
	showAll(temp);
	Node l3 = mergeIteratively(l1,l2);
	System.out.println("after merging Iteratively");
	showAll(l3);
    System.out.println("----"); 

	l1 = createSortedList();
	temp =l1;
	showAll(temp);
	l2 =createSortedList();
	temp =l2;
	showAll(temp);	 
	l3 = mergeIteratively(l1,l2);
	System.out.println("after merging Recursively");
	showAll(l3);
  
}

public static Node mergeRecursively (Node l1, Node l2){
	if(l1==null) return l2;
	if(l2==null) return l1;

	if(l1.value <= l2.value){
		l1.next = mergeRecursively(l1.next,l2);
		return l1;
	}else{
		l2.next = mergeRecursively(l2.next,l1);
		return l2;
	}
}

public static Node mergeIteratively(Node l1,Node l2){

	if(l1==null) return l2;
	if(l2==null) return l1;
	Node head;

	if(l1.value<=l2.value){
		head = l1;
	}else{
		head = l2;
		l2 =l1;
		l1 = head;
	}

	while(l1.next!=null && l2!=null){

		if(l1.next.value<=l2.value){
			l1 = l1.next;
		}else{
			Node temp = l1.next;
			l1.next = l2;
			l2 = temp;
		}
	}

	if(l1.next==null) l1.next = l2;
	return head;
}



public static Node createSortedList(){
	Random rand = new Random();
	int max=20, min=10;
	Node head = new Node();
	Node temp =head;
	int randomNum = rand.nextInt((max - min) + 1) + min;	
	temp.value = randomNum;
	int prevValue = temp.value;
	temp.next = new Node();
	temp = temp.next;

	min = min +10;
	max = max +10;
	for(int i=1;i<10;i++){
 	
 		while(true){
 			randomNum = rand.nextInt((max - min) + 1) + min;
 			if(randomNum>prevValue){
 				temp.value= randomNum;
 				prevValue= temp.value;
 				min = min +10;
 				max = max +10;
 				break;
 			}
 		}
	 
		if(i!=9){
			temp.next = new Node();
			temp = temp.next;	
		}else{
			temp.next=null;
		}
	}
		
		
		return head;
} 

	private static void showAll(Node head){
		
		while(head.next!=null){
			System.out.print(head.value+"->");
			head = head.next;
		}
		System.out.println(head.value);
		 
	}
	



}