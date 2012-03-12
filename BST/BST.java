public class BST{

BSTNode root;
int size=0;

public BST(){
	root=null;
	size=0;
}

public BSTNode createNode(BSTNode left,BSTNode right,BSTNode parent,int item){
	return new BSTNode(left,right,parent,item);
}

public BSTNode getRoot(){
	return root;
}


public void addItem(int item){
	
	if(root ==null){
		 root= createNode(null,null,null,item);
	}else{
		BSTNode current=getRoot();
		while(current!=null){
			if(item>current.getItem()){
				if(current.getRight()!=null){
					current=current.getRight();
				}else{
					current.setRight(createNode(null,null,current,item));
					break;
				}
			}else if(item<=current.getItem()){
				if(current.getLeft()!=null){
					current=current.getLeft();
				}else{
					current.setLeft(createNode(null,null,current,item));
					break;
				}
			}		
		}//end of while loop
	}
	size++;	
		
}

public BSTNode search(int item){
	
	BSTNode current = getRoot();
	while(current!=null){
		if(item>current.getItem())
		 	current=current.getRight();
		else if (item<current.getItem())
			current=current.getLeft();
			else
				return current;
	}
	return null;
}
 

 

 

	public  void delete(int item){
		BSTNode current=getRoot();
		String direction="";
		while(current!=null){			 
			if(item>current.getItem()){
				 current=current.getRight();
			}
			else if (item<=current.getItem()){
				if(item<current.getItem())
					current=current.getLeft();
				else{
 				 System.out.println("deleting "+item+" now ...");	
					
			 	if(current.getLeft()==null && current.getRight()==null)
				{
						current.getParent().setRight(null);
						break;
				}
		 		else if(current.getRight()!=null && current.getLeft()==null){
						current.getParent().setRight(current.getRight());
						break; 
						}
				else if(current.getLeft()!=null){
 						if(current.getLeft().getRight()!=null){
							BSTNode currentLeft_Right = current.getLeft();
							while(currentLeft_Right.getRight()!=null){
								currentLeft_Right=currentLeft_Right.getRight();
							}
							currentLeft_Right.getParent().setRight(currentLeft_Right);
							break;
						}else{
							current.getParent().setLeft(current.getLeft());
							break;
						}
				}
		}
   }
}
}
	 
 

public void getAllItems( BSTNode root){
 	if(root.getLeft()!=null) getAllItems(root.getLeft());
		System.out.println(root.getItem());
	if(root.getRight()!=null) getAllItems(root.getRight());
	 
}	
	
}



