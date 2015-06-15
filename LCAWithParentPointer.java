class Node{

	int val;
	Node parent,left,right;

	public Node(int val,Node left, Node right, Node parent){
		this.val=val;
		this.left=left;
		this.right=right;
		this.parent = parent;
	}

	public boolean equals(Object o){
		if(o==null) return false;
		if(!(o instanceof Node)) return false;
		Node other = (Node) o;
		if(this.val!=other.val) return false;
		if(other.left!=null)
			if(!(this.left.equals(other.left))) return false;
		if(other.right!=null)
			if(this.right.val!=other.right.val) return false;		
		return true;
	}

	public StringBuilder toString(StringBuilder prefix, StringBuilder sb) {
	    if(right!=null) {
	        right.toString(new StringBuilder().append(prefix).append((isLeaf(right)) ? "│   " : "    "), sb);
	    }
	    sb.append(prefix).append(isLeaf(this) ? "└── " : "┌── ").append(String.valueOf(val)).append("\n");
	    if(left!=null) {
	        left.toString(new StringBuilder().append(prefix).append(isLeaf(left) ? "    " : "│   "), sb);
	    }
	    return sb;
	}

	public boolean isLeaf(Node root){
		return root.left==null && root.right==null;
	}

}
public class LCAWithParentPointer{

	private static int height(Node root){
		int height=0;
		while(root!=null){
			height++;
			root=root.parent;
		}

		return height;
	}

	private static Node LCA(Node p, Node q){

		if(p==null || q==null) return null;
		int h1 = height(p);
		int h2 = height(q);
		if(h1>h2){
			int temp = h1;
			h1=h2;
			h2=temp;

			Node t = p;
			p=q;
			q=t;
			
		}
		int dh=h2-h1;
		for(int h=0;h<dh;h++) q = q.parent;
		while(p!=null && q!=null){
			//System.out.println("q is "+q.val+" and p is "+p.val);
			if(p.equals(q)) return p;
			p=p.parent;
			q=q.parent;
		}
		return null;
	}

    public static void main(String[] args) {
    	

    	Node root = new Node(1,null,null,null);
    	Node left = new Node(3,null,null,root);
    	Node right = new Node(4,null,null,root);
    	root.left = left;
    	root.right = right;

    	Node leftLeft = new Node(6,null,null,left);
    	Node leftRight = new Node(8,null,null,left);
    	root.left.left = leftLeft;
    	root.left.right = leftRight;

    	Node rightLeft = new Node(10,null,null,right);
    	Node rightRight = new Node(12,null,null,right);
    	root.right.left = rightLeft;
    	root.right.right = rightRight;

    	Node leftleftleft = new Node(14,null,null,leftLeft);
    	Node leftleftright = new Node(16,null,null,leftLeft);

    	Node leftRightLeft = new Node(18,null,null,leftRight);
    	Node leftRightRight = new Node(20,null,null,leftRight);

    	Node rightLeftLeft = new Node(22,null,null,rightLeft);
    	Node rightLeftRight = new Node(24,null,null,rightLeft);

    	Node rightRightLeft = new Node(26,null,null,rightRight);
    	Node rightRightRight = new Node(28,null,null,rightRight);

    	printTree(root);

    	Node lca = LCA(left,right);
    	if(lca!=null)
    		System.out.println("LCA of "+left.val+" and "+right.val+" is "+lca.val);
    	else System.out.println("No LCA for "+left.val+" and "+right.val);

    	lca = LCA(rightRight,left);
    	if(lca!=null)
    		System.out.println("LCA of "+rightRight.val+" and "+left.val+" is "+lca.val);
    	else System.out.println("No LCA for "+rightRight.val+" and "+left.val);

    	lca = LCA(leftRight,leftLeft);
    	if(lca!=null)
    		System.out.println("LCA of "+leftRight.val+" and "+leftLeft.val+" is "+lca.val);
    	else System.out.println("No LCA for "+leftRight.val+" and "+leftLeft.val);


    	lca = LCA(rightLeft,leftRight);
    	if(lca!=null)
    		System.out.println("LCA of "+rightLeft.val+" and "+leftRight.val+" is "+lca.val);
    	else System.out.println("No LCA for "+rightLeft.val+" and "+leftRight.val);

    	lca = LCA(root,rightRight);
    	if(lca!=null)
    		System.out.println("LCA of "+root.val+" and "+rightRight.val+" is "+lca.val);
    	else System.out.println("No LCA for "+root.val+" and "+rightRight.val);

    	Node nodeNotInTree = new Node(100,null,null,null);
    	lca = LCA(left,nodeNotInTree);
    	if(lca!=null)
    		System.out.println("LCA of "+left.val+" and "+nodeNotInTree.val+" is "+lca.val);
    	else System.out.println("No LCA for "+left.val+" and "+nodeNotInTree.val);

		lca = LCA(null,null);
    	if(lca==null)
    	 	System.out.println("No LCA for null values");



    }

    private static void printTree(Node root){

    	StringBuilder prefix = new StringBuilder();
    	StringBuilder sb = new StringBuilder();
    	StringBuilder result = root.toString(prefix,sb);
    	System.out.println(result.toString());
    }

}