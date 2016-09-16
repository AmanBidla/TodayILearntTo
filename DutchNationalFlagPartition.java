import java.util.Arrays;

public class DutchNationalFlagPartition {


	public static void arrange(int [] array, int val) {

		int less=0, equal =0, large = array.length-1;

		while(equal<large) {

			if(array[equal] < val) {
				array = swap(array, less++, equal++);				 
			} else if (array[equal] == val) {
				equal++;
			} else {
				array = swap(array, equal, --large);				 
			}
		}
	}

	private static int[] swap(int []array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}

	public static void main(String[] args) {
		
		int [] array = {1,4,6,2,9,4,-5,3,6,12,-1,5};
		int val = 4;

		arrange(array, val);
		System.out.println(Arrays.toString(array));
	}
}