public class SortLinkedList{

	public Node sort(Node node){
		if(node==null || node.next==null){
			return node;
		}
		Node left = node;
		Node right = null;
		Node p1 = head;
		int count =0;
		while(p1!=null){
			count++;
			p1=p1.next;
		}
		int middle = count/2;
		p1=head;
		int midCount =0;
		while(p1!=null){
			midCount++;
			Node next = p1.next;
			if(midCount==middle){
				right=next;
				p1.next=null;
			}
			p1=p1.next;
		}
		Node leftSide = sort(left);
		Node rightSide = sort(right);
		Node mergeNode = merge(leftSide,rightSide);
		return mergeNode;
	}

	private Node merge(Node left, Node right){
		Node p1=left;
		Node p2= right;
		Node fakeHead = new Node(100);
		Node mergeNode = fakeHead;
		while(p1!=null || p2!=null){
			if(p1==null){
				mergeNode.next = new Node(p2.val);
				p2=p2.next;
				mergeNode= mergeNode.next;
			}
			if(p2==null){
				mergeNode.next = new Node(p1.val);
				p1=p1.next;
				mergeNode= mergeNode.next;
			}
			if(p1.val<p2.val){
					mergeNode.next = new Node(p1.val);
					p1= p1.next;
					mergeNode = mergeNode.next;
			}
			if(p1.val==p2.val){
					mergeNode.next = new Node(p1.val);
					p1= p1.next;
					mergeNode = mergeNode.next;
					mergeNode.next = new Node(p2.val);
					p2=p2.next;
					mergeNode= mergeNode.next;
			}
			if(p2.val<p1.val){
					mergeNode.next = new Node(p2.val);
					p2= p2.next;
					mergeNode = mergeNode.next;
			}
		}
		return fakeHead.next;
	}

}