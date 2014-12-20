import java.util.ArrayList;

public class DecodeMessageRecursive{

	public int total(String s){
		int N = s.length();
		if(N==0){
			return 0;
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		recurse(s,sol);
		return sol.size();
	}

	private void recurse(String s, ArrayList<Integer> sol){

		int N = s.length();
		if(N==0){
			sol.add(1);
			return;
		}

		int value = Character.getNumericValue(s.charAt(0));
		if(value>0 && value<=9){
			recurse(s.substring(1),sol);
		}

		if(N>=2){

			int value1 = Character.getNumericValue(s.charAt(0));
			int value2 = Character.getNumericValue(s.charAt(1));

			if(value1==1 &&value2>=0 && value2<=9){
				recurse(s.substring(2),sol);
			}
			else if(value1==2 && value2>=0 && value2<=6){
				recurse(s.substring(2),sol);
			}

		}

	}

	public static void main(String[] args) {
		DecodeMessageRecursive dmes = new DecodeMessageRecursive();
		String s = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
		System.out.println(dmes.total(s));

	}
}