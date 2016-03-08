import java.util.Arrays;

public class CountInversions {

	public static void main(String[] args) {

		 int array[] = {1, 20, 6, 4, 5};
		 System.out.println("inversion count is "+countInversions(array));
		 System.out.println(" After sort "+Arrays.toString(array));
	}

	public static int countInversions(int[] array){

		int [] temp = new int[array.length];
		return countInversions(array,temp,0,array.length-1);
	}

	public static int countInversions(int[]array,int[]temp, int left,int right){
		int inversions =0;
		if(left<right){


			int mid =(left+right)/2;
			inversions  = countInversions(array,temp,left,mid);
			inversions += countInversions(array,temp,mid+1,right);
			inversions += merge(array,temp,left,mid+1,right);

		}

		return inversions;
	}

	public static int merge(int [] array, int []temp, int leftPos, int rightPos, int rightEnd){

		int leftEnd = rightPos-1;
		int k = leftPos;
		int N = rightEnd-leftPos+1;
		int inversions=0;

		while(leftPos<=leftEnd && rightPos<=rightEnd){

			if(array[leftPos]<=array[rightPos]){
				temp[k++] = array[leftPos++];
			}else{
				temp[k++] = array[rightPos++];
				inversions += leftEnd-leftPos+1;
			}
		}

		while( leftPos<=leftEnd){
			temp[k++]=array[leftPos++];
		}

		while(rightPos<=rightEnd){
			temp[k++]=array[rightPos++];
		}

		for(int i=0;i<N;i++,rightEnd--){
			array[rightEnd]=temp[rightEnd];
		}
		return  inversions;
	}
}