import java.util.Random;
class Node {

	Node []next;
	int value;
	int level;

	public Node(int value, int level){
		this.value=value;
		next =new Node[level];
	}

}

public class SkipLists {

	private static final int MAX_LEVELS = 33;
	private static Node head = new Node(0,MAX_LEVELS);
	private static int levels=1;
	private static Random random = new Random();


	public static void insert(int value) {

		int currLevel=0;
		for(int randomNumber = random.nextInt(); (randomNumber&1)==0; randomNumber>>=1){
			currLevel++;
			if(currLevel==levels){
				levels++;
				break;
			}
		}

		Node node = new Node(value,currLevel+1);
		Node curr = head;
		for(int i=levels-1;i>=0;i--){

			for (; curr.next[i] != null; curr = curr.next[i]){
				if(curr.next[i].value > value ){
					break;
				}				 		 
			}

			if(i<=currLevel){
				node.next[i] = curr.next[i];
				curr.next[i] = node;
			}
		}
	}

	public static boolean search(int value) {
		Node curr = head;
		for(int i=levels-1;i>=0;i--){
			for (; curr.next[i] != null; curr = curr.next[i]){
				if(curr.next[i].value > value) break;
				if(curr.next[i].value == value) return true;				 
			}
		}
		return false;
	}

	public static boolean remove(int value){
		Node curr = head;
		boolean found = false;
		for(int i=levels;i>=0;i--){
			for (; curr.next[i] != null; curr = curr.next[i]){
				if(curr.next[i].value > value) break;
				else if(curr.next[i].value == value) {
					 found = true;
					 curr.next[i] = curr.next[i].next[i];
					 break;
				}				 
			}
		}
		return found;
	}

	public static void main(String[] args) {
		
		System.out.println("insert 4");insert(4);
		System.out.println("insert 5");insert(5);
		System.out.println("insert 15");insert(15);
		System.out.print("find 4: ");find(4);
		System.out.println("insert 20");insert(20);
		System.out.println("remove 4");remove(4);
		System.out.print("find 4: ");find(4);
		System.out.print("find 15: ");find(15);
		System.out.println("insert 16");insert(16);		 
		System.out.println("remove 5");remove(5);
		System.out.print("find 16: ");find(16);
		System.out.println("find 5");find(5);
	}

	public static void find(int val){

		if(search(val)){
			System.out.println("Found "+val);
		}else{
			System.out.println("Did not find "+val);
		}

	}

}