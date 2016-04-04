 import java.util.List;
import java.util.ArrayList;

public class PalindromicSubstring{

	public static void main(String[] args) {
		
		String s="aab";
		s="forgeeksskeegfor";
		s="geeks";
		s="nitin";
		// use palindromicDecomposition() method not below
		List<String> result = palindromicSubstring(s);
		// use palindromicDecomposition function. its easier to understand
		for(String ss:palindromicDecomposition(s)){
			System.out.println(ss);
		}
	}

	public static List<String> palindromicSubstring(String S){

		List<String> result = new ArrayList<String>();

		if(S==null) return result;

		int N = S.length();

		if(N<=1){
			result.add(S);
			return result;
		}

		int [][] dp = new int[N][N];

		for(int k=1;k<=N;k++){
			for(int i=0;i<=N-k;i++){
				int j=i+k-1;				 
				System.out.println(" k "+k+" i "+i+" j "+(i+k-1));
				System.out.println(S.charAt(i)+" & "+S.charAt(j));
				if(S.charAt(i)==S.charAt(j)){

					if(k==1 || k==2){
						dp[i][j]=1;
					}else{
						dp[i][j]= dp[i+1][j-1];
					}

					if(dp[i][j]==1){
						System.out.println(">>> "+S.substring(i,j+1));
						result.add(S.substring(i,j+1));
					}
				}else{
					dp[i][j]=0;
				}
			}
		}

		return result;
	}



	/////////////////////////

	// USE BELOW CODE    ///

	///////////////////////


	static String[] palindromicDecomposition(String strInput) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> item = new ArrayList<String>();
        palindrome(strInput.toCharArray(),result,item,0);
        return convertToArray(result);
    }

    private static String[] convertToArray(List<List<String>> result) {
        
        String[] array = new String[result.size()];
        for(int i=0;i<result.size();i++){
            StringBuilder buf = new StringBuilder();
            for(int j=0;j<result.get(i).size();j++){
                buf.append(result.get(i).get(j)); 
                buf.append("|"); 
            }
            array[i]= buf.toString();
        }
        return array;
    }

    private static void palindrome(char[] array,List<List<String>> result,List<String> item, int index){
        
        if(index==array.length){
            result.add(new ArrayList<String>(item));
            return;
        }
        
        for(int i=index;i<array.length;i++){
            
            if(isPalindrome(array,index,i)){
                item.add(new String(array,index,i+1-index));
                palindrome(array,result,item,i+1);
                item.remove(item.size()-1);
            }
        }        
    }
     
    private static boolean isPalindrome(char[]array, int left, int right){
        while(left<right){
            if(array[left] != array[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}