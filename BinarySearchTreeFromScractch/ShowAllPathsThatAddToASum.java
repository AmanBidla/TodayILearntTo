public class ShowAllPathsThatAddToASum{

public void showAllPaths(){
	BinarySearchTreeNode root = getRoot();
	int depth=getDepth(root);
	int []path= new int[depth];
	showAllPaths(root,path,0);	
}

public int getDepth(BinarySearchTreeNode root){
	if(root==null)
		return 0;
	return 1+ Math.max(getDepth(root.getLeft()),getDepth(root.getRight()));
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
}