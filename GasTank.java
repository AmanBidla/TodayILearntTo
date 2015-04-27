public class GasTank{


	public static void main(String[] args) {

		int [] gas ={1,2,3,4,5};
		int [] cost={1,3,2,4,5};
		System.out.println( canGo(gas,cost));
		System.out.println( canGoFromHere(gas,cost));

	}

	public static int canGoFromHere(int [] gas, int[] cost){

		int N = gas.length;
		int totalGasConsumed=0;
		int start=-1;

		for(int i=0;i<N;i++){

			int currentGasInGasTank = gas[i]-cost[i];
			if(currentGasInGasTank <0){
				start=i;
			}
			totalGasConsumed+=currentGasInGasTank;
		}

		if(totalGasConsumed>=0) return start;
		else return -1;
	}

	public static int canGo(int []gas, int[] cost){

		int totalgas=0;
		int totalcost=0;
		int N = gas.length;

		for(int i=0;i<N;i++){
			totalgas+=gas[i];
			totalcost+=cost[i];
		}

		if(totalgas>totalcost) return -1;

		int total=0;
		int start=0;
		totalgas =0;

		for(int i=0;i<N;i++){

			int remaining = gas[i]-cost[i];
			if(remaining>=0){
				totalgas+=remaining;
			}else{
				totalgas=remaining;
				start=i;
			}
			total+=remaining;
		}

		// very important that total greater than or equal to zero
		if(total>=0){
			return start;
		}else{
			return -1;
		}



	}
}