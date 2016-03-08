import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CountingInversions {

	private static int LENGTH=100000;
	private static long sortAndCount(int []A){

		if(A==null || A.length==0) return 0;

		int N = A.length;
		int [] aux = new int[N];
		return sortAndCount(A,aux,0,N-1);
	} 

	private static long sortAndCount(int []A,int []aux,int lo,int hi){
	
	  long inv=0;
	  int mid=0;
	  if(lo<hi) {
		  mid = lo + (hi-lo)/2;
		  inv = sortAndCount(A,aux,lo,mid);
		  inv += sortAndCount(A,aux,mid+1,hi);
		  inv += mergeAndCount(A,aux,lo,mid+1,hi);
	  }
 	  return inv;	
	}

	private static long mergeAndCount(int []A, int[]aux,int lo, int mid, int hi) {
		 
		long inv=0;
		int i=lo,j=mid,k=lo;

		while(i<=mid-1 && j<=hi){

			if(A[i]<=A[j]) aux[k++] = A[i++];
			else{
				inv += mid-i;
				aux[k++] = A[j++];
			} 
		}

		while(i<=(mid-1)){
			aux[k++] = A[i++];
		}

		while(j<=hi){
			aux[k++] = A[j++];
		}

		for(i=lo;i<=hi;i++){
			A[i] = aux[i];
		}

		return inv;
		  
	}

	public static void main(String[] args) {


		//int [] A = {1,3,5,2,4,6};
		//int [] A = {1,3,8,5,7,2,4,6};
		//int [] A = {6, 9, 1, 14, 8, 12, 3, 2};		 
		//System.out.println("inversions "+sortAndCount(A));
		int []A = readFile(args[0]);
		System.out.println("inversions "+sortAndCount(A));
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