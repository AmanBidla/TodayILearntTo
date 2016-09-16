import java.util.Arrays;

public class PermutationRecursive {


	private static void permuationWithoutDuplicats(String[] array, int i) {

		if(i==array.length){
			System.out.println(Arrays.toString(array));
		}else{			 
			for(int j=i;j<array.length;++j) {				
				swap(array,i,j);
				permute(array,i+1);
				swap(array,i,j);
			}
		}
	}

	private static void swap(String []array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		
		String[] array ={"a","b","c"};
		//permuationWithoutDuplicats(array,0);
		int [] num = {3,3,1,2,3,2,3,1};
		permuationWithDuplicats(num,0);

	}

	public static void permuationWithDuplicats(int [] array, int i) {
		if(i==array.length) {
			System.out.println(Arrays.toString(array));
		} else {
			for(int j=i;j<array.length;j++){
				if(j>i && array[j] == array[j-1]) continue;
				swap(array, i, j);
				permuationWithDuplicats(array, i+1);
				swap(array,i, j);
			}
		}
	}

	public static void swap(int []array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}