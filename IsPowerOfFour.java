public class IsPowerOfFour {


	public static boolean isPowerOfFour(int num){

		return (num>0) && ((num & num-1)==0)  && ((num&(0x55555555))==num);
	}

	public static void main(String[] args) {
		

		System.out.println("4 is power of "+isPowerOfFour(4));
		System.out.println("8 is power of "+isPowerOfFour(8));
		System.out.println("5 is power of "+isPowerOfFour(5));
		System.out.println("16 is power of "+isPowerOfFour(16));
	}
}