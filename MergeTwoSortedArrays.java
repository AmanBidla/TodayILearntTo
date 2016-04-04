import java.util.Arrays;

public class MergeTwoSortedArrays {


	public static void main(String[] args) {
		
		//int []A ={1,3,6,9,};
		int []B = {-90,-10,4,5,10,15};
		int [] A = new int [4+B.length];
		A[0]=1;
		A[1]=3;
		A[2]=6;
		A[3]=9;


		
		//int [] array = merge(A,B);
		//System.out.println(Arrays.toString(array));

		int []array2 = merge(A,4,B,B.length);
		System.out.println(Arrays.toString(array2));
	}

	public static int[] merge(int []A, int M, int []B, int N){

		int i=M-1;
		int j=N-1;
		int k=M+N-1;
		while(j>=0){

			if(i>=0 && A[i]>B[j]){
				 
				A[k]=A[i];
				i--; 
			}else{				 
				A[k]=B[j];
				j--; 
			}
			k--;
		} 

		return A;


	}

	 
}