public class Pow{

	private static int power(int a, int n){
		if(n==0) return 1;
		if(n==1) return a;
		int num = power(a, n/2);
		num *= num;
		if(n%2!=0){
			num *=a;
		}

		return num;
	}

	private static double pow(int a, int n){

		if(n<0){

			return (1.0/power(a, (n*-1)));
		}else {
			return (double) power(a,n);
		}
	}

	public static void main(String[] args) {
			
			//System.out.println( pow(2,4));
			//System.out.println( pow(2,-1));
			//System.out.println( pow(2,-4));
			System.out.println( pow(3,-4));

	}

}