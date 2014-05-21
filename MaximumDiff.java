public class MaximumDiff{


	private static int maxDiffSugionline(int arr[]){

		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for(i = 1; i < arr.length; i++)
		{
		if(arr[i] - min_element>max_diff)
		max_diff = arr[i]-min_element;
		if(arr[i] < min_element)
		min_element = arr[i];
		}
		return max_diff;
	}
	 

	private static int  maxDiff(int[] array){
		int N = array.length;
		int [] minL = new int[N];
		int [] maxR = new int[N];

		minL[0]=array[0];
		for(int i=1;i<N;++i)
			minL[i]=Math.min(array[i],minL[i-1]);


		maxR[N-1]= array[N-1];
		for(int j=N-2;j>=0;--j)
			maxR[j]=Math.max(array[j],maxR[j+1]);

		int i=0,j=0,maxDiff = -1;

		while(i<N && j<N){

			if(minL[i]<maxR[j]){
				maxDiff = Math.max(maxDiff,Math.abs(j-i));
				j=j+1;
			}else{
				i=i+1;
			}
		}
		System.out.println("max difference is "+maxDiff);
		return maxDiff;

	}

	 

	public static void main(String[] args) {
		int [] array1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int [] array2 = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		assert (maxDiff(array1)==6):" diff is not 6 ";
		assert (maxDiff(array2)==8):" diff is not 8 ";
		assert (maxDiffSugionline(array1)==6):" diff is not 6 but "+maxDiffSugionline(array1);
		assert (maxDiffSugionline(array2)==8):" diff is not 6 but "+maxDiffSugionline(array2);

	}


}