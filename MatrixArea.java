public class MatrixArea {
	
	

	public static void main(String[] args) {
		
		
    	char[][] matrix = 
    	{{'0','0','0','0','0','0'},{'0','R','R','R','R','0'},{'0','R','0','0','R','0'},{'0','R','0','0','R','0'},{'0','R','R','R','R','0'},{'0','0','0','0','0','0'}};
    	//System.out.println(maxArea(matrix)-1);
    	 
    	char [][] newmatrix = 
    	{{'0','0','0','0','0','0','0','0','0'},
    	{'0','0','0','0','0','0','0','0','0'},
    	{'0','0','0','0','0','0','0','0','0'},
    	{'0','0','R','R','R','R','0','0','0'},
     	{'0','0','R','0','0','R','0','0','0'},
   		{'0','0','R','R','R','R','0','0','0'},
      	{'0','0','0','0','0','0','0','0','0'},
      	{'0','0','0','0','0','0','0','0','0'},
      	{'0','0','0','0','0','0','0','0','0'}};

      	System.out.println(maxArea(newmatrix));
 

    }
	private static int maxArea(char[][] matrix){

		int M = matrix.length;
		int N = matrix[0].length;
		int maxArea =0;
		boolean [][] used = new boolean[M][N];



		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){

				if(matrix[i][j]=='R' && !used[i][j]){
					int curArea = areaCal(matrix,i,j,used);
					if(curArea>maxArea){
						maxArea=curArea;
 					}
				}
			}
		}

		return maxArea;
	}

	private static int areaCal(char [][] matrix, int x, int y, boolean[][] used){

		int M = matrix.length;
		int N = matrix[0].length;
		if((x<0) || (y<0) || (x==M) || (y==N))
			return 0;
 		if(matrix[x][y]!='R')
			return 0;	
		//System.out.println("searching from "+x+" and "+y);
		int curArea=0;
		if((matrix[x][y]=='R') && !used[x][y]){
			curArea++;
			used[x][y]=true;
			char temp = matrix[x][y];
			matrix[x][y]='0';
			curArea = 1+  (areaCal(matrix, x+1,y,used) + areaCal(matrix, x-1,y,used) + areaCal(matrix, x,y+1,used) + areaCal(matrix, x,y-1,used));
			matrix[x][y]=temp;
			//System.out.println(curArea);
			return curArea;
		}

		return curArea;

	}

}