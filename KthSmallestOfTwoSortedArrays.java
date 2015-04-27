public class KthSmallestOfTwoSortedArrays{


	public static int kthsmallest(int []A, int []B, int K){

		int begin = Math.max(0,K-B.length);
		int end   = Math.min(A.length,K);

		while(begin < end){

			int mid = begin +(end-begin)/2;

			if(mid<A.length && 
				K-mid>0 &&
				A[mid]<B[K-mid-1]){
				begin = mid+1;
			}else if( mid > 0 &&
					 K-mid <B.length &&
					 A[mid-1]>B[K-mid]){
				end = mid;
			}else{
				begin=mid;
				break;
			}

		}

		if(begin ==0){
			return B[K-1];
		}else if(begin == K){
			return A[K-1];
		}else{
			return Math.max(A[begin -1],B[K-begin-1]);
		}
	}

 	 



	public static void main(String[] args) {
		
		int b[] = {0, 3, 7, 9};
		int a[] = {1, 2, 4,6,8};
		//int [] a ={100};
		//int [] b={1,2,3,4};
		
		for(int i=1;i<=(a.length+b.length);i++){
			//System.out.println(i+" th smallest element is "+kthlargest(a,b,i));
			System.out.println(i+" th largest element is "+kthlargest(a,b,i));
		}

	}

}