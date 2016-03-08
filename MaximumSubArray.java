public class MaximumSubArray{

	public static void main(String[] args) {
			
		//int [] array = {904,40,523,12,-355,-385,-124,481,-31};
		int [] array ={-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(find(array));
	}


	public static int find(int [] array){

		int maxTillNow=array[0],maxSumSoFar=array[0];
		int tempBegin =0, begin=0, end=0;

		for(int i=1;i<array.length;i++){

			if(maxTillNow<0){
				maxTillNow=array[i];
				tempBegin=i;
			}else{
				maxTillNow+=array[i];
			}
			if(maxSumSoFar<=maxTillNow){
				maxSumSoFar = maxTillNow;
				begin =tempBegin;
				end =i;
			}

		}
		return maxSumSoFar;

	}

}