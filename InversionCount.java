import java.util.Arrays;

public class InversionCount{

	public static int mergeSort(int [] array, int [] aux, int left, int right){

		int inv=0;
		if(left<right){

			int mid = (left+right)/2;

			inv = mergeSort(array,aux,left,mid);
			inv = inv+ mergeSort(array,aux,mid+1,right);
			inv = inv +merge(array,aux,left,mid+1,right);

		}
		return  inv;
	}


	public static int merge(int [] array,int [] aux, int left, int mid, int right){

		int i=left;
		int j= mid;
		int k= left;

		int inv=0;

		while(i<=(mid-1) && j<=right){
			if(array[i]<=array[j]){
				aux[k++]=array[i++];
			}else{
				aux[k++]=array[j++];
				inv=inv + (mid-i);
			}
		}

		while(i<=(mid-1)){
			aux[k++]=array[i++];
		}

		while(j<=right){
			aux[k++]=array[j++];
		}

		for( i=left;i<=right;i++){
			array[i]=aux[i];
		}

		System.out.println(Arrays.toString(array)+ " inv "+inv );

		return inv;
	}

	public static int inversion (int [] array){

		int N = array.length;
		int [] aux = new int [N];

		return mergeSort(array, aux,0,N-1);

	}

	public static void main(String[] args) {
		
		int [] array={2, 1, 3, 1, 2};
		System.out.println(inversion(array));
		int [] array2 ={1, 1, 1, 2, 2};
		System.out.println(inversion(array2));
	}

}