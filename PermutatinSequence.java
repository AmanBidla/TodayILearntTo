import java.util.List;
import java.util.ArrayList;
public class PermutatinSequence{

	private static String nextPermutationSequence(int N, int k){

		int nMinusOneFactorial = 1;
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder buf = new StringBuilder();

		for(int i=1;i<=N;i++){
			list.add(i);
			nMinusOneFactorial*=i;
		}

		k=k-1;
		nMinusOneFactorial=nMinusOneFactorial/N;

		for(int i=N-1;i>=1;i--){

			int position = k/nMinusOneFactorial;
			int val = list.get(position);
			buf.append(String.valueOf(val));
			list.remove(position);
			k = k%nMinusOneFactorial;
			nMinusOneFactorial=nMinusOneFactorial/i;

		}

		buf.append(String.valueOf(list.get(0)));
		return buf.toString();
	}

	public static void main(String[] args) {
		
		int N=3;
		int K=5;
		System.out.println(nextPermutationSequence(N,K));
	}

}