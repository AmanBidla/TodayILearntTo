public class FindMinimumInArrayOfDuplicates{



	public static void main(String[] args) {
		

		//int array[]={3,3,1,3,3,3};
		int [] array ={1, 0, 1, 1, 1};
		System.out.println( findMin(array,0, array.length-1));
		System.out.println(findMin(array));
	}

	public static int findMin(int [] array, int left, int right){

		if(left>right) return -1;

		// 1 element
		if(left==right) return array[left];

		// 2 element
		if(left+1==right) return Math.min( array[left], array[right]);

		int mid = (left+right)/2;

		if(array[left]<array[mid]) return findMin(array,mid,right);

		if(array[left]>array[mid]) return findMin(array,left,mid);

		else

			return Math.min( findMin(array,mid,right),findMin(array,left,mid) );

	}

	// USE THIS METHOD -- MUCH SIMPLER TO STUDY AND IMPLEMENT
	// WORST CASE O(N)
	public static int findMin(int []A){

		if(A==null || A.length==0) return -1;
		int left =0; int right = A.length-1;
		while(left<right && A[left]>=A[right]){

			int mid = (left+right)/2;
			if(A[mid]>A[right]) left =  mid+1;
			else if(A[left]>A[mid]) right= mid;
			else left = left+1;
		}
		return A[left];
	}

}