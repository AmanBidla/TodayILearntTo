import java.util.Collections;
import java.util.Arrays;

public class ArrangeElementsOfArray {


	public static void arrange(int[] array){

		if(array==null || array.length==0){
			return;
		}

		int N = array.length;
		for(int i=1;i<N;i++) {
			if ( (i%2==0 && array[i-1]<array[i]) || (i%2!=0  && array[i] < array[i-1])) {
				int temp = array[i-1];
				array[i-1] = array[i];
				array[i]= temp;
			}
		}

		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		
		int [] array = {1,-1,4,5,8};
		arrange(array);
	}
}