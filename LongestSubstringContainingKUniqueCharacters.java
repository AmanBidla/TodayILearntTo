import java.util.Arrays;

public class LongestSubstringContainingKUniqueCharacters{

	static final int MAX_CHARS = 26;

	public static void main(String[] args) {
		
		String S="aaaaabbaaac";
		//String S="aabbcc";
		System.out.println(longest(S,2));
	}

	//bbbcccbdddadacb
	//bcbbbbcccb

	//bcbbbbcccb

	//aaaaabbaaa
	//aaaaabbaaa

	public static String longest(String S, int K){
		int N = S.length();
		int [] count = new int[MAX_CHARS];
		int u=0;
		for(int i=0;i<N;i++){

			 int index = S.charAt(i)-'a';
			 if(count[index]==0){
			 	u++;
			 	count[index]++;
			 }else{
			 	count[index]++;
			 }
		}


		if(u<K) return null;

		Arrays.fill(count,0);

		count[(S.charAt(0)-'a')]++;

		int left=0,right=0;
		int leftMax=0,rightMax=0;

		for(int i=1;i<N;i++){

			int index = S.charAt(i)-'a';
			count[index]++;
			right++;

			while(!isValid(count,K)){				 
				count[(S.charAt(left)-'a')]--;
				left++;				
			}

			if(((right-left)+1) > rightMax){
				rightMax = (right-left)+1;
				leftMax = left;
			}
		}

		return S.substring( leftMax, rightMax);
		 	
	}

	public static boolean isValid(int [] count, int K){

		int val=0;
		for(int i=0;i<MAX_CHARS;i++){
			if(count[i]>0){
				val++;
			}
		}

		return K>=val;
	}

}