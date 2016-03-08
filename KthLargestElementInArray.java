import java.util.Arrays;

public class KthLargestElementInArray{


	public static void main(String[] args) {
		
		int [] array ={17,16,15,14,3,2,1};
		System.out.println("sorted "+Arrays.toString( sort(array)));
		//System.out.println("smallest  of "+Arrays.toString(array)+ " is " + kth(array,3));
	}

	private static int kth(int [] array, int k){

		int lo =0, hi = array.length-1;
		return kthLargest(array,k);
	}

	  public static int kthLargest(int[] array, int k) {
        if (k < 0 || k >= array.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
         
        int lo = 0, hi = array.length - 1;
        while (hi > lo) {
            int i = partition(array, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return array[i];
        }
        return array[lo];
    }

    private static int[] sort(int [] array){

    	int lo=0, hi=array.length-1;
    	sort(array,lo,hi);
    	return array;
    }

    private static void sort(int [] array, int lo, int hi){

    	if(lo > hi) return;
    	int i = partition(array,lo,hi);
    	sort(array, lo, i-1);
    	sort(array, i+1, hi);
    }

	private static int partition(int []array, int lo, int hi){

		int v = array[lo];
		int i = lo;
		int j = hi+1;

		while(true){

			while(less(v,array[++i])){
				if(i==hi) break;
			}

			while(less(array[--j],v)){
				if(j==lo) break;
			}

			if(i>=j) break;

			swap(array,i,j);

		}

		swap(array,lo,j);
		return j;
	}   


	private static boolean less(int a, int b){

		return a<=b;
	}

	private static void swap(int[]array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}