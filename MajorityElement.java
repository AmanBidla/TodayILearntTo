public class MajorityElement {


	private static int findMajorityElementCandidateIndex(int [] array){

		if(array == null || array.length==0) return -1;
		int majIndex =0, count=0;
		for(int i=0;i<array.length;i++){


			if(array[i] == array[majIndex]) count++;
			else count--;

			if(count<=0) majIndex =i;
		}

		return majIndex;

	}

	private static void showMajorityCandidate(int [] array){

		int index = findMajorityElementCandidateIndex(array);
		if(index != -1){

			if(isCandidateAppearingMoreThanHalfNumberOfTimes(array,index)){
				System.out.println(array[index]);
			}else{
				System.out.println("NONE");
			}
		} else{
			System.out.println("NONE");
		}
	}

	private static boolean isCandidateAppearingMoreThanHalfNumberOfTimes(int [] array, int index){
		int count=0;
		for(int i=0;i<array.length;i++){

			if(array[i]==array[index]) count++;
			if(count > (array.length/2)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		int [] array ={3,3,4,2,4,4,2,4,4};
		showMajorityCandidate(array);

		int [] anotherArray ={3,3,4,2,4,4,2,4};
		showMajorityCandidate(anotherArray);
	}

}