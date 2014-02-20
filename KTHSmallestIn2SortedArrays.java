public class KTHSmallestIn2SortedArrays{

	public static void main(String[] args) {
		
		int []a ={1,3,5};
		int []b ={2,4,6};
		int k =5;

		System.out.println("the "+k+"th smallest number in union of A & B array is "+findKth(a,b,k));

	}

	public static int findKth(int []a, int []b,int k){
		return findKth(a,b,a.length-1,b.length-1,k);
		//return find(a,b,0,a.length,0,b.length,k);
	}

	protected static int kthSmallest(int[] A, int aLow, int aLength, int[] B, int bLow, int bLength, int k){
	
	assert(aLow >= 0); assert(bLow >= 0);
	assert(aLength >= 0); assert (bLength >= 0); assert(aLength + bLength >= k);
	
	int i = (int)((double)((k-1)*aLength/(aLength+bLength)));
	int j = k - 1 - i;
	
	int Ai_1 = aLow + i == 0 ? 		MIN : A[aLow + i - 1];
	int Ai   = aLow + i == A.length ? 	MAX : A[aLow + i];
	
	int Bj_1 = bLow + j == 0 ? 		MIN : B[bLow + j - 1];
	int Bj   = bLow + j == B.length ? 	MAX : B[bLow + j];
	
	if (Bj_1 < Ai && Ai < Bj)
		return Ai;
	else if (Ai_1 < Bj && Bj < Ai)
		return Bj;
	
	assert(Ai < Bj-1 || Bj < Ai_1);
	
	if (Ai < Bj_1) // exclude A[aLow .. i] and A[j..bHigh], k was replaced by k - i - 1
		return kthSmallest(A, aLow + i + 1, aLength - i - 1, B, bLow, j, k - i - 1);
	else // exclude A[i, aHigh] and B[bLow .. j], k was replaced by k - j - 1
		return kthSmallest(A, aLow, i, B, bLow + j + 1, bLength - j - 1, k - j - 1);
}
	public static int findKth(int [] a, int []b ,int m, int n,int k){

		int i =(int) ((double) (m/(m+n)) * (k-1));
		int j = (k-1)-i;

		System.out.println("################");
		System.out.println("i : "+i+" j : "+j);
		System.out.println("################");


		int A_I_MINUS_1 = (i==0)?Integer.MIN_VALUE:a[i-1];
		int B_J_MINUS_1 = (j==0)?Integer.MIN_VALUE:b[j-1];

		int A_I = (i==m)?Integer.MAX_VALUE:a[i];
		int B_J = (j==n)?Integer.MAX_VALUE:b[j];

		if((A_I<B_J)&& (A_I>B_J_MINUS_1)) return A_I;
		else if ((B_J<A_I) && (B_J>A_I_MINUS_1)) return B_J;

		if(A_I<B_J)
			return findKth(a,b,m-i-1,j,k-i-1);
		else 
			return findKth(a,b,i,n-j-1,k-j-1);
		 
	}
	


}