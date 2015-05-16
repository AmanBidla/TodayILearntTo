public class MaximumProductSubArray{

	public static void main(String[] args) {
		
		//int [] array ={2,3,-2,-4};
		int [] array ={2,-3,-3,-4};
		System.out.println(max(array));
		System.out.println(maxProduct(array));
	}

	public static int max(int [] array){

		int N = array.length;
		int localMin=array[0];
		int localMax = array[0];
		int max=array[0];

		for(int i=1;i<N;i++){
			int temp = localMax;
			localMax = Math.max( array[i]*localMin , Math.max(array[i]*localMax, array[i]));
			localMin = Math.min( array[i]*localMin , Math.min(array[i]*temp, array[i]));
			max= Math.max( max, localMax);
		}
		return max;
	}


	public static int maxProduct(int[] A){
		int result =0;
		if(A==null || A.length<1) return result;
		int N = A.length;
		int max=A[0];
		int min =A[0];
		result=A[0];

		for(int i=1;i<N;i++){
			int tmax=max;
			int tmin=min;
			max=Math.max( Math.max(A[i]*tmax, A[i]*tmin ), A[i]);
			min=Math.min( Math.min(A[i]*tmax, A[i]*tmin ), A[i]);
			result=Math.max(result,max);
		}

		return result;
	}

}