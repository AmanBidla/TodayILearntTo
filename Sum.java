public class Sum{


	private static void sum(int [] array,int sum){

		int curr_sum = array[0], start=0;
		for(int i=1;i<array.length;i++){

			while(curr_sum>sum && start<i-1){
				curr_sum-=array[start];
				start++;
			}

			if(curr_sum==sum){
				System.out.println(" elements are "+array[start]+" and "+array[i-1]);
				
			}


			if(i<array.length){
				curr_sum+=array[i];
			}
		}

	}
	public static void main(String[] args) {
		
		int [] array ={2,5,5,3,7,1,8,0};
		sum(array,8);
	}

}