 import java.util.List;
import java.util.ArrayList;

public class PalindromicSubstring{

	public static void main(String[] args) {
		
		String s="aab";
		s="forgeeksskeegfor";
		s="geeks";
		s="nitin";
		List<String> result = palindromicSubstring(s);
		for(String ss:result){
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
}