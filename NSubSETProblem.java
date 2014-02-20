import java.util.Arrays;
public class NSubSETProblem{


	private static int [] findSum (int [] array){

		int N = array.length;
		int [] prefixSum = array;
		for(int i=0;i<N;i++){
			prefixSum[i]+=(i>0)?prefixSum[i-1]:0;
			prefixSum[i]%=N;
		}

		System.out.println(Arrays.toString(prefixSum));

		int []table = new int[N];
		for(int i=0;i<N;i++)
			table[i]=-1;
		for(int i=0;i<N;i++){
			if(prefixSum[i]==0){
				int [] ans = new int[i+1];
				System.out.println("filling with 0,1,.. for size of "+(i+1));
				fill(ans,0);
				return ans;
			}else if(table[prefixSum[i]]!=-1){
				int [] ans = new int[i- table[prefixSum[i]]];
				System.out.println("filling with "+table[prefixSum[i]]+"... for size of "+(i- table[prefixSum[i]]));
				fill(ans,table[prefixSum[i]]+1);
				return ans;
			}
			table[prefixSum[i]]=i;
		}

		System.out.println("returning array only");
		return array;
	}

	private static void fill(int [] array, int value){
		for(int i=0;i<array.length;i++){
			array[i]=value;
			value++;
		}
	}

	public static void main(String[] args) {
		
		int [] array = {1,2,3};
		int [] ans= findSum(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(ans));


	}
 }