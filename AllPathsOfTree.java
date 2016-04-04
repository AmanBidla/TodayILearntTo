import java.io.*;
import java.util.List;
import java.util.ArrayList;
    
class Node{
    int val;
    Node left, right;
    public Node(int val){
        this.val=val;
    }
}
public class AllPathsOfTree {
    
    

    public static Node buildTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right  = new Node(3);
        
        root.left.left = new  Node(4);
        root.left.right = new  Node(5);            
        
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Node root = buildTree();
    List<Node> result = new ArrayList<Node>();
    printAllPaths(root,result);
}
    
    public static void printAllPaths(Node root, List<Node> result){
        
        if(root!=null){
            
            result.add(root);
            
            if(root.left!=null){
                printAllPaths(root.left,result);
            }
            if(root.right!=null){
                printAllPaths(root.right,result);
            }
            
            if(root.right==null && root.left ==null){
                for(int i=0;i<result.size();i++){
                    System.out.print(result.get(i).val+" ");
                }
                System.out.println();
            }            
            result.remove(result.size()-1);            
        }
    }
    
    
}