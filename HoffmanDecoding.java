class Node{
	Node left,right;
	int freq;
	char val;
	public Node(char val, int freq){
		this.val= val;
		this.freq= freq;
	}
}
public class HoffmanDecoding {


	public static void decode(String S, Node root){

		Node temp=root;
        int i=0;
        StringBuilder buf = new StringBuilder();
        while(i<S.length()){
            root = temp;
            Node node;
            while( (node= findVal(root,S.charAt(i))).val =='\0'){
                i++;
                root = node;
                if(i==S.length()){
                    break;
                } 
            }
            buf.append(node.val);
            i++;
        }
        System.out.println(buf.toString());		
	}

	private static Node findVal(Node root, char c){
        if(c=='0') {
            return root.left;
        } else {
            return root.right;
        }
    }

    public static void main(String[] args) {
    	
		    /*	{ϕ,5}
		      0 /     \ 1
		     {ϕ,2}   {A,3}
		    0/   \1
		{B,1}  {C,1}  */

		Node root = new Node('\0',5);
		root.right = new Node('A',3);
		root.left = new Node('\0',2);
		root.left.left = new Node('B',1);
		root.left.right = new Node('C',1);

		String S = "1001011";
		decode(S,root);


    }
}