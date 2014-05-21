import java.util.Arrays;

public class ConsequtiveAnagrams {
	
	private static boolean hasAnagram(String word, String text){
		int N = word.length();
		int M = text.length();
		if(M ==N){
			char [] wAnagram = word.toCharArray();
			char [] tAnagram = text.toCharArray();
			Arrays.sort(wAnagram);
			Arrays.sort(tAnagram);
			String x = new String(wAnagram);
			String y = new String(tAnagram);
			return x.equals(y);
		}else if(M<N){

			return false;
		}else{
			char [] wAnagram = word.toCharArray();
			Arrays.sort(wAnagram);
			for(int i=0;i<=M-N;i++){
				
				String wTemp = text.substring(i,i+N);
				//System.out.println("substring is "+wTemp);
				char [] tAnagram = wTemp.toCharArray();				
				Arrays.sort(tAnagram);
				String x = new String(wAnagram);
				String y = new String(tAnagram);
				//System.out.println("checking "+y+" with "+x);
				if(x.equals(y)) return true;;

			}

			return false;

		}
	}

	public static void main(String[] args) {
		
		String word = "teat";
		String text ="slatet";
		boolean result = hasAnagram(word,text);
		assert(result==true);

		word="let";
		result = hasAnagram(word,text);
		assert(result==false);


	}

}