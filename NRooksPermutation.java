import java.util.Arrays;
public class NRooksPermutation {


	public static void NRooks(int N) {
		int [] array = new int[N];
		for(int i=0;i<N;i++){
			array[i]=i;
		}
		permute(array,0);
	}

	private static void permute(int[] array, int i) {

		if(i==array.length){
			System.out.println(Arrays.toString(array));
		}else{
			for(int j=i;j<array.length;j++){
				swap(array,i,j);
				permute(array,i+1);
				swap(array,i,j);
			}
		}
	}

	private static void swap(int[]array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
 	}

 	public static void main(String[] args) {
 		
 		NRooks(3);
 	}
}