import java.util.Arrays;

class Bucket{

	int low,hi;
	Bucket(int low, int hi){
		this.low=low;
		this.hi=hi;
	}
}
public class BucketSort{

	public static void main(String[] args) {
		
		int [] array ={2,5,3,1,4};
		int[] copyArray = array;
		System.out.println("result "+max(array));
		System.out.println("check "+check(copyArray));
	}
 
	public static int max(int [] array){

		int N = array.length;
		Bucket [] barray = new Bucket[N+1];
		for(int i=0;i<(N+1);i++){
			barray[i]= new Bucket(-1,-1);
		}
		int max= Integer.MIN_VALUE;
		int min= Integer.MAX_VALUE;
		for(int i=0;i<N;i++){

			max= Math.max(array[i],max);
			min= Math.min(array[i],min);
		}

		int bwidth = (int) N/(max-min);

		for(int i=0;i<N;i++){

			int index = (int) ((array[i] - min) * bwidth);
			System.out.println(index);
			Bucket b = barray[index];



			if(b.low == -1){
         		b.low = array[i];
         		b.hi = array[i];
      		}else{
         		b.low = Math.min(b.low, array[i]);
         		b.hi = Math.max(b.hi, array[i]);
			} 
		}	

   	  int result=0;
   	  int currHigh = barray[0].hi;

   	  for(int i=1;i<barray.length;i++){
   	  	Bucket b = barray[i];
   	  	if(b.low!=-1){
   	  		result = Math.max( result, b.low-currHigh);
   	  		currHigh= b.hi;
   	  	}
   	  }
     
		return result;



	}
}