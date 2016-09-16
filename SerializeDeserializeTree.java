import java.util.StringTokenizer;

class Node{

	Node left,right;
	int val;

	Node(int val) {				
		this.val=val;
	}

}
public class SerializeDeserializeTree{
 

 	public static String serialize(Node root){

 		if(root==null){
 			return null;
 		}

 		StringBuilder buf = new StringBuilder();
 		serialize(root,buf);
 		return buf.toString();

 	}

 	private static void serialize(Node root, StringBuilder buf) {

 		if(root==null){
 			buf.append("#,"); 			 
 			return;
 		}

 		buf.append(root.val);
 		buf.append(",");
 		serialize(root.left,buf);
		serialize(root.right,buf);
 	}

 	public static Node deserialize(String S) {

 		if(S==null) {
 			return null;
 		}

 		StringTokenizer tokenizer = new StringTokenizer(S,",");
 		return deserialize(tokenizer);
 	}

 	private static Node deserialize(StringTokenizer tokenizer) {

 		String val = tokenizer.nextToken();
 		if(val.equals("#")){
 			return null;
 		}

 		Node node = new Node(Integer.parseInt(val));
 		node.left = deserialize(tokenizer);
 		node.right = deserialize(tokenizer);
 		return node;
 	}

 	public static void main(String[] args) {
 		
 		Node root = new Node(8);
 		root.left = new Node(16);
 		root.right = new Node(24);
		 
 
		String S = serialize(root);
		System.out.println(S);
		Node dRoot = deserialize(S);
		print(dRoot);
		System.out.println();

 	}

 	private static void print(Node root){
		
		System.out.print(root.val+" ");
		 
		if(root.left!=null) print(root.left);
		if(root.right!=null) print(root.right);		
	}

}