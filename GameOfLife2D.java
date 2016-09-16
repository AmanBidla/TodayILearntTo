import java.util.Arrays;

public class GameOfLife2D {


	 public static int [][] gameOfLife(int[][] board) {
        
        int M = board.length;
		int N = board[0].length;

		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){

				int lives = searchNeighbour(i,j, board);

				if ((board[i][j]&1)==1){

					if(lives==2 || lives==3){
						board[i][j]=3;
					} else{
						board[i][j]=1;
					}
				} else {

					if(lives==3){
						board[i][j]=2;					
					} else {
						board[i][j]=0;
					}
				}
			}
		}
		
		board = nextMove(board);
		return board;
    }
    
    
    private  static int searchNeighbour(int i, int j, int[][] board) {

		int lives=0;
		int M = board.length;
		int N = board[0].length;

		for(int x=Math.max(i-1,0); x<Math.min(i+2,M);x++){
			for(int y=Math.max(j-1,0); y<Math.min(j+2,N);y++){
				if(x==i && y==j){
					continue;
				}
				if((board[x][y]&1)==1){
					System.out.println("x "+x+" y "+y);
					lives++;
				} else {
					System.out.println("(board[x][y]&1)==0  for x="+x+" y="+y);
				}
			}
		}

		return lives;
	}

	private static int[][] nextMove(int[][] board) {

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				board[i][j] >>=1;
			}
		}

		return board;
	}

	public static void main(String[] args) {
		
		int [][] board ={{1,1},{1,0}};

		int [][] result = gameOfLife(board);

		int [][] expected = {{1,1},{1,1}};

		System.out.print("expected : ");
		print(expected);
		System.out.print("result  : ");
		print(result);
		System.out.println("Assert expected is same as result is  "+Arrays.equals(result, expected));
  
	}

	private static void print(int [][] board) {

		System.out.print("{");
		for(int i=0;i<board.length;i++){
			System.out.print("{");
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]);
				if((j+1) != board[0].length) {
					System.out.print(",");
				}
			}
			System.out.print("}");
			if((i+1)!=board.length) {
				System.out.print(",");
			}
		}
		System.out.println("}");
	}

}