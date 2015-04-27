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

	public static boolean isValid(int x, int y,int [][] matrix){

		return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length;

	}


	public static void DFS(int [][] matrix, int x, int y, boolean [][] visited){

		if( !isValid(x,y,matrix)) return ;
		if( matrix[x][y]==0) return;
		if( visited[x][y]) return ;

		visited[x][y]=true;
		//System.out.println(">>>> visited  ("+x+","+y+") and matrix at "+matrix[x][y]);
		DFS(matrix,x+1,y,visited);
		DFS(matrix,x-1,y,visited);
		DFS(matrix,x,y-1,visited);
		DFS(matrix,x,y+1,visited);
		DFS(matrix,x+1,y+1,visited);
		DFS(matrix,x-1,y-1,visited);
		DFS(matrix,x+1,y-1,visited);
		DFS(matrix,x-1,y+1,visited);
		 
	}

	public static  int connected(int [][] matrix){

		int count=0;
		int M = matrix.length;
		int N = matrix[0].length;

		boolean [][] visited = new boolean[M][N];		 
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){

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