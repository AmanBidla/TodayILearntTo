public class LongestSubstringContainingNonRepeatingCharacters{


	public static void main(String[] args) {
		

		//String S ="GEEKSFORGEEKS";
		//String S ="ABDEFGABEF";
		//String S="rbmbibybvbsbtbvbibyb";
		//String S="abcabcbb";
		//String S="bbbbb";
		//String S="abcda";
		String S="abcabc";

		System.out.println( max(S));
	}

	public static int max(String S){

		int N = S.length();
		int currLen = 1;
		int maxLen =1;
		int prevIndex;
		int leftIndex=0;
		int [] count = new int [256];
		
		for(int i=0;i<256;i++){
			count[i]=-1;
		}


		count[S.charAt(0)]=0;


		for(int i=1;i<N;i++){

			prevIndex = count[S.charAt(i)];

			if(prevIndex==-1 || (i-currLen)>prevIndex){
				currLen++;
			}else{

				if(currLen>maxLen){
					maxLen=currLen;
				}
				currLen=i-prevIndex;				
				leftIndex=i-currLen;
			}
			//System.out.println("i "+i+" prevIndex "+prevIndex+" currLen "+currLen+" maxLen "+maxLen+" leftindex "+leftIndex);
			//System.out.println("substring from currLen "+S.substring());
			count[S.charAt(i)]=i;
		}

		if(currLen>maxLen){
			maxLen=currLen;
		}

		if(maxLen!=currLen)
		//System.out.println("leftIndex "+ leftIndex+" String " +S.substring(currLen,maxLen+currLen));
			leftIndex = maxLen-currLen-1;

		System.out.println("leftIndex "+ leftIndex+" String " +S.substring(leftIndex,(leftIndex+maxLen)));
		return maxLen;

	}

}