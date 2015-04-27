public class CopyRegexMatching{


	public static void main(String[] args) {
		
		String S="aab";
		String reg=".*";
		System.out.println(isMatch(reg,S));	
	}

	public static boolean isMatch(String reg, String S){

		if(S==null || reg==null || reg.length()==0 || S.length()==0) return true;

		if(reg.charAt(0)=='^') return isMatchHere(reg.substring(1),S);

		for(int i=0;i<S.length();i++){

			if(isMatchHere(reg,S.substring(i))) return true;
		}

		return false;
	}


	public static boolean isMatchHere(String reg, String S){

		if(reg.length()==0) return true;

		if(reg.length()==1 && reg.charAt(0)=='$') return S.length()==0;

		if(reg.length()>=2 && reg.charAt(1)=='*'){

			for(int i=0;
				i<S.length() 
				&&( S.charAt(i)==reg.charAt(0) || reg.charAt(0)=='.');
				i++){

				if(isMatchHere(reg.substring(2),S.substring(2))) return true;

				return isMatchHere(reg.substring(2),S);
			}
		}

		return !(S.length()==0)
				&& (S.charAt(0)==reg.charAt(0) || reg.charAt(0)=='.')
				&&  isMatchHere(reg.substring(1),S.substring(1));
	}

}