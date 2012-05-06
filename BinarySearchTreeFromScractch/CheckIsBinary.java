/* only use the function isBinary */
Class CheckIsBinary {

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

}