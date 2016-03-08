public class HouseRobber2 {


	private static int findMax(int []nums){

		 int N = nums.length;
		if(N==0) {
			return 0;
		}
		else if(N==1) {
			return nums[0];
		}else {
			
			int [] maxCashAfterLeavingIthHouseStartingAt_ZerothHouse = new int[N+1];
			maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[0]=0;
			maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[1]=nums[0];
			for(int i=2;i<N;i++){
			   maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[i] = Math.max( maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[i-1], maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[i-2]+nums[i-1]);
			}
			
			int [] maxCashAfterLeavingIthHouseStartingAt_FirstHouse = new int[N+1];
			maxCashAfterLeavingIthHouseStartingAt_FirstHouse[0]=0;
			maxCashAfterLeavingIthHouseStartingAt_FirstHouse[1]=nums[1];
			for(int i=2;i<N;i++){
			   maxCashAfterLeavingIthHouseStartingAt_FirstHouse[i] = Math.max( maxCashAfterLeavingIthHouseStartingAt_FirstHouse[i-1], maxCashAfterLeavingIthHouseStartingAt_FirstHouse[i-2]+nums[i]);
			}
			
			return Math.max(maxCashAfterLeavingIthHouseStartingAt_FirstHouse[N-1],maxCashAfterLeavingIthHouseStartingAt_ZerothHouse[N-1]);
						
		}
     
	}

	 

	public static void main(String[] args) {
		
		int []A ={1,1,1};
		System.out.println( findMax(A));
		int []B ={0,0};
		System.out.println( findMax(B));
		
		int []C ={1,1,1,1};
		System.out.println( findMax(C));
	}


}