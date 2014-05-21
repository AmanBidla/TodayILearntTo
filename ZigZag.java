public class ZigZag{
	
	
	private static int solution(int []array){
		int N = array.length;
		int up[] = new int[N];
		int down[] = new int[N];
		int bestLength=1;

		for(int i=0;i<N;i++){
			up[i]=1;
			down[i]=1;
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<i;j++){

				if(array[i]>array[j] ){
					up[i]= Math.max(down[j]+1,up[i]);
				}else if(array[i]<array[j]){
					down[i]= Math.max(up[j]+1,down[i]);
				}
			}
 		}

 		for(int i=0;i<up.length;i++){
 			bestLength= Math.max(bestLength,up[i]);
 		}

 		for(int i=0;i<down.length;i++){
 			bestLength= Math.max(bestLength,down[i]);
 		}

		return bestLength;
	}	


	public static void main(String[] args) {
		

		test();

	}

	public static void test(){

	int []array= { 1, 7, 4, 9, 2, 5 };
	int best = solution(array);
	System.out.println("best is "+best);
	assert(best==6);

	int []array2 ={ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
	best = solution(array2);
	System.out.println("best is "+best);
	assert(best==7);

	int []array3 ={ 44 };
	best = solution(array3);
	System.out.println("best is "+best);
	assert(best==1);



	int []array4 ={ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	best = solution(array4);
	System.out.println("best is "+best);
	assert(best==2);






	}

}