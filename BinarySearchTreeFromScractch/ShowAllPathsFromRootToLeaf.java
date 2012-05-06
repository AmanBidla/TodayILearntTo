public class ShowAllPathsFromRootToLeaf{


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
}