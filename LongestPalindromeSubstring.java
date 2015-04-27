public class LongestPalindromeSubstring{
	
	public static void main(String[] args) {
		
		String s="dabcacba01221";
		System.out.println("longest palindrome substring is "+longest(s));
	}

	private static int longest(String s){

		if(s==null || s.length()==0 ) return 0;
   else if (s.length()==1) return 1;
		
		String longest = s.substring(0,1);
		int N = s.length();
		for(int i=0;i<N;i++){

			String nextLongest = getNextLongest(s,N,i,i);
			System.out.println("next longest for (s,N,i,i) is "+nextLongest);
			if(nextLongest.length() > longest.length()){
				longest=nextLongest;
			}

			nextLongest = getNextLongest(s,N,i,i+1);
			System.out.println("next longest for (s,N,i,i+1) is "+nextLongest);

			if(nextLongest.length() > longest.length()){
				longest=nextLongest;
			}

		} 
		System.out.println("longest is "+longest);
		return longest.length();
	}

	private static String getNextLongest(String s, int N, int st, int end){

		while(st>-1 && end<N && s.charAt(st)==s.charAt(end)){
			st--;
			end++;
		}

		return s.substring(st+1,end);
	}

}