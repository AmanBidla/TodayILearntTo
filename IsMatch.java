public class IsMatch {


	public static boolean isMatch(String S, String P){

		int M = S.length();
		int N = P.length();

		int i=0,j=0,lastAsterix=-1, lastMatch=-1;

		while(i<M){
			 
			if(j<N && (S.charAt(i)==P.charAt(j) || P.charAt(j)=='?')){

				i++;
				j++;
				continue;
			}


			if(j<N && P.charAt(j)=='*'){

				lastAsterix=j;
				j++;
				lastMatch=i;
				continue;
			}

			if(lastMatch==-1){
				return false;
			} else {
				j = lastAsterix+1;
				lastMatch++;
				i=lastMatch;
			}

		}
		
		/**
		* This is need when M < N or input S="",P="*" 
		**/
		while(j<N) {

			if(P.charAt(j)!='*'){
				return false;
			}
			j++;
		}

		return true;
	}

	public static void main(String[] args) {
		
		String S ="";
		String P ="*";

		System.out.println(isMatch(S,P)); // expected true;

		S="a";
		P="aa";
		System.out.println(isMatch(S,P)); // expected false;

		System.out.println(isMatch("aa","a")); // → false
		System.out.println(isMatch("aa","aa")); // → true
		System.out.println(isMatch("aaa","aa")); // → false

		System.out.println(isMatch("aa", "*")); // → true
		
		System.out.println(isMatch("aa", "a*")); // → true
		System.out.println(isMatch("ab", "?*")); // → true
		System.out.println(isMatch("aab", "c*a*b")); // → false 
	}
}