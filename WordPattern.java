import java.util.Map;
import java.util.HashMap;

public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null){
            return true;
        }
        Map<Character,String> map = new HashMap<>();
        String[] array = str.split(" ");
        if(array.length != pattern.length()){
            return false;
        }
        for(int i=0;i<array.length;i++){
            char c= pattern.charAt(i);
            if(!map.containsKey(c)){
                if(map.values().contains(array[i])){
                    return false;
                }
                map.put(c,array[i]);
            }else{
                if(!map.get(c).equals(array[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	
    	System.out.println(wordPattern("abba","dog cat cat dog")); // true
    	System.out.println(wordPattern("abba","dog cat cat fish")); // false
    	System.out.println(wordPattern("aaaa","dog cat cat dog")); // false
    	System.out.println(wordPattern("abba","dog dog dog dog")); // false

    }
}