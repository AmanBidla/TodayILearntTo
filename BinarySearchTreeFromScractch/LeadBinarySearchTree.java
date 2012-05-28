import java.util.Iterator;
import java.util.ArrayList;
public class LeadBinarySearchTree{


	public static void main(String cb[]){
		BinarySearchTree bst = new BinarySearchTree();
		BinarySearchTree newbst = new BinarySearchTree();
		BinarySearchTree bstone = new BinarySearchTree();
		BinarySearchTree bst2 = new BinarySearchTree();
		BinarySearchTree nt = new BinarySearchTree();
		try{
			bst.createRoot(new Integer(28));
			bst.insertNode(new Integer(22));			
			bst.insertNode(new Integer(32));		
			bst.insertNode(new Integer(30));
			bst.insertNode(new Integer(42));		
			bst.insertNode(new Integer(37));					
			ArrayList allNodes = bst.allNodes();
			Iterator it = allNodes.iterator();
			System.out.println("inorder traversal");
			while(it.hasNext()){
				System.out.println(it.next().toString());
			}
			
			bst.getSum(50,bst.getRoot());
			System.out.println("showing all paths");
			bst.showAllPaths();
			System.out.println("mirroring");			
			bst.showAllPaths();
			newbst.createRoot(new Integer(28));
			newbst.insertNode(new Integer(22));			
			newbst.insertNode(new Integer(32));		
			newbst.insertNode(new Integer(33));
			newbst.insertNode(new Integer(42));		
			newbst.insertNode(new Integer(37));					
			
			System.out.println("check if identical");						
				System.out.println("both is identical is "+bst.isIdentical(bst.getRoot(), newbst.getRoot()));
				System.out.println("newbst is a BST is "+bst.isBinary(bst.getRoot()));
			
			bstone.createRoot(new Integer(50));
			bstone.insertNode(new Integer(40));			
			bstone.insertNode(new Integer(60));						
			bstone.insertNode(new Integer(10));									
			bstone.insertNode(new Integer(45));									
			bstone.insertNode(new Integer(55));									
			bstone.insertNode(new Integer(70));												
//			System.out.println("successor of "+bstone.getRoot().getLeft().getLeft().getItem().toString()+" is "+ (bstone.findSuccessor(bstone.getRoot().getLeft().getLeft())).getItem().toString());
//			System.out.println("successor of "+bstone.getRoot().getItem().toString()+" is "+ (bstone.findSuccessor(bstone.getRoot())).getItem().toString());
			System.out.println("successor of "+bstone.getRoot().getRight().getItem().toString()+" is "+ (bstone.findSuccessor(bstone.getRoot().getRight())).getItem().toString());
			Result result = bst.isAncestor(bstone.getRoot(),bstone.getRoot().getLeft().getLeft(),bstone.getRoot().getLeft().getRight());
			System.out.println("finding ancestor of "+bstone.getRoot().getLeft().getLeft().getItem().toString()+" and "+ bstone.getRoot().getLeft().getRight().getItem().toString());
			System.out.println("common ancestor is "+result.node.getItem().toString());

			 result = bst.isAncestor(bstone.getRoot(),bstone.getRoot().getLeft(),bstone.getRoot().getLeft().getRight());
			System.out.println("finding ancestor of "+bstone.getRoot().getLeft().getItem().toString()+" and "+ bstone.getRoot().getLeft().getRight().getItem().toString());
			System.out.println("common ancestor is "+result.node.getItem().toString());

			 result = bst.isAncestor(bstone.getRoot(),bstone.getRoot().getLeft(),bstone.getRoot().getRight().getRight());
			System.out.println("finding ancestor of "+bstone.getRoot().getLeft().getItem().toString()+" and "+ bstone.getRoot().getRight().getRight().getItem().toString());
			System.out.println("common ancestor is "+result.node.getItem().toString());

			 result = bst.isAncestor(bstone.getRoot(),bstone.getRoot().getRight().getLeft(),bstone.getRoot().getRight().getRight());
			System.out.println("finding ancestor of "+bstone.getRoot().getRight().getLeft().getItem().toString()+" and "+ bstone.getRoot().getRight().getRight().getItem().toString());
			System.out.println("common ancestor is "+result.node.getItem().toString());

			System.out.println("replacing node with greatest value than node");
			System.out.println(bstone.updateNode(bstone.getRoot().getRight()));

			System.out.println("replacing node with greatest value than node");
			System.out.println(bstone.updateNode(bstone.getRoot()));
			
			
				bst2.createRoot(new Integer(40));
				bst2.insertNode(new Integer(20));			
				bst2.insertNode(new Integer(60));						
				bst2.insertNode(new Integer(10));									
				bst2.insertNode(new Integer(30));									
				bst2.insertNode(new Integer(50));									
				bst2.insertNode(new Integer(70));												
				bst2.insertNode(new Integer(5));																
				bst2.insertNode(new Integer(15));	
				bst2.insertNode(new Integer(25));
				bst2.insertNode(new Integer(35));
				bst2.insertNode(new Integer(45));
				bst2.insertNode(new Integer(55));
				bst2.insertNode(new Integer(65));
				bst2.insertNode(new Integer(75));
	

				bst2.printVerticalNodes(bst2.getRoot());
				System.out.println("size is "+bst2.getSize(bst2.getRoot()));
 	//			bst2.printLevelOrderNodes(bst2.getRoot());
		 		bst2.levlOrder(bst2.getRoot());
						
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}