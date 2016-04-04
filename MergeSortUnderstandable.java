import java.util.Arrays;

public class MergeSortUnderstandable {

	public static void main(String[] args) {
		
		int [] array =  {1,5,17,13,2};
		sort(array);
		System.out.println(Arrays.toString(array));

	}

	public static void sort(int[] array){

		int [] temp = new int[array.length];
		mergeSort(array,temp,0,array.length-1);

	}

	public static void mergeSort(int [] array, int [] temp, int left, int right){

		if(left<right){

			int mid = (left+right)/2;
			//System.out.println("left "+left+" right "+right+" mid "+mid);
			mergeSort(array,temp,left,mid);
			mergeSort(array,temp,mid+1,right);
			merge(array,temp,left,mid+1,right);
		}
	}

	public static void merge(int [] array, int []temp, int leftPos, int rightPos,int rightEnd){

		int leftEnd = rightPos-1;
		int k = leftPos;
		int N = rightEnd-leftPos+1;
		while( leftPos<=leftEnd && rightPos<=rightEnd){
			if(array[leftPos]<array[rightPos]){
				temp[k++]=array[leftPos++];
			}else{
				temp[k++]=array[rightPos++];
			}
		}
		while(leftPos<=leftEnd){
			temp[k++]=array[leftPos++];
		}
		while(rightPos<=rightEnd){
			temp[k++]=array[rightPos++];
		}
		for(int i=0;i<N;i++,rightEnd--){
			array[rightEnd]=temp[rightEnd];
		}

	}
}