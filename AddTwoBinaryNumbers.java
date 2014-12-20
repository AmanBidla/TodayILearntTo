public class AddTwoBinaryNumbers{
	

	public static String add(String A, String B){

		int M = A.length();
		int N = B.length();

		int carry =0;
		int i = M-1;
		int j = N-1;

		StringBuilder sb = new StringBuilder();

		while(i>=0 || j>=0){

			int v1 = (i<0)?0:(A.charAt(i)-'0');
			int v2 = (j<0)?0:(B.charAt(j)-'0');

			int sum = v1+ v2 +carry;

			carry = sum>>1;
			sum = sum&1;

			sb.insert(0,sum==0?'0':'1');

			i--;
			j--;


		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String s1 ="0101";
		String s2 ="0011";
		//System.out.println(add(s1,s2));
		s1="011";
		s2="10";
		System.out.println(add(s1,s2));

	}


}