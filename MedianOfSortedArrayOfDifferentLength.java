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
		System.out.println(findMedianSortedArrays(A,B));

	}
}