import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.lang.Math;
import java.util.*;
  class Result{
	
	BinarySearchTreeNode node;
    boolean isAnces;
	
	public Result(BinarySearchTreeNode node, boolean isAnces){
		this.node=node;
		this.isAnces=isAnces;
	}
}


public class BinarySearchTree{

	public BinarySearchTreeNode root;
	public int size;	
	public static int []array ;
	public static int []nodeArray;
	
	public BinarySearchTree(){
		root=null;
		size=0;
	}


	public BinarySearchTreeNode createRoot(Object item){
		this.root= new BinarySearchTreeNode(null,item,null,null);	
		size++;
		return root;
	}
	
	public BinarySearchTreeNode createNode (BinarySearchTreeNode parent,Object item, BinarySearchTreeNode left, BinarySearchTreeNode right){
		 return new BinarySearchTreeNode(parent, item,left,right);
	}
 
	
	public void insertNode(Object item){
		
 	 BinarySearchTreeNode root = getRoot();
	while (root!=null){
	
		int k = ((Comparable)item).compareTo(root.getItem());
 		if(k<0)
			if(root.getLeft()!=null)
				root=root.getLeft();
			else{
 				root.setLeft(createNode(root,item,null,null));
				break;
			}
			
				
		else if(k>0)
				if(root.getRight()!=null)
					root=root.getRight();
				else{
						 root.setRight(createNode(root,item,null,null));
						break;
				}
	}	 		
		
	}
	
	
	public Result isAncestor(BinarySearchTreeNode root, BinarySearchTreeNode p, BinarySearchTreeNode q){

		if(root==null){
		//	System.out.println("returning false because null caught");
			return new Result(null,false);
			}
//		System.out.println("root is "+root.getItem().toString()+" p is "+p.getItem().toString()+" q is "+q.getItem().toString());
//		if((root==p) && (root==q))
//		System.out.println("comparing "+(Integer.parseInt(root.getItem().toString()))+" and "+ (Integer.parseInt(p.getItem().toString()))+" is "+ ((Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(p.getItem().toString()))));
//		System.out.println("comparing "+(Integer.parseInt(root.getItem().toString()))+" and " +(Integer.parseInt(q.getItem().toString()))+" is "+ ((Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(q.getItem().toString()))));
if( (Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(p.getItem().toString())) &&
(Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(q.getItem().toString())) )
			return new Result(root,true);
			
		
	//	System.out.println("calling isAncestor("+root.getLeft().getItem().toString()+","+p.getItem().toString()+","+q.getItem().toString()+")");
		Result rx = isAncestor(root.getLeft(),p,q);
//		System.out.println("rx.isAnces "+ rx.isAnces);
		if(rx.isAnces){
			System.out.println("rx.node is "+(rx.node).getItem().toString());
			return rx;
			}
		
		Result ry = isAncestor(root.getRight(),p,q);
//		System.out.println("ry.isAnces "+ ry.isAnces);
		if(ry.isAnces){
//			System.out.println("ry.node is "+(ry.node).getItem().toString());
			return ry;
		}
		
		if((rx.node!=null) && (ry.node!=null))
			return new Result(root,true);
 
		else if( (Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(p.getItem().toString())) ||
		(Integer.parseInt(root.getItem().toString()))==(Integer.parseInt(q.getItem().toString())) ){
//			System.out.println("checking for isAncesnew");
			boolean isAncesNow = ((rx.node!=null) || (ry.node!=null))?true:false;
//			System.out.println(" isAncesnew is "+isAncesNow);
				return new Result(root,isAncesNow);
		}else{
			return new Result((((rx.node!=null))?rx.node:ry.node),false);
		}		
	}


public BinarySearchTreeNode isAnces(BinarySearchTreeNode root, BinarySearchTreeNode p, BinarySearchTreeNode q){

	Result res = isAncestor(root,p,q);
		if(res.node!=null)
			return res.node;
		else{
			System.out.println("no ancestor found for "+p.getItem().toString()+" and "+ q.getItem().toString());
			return null;
		}
			
}
	public BinarySearchTreeNode getRoot(){
		if(root!=null)
			return root;
		else return null;
	}
	
	public ArrayList allNodes(){
		BinarySearchTreeNode  root = getRoot();
		if(root!=null){
			ArrayList <Object> allNodesList = new ArrayList<Object>();
			inOrderTraversal(root,allNodesList);
			return allNodesList;
			}
 		else 
			return null;
	}
 
	
	 
 
	public int getSize(BinarySearchTreeNode root){
		if(root==null)
			return 0;
		
		return 1+(getSize(root.getLeft()))+(getSize(root.getRight()));
	}
	
	
	public void printVerticalNodes(BinarySearchTreeNode root){
		if(root==null)
			return;
		int depth = getDepth(root);
		int size  = (2*depth)-1;
		array= new int[size];
		array[((size-1)/2)]=((Integer)(root.getItem()));
			array= printVerticalNodes(array,root,((size-1)/2));
		for(int i=0;i<size;i++)
			System.out.println(array[i]);
	}
	
	public int[] printVerticalNodes(int[]array, BinarySearchTreeNode root, int index){	
		if(root==null)
			return array;
		array=printVerticalNodes(array,root.getLeft(),(index-1));
		if(root.getLeft()!=null){
 			array[(index-1)]=((Integer)(root.getLeft().getItem()))+array[(index-1)];
			}
		if(root.getRight()!=null){
 			array[(index+1)]=((Integer)(root.getRight().getItem()))+array[(index+1)];
			}
			
		array=printVerticalNodes(array,root.getRight(),(index+1));
		return array;
	}
 
	
	public boolean isIdentical(BinarySearchTreeNode root, BinarySearchTreeNode otherRoot){
 		if((root==null) && (otherRoot==null))
			return true;
		else if((root!=null) && (otherRoot!=null)) {
			return(root.getItem().equals(otherRoot.getItem()) && isIdentical(root.getLeft(),otherRoot.getLeft()) && isIdentical(root.getRight(),otherRoot.getRight()));
		}else
			return false;
	}
	
	public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode node){
		if(node==null){
			System.out.println("finding successor of null ");
			return node;
			}
		if((node.getParent()==null) || (node.right!=null))
			return findLeftMost(node.getRight());
		else{
			BinarySearchTreeNode current= node;
			BinarySearchTreeNode parent = node.getParent();
			while((parent!=null) && (!(parent.getLeft().equals(node)))){
				parent=parent.getParent();
				current=current.getParent();
			}
			return parent;
		}
	}
	
	public BinarySearchTreeNode findLeftMost(BinarySearchTreeNode node){
		if(node==null)
			return null;			
		while(node.getLeft()!=null){
			node=node.getLeft();
		}
		return node;
	}

	public int updateNode( BinarySearchTreeNode node){
		if(node.getRight()!=null)
			return update(node.getRight());
		else 
			return ((Integer)node.getItem());
	}
	
	public int update(BinarySearchTreeNode node){
		if(node==null) 
			return 0;
		else{
			int rightValue = update(node.getRight());
			int leftValue = update(node.getLeft());
			return (((Integer)node.getItem())+(rightValue+leftValue));
		}
	}
	
	public void mirror(BinarySearchTreeNode root){
		if(root==null)
			return;
		mirror(root.getLeft());
		mirror(root.getRight());	
		BinarySearchTreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}	
	public void getSum(int sum,BinarySearchTreeNode root){
		if(root==null)
			return;
		int depth= getDepth(root);
		System.out.println("depth is "+depth);
		int[]path= new int[depth];
		//System.out.println("getting all paths");
		getPaths(root,sum,path,0);
		
	}
	
	public int getDepth(BinarySearchTreeNode root){
		if(root==null)
			return 0;
		return 1+ Math.max(getDepth(root.getLeft()),getDepth(root.getRight()));
	}
	
	public void showAllPaths(){
		BinarySearchTreeNode root = getRoot();
		int depth=getDepth(root);
		int []path= new int[depth];
		showAllPaths(root,path,0);	
	}
	
	public boolean isBinary(BinarySearchTreeNode root){
		
		if(root ==null)
			return true;
		if(root.getLeft()!=null){
			if(Math.min(Integer.parseInt(root.getItem().toString()),Integer.parseInt(root.getLeft().getItem().toString()))!=Integer.parseInt(root.getLeft().getItem().toString()))
 				return false;
 			else
				return true;
		}
		if(root.getRight()!=null){
			if(Math.max(Integer.parseInt(root.getItem().toString()),Integer.parseInt(root.getRight().getItem().toString()))!=Integer.parseInt(root.getRight().getItem().toString()))
				return false;
			else
				return true;
		}
		return(isBinary(root.getLeft()) && isBinary(root.getRight()));
	}
	
	
	public void showAllPaths(BinarySearchTreeNode root, int []path,int level){
		if(root==null)
			return;
 			path[level]=Integer.parseInt(root.getItem().toString());
		 	
		if((root.getLeft()==null) && (root.getRight()==null)){
			for(int i=0;i<=level;i++)
				System.out.print(path[i]+" ");
				System.out.println("");
 
				return;
		} 
		else{
		showAllPaths(root.getLeft(),path,(level+1));
		showAllPaths(root.getRight(),path,(level+1));
		}
 
	}

	public int sumAllNodeValues(BinarySearchTreeNode root){
		if(root==null)
			return 0;
		 else{
			System.out.println("root value is "+root.getItem().toString());
			int leftSum= sumAllNodeValues(root.getLeft());
			System.out.println("left sum is "+leftSum);
			int rightSum= sumAllNodeValues(root.getRight());
			System.out.println("right sum is "+rightSum);
			System.out.println("total sum is "+(((Integer)(root.getItem()))+leftSum+rightSum));
			return (((Integer)(root.getItem()))+leftSum+rightSum);
		}
 
	}
 
	
 	public void createNewBST(BinarySearchTreeNode root,BinarySearchTree bs ){
	 
		System.out.println("root value is "+root.getItem().toString());
		if(bs.getRoot()==null){
			bs.createRoot((sumAllNodeValues(root)-((Integer)root.getItem())));
			System.out.println("new root value is "+bs.getRoot().getItem().toString());
		}
 		if((root.getLeft()==null) && (root.getRight()==null)){
			System.out.println("leaf node "+root.getItem().toString()+" reached");
			bs.insertNode(new Integer(0));
 		}else{
			System.out.println("CURRENT root value is "+root.getItem().toString());
			createNewBST(root.getLeft(),bs);
	 		createNewBST(root.getRight(),bs); 
			System.out.println("now value before insertion  is "+root.getItem().toString());
			bs.insertNode( sumAllNodeValues(root)-((Integer)root.getItem()));
		}
		
		
 }


   public void levlOrder(BinarySearchTreeNode root){
	if(root==null)	
		return;
	
	LinkedList<BinarySearchTreeNode> current = new LinkedList<BinarySearchTreeNode>();
	current.add(root);
	int level=0;
	while(current.size()!=0){
		LinkedList<BinarySearchTreeNode> parents = current;
		current= new LinkedList<BinarySearchTreeNode>();
		for(BinarySearchTreeNode parent:parents){
			if(level%2==0){
				level++;
			if(parent.getLeft()!=null){
				System.out.print(parent.getLeft().getItem().toString()+" ");
				current.add(parent.getLeft());
				}
			if(parent.getRight()!=null){
				System.out.print(parent.getRight().getItem().toString()+" ");
				current.add(parent.getRight());
				}
			}else{
				level++;
				if(parent.getRight()!=null){
					System.out.print(parent.getRight().getItem().toString()+" ");
					current.add(parent.getRight());
				}
				if(parent.getLeft()!=null){
						System.out.print(parent.getLeft().getItem().toString()+" ");
						current.add(parent.getLeft());
				}
			 }
		}
		System.out.println("");
		
		
	}
	
}
  
	
	public void getPaths(BinarySearchTreeNode node, int sum, int[]path, int level){
		if(node==null)
			return;
 		path[level]=Integer.parseInt(node.getItem().toString());
 		int t=0;
		for(int i=level;i>=0;i--){

			t+=path[i];
			if(t==sum){
				printPath(path,i,level);
				}
		}
		getPaths(node.getLeft(),sum,path,(level+1));
		getPaths(node.getRight(),sum,path,(level+1));
	}
	
	public void printPath(int[]path,int start,int stop){
 		for(int i=start;i<=stop;i++)
			System.out.print(path[i]+" ");
		System.out.println("");
	}
	
	
	public void inOrderTraversal(BinarySearchTreeNode root,ArrayList list){
		if(root==null) return;
 		if(root.getLeft()!=null){
			BinarySearchTreeNode node = root.getLeft();
			inOrderTraversal(node,list);
		}
 		list.add(root.getItem());
 		if(root.getRight()!=null){
			BinarySearchTreeNode node = root.getRight();
			inOrderTraversal(node,list);
		}
		 		

	}
}