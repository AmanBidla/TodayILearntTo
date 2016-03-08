import java.util.Arrays;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InversionCount{

	private static int LENGTH=100000;

	public static long mergeSort(int [] array, int [] aux, int left, int right){

		long inv=0;
		if(left<right){

			int mid = left+(right-left)/2;

			inv = mergeSort(array,aux,left,mid);
			inv = inv+ mergeSort(array,aux,mid+1,right);
			inv = inv +merge(array,aux,left,mid+1,right);

		}
		System.out.println(" inv "+inv );
		return  inv;
	}


	public static long merge(int [] array,int [] aux, int left, int mid, int right){

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

		//System.out.println(Arrays.toString(array)+ " inv "+inv );

		return inv;
	}

	public static long inversion (int [] array){

		int N = array.length;
		int [] aux = new int [N];

		return mergeSort(array, aux,0,N-1);

	}

	public static void main(String[] args) {
		
		int [] array={2, 1, 3, 1, 2};
		System.out.println(inversion(array));
		int [] array2 ={1, 1, 1, 2, 2};
		System.out.println(inversion(array2));
		
		//System.out.println(inversion(readFile(args[0])));
	}

	private static int [] readFile(String fileName){
		int [] A = new int[LENGTH];
		try{
			BufferedReader buf = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			int i=0;
			while( (line=buf.readLine())!=null){
				A[i] = Integer.parseInt(line);
				i++;
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		for(int i=0;i<LENGTH;i++)
			System.out.println(A[i]);
		return A;
	}

}