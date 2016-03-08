public class LeakyBucket {

	private float maxRate;
	private long minTime;
	private long lastActionTime = System.currentTimeMillis();
								   

	public LeakyBucket(float maxRate){

		this.maxRate = maxRate;
		this.minTime = (long) (1000.0f/maxRate);
	}

	public void consume() throws InterruptedException{


		long currTime = System.currentTimeMillis();
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

}