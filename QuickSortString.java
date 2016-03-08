import java.util.Arrays;

public class QuickSortString{

	private static void quickSort(Comparable []array){
		 sort(array,0,array.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        //assert isSorted(a, lo, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    
     private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void swap(Object[] a, int i, int  j){
        System.out.println("replacing "+a[i]+" and "+a[j]);
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
    	
    	Comparable [] array= {2,12,9,6,11};//{"2","12","9","6","11"}; ////
    	quickSort(array);
    	System.out.println(Arrays.toString(array));
    }
}