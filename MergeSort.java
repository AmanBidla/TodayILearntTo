public class MergeSort{

	private int nInversions=0;;

	/** call helper function here */
	public void sort(Comparable[]a){
		int lo=0,hi=a.length-1;
		Comparable [] aux = new Comparable[a.length];
		nInversions = sort(a,aux,lo,hi);
 	}

	/** recursively divide []a to a/2 size and merge  */
	private int sort(Comparable []a, Comparable[]aux, int lo, int hi){
		if(hi<=lo) return 0;
		int mid = lo+(hi-lo)/2;
		int lin = sort(a,aux,lo,mid);
		int rin= sort(a,aux,mid+1,hi);
		int in = merge(a,aux,lo,mid,hi);
		return in+rin+lin;
	}

	/** merge from array [lo .. mid,mid+1.. hi] */
	private int merge(Comparable []a, Comparable[]aux, int lo, int mid, int hi){
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		int i=lo, j=mid+1,cin=0;
		for(int k=lo;k<=hi;k++){
			if(i>mid)
				a[k]=aux[j++];
	 		else if(j>hi)
				a[k]=aux[i++];							
			else if(less(aux[j],aux[i]))
				a[k]=aux[j++];
			else {
				cin=j-i;
				a[k]=aux[i++];
			}
		}
		return cin;

	}

	

	private Comparable [] mergeAndCountInversions(Comparable []a){
			
		if(a.length==1) return a;
		int lo=0,hi=a.length;
		int mid = lo+(hi-lo)/2,in=0;
		Comparable [] left = new Comparable[mid];
		Comparable [] right = new Comparable[hi-mid];
		int i=0;
		for(i=0;i<mid;i++){
			left[i]=a[i];
		}
		for(int j=0;i<hi;i++,j++){
			right[j]=a[i];
		}
		left = mergeAndCountInversions(left);
		right = mergeAndCountInversions(right);
		Comparable [] result = mergeAndCountInversions(left,right);
		return result;

	}

	private Comparable [] mergeAndCountInversions(Comparable []a, Comparable[]b){
		int N = a.length;
		int M = b.length;

 		Comparable []result = new Comparable[N+M];
		int i=0,j=0,k=0;
		while(i<N&&j<M){
			if(less(a[i],b[j])){
				result[k]=a[i];
				i++;k++;
			}else if(!less(a[i],b[j])){
				result[k]=b[j];
				k++;j++;
				System.out.println("here");
			}else {
				result[k]=a[i];
				k++;
				result[k]=b[j];
				k++;i++;j++;
			}
		}

		if(i==N&&j<M){
			while(j<M){
				result[k]=b[j];
				j++;
				k++;	
			}
			
		}else if(j==M&&i<N){
			while(i<N){
				result[k]=a[i];
				i++;
				k++;
			}
		}

		return result;

	}


	public int getInversions(){
		return nInversions;
	}

	/** compare v and w */
	private boolean less(Comparable v,Comparable w){
		boolean result = v.compareTo(w) < 0;
        return (v.compareTo(w) < 0);
	}

	private boolean greater(Comparable v,Comparable w){
			boolean result = v.compareTo(w) > 0;			
	        return (v.compareTo(w) < 0);
		}
	public static void main(String[] args) {
		
		Comparable [] a= {1,5,17,13,2};
		MergeSort m = new MergeSort();
		m.topDown(a);
		//m.bottomUp(a);

 	}

 	private void bottomUp(Comparable []a){
 		Comparable [] result= mergeAndCountInversions(a);
 		show(a);
 		show(result);
 	}

 	private void topDown(Comparable[]a){
 		show(a);
		sort(a);
		show(a);
		System.out.println("number of inversions "+getInversions());
 	}

 	/** print array */
	private void show(Comparable []a){

		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");

	}


}