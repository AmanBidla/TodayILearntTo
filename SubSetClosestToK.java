import java.util.TreeSet;
 
class SubSetClosestToK {
    public static void main(String[] args) {
        //int[] a = new int[] {1,2,3,3,5};
        int[] a = new int[] {-3,2,4,-6,-8,10,11};
        SubSetClosestToK ms = new SubSetClosestToK();
        System.out.println("answer = " + ms.getRangeSumToK(a, 6));
    }
 
    public int getRangeSumToK(int[] A, int desired) {
        TreeSet set = new TreeSet();
        int prefix = 0, leastDiff = Integer.MAX_VALUE;
        set.add(prefix);
 
        for (int i = 0; i < A.length; i++) {
            prefix += A[i];
            int extra = prefix - desired;
            int first = (Integer)set.first();
            if (first <= extra) {
                int floor =  (Integer)set.floor(extra);
                int itsSum = prefix - floor;
                if (Math.abs(itsSum - desired) < Math.abs(leastDiff))                    
                	leastDiff = itsSum - desired;           }           
                int last = (Integer)set.last();          
                if (last >= extra) {
	                int ceiling =(Integer) set.ceiling(extra);
	                int itsSum = prefix - ceiling;
	                if (Math.abs(itsSum - desired) < Math.abs(leastDiff))
	                    leastDiff = itsSum - desired;
            	}
            set.add(prefix);
        }
        return leastDiff + desired;
    }
}