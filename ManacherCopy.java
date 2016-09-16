public class ManacherCopy{

	public static int [] P;
	public static char []T;

	public static void manacher(String S) {

		T = process(S);
		P = new int[T.length];

		int center =0, right=0;

		for(int i=1;i<T.length-1;i++) {

			int mirror = 2*center-i;

			if(right>i) {
				P[i] = Math.min( (right-i), P[mirror]);
			}

			while (T[i+(1+P[i])] == T[i-(1+P[i])]){
				P[i]++;
			}

			if(i+P[i] > right){
				right = i+P[i];
				center =i;
			}
		}
		 
	}

	public static char[] process(String S){

		int N = S.length();
		char [] T= new char[(2*N)+3];
		T[0] ='$';
		T[(2*N)+2] = '@';
		T[((2*N)+1]= '#';

		for(int i=0;i<N;i++){
			T[(2*i)+1] ='#';
			T[(2*i)+2] =S.charAt(i);
		}

		return T;

	}

	public static String longest(String S) {

		int  len=0, center=0;
		for(int i=1;i<P.length-1;i++) {
			if(len<P[i]){
				len = P[i];
				center = i;
			}
		}

		return S.substring( (center-1-len)/2 , (center-1+len)/2);
	}

	public static void main(String[] args) {
		
		String word = "abaxabaxabb";
		manacher(word);
		System.out.println(longest(word));

	}
 
}