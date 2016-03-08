public class MedianOfSortedArrayOfDifferentLength{


	 public double findMedianSortedArrays(int[] A, int[] B) {
        int M = A.length;
        int N = B.length;
        int sumLen = M+N;
        if(sumLen %2 != 0){
            return kthSmallest(A,0,M,B,0,N, (sumLen/2) + 1);
        } else {
            return (kthSmallest(A,0,M,B,0,N, (sumLen/2) ) + kthSmallest(A,0,M,B,0,N, (sumLen/2) + 1))/2.0;
        }
    }
    
    private double kthSmallest(int []A, int start1, int M, int []B, int start2, int N, int k){
        
        if(M>N){
            return kthSmallest(B,start2,N,A,start1,M,k);
        }
        
        if(M==0){
            return B[start2+k-1];
        }
        if(k==1){
            return Integer.min(A[start1],B[start2]);
        }
        
        int partA = Integer.min(k/2,M);
        int partB = k - partA;
        
        if(A[start1+partA-1] == B[start2+partB-1]){
            return A[start1+partA-1];
        } else if(A[start1+partA-1] > B[start2+partB-1]){
            return kthSmallest(A,start1,M,B,start2+partB,N-partB,k-partB);
        } else {
            return kthSmallest(A,start1+partA,M-partA,B,start2,N,k-partA);
        }
    }

 

	//////////////////////////////////////////////// 
    	
    	//below is deprecated code. above is simple accepted soluton.

    //////////////////////////////////////////////// 

	

	public static double median(int []A , int [] B){

		int M= A.length;
		int N= B.length;

		int mid = (M+N)/2;

		if(M<=N)
			return median(A,B,Math.max(0,mid-N),Math.min(M-1,mid));
		else
			return median(B,A,Math.max(0,mid-M),Math.min(N-1,mid));		
	}

  
/* private static double findMedian(int A[], int B[], int left, int right) {  
   int m = A.length, n = B.length, mid = (m+n)/2;  
   if (left > right) {  
     return findMedian(B, A, Math.max(0, mid-m), Math.min(n-1, mid));  
   }  
     
   int i = (left+right) / 2, j = mid - i - 1;  
   if (j >= 0 && A[i] < B[j]) // A[i] < median  
     return findMedian(A, B, i+1, right);  
   if (j < n-1 && A[i] > B[j+1]) // A[i] > median  
     return findMedian(A, B, left, i-1);  
   // found median (j<0 => mid-i-1 < 0 => i=mid; j>=n-1 => mid-i-1>=n-1 => i=mid-n) 
   // m+n is odd  
   if ( ((m+n) & 0x1) > 0 || (i <= 0 && (j < 0 || j >= n)))  
     return A[i];  
   // m+n is even  
   if (j < 0 || j >= n)  
     return (A[i] + A[i-1]) / 2.0;  
   if (i <= 0)  
     return (A[i] + B[j]) / 2.0;  
   return (A[i] + Math.max(B[j], A[i-1])) / 2.0;  
 } */

 	/* look at above method for clarification */
 	
	public static double median(int []A, int[]B, int left, int right){

		int M = A.length;
		int N = B.length;
		int mid = (M+N)/2;

		if(left>right)
			return median(B,A,Math.max(0,mid-M),Math.min(N-1,mid));

		int i= (left+right)/2;
		int j= mid - i-1;

		if(j>=0 && A[i]<B[j])
			return median(A,B,i+1,right);

		if(j<(N-1) && A[i]>B[j+1])
			return median(A,B,left,i-1);

		if( (((M+N) & 0x1) > 0 ) || (  (i<=0) && (j<0 || j>=N) ))
			return A[i];

		if( j<0 || j>=N)
			return (A[i]+A[i-1])/2.0;

		if(i<=0)
			return (A[i]+B[j])/2.0;

		return (A[i]+Math.max(B[j],A[i-1]))/2.0;

	}



	private static double median (int []A, int []B,int left, int right, int NA, int NB){

		if(left>right)
			return median(B,A,Math.max(0,(((NA+NB)/2)-NA)),Math.min(NB,((NA+NB)/2)),NB,NA);

		int i = (left+right)/2;
		int j = ((NA+NB)/2)-i-1;
		System.out.println(" j "+j+" i "+i);
		if(j>=0 && A[i]<B[j])
			return median(A,B,i+1,right,NA,NB);

		else if( (j<NB-1) && (A[i]>B[j+1]) )
			return median(A,B,left,i-1,NA,NB);

		else{

			  	System.out.println(">>>>> j "+j+" i "+i);
			  	if(j<0 &i>0){
			  		return A[i-1];
			  	}
				if((NA+NB)%2==1)
					return A[i];

				else if(i>0){
					System.out.println(" --- "+B[j]);
					return ((A[i] + Math.max(B[j],A[i-1]))/2.0);
				}

				else
					return (A[i]+B[j])/2.0;
		}

	}



	public static void main(String[] args) {
		
		//int [] A ={10,20,30,40,50};
		//int [] B ={100,200,300,400,500};
		//int [] A ={};
		//int [] B ={2,3};
		//int [] A ={4};
		//int [] B ={1,2,3};
		//int [] A ={};
		//int [] B ={1};
		int [] A ={3};
		int [] B ={1,2};
		System.out.println(median(A,B));

	}
}