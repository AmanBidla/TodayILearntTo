public class TextJustificationCopy {



	public static String justify(String []array, int width){


		int N = array.length;
		int[][] cost = new int[N][N];
		calculateCostOfPuttingWordsInOneLine(array,width,cost);

		int [] minCost = new int[N];
		int [] result = new int[N];

		for(int i=N-1;i>=0;i--){

			minCost[i]=cost[i][N-1];
			result[i] = N;
			for(int j=N-1;j>i;j--){
				if(cost[i][j-1]==Integer.MAX_VALUE){
					continue;
				}
				if(minCost[i]>minCost[j]+cost[i][j-1]){
					minCost[i] =minCost[j] +cost[i][j-1];
				}
			}
		}

		int i=0,j=0;
		StringBuilder buf = new StringBuilder();
		do{
			j= result[i];
			for(int k=i;k<j;k++){
				buf.append(array[k]);
				if((k+1)!=j){
					buf.append(" ");
				}
			}
			buf.append("\n");
			i=j;
		}while(j<N);

		return buf.toString();
	}

	public static void calculateCostOfPuttingWordsInOneLine(String []array, int width, int [][]cost) {

		int N = array.length;

		for(int i=0;i<N;i++){
			cost[i][i] = width-array[i].length();
			for(int j=i+1;j<N;j++){
				cost[i][j]=cost[i][j-1]-array[j].length()-1;
			}
		}

		for(int i=0;i<N;i++){
			for(int j=i;j<N;j++){
				if(cost[i][j]<0){
					cost[i][j] = Integer.MAX_VALUE;
				}else{
					cost[i][j] = cost[i][j] * cost[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		String array[] = {"Tushar","likes","to","write","code","at", "free", "time"};
		System.out.println( justify(array,12));

	}

}