public class HouseRobber{

	public static void main(String[] args) {
		
		int [] array={2, 1, 5, 10, 25};
		System.out.println(max(array));	
	}


	public static int max(int [] array){
		int N = array.length;
		int [] dp = new int[N+1];
		dp[0]=0;
		dp[1]=array[0];
		for(int i=2;i<=N;i++){

			dp[i]= Math.max( dp[i-1], dp[i-2]+array[i-1]);
		}
		return dp[N];

	}

}