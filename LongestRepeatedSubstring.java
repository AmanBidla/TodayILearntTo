import java.util.Arrays;

public class LongestRepeatedSubstring{
	
	public static void main(String[] args) {
		//String s ="abcdefabcfight";
		String s ="abcabcbb";
		String result = lcs(s);
		assert(result.equals("abc")):" incorect result is "+ lcs(s);
		System.out.println("result is "+result);

	}

	private static String lcs(String s){

		if( (s==null) || (s.length()==0)) return null;
		int N = s.length();
		String [] suffixes = new String[N];
		for(int i=0;i<N;i++){
			suffixes[i]=s.substring(i,N);
			//System.out.println(suffixes[i]+" is suffix");
		}
		String lcs="";
		Arrays.sort(suffixes);
		for(int i=0;i<N-1;i++){
			String x = lcp(suffixes[i],suffixes[i+1]);
			if(x!=null && x.length()>lcs.length()){
				lcs=x;
			}
		}
		return lcs;
 	}

 	private static String lcp(String s,String t){
 		if((s==null) || (t==null) || (s.length()==0) || (t.length()==0)) return null;
 		int N =Math.min(s.length(),t.length());
 		for(int i=0;i<N;i++){
 			if(s.charAt(i)!=t.charAt(i)) return s.substring(0,i);
 		}
 		return s.substring(0,N);
 	}

}