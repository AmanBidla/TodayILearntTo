class Node{

	Node left,right;
	int val;

	Node(Node left, Node right, int val){
		this.left=left;
		this.right=right;
		this.val=val;
	}

}
public class SerializeDeserializeTree{


	private static String HASH ="#";
	private static String serialize(Node root){

		if(root==null) return HASH;

		String curr = ""+root.val;
		String left = serialize(root.left);
		String right = serialize(root.right);

		return curr +" "+left+" "+right;
	}

	private static Node deserialize(String S){
		String [] array = S.split(" ");
		return deserialize(array);
	}

	private static int index=0;
	private static Node deserialize(String [] array){
		if(index>array.length) return null;
		if(array[index].equals(HASH)){
			index++;
			return null;
		}
		int val = Integer.parseInt(array[index]);
 		Node root = new Node(null,null,val);
		index++;
		root.left = deserialize(array);
		root.right = deserialize(array);
		return root;
	}

	public static void main(String[] args) {
		
		Node root = new Node(null,null,8);
		Node left = new Node(null,null,16);
		Node right = new Node(null,null,24);

		root.left = left;
		root.right = right;
		String S = serialize(root);
		System.out.println(S);
		Node dRoot = deserialize(S);
		print(dRoot);
		System.out.println();
	}

	private static void print(Node root){
		if(root.left!=null) print(root.left);
		System.out.print(root.val+" ");
		if(root.right!=null) print(root.right);		
	}


}