import java.util.Arrays;

public class KandanesAlgorithm{

	private static int kandane(int []A){

		if(A==null || A.length==0) return Integer.MIN_VALUE;
		int N = A.length;
		int curr=A[0];
		int max=A[0];
		for(int i=1;i<N;i++){
			curr= Math.max(curr, curr+A[i]);
			max = Math.max(curr,max);
		}

		return max;
	}

	public static void main(String[] args) {
		
		int [] A1={-2,-3,-4};
		System.out.println("max sum in array "+Arrays.toString(A1)+" is "+kandane(A1));
		int [] A2={1,2,3,3,-2};
		System.out.println("max sum in array "+Arrays.toString(A2)+" is "+kandane(A2));
	}
}