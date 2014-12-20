import java.util.Arrays;
public class MergeTemp{

	    public static int [] merge(int A[], int m, int B[], int n) {
        if(A==null || A.length==0){
            A=B;
            System.out.println("b is a");
        }else{
            int i = m-1;
            int j=n-1;
            int x= m+n-1;
            while( i>=0 && j>=0 ){
                if(A[i]<=B[j]){
                    A[x--]=A[i--];
                }else{
                    A[x--]=B[j--];
                }
            }
            while(i>=0){
                A[x--]=A[i--];
            }
            while(j>=0){
                A[x--]=A[j--];
            }
        }
               return A;
    }
    public static void main(String[] args) {
    	int []A={};
    	int []B={1};
    	A = merge(A,A.length,B,B.length);
    	System.out.println( Arrays.toString(A) );
    }
}