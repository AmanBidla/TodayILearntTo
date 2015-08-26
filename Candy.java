 public class Candy{


	public static void main(String[] args) {
		
		int [] ratings ={1,2,3,5,2,1};		 
		System.out.println( candyTwo(ratings));
	}

	public static int candyTwo(int [] array){

		int N = array.length;

		int [] left = new int[N];
		left[0]=array[0];

		for(int i=1;i<N;i++){
			if(array[i-1]<array[i]){
				left[i]=left[i-1]+1;
			}else{
				left[i]=1;
			}
		}

		int [] right = new int[N];
		right[N-1]=array[N-1];

		for(int i=N-2;i>=0;i--){			 
			if(array[i]>array[i+1]){
				right[i]=right[i+1]+1;
			}else{
				right[i]=1;
			}
		}

		int result=0;
		for(int i=0;i<N;i++){
			result+=Math.max(left[i],right[i]);
		}

		return result;

	}


}