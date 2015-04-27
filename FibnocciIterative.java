public class FibnocciIterative{


	public static void main(String[] args) {
		
		int a=0;
		int b=1;
		int sum=0;

		int N =9;

		for(int i=2;i<=N;i++){

			sum = a+b;
			b=a;
			a=sum;
		}

		System.out.println("sum is "+sum);


	}
}