public class MinimumOfRotatedArrayWithDuplicates {

	public static void main(String[] args) {
	
		int [] array ={3,3,1,3,3,3};
		System.out.println(findMin(array,0,array.length-1));
	}

	public static int findMin(int[] array, int left, int right){
	
		if(left>right) return -1;

		// 1 element
		if(left==right) return array[left];

		//2 element
		if(left+1==right) return Math.min( array[left], array[right]);		 

		int mid = (left+right)/2;

		if(array[left]<=array[mid]){
			return findMin( array, mid, right);
		}

		else if(array[left] > array[mid]){
			return findMin(array,left,mid);
		}

		else return Math.min( findMin(array,left,mid), findMin(array,mid,right));

	}
}