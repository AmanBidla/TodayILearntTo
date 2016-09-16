public class NumberOfIslandsUnionFind {



	public static int numberOfIslands(int [][] matrix){

		int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		int [] roots = new int[matrix.length*matrix[0].length];
		int [] size = new int [matrix.length*matrix[0].length];
		
		for(int i=0;i<roots.length;i++){
			roots[i] = -1;
		}
		int count=0;

		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==1) {
					int root = i*matrix[0].length+j;
					roots[root] =root;
					count++;
					for(int []dir : dirs){
						int x = dir[0]+i;
						int y = dir[1]+j;
						int nb = (x*matrix[0].length)+y;
						if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length || roots[nb]==-1){
							continue;
						}
						int rootsNb = union(roots,nb);
						if(root != rootsNb) {
							roots[root] = rootsNb;
							root = rootsNb;
							count--;
						}
					}
				}
			}			
		}
		return count;
	}

	private static int union(int[]roots, int id){

		while(roots[id] != id){

			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}

	public static void main(String[] args) {
		
		/*int [][] matrix ={		{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                  };*/

        int [][] matrix ={
        	{1,1,0,0,0},
        	{1,1,0,0,0},
        	{0,0,1,0,0},
        	{0,0,0,1,1}
        };

         
        System.out.println(numberOfIslands(matrix));          
	}

	
}