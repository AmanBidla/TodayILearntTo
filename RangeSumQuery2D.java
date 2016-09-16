public class RangeSumQuery2D {
 
    private int [][] sumMatrix ;
    
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        sumMatrix = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                sumMatrix[i+1][j+1] = sumMatrix[i][j+1]+sumMatrix[i+1][j]-sumMatrix[i][j]+matrix[i][j];
            }
            //System.out.println(Arrays.toString(sumMatrix[i]));
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        
        return sumMatrix[row2+1][col2+1] - sumMatrix[row1][col2+1] - sumMatrix[row2+1][col1] + sumMatrix[row1][col1];
    }

    public static void main(String[] args) {
    	
    	int [][]  matrix = {
							  {3, 0, 1, 4, 2},
							  {5, 6, 3, 2, 1},
							  {1, 2, 0, 1, 5},
							  {4, 1, 0, 1, 7},
							  {1, 0, 3, 0, 5}
							};

    	RangeSumQuery2D rangeSum = new RangeSumQuery2D(matrix);
    	   
    	System.out.println(rangeSum.sumRegion(2, 1, 4, 3)); // 8
    	System.out.println(rangeSum.sumRegion(1, 1, 2, 2)); //11
    	System.out.println(rangeSum.sumRegion(1, 2, 2, 4)); // 12



    }
 
}