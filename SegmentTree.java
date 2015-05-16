import java.util.Arrays;

public class SegmentTree{
 

 	public static  int getSize(int N){
 		int size=1;
 		for(;size<N;size<<=1);
 		return size<<1;
 	}

 	public static void buildTree(int [] segTree, int [] input, int left, int right, int pos){

 		if(left==right){
 			segTree[pos]=input[left];
 			return;
 		}

 		int mid = (left+right)/2;
 		int leftPos = (2*pos)+1;
 		int rightPos = (2*pos)+2;
 		buildTree(segTree,input, left, mid,leftPos);;
 		buildTree(segTree,input, mid+1, right,rightPos);

 		segTree[pos]= Math.min( segTree[leftPos], segTree[rightPos] );
 	}

 	public static int getLow(int start, int end,int [] array,int []segTree){
 		int N = array.length;
 		return getLow(0, N-1,start, end, 0,segTree);
 	}

 	public static int getLow(int low, int high, int querylow, int queryhigh, int root, int []segTree){

 		//if(querylow < low && queryhigh >= high) return segTree[root];
 		if(low > querylow  && high <= queryhigh)return segTree[root];

 		if(querylow> high || queryhigh < low) return Integer.MAX_VALUE;

 		int mid = (low+high)/2;
 		int leftPos = (2*root)+1;
 		int leftLow = getLow(low, mid, querylow,queryhigh, leftPos, segTree );
 		int rightPos = (2*root)+2;
 		int rightLow = getLow(mid+1, high, querylow, queryhigh, rightPos, segTree);

 		return Math.min( leftLow , rightLow);
 	}






 	public static void main(String[] args) {
 		
 		int [] array ={-1,2,4,0};
 		System.out.println(Arrays.toString(array));
 		int N = array.length;
 		int SN = getSize(N);
 		System.out.println("size of segment tree is "+SN);
 		int [] segTree = new int [ SN ];

 		buildTree(segTree,array,0,N-1,0);
 		System.out.println(Arrays.toString(segTree));
 		System.out.println( getLow(0,3,array,segTree));

 	}



}