public class MakeChange{

	public static void main(String[] args) {
		System.out.println(makeChange(10,10));
	}

	public static int makeChange(int total, int denom){
		int next_denom=0;
		switch(denom){
			case 25:next_denom=10;
					break;
			case 10:next_denom=5;
					break;
			case 5:next_denom=1;
					break;
			case 1: return 1;
		}
		int totalways=0;
		for(int i=0;i*denom<=total;i++){
			totalways+=makeChange(total-i*denom,next_denom);
		}
		return totalways;

	}


}