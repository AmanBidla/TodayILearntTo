import java.util.Set;
import java.util.HashSet;

public class IsTrueWordBreak{
	
	public static void main(String[] args) {
		
		String s="leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");

		System.out.println(isBreakable(s,dict));
	}

	private static boolean isBreakable(String s, Set<String> dict){

		if(s==null || s.length()==0 || dict==null || dict.size()==0){
			return false;
		}

		if(s.length()==1){
			return dict.contains(s);
		}

		int N = s.length();

		boolean [] isPresent = new boolean [N+1];

		for(int i=0;i<N;i++){
			
			for(String dictionaryword:dict){

				int length = dictionaryword.length();
				int end = i+length;
				if(end > N){
					continue;
				}

				String currentWord = s.substring(i,end);
				if(currentWord.equals(dictionaryword)){
					isPresent[end]=true;
				}
			}

		}

		return isPresent[N];
	}

}