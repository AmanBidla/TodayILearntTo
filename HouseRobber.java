public class HouseRobber{

	public static void main(String[] args) {
		
		int [] array={2, 1, 5, 10, 25};
		System.out.println(max(array));	
	}


	public static int max(int [] array){
		int N = array.length;
		int [] cashAfterLeavingIthHouse = new int[N+1];
		cashAfterLeavingIthHouse[0]=0;
		cashAfterLeavingIthHouse[1]=array[0];
		for(int i=2;i<=N;i++){

			cashAfterLeavingIthHouse[i]= Math.max( cashAfterLeavingIthHouse[i-1], 
												   cashAfterLeavingIthHouse[i-2]+array[i-1]);
		}
		return cashAfterLeavingIthHouse[N];
	}

}