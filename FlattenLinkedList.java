public class FlattenLinkedList{


	class Node {

		public Node next, opt;
		public int val;

		public Node(int val){
			this.val=val;
		}

		 
	}

	public Node createList(){
		Node root = new Node(10);
		root.opt = new Node(4);
		root.next = new Node(5);

		root.opt.next = new Node(20);
		root.opt.next.opt = new Node(2);

		root.opt.next.next =new Node(13);
		root.opt.next.next.opt= new Node(16);
		root.opt.next.next.opt.opt = new Node(3);

		root.next.next = new Node(12);
		root.next.next.next = new Node(7);

		root.next.next.next.opt = new Node(17);
		root.next.next.next.opt.opt = new Node(9);
		root.next.next.next.opt.opt.opt = new Node(19);

		root.next.next.next.next=new Node(11);
		root.next.next.next.opt.next = new Node(6);
		root.next.next.next.opt.opt.next = new Node(8);

		root.next.next.next.opt.opt.opt.next = new Node(15); 

		return root;
	}

	public Node flatten(Node root){

		if(root ==null)
			return null;

		Node head = root;
		flat(root);
		return head;
	}

	public Node flat(Node root){

		if(root==null)
			return root;

		if(root.next==null && root.opt==null)
			return root;

		Node currNext =null;
		Node opt = null;
		Node last = null;

		currNext = root.next;
		opt = root.opt;

		if(opt!=null){
			root.next = opt;
			last = flat(root.next);
		}

		if(last==null)
			last = root;

		if(currNext!=null){
			 last.next = currNext;
			 last = flat(last.next);
		}

		return last;
	}

	public static void main(String[] args) {
		
		FlattenLinkedList fl = new FlattenLinkedList();
		Node root = fl.createList();
		root = fl.flatten(root);
		fl.show(root);
	}

	public void show (Node root){

		while(root!=null){
			System.out.print(root.val+" - ");
			root = root.next;
		}
	}

}