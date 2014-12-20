public class NeedleInHaystack{

	public static String findNeedle(String haystack, String needle){
		if(haystack==null){
			return null;
		}else if(needle==null){
			return haystack;
		}else if( needle.length()==0 && needle.equals(haystack) ){
			return "";
		}else if(needle.length()==0){
			return haystack;
		}else{
			int haystacklen = haystack.length();
			int needlelen = needle.length();
			for(int i=0;i<haystacklen;i++){
				if(haystacklen-i+1<needlelen){
					return null;
				}
				int k=i;
				int j=0;
				while( j<needlelen && k<haystacklen && haystack.charAt(k)==needle.charAt(j) ){
					j++;
					k++;
					if(j==needlelen){
						return haystack.substring(i);
					}
				}
			}
			return null;
		}
	}

		public static void main(String[] args) {
			
			String needle="abab";
			String haystack ="zzzzababazzz";
			System.out.println(findNeedle(haystack,needle));

		}
	
}