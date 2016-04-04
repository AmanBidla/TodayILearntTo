import java.util.Arrays;

public class MergeSortedArrays {


	public static void main(String[] args) {
		
		int [] A ={1,8};
		int [] B ={2,5,7};
		System.out.println(Arrays.toString(merge(A,B)));
	}

	public static int[] merge(int[]A, int []B){

		if(A==null || A.length==0) return B;
		if(B==null || B.length==0) return A;

		int M = A.length;
		int N = B.length;

		int k = 0;
		int i = 0;
		int j = 0;

		int [] array = new int[M+N];

		while(i<M && j<N){

			if(A[i] < B[j]){
				array[k] = A[i];						 
				i++;
			}else if(A[i]>B[j]){
				array[k] = B[j];		 
				j++;
			}else{
				array[k]=A[i];		 
				i++; j++;
			}
			k++;
		}
		 

		if(i<M){
			array[k]=A[i];
			i++; k++;
		}

		if(j<N){
			array[k]=B[j];
			j++;k++;
		}
		return array;

 
	}
}