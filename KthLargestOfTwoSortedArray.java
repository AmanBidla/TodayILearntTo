public class KthLargestOfTwoSortedArray  {

	public static void main(String[] args) {
		
		//int []A ={1,3,5,7,9};
		//int []B ={2,4,6,8,10};
        int A [] = {1, 5, 7, 10, 13};
        int B [] = {11, 15, 23, 30, 45};

		int K =10;
		int M = A.length;
		int N = B.length;

		for(int i=1;i<=(M+N);i++) 
			System.out.println(i+" th smallest number ="+FindKthNumber(A,0,M,B,0,N,i));

        int mid = (M+N)/2;
        if( (M+N)%2==0){

              
             int midMedian = FindKthNumber(A,0,M,B,0,N,mid);
             int midMedianplusOne = FindKthNumber(A,0,M,B,0,N,mid+1);
             //System.out.println("mid "+mid+" val "+midMedian);
             //System.out.println("mid+1 "+(mid+1)+" val "+midMedianplusOne);
             double median = (double) (midMedian + midMedianplusOne)/2;
             System.out.println("Median = "+median);

         }else{
            System.out.println("Median = "+(FindKthNumber(A,0,M,B,0,N,mid)));
         }
 
	}
 

	  private static int FindKthNumber(
            int[] nums1,
            int s1, 
            int l1, 
            int[] nums2, 
            int s2, 
            int l2, 
            int k)
        {
            if (l1 <= 0)
            {
                return nums2[k - 1];
            }

            if (l2 <= 0)
            {
                return nums1[k - 1];
            }

            if (k < 2)
            {
                return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
            }
            else
            {
                 
                int e1 = k / 2;
                int e2 = k - e1;

                if (e1 > l1)
                {
                    e1 = l1;
                    e2 = k - e1;
                }
                else if (e2 > l2)
                {
                    e2 = l2;
                    e1 = k - e2;
                }

                if (nums1[s1+e1 - 1] <= nums2[s2+e2 - 1])
                {
                    return FindKthNumber(nums1, s1+e1, l1-e1, nums2, s2, l2, k - e1);
                }
                else
                {
                    return FindKthNumber(nums1, s1, l1, nums2, s2+e2, l2-e2, k - e2);
                }
            }
       }
	 
}