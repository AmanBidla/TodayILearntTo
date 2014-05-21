public class AllPathOfMatrix{
	
	public static void main(String args[]) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		printpaths(matrix);
	}



	public static void printpaths(int[][] matrix) {	
		int[] path = new int[matrix.length];
		for (int i = 0; i < matrix[0].length; i++)
			printpaths(matrix, path, 0, 0, i);
	}
	
	private static void printpaths(int[][] matrix, int[] path, int index, int row, int column) {
		path[index++] = matrix[row][column];
		row++;
		if (row == matrix.length)
			print(path);
		else if (row < matrix.length) {
			for (int i = column - 1; i <= column + 1; i++)
				if (i > -1 && i < matrix[0].length)
					printpaths(matrix, path, index, row, i);
		}
	}
	
	private static void print(int[] path) {
		for (int i = 0; i < path.length; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
}