public class FriendsCirclesDFS {


	 
	public static void main(String[] args) {
		
		String [] array = 
        {
        	"YYNN",
			"YYYN",
			"NYYN",
			"NNNY"
		};
		int N = 4;
		char [][] matrix = new char[N][N];
		for(int i=0;i<N;i++){
			matrix[i]= array[i].toCharArray();
		}

		solve(N,matrix);

	}
}