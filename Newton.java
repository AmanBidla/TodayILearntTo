public class Newton{

	private static double sqrt(double c){

		if(c<0) return Double.NaN;
		double EPS = 1E-15;
		double t = c;

		while(Math.abs(t-c/t) >EPS*t){
			t=(t+c/t)/2.0;
		} 

		return t;
	}

	public static void main(String[] args) {
		
		System.out.println("sqrt of 4 is "+sqrt(4));
		System.out.println("sqrt of 5 is "+sqrt(5));
	}

}