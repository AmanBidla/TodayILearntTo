class Human{

	String gender;
	String word="!";
	public Human(String gender){
		this.gender=gender;
	}

	public void sayHello(Human other){
		while (!other.word.equals("hello")) {
			System.out.println(this.gender+"  is sleeping because "+other.gender+" has not said hello");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){

			}
			
		}
		this.word="hello!";
	}
}

class HelloThread implements Runnable{

	Human human;
	Human stranger;
 	
 	public void setHuman(Human human){
 		this.human=human;
 	}

 	public void setStranger(Human stranger){
 		this.stranger=stranger;	
 	}


 	@Override
 	public void run(){

 		human.sayHello(stranger);

 	}

}


public class LiveLockExample{


	public static void main(String[] args) {
		Human boy = new Human("boy");
		Human girl = new Human("girl");
		HelloThread h1 = new HelloThread();
		h1.setHuman(boy); h1.setStranger(girl);

		HelloThread h2 = new HelloThread();
		h2.setHuman(girl); h2.setStranger(boy);

		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);

		t1.start();
		t2.start();
	}
	
   
}