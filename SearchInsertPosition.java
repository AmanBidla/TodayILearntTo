public class SearchInsertPosition{

	public static void main(String[] args) {
		
		int [] array={1,3,5,6};
		int target=5;
		System.out.println( search(array,target)); // output 2
		target=2;
		System.out.println( search(array,target)); // output 1
		target=7;
		System.out.println( search(array,target)); // output 4
		target=0;
		System.out.println( search(array,target)); // output 0
	}

	public static int search(int [] array, int target){

		if(array==null) return -1;
		int N = array.length;

		if(array[0]>target) return 0;
		if(array[N-1]<target) return N;

		int left=0;
		int right=N-1;

		while(left<=right){

			int mid = (left+right)/2;

			if(array[mid]==target) return mid;

			int prev= mid-1;
			int next = mid+1;

			if(prev>=0){

				if(array[prev]<target && target<array[mid]) return mid;
			}

			if(next<N){

				if(array[mid]<target && target<array[next]) return next;
			}

			if(array[mid]<target)
				left=mid+1;
			else
				right= mid-1;
			 
		}

		return -1;

	}

}