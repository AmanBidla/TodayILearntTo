public class IsPalindrome {



	public static boolean isPalindrome(String S){

		if((S==null) || (S.length()==0))  return false;

		return isPalindrome(S,0,S.length()-1);
	}

	public static boolean isPalindrome(String S, int left, int right){

		if(left>right) return true;

		if(S.charAt(left) != S.charAt(right)) return false;

		return isPalindrome(S,left+1,right-1);

	}


	public static void main(String[] args) {
		

		String S ="abradadarba";
		System.out.println( isPalindrome(S));
	}
}