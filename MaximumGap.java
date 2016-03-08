class Bucket{

	int low,  hi;
	Bucket(int low, int hi){
		this.low=low;
		this.hi=hi;
	}
}

public class MaximumGap {

	public static void main(String[] args) {
		
		//int [] array={5,9,8,3,15}; // should be 6		
		//System.out.println( maxGap(array));
		int [] array = {1,10000000};
		System.out.println( maxGap(array));

	}

	public static int maxGap(int [] array){

		int N = array.length;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=0;i<N;i++){
			min = Math.min(min,array[i]);
			max = Math.max(max,array[i]);
		}

		Bucket[] barray = new Bucket[N+1];
		for(int i=0;i<(N+1);i++){
			barray[i]=new Bucket(-1,-1);
		}

		double bwidth =   (double) N/(max-min);
		for(int i=0;i<N;i++){
			
			int index = (int) ((array[i]-min)*bwidth);
			Bucket b = barray[index];
			if(b.low==-1){
				b.low = array[i];
				b.hi = array[i];
			}else{
				b.low= Math.min( b.low, array[i]);
				b.hi = Math.max( b.hi, array[i]);
			}
		}

		int result =0;
		int currHigh= barray[0].hi;

		for(int i=1;i<(N+1);i++){

			Bucket b = barray[i];

			if(b.low!=-1){
				result= Math.max( result, b.low-currHigh);
				currHigh= b.hi;
			}
		}

		return result;
	}
}