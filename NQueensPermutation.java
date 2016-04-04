import java.util.Arrays;
public class NQueensPermutation {

	public static void main(String[] args) {
		
		NQueens(8);
	}

	public static void NQueens(int N) {

		int [] array = new int[N];
		for(int i=0;i<N;i++){
			array[i]=i;
		}

		permute(array,0);
	}

	private static void permute(int []array, int i){		 
		if(i==array.length){
			System.out.println(" sol "+Arrays.toString(array));
		}else{
			for(int j=i;j<array.length;j++){
				swap(array,i,j);
				if(!canBackTrack(array, i)){					 
					permute(array,i+1);
				}
				swap(array,i,j);
			}
		}
	}

	private static boolean canBackTrack(int []array, int k){
		for(int i=0;i<k;i++){
			if((array[i]-array[k]) == (k-i)) {
				return true;
			}
			if((array[k]-array[i]) == (k-i)) {
				return true;
			}
		}
		return false;
	}

	private static void swap(int []array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}