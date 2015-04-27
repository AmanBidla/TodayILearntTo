public class RegexMatching{

	static boolean regex(String r, String s){

		if(r.charAt(0)=='^')
			return matchHere(r.substring(1),s);
		int i=0;
		do{
			if(matchHere(r,s.substring(i))){
				return true;
			}			
		}while(i++ <s.length());
		return false;
	}

	static boolean matchHere(String r, String s){
		
		//if r is empty
		if(r.length()==0){
			return true;
		}

		// check for *
		if(r.length()>=2 && r.charAt(1)=='*')
			return matchStar(r.charAt(0),r.substring(2),s);

		if(r.charAt(0)=='$' && r.length()==1)
			return s.length()==0;

		//check for . or char
		if(s.length()>0 && (r.charAt(0)=='.' || r.charAt(0)==s.charAt(0)))
			return matchHere(r.substring(1),s.substring(1));

		//System.out.println("return false s " + s+" r "+r);
		return false;
	}

	static boolean matchStar(char c, String r, String s){
		//System.out.println("c "+c+" r "+r+" s "+s );
		int i=0;
		do{
			//System.out.println("checked "+s.substring(i));
			if(matchHere(r,s.substring(i))){
				return true;
			}
			//System.out.println("incrementing i "+i);
		}while(i<s.length() && (s.charAt((i++))==c || c=='.') );

		return false;
	}

	public static void main(String[] args) {
		
		/*String r="a*b";
		String s="accccccb";
		boolean b = regex(r,s);
		//System.out.println("r "+r+" s "+s+" ans "+b);

		r="^abc*b*ebe$";
		s="abcbbbbbebe";
		b=regex(r,s);
		//System.out.println("r "+r+" s "+s+" ans "+b);		
		r="aa";
		s="aaa";
		b=regex(r,s);
		System.out.println("r "+r+" s "+s+" ans "+b);
		*/

		String r="a*b";
		String s="accccccb";
		boolean b = regex(r,s);
		System.out.println("r "+r+" s "+s+" ans "+b);



	}


}