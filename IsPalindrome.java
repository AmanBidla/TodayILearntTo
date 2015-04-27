public class IsPalindrome{

	public static void main(String[] args) {
		
		String S="Red rum, sir, is murder";
		System.out.println(isPalindrome(S));

	}


	public static boolean isPalindrome(String S){

		if(S==null || S.length()==0) return false;

		int N = S.length();
		if(N==1) return true;

		String neat = S.replaceAll("[^a-zA-Z0-9]","").toLowerCase();;
		neat = neat.trim();	
		int start=0;
		int end=neat.length()-1;

		while(start<=end){			 
			if( ! (neat.charAt(start)== neat.charAt(end)) )  return false;

			start++;
			end--;
		}
		return true;
	}
}