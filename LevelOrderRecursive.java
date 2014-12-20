import java.util.ArrayList;
import java.util.List;
public class LevelOrderRecursive{


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

	public void recurseBegin(Node root){

		if(root==null)
			return;
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		recurse(list);
	}

	public void recurse(List<Node> list){

		if(list.size()==0)
			return;
		List<Node> newList = new ArrayList<Node>();
		for(Node node:list){
			System.out.print(node.value+" ");
			if(node.left!=null)
				newList.add(node.left);
			if(node.right!=null)
			newList.add(node.right);
		}
		System.out.println();
		recurse(newList);
	}

	public static void main(String[] args) {
		LevelOrderRecursive l = new LevelOrderRecursive();
		Node root =l.createTree();
		l.recurseBegin(root);

	}
}