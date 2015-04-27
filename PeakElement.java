public class PeakElement{


	public static void main(String[] args) {
		
		int [] array ={1, 2, 3, 1};
		int index = findPeak(array);
		if(index!=-1){
			System.out.println(array[index]);
		}else{
			System.out.println("No such element");
		}

	}

	public static int findPeak(int []array){

		int N = array.length;
		int index=-1;
		int max=array[0];

		for(int i=1;i<N-1;i++){

			int prev = array[i-1];
			int curr = array[i];
			int next = array[i+1];

			if(prev<curr && curr>next && curr>max){
				max=curr;
				index=i;
			}
		}

		return index;

	}
}