import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.TimeUnit;
import java.util.Random;

class TokenBucket {
    private final RefillStrategy refillStrategy;
    private final long capacity;
    private AtomicLong size;

    public TokenBucket(long capacity, RefillStrategy refillStrategy) {
        this.refillStrategy = refillStrategy;
        this.capacity = capacity;
        this.size = new AtomicLong(0L);
    }

    public void consume(long numTokens) throws InterruptedException {
        if (numTokens < 0)
            throw new RuntimeException("Number of tokens to consume must be positive");
        if (numTokens >= capacity)
            throw new RuntimeException("Number of tokens to consume must be less than the capacity of the bucket");

        long newTokens = Math.max(0, refillStrategy.refill());
        while (!Thread.currentThread().isInterrupted()) {
            long existingSize = size.get();
            long newValue = Math.max(0, Math.min(existingSize + newTokens, capacity));
            if (numTokens <= newValue) {
                newValue -= numTokens;
                if (size.compareAndSet(existingSize, newValue))
                    break;
            } else {
            	long sleepTime = refillStrategy.getIntervalInMillis();
            	System.out.println("sleeping for "+sleepTime);
                Thread.sleep(sleepTime);
                newTokens = Math.max(0, refillStrategy.refill());
            }
        }
    }


@Override
 public String toString() {
     return "Capacity : " + capacity + ", Size : " + size;
 }

 static interface RefillStrategy {
     long refill();
     long getIntervalInMillis();
 }

}





public final class RateLimiter {

    

    public static TokenBucket newFixedIntervalRefill(long capacityTokens, long refillTokens, long period, TimeUnit unit)
    {
        TokenBucket.RefillStrategy strategy = new FixedIntervalRefillStrategy(refillTokens, period, unit);
        return new TokenBucket(capacityTokens, strategy);
    }

    public static void main(String[] args) throws InterruptedException {
    	Random random = new Random();
    	TokenBucket tokenBucket = RateLimiter.newFixedIntervalRefill(5,4,1,TimeUnit.SECONDS);
    	boolean t = false;
    	 for(int i=0;i<50;i++) {
           if(random.nextInt()%2==0){
           		
           		if (!t) {
           			System.out.println("consuming 4 req");
           			consume2(tokenBucket);
           			consume2(tokenBucket);           			 
           		} else {
           			System.out.println("consuming > 4 req");
           			consume2(tokenBucket);
           			consume2(tokenBucket);
           			consume2(tokenBucket);
           			consume2(tokenBucket);	
           		}
           		t = !t;           		

           } else {
           		System.out.println("consuming 1 req");
           		consume1(tokenBucket);
           }
            
           System.out.println("sending sms "+i+" at time "+System.currentTimeMillis()/1000);
         }
    }

    private static void consume2(TokenBucket tokenBucket) throws InterruptedException {
    	tokenBucket.consume(2);
    }
    private static void consume1(TokenBucket tokenBucket) throws InterruptedException {
    	tokenBucket.consume(1);
    }

}

class FixedIntervalRefillStrategy implements TokenBucket.RefillStrategy {
    private final long numTokens;
    private final long intervalInMillis;
    private AtomicLong nextRefillTime;

   public FixedIntervalRefillStrategy(long numTokens, long interval, TimeUnit unit) {
        this.numTokens = numTokens;
        this.intervalInMillis = unit.toMillis(interval);
        this.nextRefillTime = new AtomicLong(-1L);
    }

    public long refill() {
        final long now = System.currentTimeMillis();
        final long refillTime = nextRefillTime.get();
        if (now < refillTime) {
            return 0;
        }

        return nextRefillTime.compareAndSet(refillTime, now + intervalInMillis) ? numTokens : 0;
    }

    public long getIntervalInMillis() {
        return intervalInMillis;
    }

}