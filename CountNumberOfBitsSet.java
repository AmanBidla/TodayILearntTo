public class CountNumberOfBitsSet{


	public static int count(int N){

		int count=0;

		while(N>0){

			N=N&(N-1);
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		int N =9;
		System.out.println(count(N));
	}
}