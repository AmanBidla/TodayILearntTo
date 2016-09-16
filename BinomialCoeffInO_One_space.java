public class BinomialCoeffInO_One_space {


	public static int binomial(int N, int K){

		// since C(N,K) = C(N,N-K);
		if(K>N-K){
			K = N-K;
		}

		int result =1;
		
		for(int i=0;i<K;i++){
			result*=(N-i);
			result/=(i+1);
		}
		return result;
	}

	public static void main(String[] args) {
		
		int result = binomial(5,2);
		System.out.println(result);
	}

	
}