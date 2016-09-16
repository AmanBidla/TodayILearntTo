import java.util.Map;
import java.util.HashMap;

public class WordPatternCopy {


	public static boolean isValid(String pattern, String S) {

		Map<Character,String> map = new HashMap<>();
		Map<String,Character> reverseMap = new HashMap<>();
		

		String [] array = S.split(" ");

		for(int i=0;i<array.length;i++){

			if(map.containsKey(pattern.charAt(i))){

				if( !map.get(pattern.charAt(i)).equals(array[i]) ){
					return false;
				}
			} else if (reverseMap.containsKey(array[i])){
				return false;
			} else {

				map.put(pattern.charAt(i), array[i]);
				reverseMap.put(array[i],pattern.charAt(i));
			}
			 
		}
		return true;
	}
}