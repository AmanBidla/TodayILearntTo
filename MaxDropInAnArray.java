public class MaxDropInAnArray{
	

	public static int maxDrop(int[]array){

		int maxDrop =0,drop=0,min=array[0],minI=0,maxI=0;

		for(int i=1;i<array.length;i++){

			if(array[i]<min){
				min=array[i];
				minI=i;
			}

			drop = array[i]-min;
			if(drop>maxDrop){
				maxDrop=drop;
				maxI=i;
			}

		}

		System.out.println(maxDrop);
		return maxDrop;

	}
	public static void main(String[] args) {
		
		int A[] = {5,10,4,6,12};
		System.out.println("max drop is "+maxDrop(A));

	}


}