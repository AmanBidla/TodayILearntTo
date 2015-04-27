wpublic class MinimumOfRotatedArrayWithoutDuplicates{

	public static void main(String[] args) {
		
		int [] array={4,5,6,7,8,1,2,3};
		System.out.println( findMin(array));
	}

	public static int findMin(int[] array){

		int N = array.length;
		int left = 0;
		int right = N-1;

		while(left<right){

			if(array[left]<=array[right]) return array[left];

			int mid = (left+right)/2;
			int prev = (mid-1+N)%N;
			int next = (mid+1)%N;

			if(array[prev]> array[mid] && array[mid]<array[next]) return array[mid];

			if( array[left] <=array[mid]){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}

		return -1;
	}

}