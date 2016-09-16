public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
         solve(0,0,board);
    }
    
    private static boolean solve(int i, int j,char[][] board){
        
        if(i==board.length){
            i=0;
            if(++j==board[i].length){
                return true;
            }
        }
        
        
        if(board[i][j]!='.'){
            return solve(i+1,j,board);
        }
        
        for(char val='1';val<='9';val++){
            if(!isInvalid(val,i,j,board)){
                board[i][j]=val;
                if(solve(i+1,j,board)){
                    return true;
                }
            }
        }
        board[i][j]='.';
        return false;
    }
    
    private static boolean isInvalid(char val, int r, int c, char[][] board){
        for(int i=0;i<board[r].length;i++){
            if(board[r][i]==val){
                return true;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][c]==val){
                return true;
            }
        }
        int region =(int) Math.sqrt(board.length);
        int I = r/region;
        int J = c/region;
        for(int a=0;a<region;a++){
            for(int b=0;b<region;b++){
                if(board[I*region+a][J*region+b] == val){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    	
    	String [] arrayString = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	char [][] board = new char[9][9];
    	for(int i=0;i<arrayString.length;i++){
    		board[i]= arrayString[i].toCharArray();    		
    	}
    	solveSudoku(board);
    	print(board);
    }

    private static void print(char [][] board){
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    }
}