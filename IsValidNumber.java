public class IsValidNumber {

	public static void main(String[] args) {
		
		//String [] array ={ "0", "0.1", "abc", "1 a", "2e10", null,"5e"};
		String [] array ={"5e",".e1","1e.","3.","-1.","+.8"};
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+" "+isNumber(array[i]));	
		}
		
	}

	private static boolean isNumber(String s){

		/*
        "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
        */

        if(s == null) return false;
        s = s.trim();
        if(s.length() ==0) return false;
        char [] array = s.toCharArray();
        boolean hasSeenDecimalBefore = false;
        boolean hasSeenExp = false;
        for(int i=0;i<array.length;i++){
        	System.out.println("char c "+array[i]);
        	if(array[i]=='-' || array[i]=='+' ){

        		if(i==0) continue;
        		else return false;
        	}
        	if( (array[i] >= '0') && (array[i] <= '9')) continue;
            if(array[i]=='.'){
            	if(hasSeenDecimalBefore) return false;
            	else {
            	    hasSeenDecimalBefore = true;
            	    if(s.length() ==1) return false;
            	    if((i+1)==s.length() && (array[i-1]=='e' || array[i-1]=='+' || array[i-1]=='-')) return false;
            	}
            	continue;
            }

            if(array[i]=='e'){
            	if(hasSeenExp) return false;
            	else {
            		System.out.println(" (i>0 && s.charAt(i-1) =='0') "+((i>0 && s.charAt(i-1) =='0')));
            	    if(s.length() ==1) return false;
            	    if(i==0) return false;
            	    if((i+1)==array.length) return false;
            	    if(i>0 && array[i-1]=='.') return false;
            	    hasSeenExp = true;
            	}
            	continue;
            } 
            return false;
        }

        return true;
	}
}