import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
public class LevelOrderTraversalUsingQueue{


	class Node {

		Node left,right;
		char value;
		Node(char value){
			this.value=value;
		}
	}

	public Node createTree(){

		Node root = new Node('a');
		root.left = new Node('b');
		root.right = new Node('c');

		root.left.left = new Node('d');
		root.left.right = new Node('e');
		root.right.left = new Node('f');
		root.right.right = new Node('g');

		return root;
	}

	public void levelOrder(Node root){
		
		Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(root);

		  while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.value + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        }
	}

	public static void main(String[] args) {
		LevelOrderTraversalUsingQueue l = new LevelOrderTraversalUsingQueue();
		Node root =l.createTree();
		l.levelOrder(root);
	 

	}

	
}