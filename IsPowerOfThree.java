public class IsPowerOfThree {


	public static boolean isPowerOfThree(int num) {

		return (Math.log10(num)/Math.log10(3)) %1 ==0;
	}

	public static void main(String[] args) {
		

		System.out.println("3 is power of 3 "+ isPowerOfThree(3));
		System.out.println("5 is power of 3 "+ isPowerOfThree(5));
		System.out.println("9 is power of 3 "+ isPowerOfThree(9));
	}
}