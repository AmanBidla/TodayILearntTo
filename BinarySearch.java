public class BinarySearch{


	public static void main(String[] args) {
		
		int [] array= {1,2,3,4,5,6,7,8,9};
		int val=5;
		System.out.println( search(val,array));
	}


	public  static int search(int val , int [] array){

		int left=0;
		int right= array.length;

		while(left<=right){

			int  mid = left+(right-left)/2;
			if(array[mid]==val) return mid;

			if(array[mid]<val) left=mid+1;
			else right=mid-1;

		}

		return Integer.MAX_VALUE;

	}
}