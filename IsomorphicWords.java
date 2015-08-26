import java.util.Map;
import java.util.HashMap;

public class IsomorphicWords{

	 
    public static boolean isIsomorphic(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (length1 != length2) {
            return false;
        }
        if (length1 == 1) {
            return true;
        }
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        for (int i = 0; i < length1; i++) {
        	
        	char c1 = inputString1.charAt(i);
        	char c2 = inputString2.charAt(i);

            if (!characterMap.containsKey(c1) && !characterMap.containsValue(c2)) {
                characterMap.put(c1, c2);
            }
            if (characterMap.get(c1) == null) {
                return false;
            }
            if (!characterMap.get(c1).equals(c2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	
    	System.out.println("foo and app "+isIsomorphic("foo","app"));
    	System.out.println("foo and bar "+isIsomorphic("foo","bar"));
    	System.out.println("bar and foo "+isIsomorphic("bar","foo"));
    	System.out.println("tletur and turtle "+isIsomorphic("tletur","turtle"));
    	System.out.println("ab and ca "+isIsomorphic("ab","ca"));
		System.out.println("ofo and foo "+isIsomorphic("ofo","foo"));
    }
}