public class ATOI{


	private static int atoi(String s){
		int N = s.length();
		int result =0;
		for(int i=0;i<N;i++){
			char a = (char) (s.charAt(i) - '0');
			result += a * Math.pow(10,N-i-1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(atoi("12424"));
	}
}