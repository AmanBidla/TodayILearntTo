import java.util.List;
import java.util.ArrayList;

public class LevelOrder{

	private class Node{

		private int value;
		Node left,right;
		public Node(int val){
			this.value =val;
		}
	}

	public Node createTree(){

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);

		root.left.left = new Node(1);
		root.left.right = new Node(6);

		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		return root;
	}

	public void level(Node root){

		if(root ==null)
			return;
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		System.out.println(root.value);

		while(list.size()>0){

			List<Node> parent = list;
			list = new ArrayList<Node>();
			for(Node node:parent){

				if(node.left!=null){
					System.out.print(node.left.value+" ");
					list.add(node.left);
				}
				if(node.right!=null){
					System.out.print(node.right.value+" ");
					list.add(node.right);
				}
			}
			System.out.println("");

		}
	}

	public static void main(String[] args) {
		LevelOrder l = new LevelOrder();
		Node root = l.createTree();
		l.level(root);
	}

}