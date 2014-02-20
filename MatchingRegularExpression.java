public class MatchingRegularExpression{

	public static void main(String[] args) {
		
		System.out.println("isMatch(b,aa)\t"+isMatch("b","aa"));
		System.out.println("isMatch(aaa,aa)\t"+isMatch("aaa","aa"));
		System.out.println("isMatch(a*,aa)\t"+isMatch("a*","aa"));
		System.out.println("isMatch(.,aa)\t"+isMatch(".","aa"));
		System.out.println("isMatch(.*,ab)\t"+isMatch(".*","ab"));
		System.out.println("isMatch(c*a*b,aab)\t"+isMatch("c*a*b","aab"));
	}


	private static boolean isMatchHere(String pat, String s){

		if(pat.length()==0) return true;

		if((pat.length()==1) && (pat.charAt(0)=='$'))
			return (s.length()==0);

		if(pat.length()>=2 && pat.charAt(1)=='*'){

			for(int i=0;
				( (i<s.length()) && ( (s.charAt(i)==pat.charAt(0)) || (pat.charAt(0)=='.') ) );
				i++){

				if(isMatchHere(pat.substring(2),s.substring(i+1)))
					return true;

				return isMatchHere(pat.substring(2),s);
			}

		}

		return ( !(s.length()==0) 
				 && ( (pat.charAt(0)==s.charAt(0)) || (pat.charAt(0)=='.') ) 
				 && isMatchHere(pat.substring(1),s.substring(1)) );
	}

	private static boolean isMatch(String pat, String s){
		if(pat.length()==0) return true;
		if(pat.charAt(0)=='^')
			return isMatchHere(pat.substring(1),s);


		for(int i=0;i<s.length();i++){
			if(isMatchHere(pat,s.substring(i))) return true;
		}
		return false;
	}

}