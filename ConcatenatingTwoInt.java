public class ConcatenatingTwoInt {

	private static long add(long a, long b){

			long temp =b;
			while(temp>0){
				temp/=10;
				a*=10;
			}
			a +=b;
			return a;
	}

	public static void main(String[] args) {
		
		long a=878;
		long b=2345;

		System.out.println(add(a,b));

	}


}