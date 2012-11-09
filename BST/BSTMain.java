public class BSTMain{


public static void main(String abd[]){
	BST b = new BST();
	b.addItem(5);
	b.addItem(10);
	b.addItem(1);
	b.getAllItems(b.getRoot());
 	BSTNode searchNode = b.search(10);
	if(searchNode!=null) System.out.println("item "+searchNode.getItem()+" found.");
	else System.out.println("Search item not found.");
	 b.delete(10);
//	 b.getNode(b.getRoot());
	b.getAllItems(b.getRoot());

}


}