import java.util.Arrays;
import java.util.Scanner;

public class SparseTable{

  private int LEN = 0;  
    private int EXP = 0;  
    private int[] A = null;  
    private int[][] D = null;  
      
    public SparseTable(int[] a) {  
          
        LEN = a.length;  
        EXP = minExp(LEN);  
          
        A = a;  
        D = new int[a.length][EXP];  
          
        for ( int i=0; i<A.length; i++ ) D[i][0] = A[i];  
          
        for ( int j=1; j<=EXP; j++ ) {  
            for ( int i=0; (i+(1<<j)-1)<LEN; i++ ) {  
                D[i][j] = min(D[i][j-1],D[i+(1<<(j-1))][j-1]);  
            }  
        }  
          
    }  
      
    public int query(int L, int R) {  
          
        int k = 0;  
        while ( ( 1 << k ) <= (R-L+1) ) {  
            k++;  
        }  
        k--;  
          
        return min(D[L][k],D[R-(1<<k)+1][k]);  
    }  
      
    private int minExp(int x) {  
        int exp  = 0;  
        int test = 1;  
        while ( test < x ) {  
            test <<= 1;  
            exp++;  
        }  
        return exp;  
    }  
      
    private int min(int x, int y) {  
        return (x<y)?x:y;  
    }  
  
    /**  
     * @param args  
     */  
    public static void main(String[] args) {  
  
        int[] v = {2,4,3,6,7,8,9,0,7}; 
        System.out.println(Arrays.toString(v)); 
        SparseTable inst = new SparseTable(v);  
        /*for ( int i=0; i<v.length; i++) {  
            int r = inst.query(i,v.length-1);  
            System.out.println(r);  
        } */ 
        	int i=5,j=7;
        	System.out.println("range between index "+i+" and "+j);
  			int r = inst.query(3,7);  
            System.out.println(r);  
    }  

}