import java.util.Arrays;

public class CountingBits {


	public static int [] countingBits(int N) {

		int [] result  = new int[N+1];

		int pow=1, p=1;
		for(int i=1;i<=N;i++) {

			if(i==pow){
				result[i] = 1;
				pow = 1<<pow;
				p=1;
				System.out.println(" p "+p+" where i = pow , i "+i+" pow "+pow);
			} else {
				result[i] = result[p]+1;
			 	p++;
			 	System.out.println(" p "+p);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(countingBits(5)));
		
	}
}