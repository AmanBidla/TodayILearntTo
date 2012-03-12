 public class ReverseLetters{


	public static void main(String abc[]){
 
//	String reverseMe = "MynameisSreeprasad";
   	//String reverseMe = "AAAa";
 	String reverseMe = "AfFa";

 
		/*for (int i = 0; i < reverseMe.length(); i++) {
		    reverseMe = reverseMe.substring(1, reverseMe.length() - i)
		        + reverseMe.substring(0, 1)
		        + reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		 }
		 System.out.println(reverseMe);*/
 	 //System.out.println(reverseMe.substring(reverseMe.length()));

	/*		System.out.println(reverseMe);
  		for(int i=0;i< reverseMe.length();i++){
		      for(int j=0;j<reverseMe.length();j++){
			System.out.println("i is "+i+" and j is "+ j);
			System.out.println(reverseMe.charAt(i)+" and "+reverseMe.charAt(j) +" and is "+(reverseMe.charAt(i)==reverseMe.charAt(j)));
				if(i!=j){
		               if(reverseMe.charAt(i)==reverseMe.charAt(j)){
		           	            reverseMe = reverseMe.substring(0,j)+reverseMe.substring(j+1);     
								System.out.println("string is "+reverseMe);
							}
						}
		}
	}
 
	System.out.println(reverseMe);	*/
	String s1="carr";
	String s2="race";
	StringBuffer s1b = new StringBuffer(s1);
	StringBuffer s2b = new StringBuffer(s2);
	System.out.println(areAnagrams(s1b,s2b)	);	
  	
	}
	
	
	public static boolean areAnagrams(StringBuffer s1b, StringBuffer s2b) {
				    System.out.println(s1b+" "+s2b);
		if(!(s1b.length()==s2b.length())) return false;

	    for (int i=0; i<s1b.length();) {
	        for (int j=0; j<s2b.length(); ++j) {
				System.out.println(s1b.charAt(i)+" compares with "+ s2b.charAt(j)+" "+(s1b.charAt(i) == s2b.charAt(j))+ "i is "+i+" j is "+j)	;
	            if (s1b.charAt(i) == s2b.charAt(j)) {

	                s1b.deleteCharAt(i);
	                s2b.deleteCharAt(j);
				    System.out.println(s1b+" "+s2b);
 					break;
	            }
 
	        }
	    }

		if(!(s1b.length()==s2b.length())) return false;
		else return true;

	}
	

}