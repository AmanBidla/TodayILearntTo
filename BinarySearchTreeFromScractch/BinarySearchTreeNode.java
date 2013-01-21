public class BinarySearchTreeNode {


	public BinarySearchTreeNode parent;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;	
	public Object item;
	
	
	public BinarySearchTreeNode(BinarySearchTreeNode parent, Object item, BinarySearchTreeNode left, BinarySearchTreeNode right){
		this.parent=parent;
		this.item=item;
		this.left=left;
		this.right=right;
	}


	public BinarySearchTreeNode getLeft(){
		return left;
	}
	
	public void setLeft(BinarySearchTreeNode left){
 		this.left=left;
	}	
	
	public BinarySearchTreeNode getRight(){
		return right;
	}
	
	public void setRight(BinarySearchTreeNode right){
 		this.right=right;
	}
	
	public BinarySearchTreeNode getParent(){
		return parent;
	}
	
	public void setParent(BinarySearchTreeNode parent){
 		this.parent=parent;
	}
	
	public Object getItem(){
		return item;
	}
	
	
	public void setItem(Object item){
		this.item=item;
	}
	
	
}