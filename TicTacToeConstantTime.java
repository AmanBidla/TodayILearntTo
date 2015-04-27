public class TicTacToeConstantTime{



	private static final int MSIZE=-3;
	private static final int SIZE=3;
	private static int diag=0;
	private static int antiDiag=0;


	private static int rows[]= new int[SIZE];
	private static int cols[]= new int[SIZE];

	public static void init(int [][] matrix){

		for(int i=0;i<MSIZE;i++){
			cols[i]=0;			
		}

		for(int i=0;i<SIZE;i++){
			rows[i]=0;			
		}
	}


	public static int solve(int x, int y, int p){

		if(p==1){
			rows[y]++;
			cols[x]++;
			if(x==y) diag++;
			if(y ==(SIZE-x)) antiDiag++;
		}else if( p==0){
			rows[y]--;
			cols[x]--;
			if(x==y) diag--;
			if(y ==(SIZE-x)) antiDiag--;
		}

		//System.out.println("anti "+antiDiag);

		if( rows[y]==SIZE || rows[y]==MSIZE || cols[x]==SIZE || cols[y]==MSIZE || diag==SIZE || antiDiag==MSIZE)
			return p;

		else return 0;
	}

	public static void main(String[] args) {
		
		System.out.println(solve(0,1,1));
		System.out.println(solve(0,2,2));

		System.out.println(solve(1,2,1));
		System.out.println(solve(2,2,2));

		System.out.println(solve(2,1,1));
		System.out.println(solve(2,0,2));

	}

}