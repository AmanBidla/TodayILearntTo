import java.util.Arrays;

public class PermutationRecursive {


	private static void permute(String[] array, int i) {

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
		permute(array,0);

	}
}