import java.util.Map;
import java.util.HashMap;

public class PalindromePermutation{

	public static void main(String[] args) {
		
		String  check="ivicc";
		System.out.println(check+" has a permutation palindrome is "+isPalindromeBetter(check));
		  check="civil";
		System.out.println(check+" has a permutation palindrome is "+isPalindromeBetter(check));


	}

	/* Note in this Map, we are storing boolean to check if character has appeared odd or even times
	* This PROTECTS against cases when the number of characters are arbitrarily large
	* Tell this to interviewer */
	public static boolean isPalindromeBetter(String word){

		Map<Character,Boolean> map = new HashMap<Character, Boolean>();
		for(int i=0;i<word.length();i++){

			if(map.containsKey(word.charAt(i))){
				map.put(word.charAt(i), !map.get(word.charAt(i)));
			}else{
				map.put(word.charAt(i),false);
			}

		}
		boolean  hasSingle=false;
		for(int i=0;i<word.length();i++){

			if(map.get(word.charAt(i))){
				continue;
			}else{
				if(!hasSingle) hasSingle =true;
				else return false;
			}
		}
		return true;

	}

}