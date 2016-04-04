import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SplitStringBasedOnCharacterLimitUsingRegex {


	public static List<String> split(int max, String S){

		List<String> result = new ArrayList<String>();
		Pattern p = Pattern.compile("\\G\\s*(.{1,"+max+"})(?=\\s|$)", Pattern.DOTALL);
		Matcher m = p.matcher(S);
		while (m.find()){
			String word = m.group(1);
			result.add(word);
			System.out.println(word);
		}
		return result;
 
	}

	public static void main(String[] args) {
		
		String S = "Hi Sivasrinivas, your Uber is arriving now!";
		int max= 20;
		//["Hi Sivasrinivas,(1/3)", "your Uber is arriving(2/3)", "now!(3/3)"]
		List<String> result = split(max,S);
		System.out.println(Arrays.toString(result.toArray(new String[result.size()])));


	}

}