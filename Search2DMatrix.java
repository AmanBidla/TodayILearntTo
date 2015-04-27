public class Search2DMatrix{

	public static void main(String[] args) {
		
		int [][] matrix={	{1, 3, 5, 7},
							{10, 11, 16, 20},
							{23, 30, 34, 50}
						};

		System.out.println( search(matrix,3));

	}

	public static boolean search(int[][] matrix, int target){

		int row = 0;
		int col = matrix[0].length-1;
		while( row>=0 && col>=0 && row<matrix.length && col<matrix[0].length){

			int elem = matrix[row][col];
			if(elem==target) return true;
			else if(elem>target) col--;
			else row++;
		}

		return false;

	}

}