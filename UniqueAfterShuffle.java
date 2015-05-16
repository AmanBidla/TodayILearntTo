import java.util.Arrays;


public class UniqueAfterShuffle{

	public static void main(String[] args) {
		
		int [] array ={3, 3, 4, 5, 5, 6, 7, 7, 7};
		System.out.println( remove(array));

	}

	public static int remove(int [] array){
			int i = 0;
		
		if (array.length == 1 || array.length == 0) {
			return i;
		}
		
		for (int j = 1; j < array.length; j++) {
			if (array[i] == array[j]) {
				continue;
			} else {
				i++;
				array[i] = array[j];
			}
		}
		System.out.println(Arrays.toString(array));
		return i;
	}
  
}