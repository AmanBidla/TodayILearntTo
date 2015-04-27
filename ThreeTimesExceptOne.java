public class ThreeTimesExceptOne{

	public static void main(String[] args) {
			
		int [] array = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		System.out.println(threeTimesExceptOne(array));

	}

	private static int threeTimesExceptOne(int [] array){

		int ones=0, twos=0, bitMask=0;

		for(int i=0;i<array.length;i++){

			//System.out.println("ones = "+ones+" & array["+i+"] = "+(ones&array[i]));
			twos |= ones&array[i] ;
			//System.out.println("twos |= ones&array[i] " + twos);
			ones ^= array[i];
			//System.out.println("ones ^= array[i] " + ones);
			bitMask = (ones&twos);
			//System.out.println("bitMask = (ones&twos) " + bitMask);
			ones &= ~bitMask;
			//System.out.println("ones &= ~bitMask " + ones);
			twos &= ~bitMask;
			//System.out.println("twos &= ~bitMask " + twos);

		}

		return ones;

	}

}