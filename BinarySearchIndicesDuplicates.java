import java.util.Arrays;

public class BinarySearchIndicesDuplicates{

	public static void main(String[] args) {
		
		int [] array={1,2,2,2,2,2,3,4,4,4,4,4,5};
		int target =2;
		System.out.println(Arrays.toString(search(array,target)));
	}

	public static int[] search(int[] array, int target){

		int[] result ={-1,-1};
		
		if(array==null || array.length<1) return result;
		int N = array.length;
		int left = 0;
		int right= N-1;

		while(left<=right){

			int mid = left+(right-left)/2;
			int value = array[mid];
			if(value==target){
				result[0]=mid;
				right=mid-1;
			}else if(value<target){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}

		if(result[0]==-1) return result;
		left=0;
		right= N-1;
		while(left<=right){

			int mid = left+(right-left)/2;
			int value = array[mid];

			if(value==target){
				result[1]=mid;				 
				left=mid+1;
			}else if(value<target){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}

		return result;

	}
}