public class MinimumWindowInSContainingAllCharactersInT{


	private static int minWindow(String S, String T){


		if(S==null || T==null) return -1;
		
		int M = S.length();
		int N = T.length();

		if(M==0 || N==0) return -1;

		int [] needToFind = new int[256];
		int [] hasToFind = new int[256];

		for(int i=0;i<N;i++){
			needToFind[T.charAt(i)]++;
		}

		int begin=0;
		int count=0;
		int min=Integer.MAX_VALUE;
		int windowBegin=0, windowEnd=0;

		for(int end=0;end<M;end++){
			 
			if(needToFind[S.charAt(end)]==0) continue;
			hasToFind[S.charAt(end)]++;
			if(hasToFind[S.charAt(end)]<=needToFind[S.charAt(end)]) count++;
			if(count==N){

				while(hasToFind[S.charAt(begin)]==0 || hasToFind[S.charAt(begin)]> needToFind[S.charAt(begin)] ){

					if(hasToFind[S.charAt(begin)]> needToFind[S.charAt(begin)]){
						hasToFind[S.charAt(begin)]--;
					}
					begin++;
				}

				int window = end-begin+1;
				if(window<min){
					min=window;
					windowBegin=begin;
					windowEnd=end;
				}
			}

		}

		if(min==Integer.MAX_VALUE)  min=-1;
		return min;

	}

	public static void main(String[] args) {
		
		String S="ACBBACA";
		String T="ABA";
		System.out.println(minWindow(S,T));

		S="ADOBECODEBANC";
		T="ABCC";
		System.out.println(minWindow(S,T));

		S="ADOBEODEBAN";
		T="ABC";
		System.out.println(minWindow(S,T));

		S="AAAAAAAAAAAAAAAA";
		T="AA";
		System.out.println(minWindow(S,T));

		S="AAAAAAAAAAAAAAAA";
		T="";
		System.out.println(minWindow(S,T));

	}
}