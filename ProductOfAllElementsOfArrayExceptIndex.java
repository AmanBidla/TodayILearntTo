public class ProductOfAllElementsOfArrayExceptIndex{


	private static int [] product;

	private static void process(int [] A){
		if(A==null || A.length==0) return;
		int p=1;
		int N = A.length;
		product = new int[N];
		for(int i=0;i<N;i++){
			product[i]=p;
			p*=A[i];
		}

		p=1;
		for(int i=N-1;i>=0;i--){
			product[i]*=p;
			p*=A[i];
		}
	}

	private static int find(int i){
		if(product==null) return Integer.MIN_VALUE;
		return product[i];
	}

	public static void main(String[] args) {
		int [] array = {1, 2, 3, 4, 0};
		process(array);
		System.out.println(find(0));
		System.out.println(find(4));
		System.out.println(find(3));
	}
}