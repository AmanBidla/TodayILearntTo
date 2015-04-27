public class SquareRoot{

	public static void main(String[] args) {
		int N =10;
		System.out.println( squareRoot(N));

		int M=27;
		System.out.println( cubeRoot(M));


	}

	public static double cubeRoot(int N){

		if(N<0) return -1;

		Double val = Double.valueOf(N);
		double start=0;
		double end= N;
		double EPSILON =0.0000000000001;

		while(start<end){

			double mid =(start+end)/2;
			double expected = mid*mid*mid;
			if(Math.abs(val-expected)<EPSILON){
				return mid;
			}else if(expected<val){
				start=mid;
			}else{
				end=mid;
			}

		}
		return -1;
	}

	public static double squareRoot(int N){

		if(N<0) return -1;

		Double val = Double.valueOf(N);
		//double EPSILON= 1e-15;
		double EPSILON= 0.0000000000001;
		double start=0;
		double end=N;

		while(start<end){

			double mid = (start+end)/2;
			double expected = mid*mid;

			if(Math.abs(val-expected) < EPSILON){
				return mid;
			}else if(expected<val){
				start=mid;
			}else{
				end=mid;
			}
		}

		return -1;	

	}
}