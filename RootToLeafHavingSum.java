import java.util.LinkedList;

public class RootToLeafHavingSum {

	class TreeNode{
		Treenode left,right;
		int val;
		Treenode(int val){
			this.val = val;
		}
	}

	public boolean hasPath(TreeNode root,int sum){
		 if(root ==null){
		 	return false;
		 }
		 LinkedList<TreeNode> nodeList =  new LinkedList<TreeNode>();
		 LinkedList<Integer> valueList =  new LinkedList<Integer>();
		 nodeList.add(root);
		 valueList.add(root.val);
		 while(nodeList.isEmpty()){
		 	TreeNode node = (TreeNode) nodeList.pop();
		 	int nodeValue = (Integer) valueList.pop();
		 	if( node.left==null && node.right==null && nodeValue==sum ){
		 		return true;
		 	}
		 	if(node.left!=null){
		 		nodeList.add(node.left);
		 		nodeValue.add(nodeValue+node.left.val);
		 	}
		 	if(node.right!=null){
		 		nodeList.add(node.right);
		 		nodeValue.add(nodeValue+node.right.val);
		 	}
		 }
		 return false;
	}
}