public class SpiralMatrix{

	public static void main(String[] args) {
		
		

		int[][] matrix = {{2,3}};
		spiral(matrix);

		//expected 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		// output  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
				     
	}

	private static void testOne(){

		int [][] matrix ={{1, 2, 3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiral(matrix);
	}

	public static void spiral(int[][]matrix){

		int rowStart=0, rowEnd = matrix.length;
		int colStart=0, colEnd = matrix[0].length;
		System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd);
		System.out.println("colStart: "+colStart+" colEnd: "+colEnd);

		while(rowStart<rowEnd && colStart<colEnd){

			for(int i=colStart;i<colEnd;++i){
				System.out.printf("%d ", matrix[rowStart][i]);				
			}
			rowStart++;

			for(int i=rowStart;i<rowEnd;++i){
				System.out.printf("%d ", matrix[i][colEnd-1]);
			}
			colEnd--;

			if(rowStart<rowEnd){
				for(int i=colEnd-1;i>=colStart;--i){
					System.out.printf("%d ", matrix[rowEnd-1][i]);
				}
				rowEnd--;				
			}

			if(colStart<colEnd){
				for(int i=rowEnd-1;i>=rowStart;--i){
					System.out.printf("%d ", matrix[i][colStart]);
				}
				colStart++;
			}

		}

	}
}