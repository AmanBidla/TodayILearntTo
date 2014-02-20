public class MedianOf2SortedArray{
	
	public static int findMedian(int []a, int []b,int k){

		int M = a.length;
		int N = b.length;

		if(k>=M+N) return -1;
		if(k<0) return -1;

		int begin =Math.max(0,k-N);
		int end = Math.min(k,M);

		while(begin <end){

			int mid = (begin)+(end-begin)/2;
			System.out.println("begin "+begin+ " mid "+ mid+" end "+end);

			if(mid<M && (k-mid)>0 && a[mid]<b[k-mid-1]){
				begin = mid+1;
			}else if( mid>0 && (k-mid)<N && a[mid-1]>b[k-mid]){
				end = mid-1;
			}else{
				begin = mid;
				break;
			}
		}

		if(begin ==0) return b[k-1];
		else if(begin ==k) return a[k-1];
		else return Math.max(a[begin-1], b[k-begin-1]);
	}

	public static void main(String[] args) {
		
		int []a ={ 5, 7, 8, 9, 12};
		int []b  ={3, 10, 11, 14, 15};
		int k = (a.length+b.length)/2;
		int ans =findMedian(a,b,k);
		System.out.println("ans "+ans);
	}

}