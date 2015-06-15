import java.util.Arrays;

public class KandanesAlgorithm{

	private static int kandane(int []A){

		if(A==null || A.length==0) return Integer.MIN_VALUE;
		int N = A.length;
		int curr=A[0];
		int max=A[0];
		int start=0, indexBegin=0, indexEnd=0;
		for(int i=1;i<N;i++){
			curr = curr+A[i];
			if(curr<0) {
				curr=0;
				start=i+1;
			}else {
				max = Math.max(curr,max);
				indexBegin = start;
				indexEnd = i; 
			}
		}
		if(indexBegin!=indexEnd) indexEnd--;
		System.out.println("indexBegin "+indexBegin+" indexEnd "+indexEnd);

		return max;
	}

	public static void main(String[] args) {
		
		int [] A1={-2,-3,-4};
		System.out.println("max sum in array "+Arrays.toString(A1)+" is "+kandane(A1));
		int [] A2={1,2,3,3,-2};
		System.out.println("max sum in array "+Arrays.toString(A2)+" is "+kandane(A2));
		int [] A3={1, 2, -4, 1, 3, -2, 3, -1};
		System.out.println("max sum in array "+Arrays.toString(A3)+" is "+kandane(A3));
		int [] A4 = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("max sum in array "+Arrays.toString(A4)+" is "+kandane(A4));

	}
}