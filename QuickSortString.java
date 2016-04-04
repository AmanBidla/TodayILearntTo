import java.util.Arrays;

public class QuickSortString{

	private static void quickSort(String []array){
		 sort(array,0,array.length-1);
	}

	private static void sort(String[] a, int lo, int hi) { 
         if(lo>=hi) return;
	    int lt = lo, gt = hi;
	    int i = lo+1;
	    String v = a[lo];
	    while(i<=gt){
	        String s = a[i];
	        if(compare(s,v) > 0) swap(a, i++, lt++);
	        else if(compare(s, v) < 0) swap(a, i, gt--);
	        else i++;
	    }
	    sort(a, lo, lt-1);
	    sort(a, gt+1, hi);
        //assert isSorted(a, lo, hi);
    }
    
     
    private static int compare(String i, String j){
	    String str1 = i+j;
	    String str2 = j+i;
	    return str1.compareTo(str2);
	}
    
    private static void swap(String[] a, int i, int j){
	    String tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	}	

    public static void main(String[] args) {
    	
    	String [] array= {"2","12","9","6","11"};//{2,12,9,6,11};
    	quickSort(array);
    	System.out.println(Arrays.toString(array));
    }
}