public class SpiralMatrix{

	public static void main(String[] args) {
		
		int [][] matrix ={{1, 2, 3, 4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiral(matrix);

		//expected 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		// output  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
	}

	public static void spiral(int[][]matrix){

		int top=0;
		int down = matrix[0].length-1;
		int left=0;
		int right=matrix[0].length-1;

		while(true){

			// move left to right
			for(int i=left;i<=right;i++){				
				System.out.print(matrix[top][i]+" ");
			}
			top++;
			if(top>down|| left>right) break;

			//move top to down
			for(int i=top;i<=down;i++){
				System.out.print(matrix[i][right]+" ");
			}
			right--;
			if(top>down|| left>right) break;

			// move right to left
			for(int i=right;i>=left;i--){
				System.out.print(matrix[down][i]+" ");
			}
			down--;
			if(top>down|| left>right) break;


			// move down to top
			for(int i=down;i>=top;i--){
				System.out.print(matrix[i][left]+" ");
			}
			left++;
			if(top>down|| left>right) break;
		}

	}
}