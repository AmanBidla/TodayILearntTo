public class AllSubsetsOfArray {


	public static void allSubsets(int[] cArray){

		int [] array = new int[cArray.length];
		allSubsets(array,cArray,0);
	}

	private static void allSubsets(int[]array,int []cArray, int k){

		if(k==array.length){
			print(array,cArray);
		}else{
			allSubsets(array,cArray,k+1);
			array[k]=1;
			allSubsets(array,cArray,k+1);
			array[k]=0;
		}
	}

	private static void print(int[] array,int[]cArray){
		System.out.print("{");
		for(int i=0;i<array.length;i++){
			if(array[i]==1){
				System.out.print(cArray[i]+" ");
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		
		int [] array = {1,2,3};
		allSubsets(array);
	}
}