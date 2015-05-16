public class BuySellStock{


	public static int profit(int [] array){

		int profit=0;
		int minElement = Integer.MAX_VALUE;
		int N = array.length;
		int sell=0, buy=0;
		for(int i=0;i<N;i++){

			//profit= Math.max( profit, array[i]-minElement);
			//minElement= Math.min( array[i], minElement);
			int diff = array[i]-minElement;
			if(diff>profit){
				sell=array[i];
				profit=diff;
			}
			minElement= Math.min( array[i], minElement);	 

		}

		System.out.println("buy at "+minElement+" and sell at "+sell);
		return profit;
	}


	public static void main(String[] args) {
		
		int [] array={80, 2, 6, 3, 100};
		System.out.println( profit(array));
	}
	
}