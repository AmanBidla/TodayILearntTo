public class MaximumProductSubArray{

	public static void main(String[] args) {
		
		//int [] array ={2,3,-2,-4};
		int [] array ={2,-3,-3,-4};
		System.out.println(max(array));
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

}