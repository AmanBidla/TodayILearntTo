public class TrekAndSwim{



	public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if(A==null || A.length<2) return 0;
        int total=0, indexWithConsequtiveZeroAndOne=-1;
        int min=0;
        for(int i=0;i<N-1;i++){
            
            if(A[i]==1) total++;
            else total--;
            
            if(A[i]==0 && A[i+1]==1){
                if(indexWithConsequtiveZeroAndOne==-1 || total<min){
                    min=total;
                    indexWithConsequtiveZeroAndOne=i+1;
                }
            }            
        }
        
        if(indexWithConsequtiveZeroAndOne==-1) return 0;
        
        total=0;
        int start=-1;
        for(int i=indexWithConsequtiveZeroAndOne-1;i>=0;i--){
            if(A[i]==1) total++;
            else total--;
            
            if(total<0) start=i;
        }
        
        total=0;
        int end=-1;
        for(int i=indexWithConsequtiveZeroAndOne;i<N;i++){
            if(A[i]==1) total++;
            else total--;
            
            if(total>0) end=i+1;
        }
        
        return end-start;
        
    }
}