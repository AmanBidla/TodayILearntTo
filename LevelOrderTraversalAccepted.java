import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LevelOrderTraversalAccepted{

	public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> list  = new ArrayList<>();
     Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
     ArrayList<Integer> level;
     if(root!=null){
         level = new ArrayList<Integer>();
         level.add(root.val);
         list.add(level);
         q.add(root);
         level = new ArrayList<Integer>();
         int currentLevel=1;
         int nextLevel =0;
         int visited =0;
         while(!q.isEmpty()){
             visited++;
             TreeNode node = q.remove();
             if(node.left!=null){
                level.add(node.left.val); 
                q.add(node.left);
                nextLevel++;
            }
            if(node.right!=null){
                level.add(node.right.val);
                q.add(node.right);
                nextLevel++;
            }
            if( visited == currentLevel ){
                visited=0;
                currentLevel = nextLevel;
                nextLevel=0;
                if(level.size()>0){
                    list.add(level);    
                    level = new ArrayList<>();    
                }
            }
            
        }
    }
    return list;
    }

}