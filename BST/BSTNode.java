public class BSTNode{
	
	BSTNode left;
	BSTNode right;
	BSTNode parent;
	int item;
	
	
	public BSTNode(BSTNode left,BSTNode right, BSTNode parent,int item){
		
		this.left=left;
		this.right=right;
		this.parent=parent;
		this.item=item;
	}
	
	
	public void setLeft(BSTNode left){
		this.left=left;
	}
	public BSTNode getLeft(){
		return left;
	}
	public void setRight(BSTNode right){
		this.right=right;
	}
	public BSTNode getRight(){
		return right;
	}
	public int getItem(){
		return item;
	}
	public void setParent(BSTNode parent){
		this.parent=parent;
	}
	public BSTNode getParent(){
		return parent;
	}
	public void setItem(int item){
		this.item=item;
	}
	
}