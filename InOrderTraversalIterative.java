
import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 

public class InOrderTraversalIterative{


	    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(!stack.isEmpty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root=root.left;
                }else{
                    root = (TreeNode) stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
            return list;
        }

}