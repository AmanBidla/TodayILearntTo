import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IsValidPalindrome{

	public static void main(String[] args) {
		
		//String S = "A man, a plan, a canal: Panama"; //true
		//String S ="race a car"; // false
		//String S =".,"; // true
		//String S ="0P"; // false
		//String S ="a."; //true
		String S =""; //true
		 
		 
		System.out.println( isPalindrome(S));

	}

	public static boolean isPalindrome(String S) {

		if((S==null) || (S.length() == 0)){
			return true;
		}

		S = S.toLowerCase();
 
		char [] array = S.toCharArray();
		int i=0,j = array.length-1;
		char left,right;
		while(i<=j){

			left = array[i];
			right = array[j];

			if(!isCharOrNum(left)){
				i++;				
			
			}else if(!isCharOrNum(right)){
				j--;
			
			}else{

				if(left != right){
					return false;
				}

				i++; j--;
			}
			 
		} 
 
		  

		return true;

	}

 	 
    private static boolean isCharOrNum(char c){    	 
    	boolean isChar =  (c>='a' && c<='z') || (c>='A' && c<='Z');
    	boolean isNum = c>='0' && c<='9';
    	return isChar || isNum;
    }
}