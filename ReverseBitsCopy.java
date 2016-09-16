public class ReverseBitsCopy {

 	public static int reverse(int N ){

 		for(int i=0;i<16;i++){
 			N = reverse(N, i, 32-i-1);
 		}

 		return N;
 	}

 	private static int reverse(int N, int i, int j){

 		int a = N>>i & 1;
 		int b = N>>j & 1;

 		if(a^b !=0) {
 			return N^= 1<<i | 1<<j;
 		}

 		return N;
 	}

}