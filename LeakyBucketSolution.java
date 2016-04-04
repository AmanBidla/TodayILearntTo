import java.util.*;
import java.util.concurrent.*;

public class LeakyBucketSolution {
        private int numDropsInBucket = 0;
        private Date timeOfLastDropLeak = null;
        private final int BUCKET_DROP_SIZE = 40;
        private final long MAX_TIME_BETWEEN_DROPS = 1000 * 60 * 60;  

        public synchronized boolean addDropToBucket() {
            Date now = new Date();
             
            if (timeOfLastDropLeak != null) {

                long delta = now.getTime() - timeOfLastDropLeak.getTime();
                 
                long numberToLeak = delta / MAX_TIME_BETWEEN_DROPS;
                if (numberToLeak > 0) {  
                    if (numDropsInBucket <= numberToLeak) {
                        numDropsInBucket = 0;
                    } else {
                        numDropsInBucket -= (int) numberToLeak;
                    }
                    timeOfLastDropLeak = now;
                }
            }
            if (numDropsInBucket < BUCKET_DROP_SIZE) {
                numDropsInBucket ++;
                return true;  
            }
            return false;  
        }
    
   

	public static void main(String[] args) {
     	
     	LeakyBucketSolution bucketLimiter = new LeakyBucketSolution();
    	while (bucketLimiter.addDropToBucket()) {
        	System.out.println("Sending SMS in "+TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
    	}
	}
}   