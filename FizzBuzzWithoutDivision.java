public class FizzBuzzWithoutDivision {


	static int [] array = {  15,0,0,3,0,5,3,0,0,3,5,0,3,0,0};

	static void fizzBuss(int N){
		int ix=0;
		for(int i=0;i<N;i++){

			if(array[ix]==0) System.out.println(i);
			else if(array[ix]==3) System.out.println("Fizz");
			if(array[ix]==5) System.out.println("Buzzz");
			if(array[ix]==15) System.out.println("FizzBuzz");
			ix++;
			if(ix==15) ix=0;
		}
	}

	public static void main(String[] args) {
		
		fizzBuss(20);
	}
}