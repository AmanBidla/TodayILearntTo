import java.util.Arrays;

public class LongestIncreasingSubsequenceUsingBinarySearch {


	public static int binarySearch(int []array, int end, int key, int[] dp){
		int start=0;
		int N = end;
		while(start<=end){

			int mid = (start+end)/2;
			if(mid<N && array[dp[mid]]<key && key<array[dp[mid+1]]){
				return mid+1;
			}else if(array[dp[mid]]<key){
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
		return -1;
	}


	public static int[] longestIncreasingSubsequenceUsingBinarySearch(int[]array){

		int N = array.length;
		int []dp = new int[N];
		int []prev = new int[N];
		for(int i=0;i<N;i++){
			prev[i]=-1;
		}

		int len=0;
		dp[0]=0;

		for(int i=1;i<N;i++){

			if(array[dp[0]]>array[i]){
				dp[0]=i;
			}else if(array[dp[len]]<array[i]){
				len++;
				dp[len]=i;
				prev[dp[len]]=dp[len-1];
			}else{

				int pos = binarySearch(array,len,array[i],dp);
				dp[pos]=i;
				prev[dp[pos]]=dp[pos-1];
			}
		}

		int[] sol = new int[len+1];
		for(int j=len,i=dp[len];i!=-1;j--,i=prev[i]){
			sol[j]=array[i];
		}

		return sol;
	}

	public static void main(String[] args) {
		
		int []array = {200, 5, 3, 7, 11, 8, 10, 13, 6};
		System.out.println(Arrays.toString(array));
		int [] sol = longestIncreasingSubsequenceUsingBinarySearch(array);
		System.out.println(Arrays.toString(sol));
	}


} 