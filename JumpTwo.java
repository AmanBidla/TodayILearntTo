public class JumpTwo{


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
}