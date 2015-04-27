public class RotatedArrayPivot{


	private static int pivot(int [] array){
		int N = array.length;
		int L=0;
		int R= N-1;
		while(array[L]>array[R]){
			int M = L+(R-L)/2;
			if(array[M]>array[R]){
				L=M+1;
			}else{
				R=M;
			}
		}
		return L;
	}

	public static void main(String[] args) {
		
		//int [] array={4, 5, 6, 1, 2, 3}; // should output 3
		int [] array={1, 2, 3, 4, 5};// should output 0
		System.out.println( pivot(array));
	}

}