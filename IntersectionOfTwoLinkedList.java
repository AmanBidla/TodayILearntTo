class Node {
	int val;
	Node next;
	public Node(int val){
		this.val=val;
	}
}

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		
		Node l1 = new Node(3);
		l1.next = new Node(1);
		l1.next.next = new Node(5);
		l1.next.next.next = new Node(9);
		l1.next.next.next.next = new Node(7);
		l1.next.next.next.next.next = new Node(2);
		l1.next.next.next.next.next.next = new Node(1);

		Node l2 = new Node(4);
		l2.next = new Node(6);
		l2.next.next = l1.next.next.next.next;
		Node show1 = l1;
		Node show2 = l2;
		show(show1);
		show(show2);
		Node intersection = intersection(l1,l2);
		if(intersection == null ) System.out.println("No intersection");
		else System.out.println("intersection is "+intersection.val);

	}

	private static void show(Node l1) {

		while(l1!=null) {
			System.out.print(l1.val+"->");
			l1 =l1.next;
		}
		System.out.println("");

	}
	public static Node intersection(Node l1, Node l2) {

		if( l1==null || l2==null ) {
			return null;
		}

		Node s1 = l1, s2=l2;		 
 		int len1=0,len2=0;

 		while(s1.next!=null){
 			len1++;
 			s1=s1.next;
 		}

 		while(s2.next!=null){
 			len2++;
 			s2=s2.next;
 		}

 		if(!(s1.equals(s2))) return null;

		Node longerNode = (len2<len1) ? l1 : l2;
		Node shorterNode = (longerNode==l1) ? l2 : l1;
		int diff = Math.abs(len1-len2);
		longerNode = moveLongerNodeBy(diff, longerNode);
		while(longerNode!=null && shorterNode!=null) {

			if (longerNode.equals(shorterNode)) {
				return longerNode;
			} else {
				longerNode = longerNode.next;
				shorterNode = shorterNode.next;
			}
		}
		return null;

	}

	private static Node moveLongerNodeBy(int diff,Node longerNode){
		while(diff>0){		 
			longerNode = longerNode.next;
			diff--;
		}
		return longerNode;
	}


}