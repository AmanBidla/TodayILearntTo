import java.util.BitSet;

public class BitSETFindMissingInteger {
	
	private static void find (int [] array){
		int N = array.length;
		BitSet bits1= new BitSet(N+1);
		for(int i=0;i<N;i++){
			bits1.set(array[i]%(N+1));
		}
		int index=0;
		//System.out.println(bits1);
		for (int i=0;i<(N+1);i++) {
			
				 if(!bits1.get(i)){
				 	System.out.println("missing number :"+i);
				 }    			
 		}

	}
	
	public static void main(String[] args) {
		int []array ={2,100,4,3};
		find(array);
	}
}