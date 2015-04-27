public class MissingPositiveInteger{


    public static void main(String[] args) {
            
        int [] array = {2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println( firstMissingPositive(array)); 

    }

	public static int firstMissingPositive(int[] A) {
     int N = A.length;
     for(int i=0;i<N;i++){
         while(A[i]!=i+1){
             if( A[i]>N || A[i]<=0 ||  A[i]==A[A[i]-1]){
                 break;
             }
             int temp = A[i];
             A[i]=A[temp-1];
             A[temp-1]=temp;
         }
     }
     for(int i=0;i<N;i++){
         if(A[i]!=i+1){
             return i+1;
         }
     }
     return N+1;
    }
}