
/* Implement a rate limiter */

public class LeakyBucket {

    private float maxRate;
    private long minTime;
	private long lastActionTime = System.currentTimeMillis();

 
    public LeakyBucket(float maxRate){

        this.maxRate = maxRate;
        this.minTime = (long) (1000.0f/maxRate);
    }
 
    public void consume() throws InterruptedException{
		// read from socket  
        long currTime = System.currentTimeMillis(); // get current time form socket 
        long timeLeft;

        synchronized(this){
            timeLeft = lastActionTime+minTime-currTime;

            if(timeLeft>0){

                lastActionTime+=minTime;

            }else{

                lastActionTime=currTime;
            }
        }

        if(timeLeft<0){            
            return;
        }else{
            Thread.sleep(timeLeft);

        }
    }

    public static void main(String[] args)throws InterruptedException {
    	float rate = 2.0f;
        LeakyBucket leakyBucket = new LeakyBucket(rate);

        for(int i=0;i<50;i++){
           leakyBucket.consume();
           System.out.println("sending sms "+i+" at time "+System.currentTimeMillis()/1000);
         }

    }

}