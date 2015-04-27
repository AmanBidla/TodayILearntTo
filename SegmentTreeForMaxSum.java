public class SegmentTreeForMaxSum{

	class SegNode{
		public SegNode left, right;
		public int L,R,sum;
		public SegNode(int L,int R, int sum){
			this.L=L;
			this.R=R;
			this.sum=sum;
			this.left=this.right=null;
		}
	}


	public SegNode init(int []array, int L, int R){

		if(L==R){
			SegNode node = new SegNode(L,R,array[L]);
			return node;
		}else{
			int mid= (L+R)/2;
			SegNode left = init(array,L,mid);
			SegNode right = init(array,mid+1,R);
			SegNode root = new SegNode(L,R,left.sum+right.sum);
			root.left =left;
			root.right=right;
			return root;
		}
	}

	public int query(SegNode node, int L, int R){

		if(isContained(L,R,node.L, node.R)){
			return node.sum;
		}else if(isDifferent(L,R,node.L,node.R)){
			return 0;
		}else{
			return query(node.left,L,R)+query(node.right,L,R);
		}
	}

	public boolean isContained(int QL,int QR,int L, int R){
		return QL<=L&&QR>=R;
	}

	public boolean isDifferent(int QL, int QR, int L, int R){
		return QL>R||QR<L;
	}

	public boolean isInBetween(int index,int L, int R){
		return index>=L&& index<=R;
	}

	public void  update(int index, int diff, int []array, SegNode node){

		if(node!=null){

			if(isInBetween(index,node.L, node.R)){
				node.sum+=diff;
				update(index,diff,array, node.left);
				update(index,diff, array,node.right);				
			}

		}
	}

	public static void main(String[] args) {
		
		int[] array = {1, 3, 5, 7, 9, 11};
    SegmentTreeForMaxSum tree = new SegmentTreeForMaxSum();
    SegNode node = tree.init(array, 0, 5);
    System.out.println("Query between 0 and 5 = " + tree.query(node, 0, 5));
   	tree.update(4, 20-array[4],array,node);
    System.out.println("Query between 4 and 5 = " + tree.query(node, 4, 5));
    System.out.println("Query between 1 and 5 = " + tree.query(node, 1, 5));
    System.out.println("Query between 2 and 5 = " + tree.query(node, 2, 5));
	}
	 

}