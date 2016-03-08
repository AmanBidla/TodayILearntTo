 class Node{

 	Node left,right;
 	int leftSize=0;
 	int val;

 	public Node(int val){
 		this.val=val;
 	}

 	public void insert(int num){

 		if(num<=val){
 			if(left == null){
 				left = new Node(num);
 			}else{
 				left.insert(num);
 			}
 			leftSize++;
 		}else{

 			if(right == null){
 				right = new Node(num);
 			}else{
 				right.insert(num);
 			}
 		}
 	}

 	public int getRank(int num){

 		if(num == val){
 			return leftSize;
 		}else if(num <val){
 			if(left == null){
 				return -1;
 			}else{
 				return left.getRank(num);
 			}
 		}else{
 			if(right == null){
 				return -1;
 			}else{
 				return 1 + leftSize + right.getRank(num);
 			}
 		}
 	}

 }

 public class GetRankFromStreamOfNumbers{

 	Node root = null;

 	public void insert(int num){

 		if(root == null){
 			root = new Node(num);
 		}else{
 			root.insert(num);
 		}
 	}

 	public int getRank(int num){

 		if(root == null){
 			return -1;
 		}else{
 			return root.getRank(num);
 		}
 	}

 	public static void main(String[] args) {
 		
 		GetRankFromStreamOfNumbers g = new GetRankFromStreamOfNumbers();
 		g.insert(5);
 		g.insert(1);
 		g.insert(4);
 		g.insert(4);
 		g.insert(5);
 		g.insert(9);
 		g.insert(7);
 		g.insert(13);
 		g.insert(3);
 

 		System.out.println(g.getRank(1)); // should be 0
 		System.out.println(g.getRank(3)); // should be 1
 		System.out.println(g.getRank(4)); // should be 3


 	}

 }