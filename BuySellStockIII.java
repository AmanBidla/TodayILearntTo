import java.util.Arrays;

public class BuySellStockIII {

	private static int stockIII(int []A){

		if(A==null || A.length==0){
			return 0;
		}


		int N = A.length;
		int [] left = new int[N];
		int [] right = new int[N];

		left[0]=0;
		int min = A[0];
		for(int i=1;i<N;i++){
			min = Math.min(min, A[i]);			
			left[i] = Math.max( left[i-1], A[i]-min);
			System.out.print("left["+i+"] = "+left[i]);
			System.out.println(" min = "+min);
		}

		System.out.println("left "+Arrays.toString(left));

		right[N-1]=0;
		int max = A[N-1];
		for(int i=N-2;i>=0;i--){
			max = Math.max(max, A[i]);
			right[i] = Math.max( right[i+1], max-A[i]);
		}
		System.out.println("right "+Arrays.toString(right));

		int result=0;
		for(int i=0;i<N;i++){
			result= Math.max( result, left[i]+right[i]);
		}
		return result;
	}

 
	public static void main(String[] args) {
		
		//int [] A = {1,4,5,7,6,3,2,9};
		int [] A = {7,1,2,3,4};
		System.out.println("max is "+stockIII(A));
	}
}