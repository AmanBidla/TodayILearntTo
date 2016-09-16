import java.util.Map;
import java.util.HashMap;

public class IsValidSuduku {

	public static void main(String[] args) {
		
		//char [][] board = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
		char [][] board = {"..4...63.".toCharArray(),".........".toCharArray(),"5......9.".toCharArray(),"...56....".toCharArray(),"4.3.....1".toCharArray(),"...7.....".toCharArray(),"...5.....".toCharArray(),".........".toCharArray(),".........".toCharArray()};
		System.out.println(another(board));

	}

	  

	public static boolean another(char [][] board){

		if (board == null || board.length != 9 || board[0].length != 9)
		return false;
 		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					System.out.println(" (int) (board[i][j] - '1') "+((int) (board[i][j] - '1'))+" m[(int) (board[i][j] - '1')] "+(m[(int) (board[i][j] - '1')]));
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	 
		//check each  row
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	 
		//check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (m[(int) (board[i][j] - '1')]) {
							return false;
						}
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
	 
		return true;
	}
 
         
   

}

 