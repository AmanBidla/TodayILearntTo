import java.util.Arrays;
import java.util.Collections;

public class NumberOfTrianglesInArray{

	public static int count(Integer [] array){

		if(array==null || array.length==0) return 0;
		Arrays.sort(array, Collections.reverseOrder());
		//System.out.println(Arrays.toString(array));
		int N = array.length;
		int count=0;
		for(int i=0;i<(N-2);i++){
			int k=i+2;
			for(int j=i+1;j<N;j++){
				// instead of checking a+b>c 
				// check for a>c-b
				// this avoid over flow issues when Integer MAX value is given
				// what if c is Integer MIN ?
				// b > c so c-b > Integer MIN always				
				while( k<N && ((array[i] > array[k] - array[j]) )){
					System.out.println(array[i]+","+array[j]+","+array[k]);
					k++;
				}
				count+= Math.max(0,k-j-1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		int arr[] =   {10, 21, 22, 100, 101, 200, 300};
		Integer[] r = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
		System.out.println(Arrays.toString(r));
		System.out.println(count(r));

	}
}