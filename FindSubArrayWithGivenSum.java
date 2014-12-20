public class  FindSubArrayWithGivenSum{


	private static void find(int []array, int sum){

		int N = array.length;
		int currSum =0;

		for(int i=0;i<N;i++){

			currSum=array[i];

			for(int j=i+1;j<=N;j++){

				if(currSum==sum){
					System.out.println("found between "+i+" and "+(j-1));
					return;
				}

				if(j==N ||  currSum>sum)
					break;

				currSum=currSum+array[j];

			}

		}

		System.out.println("not found");

	}


	public static void main(String[] args) {
		
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		int sum =23;
		find(arr,sum);
	}
}