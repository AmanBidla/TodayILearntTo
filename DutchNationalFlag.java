public class DutchNationalFlag {

	private static int RED_BALL = 0;
	private static int WHITE_BALL = 1;
	private static int BLUE_BALL = 2;

	private static void dutch(int []array){

		int j=0,i=0,k=array.length-1;
		while(j<=k){

			if(array[j]==RED_BALL){
				swap(array,j,i);
				i++;j++;
			}else if(array[j]==WHITE_BALL){
				j++;
			}else if(array[j]==BLUE_BALL){
				swap(array,j,k);
				k--;
			}
		}
	}

	private static void swap(int[] array,int i, int j){
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
	}
 
}