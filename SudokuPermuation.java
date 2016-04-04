import java.util.Arrays;
public class SudokuPermuation {

	public static void main(String[] args) {
		
		//NQueens(5);
		int [][] board =  

		{
			{7,0,8,0,0,0,3,0,0}, 
			{0,0,0,2,0,1,0,0,0}, 
			{5,0,0,0,00,0,0,0}, 
			{0,4,00,0,0,0,2,6}, 
			{3,0,0,0,8,0,0,0,0}, 
			{0,0,0,1,0,0,0,9,0}, 
			{0,9,0,6,0,0,0,0,4}, 
			{0,0,0,0,7,0,5,0,0},
			{0,0,0,0,0,0,0,0,0}
	    };
		sudoku(board);
	}

	public static void sudoku(int[][] board){
		int [] array = new int[81];
		int k=0;		 
		System.out.println(" before "+Arrays.toString(array));
		sudoku(array,0,board)
	}

	private static void sudoku(int []array, int k,int [][] board){

		if(k==array.length){
			System.out.println(" sol "+Arrays.toString(array));
			return;
		}

		if(array[k]!=0){
			sudoku(array,k+1,board);
			return;
		}

		for(int i=1;i<=9;i++){
			array[k]=i;
			if(!canBackTrackSudoku(array,k,board)){
				sudoku(array,k+1,board);
			}			
		}

		array[k]=0;

	}

	private boolean canBackTrackSudoku(int [] array, int k,int [][] board){

		if(foundInRow(array,k,board) || foundInCol(array,k,board) || foundInBox(array,k,board)) return true;
		return false;

	}

	private boolean foundInRow(int [] array ,int k, int [][]board){
		 int row = k/9;		  
	 	for(int j=0;j<board.length;j++){
	 		if(board[row][j]==array[k]) return true;
	 	}		 
		 return false;
	}

	private boolean foundInCol(int [] array ,int k, int [][]board){
		int col = k%9;		  
	 	for(int j=0;j<board.length;j++){
	 		if(board[j][col]==array[k]) return true;
	 	}		 
		 return false;
	}

	private boolean foundInBox(int [] array, int k, int [][] board){
		
	}



	public static void NQueens(int N) {

		int [] array = new int[N];
		for(int i=0;i<N;i++){
			array[i]=i+1;
		}
		System.out.println(" before "+Arrays.toString(array));
		permute(array,0);
	}

	private static void permute(int []array, int i){		 
		if(i==array.length){
			System.out.println(" sol "+Arrays.toString(array));
		}else{
			for(int j=i;j<array.length;j++){
				swap(array,i,j);			 
				permute(array,i+1);			 
				swap(array,i,j);
			}
		}
	}

	private static boolean canBackTrack(int []array, int k){
		for(int i=0;i<k;i++){
			if((array[i]-array[k]) == (k-i)) {
				return true;
			}
			if((array[k]-array[i]) == (k-i)) {
				return true;
			}
		}
		return false;
	}

	private static void swap(int []array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}