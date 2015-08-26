public class UniqueFactors{


	private static void print(String curr, int N, int prevFactor){

		for(int i=N-1;i>=2;i--){
			if(N%i==0 && i<=prevFactor){
				int nextFactor = N/i;
				if(nextFactor<=i && nextFactor<=prevFactor){
					System.out.println(curr+i+" * "+nextFactor);
				}
				print(curr+i+" * ",nextFactor,i);
			}

		}
	}

	public static void main(String[] args) {
		int N =24;
		print("",N,N);
	}
}