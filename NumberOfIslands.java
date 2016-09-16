public class NumberOfIslands{
	

	public static void main(String[] args) {
		

		int [][] matrix ={		{1, 1, 0, 0, 0},
		                        {0, 1, 0, 0, 1},
		                        {1, 0, 0, 1, 1},
		                        {0, 0, 0, 0, 0},
		                        {1, 0, 1, 0, 1}
		                  };
 		 


		System.out.println( connected(matrix));
	}

	public static boolean isSafe(int i, int j,int [][] matrix, boolean[][] visited){

		return i>=0 
					&& i<matrix.length 
					&& j>=0 
					&& j<matrix[0].length
					&& !visited[i][j]
					&& matrix[i][j]==1;
  
	}


	public static void DFS(int [][] matrix, int i, int j, boolean [][] visited){
 
			visited[i][j]=true;

			if (isSafe(i+1,j,matrix,visited)){
				DFS(matrix,i+1,j,visited);
			}

			if (isSafe(i-1,j,matrix,visited)){
				DFS(matrix,i-1,j,visited);
			}
			if (isSafe(i,j+1,matrix,visited)){
				DFS(matrix,i,j+1,visited);
			}
			if (isSafe(i,j-1,matrix,visited)){
				DFS(matrix,i,j-1,visited);
			}
 

	}

	public static  int connected(int [][] matrix){

		int count=0;

		int M = matrix.length;
		int N = matrix[0].length;

		boolean [][] visited = new boolean[M][N];	

		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {

				if(!visited[i][j] && matrix[i][j]==1){
					System.out.println("visiting ("+i+","+j+")");
					DFS(matrix,i,j,visited);
					count++;					
				}
			}
		}

		return count;
	}





}