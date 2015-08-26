public class IsNumeric{


	public static boolean isNumber(String S){

		if(S==null || S.length()==0) return false;
		

		int dots=0, digits=0, negatives=0;		 
		int N = S.length();
		int i;
		i = S.charAt(0)=='-'?1:0;
		if(i==0)
			 i= S.charAt(0)=='+'?1:0;

		for(;i<N;i++){
			char c = S.charAt(i);
			switch(c){
				case '0':case '1':case '2':case '3':case '4':
				case '5':case '6':case '7':case '8':case '9':
				digits++;
				break;
				case '-': negatives++; break;
				case '.': dots++; break;
				default : return false;
			}			
		}

		if(dots>1 || negatives>0) return false;
		return digits>0;
	}

	public static void main(String[] args) {
		
		System.out.println("123 isNumber ? " + isNumber("123"));
	    System.out.println(".123 isNumber ? " + isNumber(".123"));
	    System.out.println("-.123 isNumber ? " + isNumber("-.123"));
	    System.out.println("-. isNumber ? " + isNumber("-."));
	    System.out.println(".- isNumber ? " + isNumber(".-"));
	    System.out.println("23.34.545 isNumber ? " + isNumber("23.34.545"));
	    System.out.println("- isNumber ? " + isNumber("-"));
	    System.out.println("-0 isNumber ? " + isNumber("-0"));
	    System.out.println("12$%^&*# isNumber ? " + isNumber("12$%^&*#"));
	    System.out.println("+77288.100 isNumber ? " + isNumber("+77288.100"));
	    System.out.println("+a772sb isNumber ? " + isNumber("a772sb"));
	    System.out.println("+2000.00.11 isNumber ? " + isNumber("2000.00.11"));

	    System.out.println("12--3 isNumber ? " + isNumber("12--3"));
	    System.out.println("12-3 isNumber ? " + isNumber("12-3"));

	}
}