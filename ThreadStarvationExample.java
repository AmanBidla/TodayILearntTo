public class ThreadStarvationExample implements Runnable{


	boolean fair;
	String message;
	Object resource;

 	public ThreadStarvationExample(boolean fair, String message, Object resource){

		this.fair = fair;
		this.message=message;
		this.resource=resource;
	}

	public static void main(String[] args) {
		boolean flag=false;
		if(args.length==0 || (args.length==1 && args[0]=="fair")) 
			flag=true;
		int cpu = Runtime.getRuntime().availableProcessors();
		final int runners = 2*cpu;
		Object resource = new Object();
		System.out.println("running with runners "+runners);
		for(int i=0;i<=runners;i++){
			ThreadStarvationExample ts = new ThreadStarvationExample(flag, String.valueOf(i), resource);
			Thread t = new Thread(ts);
			t.start();
		}

		synchronized(ThreadStarvationExample.class){
			try{
				ThreadStarvationExample.class.wait(10);
			}catch(InterruptedException e){

			}
		}
	}
 
	@Override
	public void run(){

		synchronized(this){

			while(true){

				synchronized(resource){
					try{
						System.out.println("message is "+message);
						((fair)? resource:this).wait(100);
					}catch(InterruptedException e){

					}
					
				}
			}
		}
	}



}	