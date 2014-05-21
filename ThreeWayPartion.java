import java.util.Arrays;
public class ThreeWayPartion{
	
	private static int[] partition(int []array, int low, int hi){

		int N = array.length;
		int startIndex=0,endIndex=N-1,i=0;
		while(i<=endIndex){

			if(array[i]<low){
				swap(array,i,startIndex);
				startIndex++;
				i++;
			}else if(array[i]>hi){
				swap(array,i,endIndex);
				endIndex--;
			}else{
				i++;
			}
		}
		return array;
	}
	public static void main(String[] args) {
		int arr[]={1,14,5,20,4,2,54,20,87,98,3,1,32};
		System.out.println(Arrays.toString(arr));
		arr =partition(arr,20,20);
		System.out.println(Arrays.toString(arr));

	}

	private static void swap(int [] array,int i, int j){
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
	}

}