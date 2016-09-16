public class CollectedRainFall {


	public static int collectedRainFall(int [] array) {

		int N = array.length;

		int [] highestToRight  = new int[N+1];
		for(int i=0;i<N;i++) {
			highestToRight[i] = array[i];
		}

		for(int i=N-1;i>=0;i--){
			highestToRight[i] = Math.max( highestToRight[i], highestToRight[i+1]);
		}

		int collected=0;
		int highestToLeft =0;

		for(int i=0;i<N;i++){
			collected += Math.max(0, Math.min(highestToLeft, highestToRight[i])-array[i]);
			highestToLeft = Math.max(highestToLeft, array[i]);
		}

		return collected;
	}

	public static void main(String[] args) {
		
		//int [] array = {2, 4, 2, 2, 5, 1, 2, 2, 1, 3};
		int [] array = {1, 2, 3, 2, 1};
		System.out.println( collectedRainFall(array));
	}
}