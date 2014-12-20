import java.util.Arrays;

public class MergeTwoSortedArray{

	public void merge(int[] A1, int [] A2){

		int N1 = A1.length; // 2 power N
		int N2 = A2.length; // N

		int [] mergeArray = new int[N1+N2];

		int left=0; // index of A1
		int right=0; // index of A2
		int index=0; // index of merge Array

		while(left<N1 && right<N2){

			int a1 = A1[left];
			int a2 = A2[right];

			if(a1<=a2){
				mergeArray[index]=A1[left];
				left++;
			}else{
				mergeArray[index]=A2[right];
				right++;
			}
			index++;
		}

		// if there are still elements in A1 that is not added to merge array
		if(left<A1.length){
			while(left<A1.length){
				mergeArray[index]=A1[left];
				left++;
				index++;
			}
		}
		
		// if there are still elements in A2 that is not added to merge array
		if(right<A2.length){
			while(right<A2.length){
				mergeArray[index]=A2[right];
				right++;
				index++;
			}
		}

		System.out.println(Arrays.toString(mergeArray));

	}

	public static void main(String[] args) {
		
		int []A1 ={100,200,300,400,500,600,700,800};
		int []A2 ={101,301,801};
		MergeTwoSortedArray mg = new MergeTwoSortedArray();
		mg.merge(A1,A2);

	}

}