import java.util.Arrays;

public class QuickSort{


    public static void main(String[] args) {
    	
    		Integer [] a= {1,3,99,34,67,100,58};
    		
    		int k=4;
    		System.out.println(k+" highest is "+kthClosest(k,a));
    		sort(a);
    		show(a);
    }


    public static int kthClosest(int k,Integer []a){
    	if(k<0 || k>=a.length) throw new IndexOutOfBoundsException(" no such k ");
          int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }



    public static void show(Integer []a){
    	 System.out.println(Arrays.toString(a));
    }

	public static void sort(Comparable []a){

		sort(a,0,a.length-1);
	}

	public static void sort(Comparable []a, int lo, int hi){
		if(hi <=lo) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	public static int partition(Comparable []a, int lo, int hi){
		int i=lo;
		int j=hi+1;
		Comparable v = a[lo];

		while(true){

			while(less(a[++i],v)) if( i == hi) break;
			while(less(v,a[--j])) if(j == lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}

		exch(a,lo,j);
		return j;
	}

	public static boolean less(Comparable v, Comparable w){
		return (v.compareTo(w)<0);
	}

	public static void exch(Object []a, int v, int w){
		Object swap = a[v];
		a[v] = a[w];
		a[w] = swap;
	}

}