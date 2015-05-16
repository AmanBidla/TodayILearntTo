import java.util.Arrays;

public class ReArrange{


	public static int[] change(int []A, int target){

		if(A==null || A.length==0) return A;
		int N = A.length;
		int left=0, right=N-1;

		while(left<right){

			while(A[left]<target){
				left++;
			}

			while(A[right]>target){
				right--;
			}

			exch(A,left,right);
			left++; right--;

		}

		return A;

	}

	public static void exch(int[] A, int left, int right){
		int swap = A[left];
		A[left]=A[right];
		A[right]=swap;
	}

	public static void main(String[] args) {
		
		int [] A ={1, 7, -5, 9, -12, 15};
		int target=0;
		System.out.println(Arrays.toString(change(A,target)));
	}

}