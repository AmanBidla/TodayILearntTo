public class SlidingWindow{


	private static void slide(int slide,int[] array){

		int min = array[0];
		int N = array.length;
		int j=0;
		System.out.println("min "+min);
		for(int i=0;i<N;i++,j++){
 			if(j==slide){
				System.out.println(min);
				j=0;
				min = Integer.MAX_VALUE;
				i-=slide-1;
 			}
 			if(min>array[i]){
 				min= array[i];
			}
		}

	}

	public static void main(String[] args) {
		int [] array ={2,1,3,4,6,3,8,9,10,12,56};
		slide(4,array);
	}
}