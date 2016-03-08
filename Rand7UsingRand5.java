public class Rand7UsingRand5 {


	private static int rand7(){

		int x = rand5() * 4 + rand5() * 2 + 1 * rand5();
		if ( x == 7) {
			return rand7();
		} else {
			return x;
		}
	}

	private static int rand5(){

		int x = getRandom5();
		if(x==4) {
			return rand5();
		} else {
			return x%2;
		}
	}

}