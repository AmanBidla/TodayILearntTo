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

       //printMatrix(array,array[0].length,array[0].length);
        //spiral(array,0,4);
        createSpriral(4);
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

    public static int [][] createSpriral(int n){
        int val=1;
        int [][]matrix = new int[n][n];
        int temp=n;
     for (int level = 0; level < n; ++level, --n) {  
     // top  
     for (int i=level; i < n; ++i) matrix[level][i] = val++;  
     // right  
     for (int i=level+1; i < n; ++i) matrix[i][n-1] = val++;  
     // bottom  
     for (int i=n-2; i >= level; --i) matrix[n-1][i] = val++;  
     // left  
     for (int i=n-2; i > level; --i) matrix[i][level] = val++;  
   }  
    
        n=temp;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }

        return matrix;

    }

}
