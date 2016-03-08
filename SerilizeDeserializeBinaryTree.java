import java.util.StringTokenizer;
class Node{

	Node left, right;
	int val;
	public Node(int val){
		this.val=val;
	}

}
public class SerilizeDeserializeBinaryTree {

	private static String serialize(Node root){
		if(root==null) return null;
		StringBuilder buf = new StringBuilder();
		serialize(root,buf);
		return buf.toString();
	}

	private static void serialize(Node root, StringBuilder buf){

		if(root == null){
			buf.append("# ");
			return;
		}

		buf.append(root.val).append(" ");
		serialize(root.left,buf);
		serialize(root.right,buf);
	}

	private static Node deserialize(String S){

		if(S==null) return null;
		StringTokenizer st = new StringTokenizer(S, " ");
		return deserialize(st);
	}

	private static Node deserialize(StringTokenizer st){

		if(!st.hasMoreTokens()) return null;
		String val = st.nextToken();
		if(val.equals("#")) return null;
		Node root = new Node(Integer.parseInt(val));
		root.left = deserialize(st);
		root.right= deserialize(st);
		return root;
	}

	public static void main(String[] args) {
		
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(3);
		Node four = new Node(2);
		Node five = new Node(4);
		root.right.left= four;
		root.right.right = five;
		root.right.left.left = new Node(3);
		root.right.left.right = new Node(1);
		String S = serialize(root);
		System.out.println(S);
		Node result = deserialize(S);
		System.out.println(serialize(result));
	}

}