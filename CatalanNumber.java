public class CatalanNumber {


	public static int binomial(int N, int K){

		if(K>(N-K)){
			K = N-K;
		}
		int result=1;
		for(int i=0;i<K;i++){
			result *= (N-i);
			result /= i+1;
		}
		return result;
	}

	public static int catalan(int N){
		int c = binomial(2*N, N);
		return c/(N+1);
	}

	public static void main(String[] args) {
		
		int result = catalan(3);
		System.out.println(result); // should be 5;
	}
}