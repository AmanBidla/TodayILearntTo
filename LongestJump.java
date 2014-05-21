import java.util.Arrays;
public class LongestJump {


	private static int longstJump ( int [] array){

		int N = array.length;
		int [] dp = new int[N];
		int [] prev = new int[N];
		dp[0]=0;
		prev[0]=1;
		int ans=0;

		for( int i=1;i<N;i++){
			dp[i]=Integer.MAX_VALUE-1;
			for(int j=0;j<i;j++){
				if(array[j]>=(i-j)){
					if(dp[j]+1<dp[i]){
						dp[i]=1+dp[j];
						prev[j]=i;
					}
				}

				if(dp[j]>dp[ans]){
					ans=j;
				}
			}
		}

		int max=0;
		for(int i=0;i<N;i++){
			max=Math.max(max,dp[i]);
		}

		int []seq = new int [max];
		int L = max;
		int j=N-1;
		for(int i=L-1;i>=0;i--){
			seq[i]=array[j];
			j = dp[j]-1;
		}
		System.out.println(Arrays.toString(seq));



 
		return max;
	}

	public static void main(String[] args) {
		int answer;
		int [] array ={2,3,1,1,4};
		System.out.println("input is "+Arrays.toString(array));
		answer =longstJump(array);
		assert(answer==2);
		System.out.println(answer);
	}

}