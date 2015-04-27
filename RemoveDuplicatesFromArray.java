import java.util.Arrays;

public class RemoveDuplicatesFromArray{

	public static void main(String[] args) {
		int [] array = {1,1,1,2,2,3,4,4,5,5,5,5,5,6,7,7,8};
		//int [] array = {0,1,1,1,2,2,3};
		//int [] array = {1,1,2};
		int N = remove(array);
		
		int [] newarray = new int[N];
		for(int i=0;i<N;i++){
			newarray[i]=array[i];
		}
		System.out.println(Arrays.toString(newarray));

	}

	public static int remove(int [] A){

		int prev=0;
		int curr=1;
		int N = A.length;

		while(curr<N){

			if(A[curr]==A[prev]){
				curr++;
			}else{
				prev++;
				A[prev]=A[curr];
				curr++;
			}
		}

		return prev+1;
	}
}