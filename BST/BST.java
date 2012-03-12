public class BST{

BSTNode root;
int size=0;

public BST(){
	root=null;
	size=0;
}

public BSTNode createNode(BSTNode left,BSTNode right,BSTNode parent,int item){
	size++;;
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
//		System.out.println(" root item is "+current.getItem());
		String direction="";
		while(current!=null){
			 
			if(item>current.getItem()){
				 current=current.getRight();
				direction="RIGHT";
			}
				
			else if (item<current.getItem()){
					current=current.getLeft();
					direction="LEFT";
				}
			else{
 				 System.out.println("deleting "+item);	

				if(current.getLeft()!=null){
						BSTNode deleteLeft = current.getLeft();
						while(deleteLeft!=null){
							if(deleteLeft.getRight()!=null) deleteLeft=deleteLeft.getRight();
							else{
								current=deleteLeft;
								deleteLeft.getParent().setRight(null);
								size--;
								break;
							}
						}
				}else{ 
 						remove(current,direction);
						size--;
					}
					break;
				}
		}

}
	 


public void remove(BSTNode current,String direction){
	
	if(current!=root){
		if(direction=="RIGHT") current.getParent().setRight(null);
		else current.getParent().setLeft(null);
	}else
		System.out.println("cannot remove root");
 
	
}

public void getAllItems( BSTNode root){
 	if(root.getLeft()!=null) getAllItems(root.getLeft());
		System.out.println(root.getItem());
	if(root.getRight()!=null) getAllItems(root.getRight());
	 
}	
	
}



