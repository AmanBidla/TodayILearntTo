import java.util.Arrays;
public class MinimumOfArrayWithDuplicates{


	private static int min(int [] array){

		if(array==null || array.length==0) return -1;
		int left =0, right = array.length-1;
		while(left<right && array[left]>=array[right]){

			int mid = (left+right)/2;
			if(array[mid]>array[right]) left = mid+1;
	   		else if(array[mid]<array[left]) right = mid;
	   		else  left = left+1;
		}

		return left;
	}

	 public static void main(String[] args) {
	 	
	 	//int [] array ={1,1,1,1,2,2,0};
	 	//int [] array ={1, 1, 1, 0, 1};
	 	int [] array={3,4,5,6,7,1,2,3};
	 	System.out.println("Arrays is "+Arrays.toString(array));
	 	System.out.println("index of min "+min(array)+" and value is "+array[min(array)]);
	 }
}