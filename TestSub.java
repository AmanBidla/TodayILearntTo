public class TestSub{
	
	public static void main(String[] args) {
		
		String haystack ="abcbbcabc";
		String needle = "bca";
		System.out.println( search(needle,haystack));

	}

	public static int search (String needle, String haystack){
 
	if( needle==null || haystack==null){
		return -1;
	}
	if( needle.length() == haystack.length() && needle.equals(haystack)  ){
		return 0;
	}
	if(needle.length() > haystack.length() ){
		return -1;
	}
	int M = haystack.length();
	int N = needle.length();
	for(int i=0;i<M;i++){
		if(M-i+1 < N){
			return -1;
		}
		int k=i;
		int j=0;
		while( j<N && k<M && haystack.charAt(k)==needle.charAt(j)){
			j++;
			k++;
			if( j == N ){
				return i;
			}
		}
	}
	return -1;
}
}

