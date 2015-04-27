public class JumpTwo{


    public static void main(String[] args) {
        
    }

	public int jump(int[] A) {
         int step=A[0];
         int jump=1;
         int max=A[0];
         if(A.length<=1){
             return 0;
         }
         for(int i=1;i<A.length;i++){
             if(i==A.length-1){
                 return jump;
             }
             if(A[i]+i>max){
                 max=A[i]+i;
             }
             step--;
             if(step==0){
                 step=max-i;
                 jump++;
             }
         }
         return jump;
    }


    public static int jump2(int [] A){

        int N = A.length;
        int start=0;
        int end=0;
        int count=0;
        if(N==1) return 0;
        while(end<N){

            int max=0;
            count++;
            for(int i=start;i<=end;i++){
                if(A[i]+i>=(N-1)) return count;
                if((A[i]+i)>max){
                    max=A[i]+i;
                }
                start=end+1;
                end=max;
            }

        }
    }
}