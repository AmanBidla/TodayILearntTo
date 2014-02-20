public class Spiral {
    
    public static void main(String[] args) {
        /*
        int [][] array = 
        { 
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 0, 1, 2},  
            {3, 4, 5, 6},
            {7, 8, 9, 1}
        }; */

        int [][]array = {
            {1 , 2 , 3 , 4},
            {5 , 6 , 7 , 8},
            {9, 10 , 11, 12},
            {13, 14, 15, 16}
        };

       printMatrix(array,array[0].length,array[0].length);
        //spiral(array,0,4);
    }

    public static void spiral(int a[][],int x,int y){

    //If the x and y co-ordinate collide, break off from the function

    if(x==y)
        return;
    int i;

    //Top-left to top-right

    for(i=x;i<y;i++)
        System.out.println(a[x][i]);

    //Top-right to bottom-right 

    for(i=x+1;i<y;i++)
        System.out.println(a[i][y-1]);

    //Bottom-right to bottom-left

    for(i=y-2;i>=x;i--)
        System.out.println(a[y-1][i]);

    //Bottom left to top-left

    for(i=y-2;i>x;i--)
        System.out.println(a[i][x]);

    //Recursively call spiral

    spiral(a,x+1,y-1);

}
    public static void printMatrix(int matrix[][], int M, int N){
    int level = 0;
    int min = (M < N) ? M:N;
    System.out.println();
        while(level <= min/2){
            for(int j = level; j < N - level - 1; j++){
                System.out.print(matrix[level][j] + "\t");
            }
            for(int i = level; i < M - level - 1; i++) {
                System.out.print(matrix[i][N - level - 1] + "\t");
            }
            for(int j = N - level - 1; j > level; j--){
                System.out.print(matrix[M - level - 1][j] + "\t");
            }
            for(int i = M - level - 1; i > level; i-- ){
                System.out.print(matrix[i][level] + "\t");
            }
            level++;
        }
    }

}
