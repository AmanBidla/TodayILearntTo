import java.util.Stack;
public class Test{

	public static void main(String[] args) {
		/*int a=Integer.MAX_VALUE;
		int b=Integer.MIN_VALUE;

		int []A = new int[2];
		A[0]=-2147483648;
		A[1]=-2147483647;

		double M=0;
		for(int i=0;i<2;i++){
			M+=A[i];
		}

		M=M/2;

		System.out.println(M);
		double max=0;
		for(int i=0;i<2;i++){
			double t = Math.abs(A[i]-M);
			//System.out.println("max "+max+" t "+t);
			if(max<t){
				max=t;
				//System.out.println("index "+i);
			}
		}
		System.out.println(find());*/

		 int []A={1,2,3,4,0,10,1,1,2,2,3,3,2};
		 System.out.println(ascendingSlice(A));
	}


		private static int  find(){
			Stack<Integer> s1 = new Stack<Integer>();
			String s="1";
			int b = Character.getNumericValue(s.charAt(0));
			System.out.println(b);
			int a = 'a'- s.charAt(0);
			return a;
		}

		public static int  ascendingSlice(int[] A) {
        	
        	int start=0;
        	int index=0;
        	int count=0;
        	int max=0;
        	for(int i=1;i<A.length;i++){
        		System.out.println("count "+count);
        		if(A[i]>A[i-1]){
        			count++;
        		}else{
        			count=1;
        			index=i;
        			System.out.println("index "+index);
         		}
        		if(count>max){
        			max=count;
        			start=index;
          			//System.out.println("reseing start "+start+" max "+max);
        		}

        	}

        return start;
    }
}