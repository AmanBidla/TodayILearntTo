public class AllSubsets{

	public static void main(String[] args) {
		int [] array = {1,2,3};
		int [] subsets = new int[array.length];
		subsets(array,0, subsets,0);
	}

	public static void subsets(int[] array, int read, int [] subset, int write){

		if(read == array.length){
			System.out.print("{");
			for(int i=0;i<write;i++){
				System.out.print(subset[i]);
				if(i+1 != write){
					System.out.print(",");
				}
			}
			System.out.println("}");
		}else{

			subsets(array,read+1,subset,write);
			//subset[write++] = array[read++];
			subset[write]=array[read];
			subsets(array,read+1,subset,write+1);
		}
	}
}