import java.util.Arrays;

public class SegmentTree{
 	
 	private static int []A ;

 	public static  int getSize(int N){
 		int size=1;
 		for(;size<N;size<<=1);
 		return size<<1;
 	}
 	
 	public static void main(String[] args) {
 		int [] array  = {31,41,59,26,53,58,97,93};
 		A = array;
 		int N = A.length;
 		int node=0, begin = 0, end = N-1;
 		int [] dp = new int[N+1];
 		initialize(node,begin,end,A,dp);
 		int i= begin, j=end;
 		
 		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[query(node,begin,end,dp,i,j)]);

 		i=0;j=3;
 		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[query(node,begin,end,dp,i,j)]);

 		i=1;j=2;
 		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[query(node,begin,end,dp,i,j)]);

 		i=4;j=N-1;
 		System.out.println("minimum of "+ Arrays.toString(Arrays.copyOfRange(array,i,j+1))+" is "+array[query(node,begin,end,dp,i,j)]);
 	}

 	public static void initialize(int node, int begin, int end, int []A, int[] dp){

 		int N = A.length;
 		if(begin==end) dp[node]=begin;
 		else{


 			initialize(2*node,begin,(begin+end)/2,A,dp);
 			initialize((2*node)+1,(begin+end)/2 +1 ,end,A,dp);

 			int l = dp[2*node];
 			int h = dp[(2*node)+1];
 			if(A[l] <= A[h]) dp[node] = l;
 			else 			 dp[node] = h;

 		}

 	}

 	public static int query(int node, int begin, int end, int [] dp, int i, int j){
 		int p1, p2;

 		// current interval does not intersect query interval
 		if(i>end || j<begin) return -1;

 		// current interval is in the query interval
 		if(begin >=i && end<=j) return dp[node];

 		// compute min position of left and right part of interval
 		p1 = query(2*node, begin, (begin+end)/2,dp,i,j);
 		p2 = query((2*node)+1, (begin+end)/2+1, end, dp, i,j);

 		// return overall minimum
 		if(p1==-1) return dp[node] = p2;
 		if(p2==-1) return dp[node] = p1;
 		if(A[p1]<=A[p2]) return dp[node]=p1;
 		else 			 return dp[node]=p2;

 	}



}